package telran.utils;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import telran.persons.dto.CompanySalary;
import telran.persons.dto.Employee;

public class Statistics {

public static void getStatistics(ArrayList<Employee> employees) {
	printStars();
	System.out.println("\nTotal Employees:"+employees.size()+"\n"+"*".repeat(40));
	System.out.println("a.Top 10 most populated cities:");
	employees.stream()
			.map(e->e.getAddress().getCity())
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
			.limit(10)
			.forEach(entry -> System.out.printf("%s : %s\n",entry.getValue(), entry.getKey()));
	
	Map<String, List<Employee>> employeesCompanys=employees.stream()
			.collect(Collectors.groupingBy(Employee::getCompany));

	ArrayList<CompanySalary>Companylist = new ArrayList<>();
	employeesCompanys.forEach((k, v) -> {
		IntSummaryStatistics stats = v.stream().mapToInt(Employee::getSalary).summaryStatistics();
		Companylist.add(new CompanySalary(k, stats.getAverage()));
	});

	IntSummaryStatistics stats = employees.stream()
			.mapToInt(Employee::getSalary)
			.summaryStatistics();

	printStars();
	System.out.println("b. Company names and averaging salary for each company");
	Companylist.stream()
		.sorted((e1,e2)->Double.compare(e2.getAvgSalary(),e1.getAvgSalary()))
		.forEach(company->System.out.println(company.toString()));
			
	printStars();
	System.out.printf("c. Data about all employees (top 50) with salary greater than overall average salary %.2f\n",stats.getAverage());
	printStars();
	employees.stream()
		.filter(e->e.getSalary()>stats.getAverage())
		.sorted((e1,e2)->e2.getSalary()-e1.getSalary())
		.limit(50)
		.collect(Collectors.toList())
		.forEach(e-> {
			System.out.println(e.getSalary()+" - "+e.getName());
		});

}

private static void printStars() {
	System.out.println("*".repeat(80));
}
}

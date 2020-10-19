package telran.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import telran.persons.dto.CompanySalary;
import telran.persons.dto.Employee;
import telran.persons.dto.Person;

public class Statistics {

	public static void getStatistics(Person[] persons) {
		printStars();
		System.out.println("\nTotal Persons:" + persons.length + "\n" + "*".repeat(40));
		System.out.println("a. most populated cities:");
		Arrays.stream(persons)
				.collect(Collectors.groupingBy(e -> e.getAddress().getCity(), Collectors.counting()))
				.entrySet().parallelStream()
				.collect(MaxRatedWinnersCollector.of(e -> e.getValue()))
				.forEach(entry -> System.out.printf("%s : %s\n", entry.getValue(), entry.getKey()));
		
		//System.out.println("a.Top 10 most populated cities:");
		//Arrays.stream(persons)
		//.collect(Collectors.groupingBy(e -> e.getAddress().getCity(), Collectors.counting()))
		//.entrySet()
		//.stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(10)
		//.forEach(entry -> System.out.printf("%s : %s\n", entry.getValue(), entry.getKey()));
		
		Map<String, List<Employee>> employeesCompanys = getStreamEmp(persons)
				.collect(Collectors.groupingBy(Employee::getCompany));

		ArrayList<CompanySalary> Companylist = new ArrayList<>();
		employeesCompanys.forEach((k, v) -> {
			IntSummaryStatistics stats = v.stream().mapToInt(Employee::getSalary).summaryStatistics();
			Companylist.add(new CompanySalary(k, stats.getAverage()));
		});

		IntSummaryStatistics stats = getStreamEmp(persons).mapToInt(Employee::getSalary).summaryStatistics();

		printStars();
		System.out.println("b. Company names and averaging salary for each company");
		Companylist.stream().sorted((e1, e2) -> Double.compare(e2.getAvgSalary(), e1.getAvgSalary()))
				.forEach(company -> System.out.println(company.toString()));

		printStars();
		System.out.printf("c. Data about all employees (top 50) with salary greater than overall average salary %.2f\n",
				stats.getAverage());
		printStars();
		getStreamEmp(persons).filter(e -> e.getSalary() > stats.getAverage()).collect(Collectors.toList())
				.forEach(e -> {
					System.out.println(e.getSalary() + " - " + e.getName() + " (id=" + e.getId() + ")");
				});

	}

	private static void printStars() {
		System.out.println("*".repeat(80));
	}

	static Stream<Employee> getStreamEmp(Person[] persons) {
		return Arrays.stream(persons).filter(p -> p instanceof Employee).map(p -> (Employee) p);
	}
}

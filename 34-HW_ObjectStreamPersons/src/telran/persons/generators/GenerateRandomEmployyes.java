package telran.persons.generators;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import telran.persons.dto.Employee;
import static telran.utils.RandomData.*;

public class GenerateRandomEmployyes {
	private final static int MAX_ID = Integer.MAX_VALUE - 4;

	public static Employee[] GenerateEmployees(int count) {
		return Stream.generate(() -> generateRandomEmployee()).distinct().limit(count).collect(Collectors.toList())
				.toArray(new Employee[0]);
	}

	public static Employee generateRandomEmployee() {
		
		return new Employee(getRandomInt(1_000_000, MAX_ID), getRandomAddress(), getRandomName(),
				getRandomDate(1940, LocalDate.now().getYear()), getRandomCompany(), getRandomTitle(),
				getRandomInt(10000, 100000));
	}

}

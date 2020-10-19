package telran.persons.generators;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import telran.persons.dto.Child;
import telran.persons.dto.Employee;
import telran.persons.dto.Person;

import static telran.utils.RandomData.*;

public class GenerateRandomEmployyes {
	private final static int MAX_ID = Integer.MAX_VALUE - 4;

	public static Person[] GenerateEmployees(int count) {
		return Stream.generate(() -> generateRandomEmployee()).limit(count).collect(Collectors.toList())
				.toArray(new Person[0]);
	}

	public static Person generateRandomEmployee() {
		int childOrPersonOrEmpl = getRandomInt(0, 3);
		if (childOrPersonOrEmpl == 0)
			return new Child(getRandomInt(1_000_000, MAX_ID), getRandomAddress(), getRandomName(),
					getRandomDate(1940, LocalDate.now().getYear()),getRandomGarden());
		else if (childOrPersonOrEmpl == 1)
			return new Person(getRandomInt(1_000_000, MAX_ID), getRandomAddress(), getRandomName(),
					getRandomDate(1940, LocalDate.now().getYear()));

		return new Employee(getRandomInt(1_000_000, MAX_ID), getRandomAddress(), getRandomName(),
				getRandomDate(1940, LocalDate.now().getYear()), getRandomCompany(), getRandomTitle(),
				getRandomInt(10000, 100000));
	}

}

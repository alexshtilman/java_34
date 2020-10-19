package telran.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import telran.persons.dto.Person;

import static telran.persons.generators.GenerateRandomEmployyes.*;
import static telran.utils.DeserializePersonsFromFIle.*;
import static telran.utils.SerializePersonsToFile.*;
import static telran.utils.Statistics.*;

public class PersonsApp {
	private final static int DEFAULT_AMOUNT_OF_EMPLOYYES = 1000;
	private final static String DEFAULT_FILE_NAME = "persons.db";
	private final static String PROGRAM_STOPED = "Recived exit code. Program is stoped.";

	public static void main(String[] args) throws IOException {
		if (args.length > 0) {
			if (args[0] == "--generate") {
				saveToFileAction(DEFAULT_AMOUNT_OF_EMPLOYYES);
			} else if (args[0] == "--statistics") {
				try {
					readFromFileAction();
				} catch (Exception e) {
					System.out.println("Reading file fails: " + e.getMessage());
					System.err.println(PROGRAM_STOPED);
					return;
				}
			}
		}
		String initText = "Please choose action:\n1 - generate random employees\n2 - get statistics\nq - exit";
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println(initText);
			String line = reader.readLine();
			char choice = line.charAt(0);
			switch (choice) {
			case '1': {
				System.out.printf(
						"Specify how many employees to generate, please type amount (minimum 1, Maximum is %d)\n",
						Integer.MAX_VALUE - 4);
				while (true) {
					String amountS = reader.readLine();
					if (amountS.charAt(0) == 'q') {
						System.out.println(PROGRAM_STOPED);
						return;
					}
					try {
						Integer amount = Integer.parseInt(amountS);
						if (amount < 0)
							throw new Exception("");
						saveToFileAction(amount);
						return;
					} catch (Exception e) {
						System.err.printf(
								"Incorrect input, please type amount (minimum 1, Maximum is %d) or q - exit\n",
								Integer.MAX_VALUE - 4);
						continue;
					}
				}
			}
			case '2': {
				try {
					readFromFileAction();
				} catch (Exception e) {
					System.err.println("Reading file fails: " + e.getMessage());
					System.err.println(PROGRAM_STOPED);
					break;
				}

			}
			case 'q': {
				System.out.println(PROGRAM_STOPED);
				return;
			}
			default: {
				System.out.println(initText);
			}
			}
		}
	}

	private static void displayTimeResults(long startTime, long finishTime) {
		System.out.printf("Operation complete after %d\n", finishTime - startTime);
	}

	private static void readFromFileAction() throws Exception {
		long startTime = System.currentTimeMillis();
		System.out.println("Reading data from file, please wait...");
		Person[] employees = {};
		try {
			employees = getObjectsFromFile( DEFAULT_FILE_NAME);
			long endTime = System.currentTimeMillis();
			displayTimeResults(startTime, endTime);
			getStatistics(employees);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	private static void saveToFileAction(Integer amount) {
		long startTime = System.currentTimeMillis();
		System.out.println("Starting generation, please wait...");
		Person[] persons = GenerateEmployees(amount);
		long endTime = System.currentTimeMillis();
		displayTimeResults(startTime, endTime);
		System.out.println("Saving to file...");
		try {
			putObjectsToFile(persons, DEFAULT_FILE_NAME);
			System.err.println("Saving complete.");
		} catch (IOException e) {
			System.out.println("Saving file fails: " + e.getStackTrace());
		}
	}
}

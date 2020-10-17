package telran.utils;

import java.io.*;
import java.util.ArrayList;

import telran.persons.dto.Employee;


public class DeserializePersonsFromFIle {


	public static ArrayList<Employee> getObjectsFromFile(String fileName) throws Exception {
		ArrayList<Employee> objects = new ArrayList<Employee>() ;
		Employee[] empl;
		try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName))) {
			empl = (Employee[])stream.readObject();		
			for(Employee em:empl) {
				objects.add(em);
			}
			return objects;
		} 
	}
}

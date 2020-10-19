package telran.utils;

import java.io.*;
import telran.persons.dto.Person;


public class DeserializePersonsFromFIle {


	public static Person[] getObjectsFromFile(String fileName) throws Exception {
		try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileName))) {
			return (Person[])stream.readObject();		
		} 
	}
}

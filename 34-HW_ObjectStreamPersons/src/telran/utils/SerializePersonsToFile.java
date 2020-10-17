package telran.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializePersonsToFile {
	public static <T> void putObjectsToFile(T[] objects, String fileName) throws IOException  {
		try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName))) {
			stream.writeObject(objects);
		} 
	}
}

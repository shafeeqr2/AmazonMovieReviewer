package loadata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Model {

	/**
	 * Open and read a file, and return the lines in the file as a list of Strings.
	 * (Demonstrates Java FileReader, BufferedReader, and Java5.)
	 */
//
//	private static List<String> readFile(String filename) {
//
//		List<String> records = new ArrayList<String>();
//		try {
//			BufferedReader reader = new BufferedReader(new FileReader(filename));
//			String line;
//			while ((line = reader.readLine()) != null) {
//				records.add(line);
//				System.out.println(line);
//			}
//			reader.close();
//			return records;
//		} catch (Exception e) {
//			System.err.format("Exception occurred trying to read '%s'.", filename);
//			e.printStackTrace();
//			return null;
//		}
//	}
	

	public static void main(String[] args) {

		System.out.println("Hi");
//		List<String> myFile = Model.readFile("text_movies.txt");

	}

}

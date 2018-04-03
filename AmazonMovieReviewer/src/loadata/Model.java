package loadata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Model {

	/**
	 * Open and read a file, and return the lines in the file as a list of Strings.
	 * (Demonstrates Java FileReader, BufferedReader, and Java5.)
	 */
	
	static List<Movie> movies = new ArrayList<Movie>();
	
//	public static movies 
	
	private static String getRowData(List<String> records, int rowNum) {
		return records.get(rowNum).substring(records.get(rowNum).indexOf(" ") + 1);
	}

	private static List<String> readFile(String filename) {

		//Records for one single review.
		List<String> records = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				
				records.add(line);
				System.out.println(line);
				if (line.trim().length() == 0) {

					String productId = getRowData(records, 0);
					String userId = getRowData(records, 1);
					String profileName = getRowData(records, 2);
					//int helpfulness = Integer.parseInt(getRowData(records, 3));
					int helpfulness = 4;
					String score = getRowData(records, 4);
					String time = getRowData(records, 5);
					String review_title = getRowData(records, 6);
					String review_detail = getRowData(records, 7);
					
					
					Review review = new Review(userId, review_title, review_detail, helpfulness, productId);
//					
//					1. Create an entry for movie array if it doesn't already exist. 
//					2. Add review to the movies array (sorted by productId)
//					3. Find userId in binary search tree (structured by userId). If node is found, then add to movies array.
					
					
					records.clear();
				}
					


			}

			reader.close();
			System.out.println(line);

			return records;
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {

		List<String> myFile = Model.readFile("./test_movies.txt");

		
	}

}

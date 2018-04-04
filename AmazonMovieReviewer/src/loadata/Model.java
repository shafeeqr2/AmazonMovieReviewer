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

	//Declaration of the movies array
	static SortedList<Movie> movies = new SortedList<Movie>();

	//Declaration of the Binary Search Tree
	static BST binaryST = new BST();


	private static String getRowData(List<String> records, int rowNum) {
		return records.get(rowNum).substring(records.get(rowNum).indexOf(" ") + 1);
	}
	
	public static void checkAddMovie(Movie movie) {
		for (Movie m : movies) {
			if (m.getProductID().equals(movie.getProductID())) return;
		}
		
		movies.addSortItem(movie);
	}

	private static List<String> readFile(String filename) {

		// Records for one single review.
		List<String> records = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {

				records.add(line);
//				System.out.println(line);
				if (line.trim().length() == 0) {

					String productId = getRowData(records, 0);
					String userId = getRowData(records, 1);
					String profileName = getRowData(records, 2);
					String[] helpfulness_fraction = getRowData(records, 3).split("/");
					int helpfulnessCounter = Integer.parseInt(helpfulness_fraction[1]);
					double helpfulness = Double.parseDouble(helpfulness_fraction[0]) / helpfulnessCounter;
					double score = Double.parseDouble(getRowData(records, 4));
					String time = getRowData(records, 5);
					String review_title = getRowData(records, 6);
					String review_detail = getRowData(records, 7);

					Review review = new Review(userId, review_title, review_detail, helpfulness, helpfulnessCounter,
							productId);
					//
					// 1. Create an entry for movie array if it doesn't already exist.
					Movie movie = new Movie(productId, score);
					//Note: we cannot use addSortItem method directly becuase we want to check if the movie already exists first
					
					// 2. Add review to the movies array (sorted by productId)
					checkAddMovie(movie);
					
					// 3. Find userId in binary search tree (structured by userId). If node is
					// found, then add to movies array.
					userMovie umovie = new userMovie(productId, score);
					binaryST.add(userId, umovie);

					records.clear();
				}

			}

			reader.close();

			return records;
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {

		List<String> myFile = Model.readFile("./test_movies.txt");
		for (Movie m : movies) {
			System.out.println(m.getProductID());
		}
		System.out.println(binaryST.size());
		binaryST.Balance();
		System.out.println(binaryST.size());
		

	}

}

package MVC;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {

	/**
	 * Open and read a file, and return the lines in the file as a list of Strings.
	 * (Demonstrates Java FileReader, BufferedReader, and Java5.)
	 */

	
	//Declare Search object used for Binary Search
	Search search = new Search();

	// Declaration a SortedList Object to store all the movies
	static SortedList<Movie> movies = new SortedList<Movie>();

	// Declaration of the Binary Search Tree
	static BST binaryST = new BST();
	
	//This method returns the data of a particular row and inputs it into a given column of records
	private static String getRowData(List<String> records, int rowNum) {
		return records.get(rowNum).substring(records.get(rowNum).indexOf(" ") + 1);
	}

	/**
	 * Check if a given movie already exists in the movies SortedList. If so, then add all the reviews of the movie object to the one in the SortedList.
	 * @param movie
	 */
	public static void checkAddMovie(Movie movie) {
		for (Movie m : movies) {

			// if movie already exists, just add the review
			if (m.getProductID().equals(movie.getProductID())) {
				for (Review r : movie.getReviews().getArraylist()) {

					m.add(r);
				}

				return;
			}
		}

		movies.addSortItem(movie);
	}
	
	
	/**
	 * Get the rating for a movie given the product ID.
	 * @param productId
	 * @return
	 */
	public static double getMovieRating(String productId) {
		
		int movieIndex = findMovie(productId);
		
		if (movieIndex < 0) return -1.0;
		
		Movie movie = movies.get(movieIndex);
		
		return movie.getScore();
	}

	
	//Return an ArrayList of reviews. Only return the top two reviews.
	private static ArrayList<Review> getUptoFirst2Items(SortedList<Review> checkReviews) {
		ArrayList<Review> reviews = new ArrayList<Review>();

		for (Review r : checkReviews) {

			if (r.getHelpfulness() > 0.80)
				reviews.add(r);

			if (reviews.size() >= 2)
				return reviews;
		}

		return reviews;

	}

	/**
	 * Given the product ID, return the index of the movie in the SortedList Array by carrying out a Binary Search.
	 * @param productId
	 * @return
	 */
	public static int findMovie(String productId) {

		return Search.binarySearch(movies, 0, movies.size(), new Movie(productId));

	}

	/**
	 * Provided the product ID of a movie, this method first determines whether the movie exists. If so, it returns the top 2 reviews for that movie.
	 * @param productId
	 * @return
	 */
	
	public static ArrayList<Review> getTop2Reviews(String productId) {
		
		//Start off by searching for the movie index
		int movieIndex = findMovie(productId);
		//If the movie does not exist, then return null.
		if (movieIndex < 0) {
			System.out.println("number does not exists");
			return null;

		}
		
		//If the movie exists, then get the movie.
		Movie movie = movies.get(movieIndex);

		//Extract the reviews of the movie.
		SortedList<Review> checkReviews = movie.getReviews();
		
		//Pick the top 2 reviews and return.
		return getUptoFirst2Items(checkReviews);
	}
	
	/**
	 * Given a user ID, return the the string of movies this user has rated highy.
	 * @param userID
	 * @return
	 */
	public String[] getUserRecommendation(String userID) {

		return binaryST.get(userID);
	}

	/**
	 * This method reads the contents of the text file and populates the Binary Search Tree and Movies Array Simultaneously. 
	 * @param filename
	 */
	private static void readFile(String filename) {

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
					
					// 1. Create an entry for movie array if it doesn't already exist.
					Movie movie = new Movie(productId, score, review);
					// Note: we cannot use addSortItem method directly becuase we want to check if
					// the movie already exists first

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

		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();

		}
	}

	//Main function runs the code.
	public static void main(String[] args) {

		//Alternative dataset in ./movies.txt
//		Model.readFile("./movies.txt");
		Model.readFile("test_movies.txt");
//
////		 This code is for testing purposes only.
		for (Movie m : movies) {
			System.out.println(m.getProductID());
//			ArrayList<Review> testreviews = Model.getTop2Reviews(m.getProductID());
//
//			if (testreviews == null) {
//				System.out.println("no goog reveiws for " + m.getProductID());
//			} else {
//				System.out.println("review for " + m.getProductID());
//				for (Review r : testreviews) {
//					System.out.println(r.getUserID() + " " + r.getHelpfulness());
//				}
//				System.out.println();
//
//			}

		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GUI gui = new GUI();
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}


	//Please feel free to test these movie ids.
	//Samples to test the GUI.
	
	
	//	B00652U64C
	//	B006DB382C
	//	B006ELF9ZK
	//	B006FJGOPA
	//	B006FSRSFQ
	//	B006GWXSNW
	//	B006L4MX4A
	//	B006M69MFA
	//	B006RASZ4K
	//	B006RXPVOE
	//	B006WFNTWI
	//	B006ZPDMLS
	//	B0071CL7SO
	//	B0073PJT3E
	//	B0073YKC6S
	//	B0074B2N8A
	//	B0076HMNXW
	//	B0076XTHKS
	//	B0077AYMDW
	//	B0077PBPQE
	//	B0079ZWULG
	//	B007EQQTL2
	//	B007K7IBTI
	//	B007PKOKZY
	//	B007Q9BHY6
	//	B007QDUK9U
	//	B007QJARZ6
	//	B007QTL2PK
	//	B007T284K0
	//	B007TWBWQ8
	//	B007WB5DOI
	//	B007XOHZOK
	//	B007Y7GE9S
	//	B0081EO6WA
	//	B0082GZ4MI
	//	B0083GQU6G
	//	B0083Q4KCC
	//	B0083TS7PA
	//	B0084RZMSQ
	//	B0085Z3AMW
	//	B00887494A
	//	B008ASL8OG

	


}

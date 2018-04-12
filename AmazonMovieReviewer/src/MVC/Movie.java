package MVC;

/**
 * The Movie class contains information about each Movie. This includes a SortedList of all reviews, the productID and the Score of the movie.
 * @author shafeeq
 *
 */
public class Movie implements Comparable<Movie> {
	private SortedList<Review> reviews = new SortedList<Review>();
	private String productID;
	private double score;

	/**
	 * Constructor that instantiates a movie object based on the productID, score and Review. This constructor is needed for populating the movies array.
	 * @param productID
	 * @param score
	 * @param review
	 */
	public Movie(String productID, double score, Review review) {
		reviews = new SortedList<Review>();
		reviews.addSortItem(review);
		this.productID = productID;
		this.score = score;
	}
	
	/**
	 * Constructor that instantiates a movie object based solely on the productID. This constructor is needed for creating a dummy movie object to search the movies array.
	 * @param productID
	 */
	public Movie(String productID) {
		this.productID = productID;
	}

	
	/**Adds a review into the the Movie object. In order to avoid the possibility of duplicate reviews, the assumption is made that the each user will only review a movie once. 
	 * @param review
	 */
	public void add(Review review) {
		
		for (Review r : reviews) {
			if (r.getUserID().equals(review.getUserID())) return;
		}
		
		reviews.addSortItem(review);
	}
	
	/**
	 * Returns productId
	 * @return
	 */
	public String getProductID() {
		return productID;
	}

	/**
	 * Returns the score.
	 * @return
	 */
	public double getScore() {
		return score;
	}
	
	/**
	 * Returns the SortedList<Review>
	 * @return
	 */
	public SortedList<Review> getReviews() {
		return reviews;
		
	}

	/**
	 * Used to compare two movies for sorting purposes.
	 */
	public int compareTo(Movie that) {
		return this.productID.compareTo(that.getProductID());
	}

}

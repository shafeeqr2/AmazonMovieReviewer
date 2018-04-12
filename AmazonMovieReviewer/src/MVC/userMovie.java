package MVC;

/**
 * The userMovie class stores the movieProduct ID and the score for each movie. This information will be used the by the node in the Binary Search Tree.
 * @author shafeeq
 *
 */
public class userMovie {

	private String productId;
	private double score;

	//Constructor
	public userMovie(String productId, double score) {
		this.productId = productId;
		this.score = score;
	}

	/**
	 * Returns the product ID of the movie.
	 * @return
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * Returns the score of the movie.
	 * @return
	 */
	public double getScore() {
		return score;
	}

}

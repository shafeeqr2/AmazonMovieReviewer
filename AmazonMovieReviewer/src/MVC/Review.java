package MVC;

/**
 * Review class stores the information for the review of each user. This includes the userID, the review_title, review_detail, helpfulness, helpfulnessCount and productID.
 * @author shafeeq
 *
 */
public class Review implements Comparable<Review> {
	private String userID;
	private String review_title;
	private String review_detail;
	private double helpfulness;
	private int helpfulnessCount;
	private String productID;


	/**
	 * Constructor for instantiating a review object.
	 * @param userID
	 * @param review_title
	 * @param review_detail
	 * @param helpfulness
	 * @param helpfulnessCount
	 * @param productID
	 */
	public Review(String userID, String review_title, String review_detail, double helpfulness, int helpfulnessCount,
			String productID) {
		this.userID = userID;
		this.review_title = review_title;
		this.review_detail = review_detail;
		this.helpfulness = helpfulness;
		this.helpfulnessCount = helpfulnessCount;
		this.productID = productID;
	}

	/**
	 * In order to compare two Reviews for sorting purposes.
	 */
	@Override
	public int compareTo(Review o) {
		return o.getHelpfulnessCount() - this.helpfulnessCount;
	}

	/**
	 * Returns the userID.
	 * @return
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * Returns the review_title
	 * @return
	 */
	public String getReview_title() {
		return review_title;
	}

	/**
	 * Returns the review_detail
	 * @return
	 */
	public String getReview_detail() {
		return review_detail;
	}

	/**
	 * Returns the helpfulness.
	 * @return
	 */
	public double getHelpfulness() {
		return helpfulness;
	}

	/**
	 * Returns the helpfulnessCount.
	 * @return
	 */
	public int getHelpfulnessCount() {
		return helpfulnessCount;
	}

	/**
	 * Returns the productID.
	 * @return
	 */
	public String getProductID() {
		return productID;
	}

	/**
	 * In order to display the Review as a String.
	 */
	@Override
	public String toString() {
		return "Review [userID=" + userID + ", review_title=" + review_title + ", review_detail=" + review_detail
				+ ", helpfulness=" + helpfulness + ", helpfulnessCount=" + helpfulnessCount + ", productID=" + productID
				+ "]";
	}
	
	



}

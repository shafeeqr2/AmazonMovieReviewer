package loadata;

public class Review implements Comparable<Review> {
	private String userID;
	private String review_title;
	private String review_detail;
	private double helpfulness;
	private int helpfulnessCount;
	private String productID;


	public Review(String userID, String review_title, String review_detail, double helpfulness, int helpfulnessCount,
			String productID) {
		this.userID = userID;
		this.review_title = review_title;
		this.review_detail = review_detail;
		this.helpfulness = helpfulness;
		this.helpfulnessCount = helpfulnessCount;
		this.productID = productID;
	}

	@Override
	public int compareTo(Review o) {
		return this.helpfulnessCount - o.getHelpfulnessCount();
	}

	public String getUserID() {
		return userID;
	}

	public String getReview_title() {
		return review_title;
	}

	public String getReview_detail() {
		return review_detail;
	}

	public double getHelpfulness() {
		return helpfulness;
	}

	public int getHelpfulnessCount() {
		return helpfulnessCount;
	}

	public String getProductID() {
		return productID;
	}



}

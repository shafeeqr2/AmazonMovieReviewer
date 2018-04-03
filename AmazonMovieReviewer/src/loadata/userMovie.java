package loadata;

public class userMovie {

	private String userId;
	private String productId;
	private int rating;

	public userMovie(String userId, String productId, int rating) {
		this.userId = userId;
		this.productId = productId;
		this.rating = rating;
	}

	public String getUserId() {
		return userId;
	}

	public String getProductId() {
		return productId;
	}

	public int getRating() {
		return rating;
	}

}

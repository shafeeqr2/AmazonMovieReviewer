package loadata;

public class userMovie {

	private String productId;
	private double rating;

	public userMovie(String productId, int rating) {
		this.productId = productId;
		this.rating = rating;
	}

	public String getProductId() {
		return productId;
	}

	public double getRating() {
		return rating;
	}

}

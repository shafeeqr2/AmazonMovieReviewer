package MVC;

public class userMovie {

	private String productId;
	private double score;

	public userMovie(String productId, double score) {
		this.productId = productId;
		this.score = score;
	}

	public String getProductId() {
		return productId;
	}

	public double getScore() {
		return score;
	}

}

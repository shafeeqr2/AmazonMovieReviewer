package loadata;

public class Movie implements Comparable<Movie> {
	private SortedList<Review> reviews;
	private String productID;
	private double score;

	public Movie(String productID, double score) {
		this.productID = productID;
		this.score = score;
	}

	//Assumption: Each user will only review a movie once.
	public void add(Review review) {
		
		for (Review r : reviews) {
			if (r.getUserID().equals(review.getUserID())) return;
		}
		reviews.addSortItem(review);
	}

	public String getProductID() {
		return productID;
	}

	public double getScore() {
		return score;
	}

	public int compareTo(Movie that) {
		return this.productID.compareTo(that.getProductID());
	}

}

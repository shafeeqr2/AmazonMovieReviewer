package adt;

public class Movie implements Comparable <Movie>{
	public Review[] reviews;
	public String productID;
	public int Rating;
	
	public Movie(Review[] reviews, String productID, int rating) {
		this.reviews = reviews;
		this.productID = productID;
		this.Rating = rating;
	}

	public Review[] getReviews() {
		return reviews;
	}

	public String getProductID() {
		return productID;
	}

	public int getRating() {
		return Rating;
	}
	
	public int compareTo(Movie that) {
		return this.productID.compareTo(that.getProductID());
	}

}


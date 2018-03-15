package loadata;

public class Review {
	public String userID;
	public String review;
	public String summary;
	public int helpfulness;
	
	public Review(String userID, String review, String summary, int helpfulness) {
		this.userID = userID;
		this.review = review;
		this.summary = summary;
		this.helpfulness = helpfulness;
	}

	public String getUserID() {
		return userID;
	}

	public String getReview() {
		return review;
	}

	public String getSummary() {
		return summary;
	}

	public int getHelpfulness() {
		return helpfulness;
	}
	
	
	

}

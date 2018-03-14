package adt;

public class Node implements Comparable <Node>{
	public String userID;
	public Movie[] moviesByUser;
	
	public Node(String userID, Movie[] moviesByUser) {
		this.userID = userID;
		this.moviesByUser = moviesByUser;
	}

	public String getUserID() {
		return userID;
	}

	public Movie[] getMoviesByUser() {
		return moviesByUser;
	}

	public int compareTo(Node that) {
		return this.userID.compareTo(that.getUserID());
	}
	
	
}

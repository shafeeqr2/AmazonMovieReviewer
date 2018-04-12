package loadata;

import java.util.List;

public class Node implements Comparable<Node> {
	public String userID;
	public List<userMovie> userMovies;
	Node left;
	Node right;

	public Node(String userID, userMovie umovie) {
		this.userID = userID;
		this.userMovies.add(umovie);
		left = null;
		right = null;
	}

	public String getUserID() {
		return userID;
	}
	
	public void add(userMovie umovie) {
		
		//check if userMovie already exists
		for (userMovie um :userMovies) {
			if (um.getProductId().equals(umovie.getProductId())) return;
		}
		
		//add user movie
		userMovies.add(umovie);
	}

	public List<userMovie> getMoviesByUser() {
		return userMovies;
	}

	public int compareTo(Node that) {
		return this.userID.compareTo(that.getUserID());
	}

}

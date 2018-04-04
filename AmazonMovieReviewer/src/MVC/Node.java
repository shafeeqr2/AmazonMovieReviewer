package MVC;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {
	private String userID;
	List<userMovie> userMovies = new ArrayList<userMovie>();
	Node left;
	Node right;
	int size;

	public Node(String userID, userMovie umovie) {
		this.userID = userID;
		this.userMovies.add(umovie);
		left = null;
		right = null;
		this.size = 1;
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

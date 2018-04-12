package MVC;

import java.util.ArrayList;
import java.util.List;

/**
 * Node class defines each Node of the Binary Search Tree.
 * Other than the information of the left and right child, it also stores the information of the userID and userMovies .i.e. movies recommended by the user.
 * @author shafeeq
 *
 */
public class Node implements Comparable<Node> {
	private String userID;
	private List<userMovie> userMovies = new ArrayList<userMovie>();
	private Node left;
	private Node right;
	private int size;
	
	

	public List<userMovie> getUserMovies() {
		return userMovies;
	}

	public void setUserMovies(List<userMovie> userMovies) {
		this.userMovies = userMovies;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * Constructor for Node class used for Binary Search Tree. It takes in the userID and the userMovie objects.
	 * @param userID
	 * @param umovie
	 */
	public Node(String userID, userMovie umovie) {
		this.userID = userID;
		this.userMovies.add(umovie);
		left = null;
		right = null;
		this.size = 1;
	}

	/**
	 * Returns the userId.
	 * @return
	 */
	public String getUserID() {
		return userID;
	}
	
	/**
	 * Adds a movie to the calling Node's userMovies list.
	 * @param umovie
	 */
	public void add(userMovie umovie) {
		
		//check if userMovie already exists
		for (userMovie um :userMovies) {
			if (um.getProductId().equals(umovie.getProductId())) return;
		}
		
		//add user movie
		userMovies.add(umovie);
	}
	
	/**
	 * Returns the list of userMoives
	 * @return
	 */

	public List<userMovie> getMoviesByUser() {
		return userMovies;
	}

	/**
	 * Compares two nodes based on the userID. This is needed for creating and traversing through the Binary Search Tree.
	 */
	public int compareTo(Node that) {
		return this.userID.compareTo(that.getUserID());
	}

}

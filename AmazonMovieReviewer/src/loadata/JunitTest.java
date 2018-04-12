package loadata;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import MVC.Model;
import MVC.Movie;
import MVC.Review;

public class JunitTest {

	@Test //test on whether nodes in binary search tree has been put in correct places.
	public void BSTtest() {
		Model.readFile("./test_movies.txt");
		assertEquals(Model.getBinaryST().get("A1I7QGUDP043DG")[0],"B003AI2VGA");
	}
	
	@Test //test on whether BST is balanced
	public void BalanceSearch() {
		Model.readFile("./test_movies.txt");
		assertEquals(Model.getBinaryST().size(Model.getBinaryST().getRoot().getLeft())-Model.getBinaryST().size(Model.getBinaryST().getRoot().getRight())<=1,true);
	}
	
	@Test //Test on FileNotFound
	public void FileNotFoundException() throws FileNotFoundException {
		Model.readFile("./.txt");
	}
	
	@Test //test on whether movies are in order.
	public void MoviesTest() {
		Model.readFile("./test_movies.txt");
		for(int i = 0; i<Model.getMovies().size()-1; i++) {
			assertTrue(Model.getMovies().get(i).compareTo(Model.getMovies().get(i+1))<0);
		}
	}
	@Test //test on no reviews are empty
	public void getTop2ReviewsTest() {
		Model.readFile("./test_movies.txt");
		for (Movie m : Model.getMovies()) {
			ArrayList<Review> testreviews = Model.getTop2Reviews(m.getProductID());
			assertNotEquals(testreviews, null);
		}
	}

}

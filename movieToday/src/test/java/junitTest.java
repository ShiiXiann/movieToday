import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ReviewTesting {
	private ReviewServlet reviewServlet = new ReviewServlet(); 
	private int rid;
	private int movie_id;
	private int user_id;
	private String review; 
	
	

	@BeforeEach
	void setUp() throws Exception {
		rid = 97;
		movie_id = 1;
		user_id = 5;
		review = "the movie is good";
	}
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateReview() {
		int i = reviewServlet.CreateReview(movie_id, user_id, review);
		assertTrue(i>0);
	}
	
	@Test
	void testUpdateReview() {
		boolean i = reviewServlet.UpdateReview(rid, movie_id, user_id, review);
		assertEquals(i, true);
		
	}

	@Test
	void testDeleteReview() {
		boolean i = reviewServlet.DeleteReview(rid);
		assertEquals(i, true);
		
	}

}
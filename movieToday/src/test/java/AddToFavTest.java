import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

public class AddToFavTest {
	private MovieServlet movieServlet = new MovieServlet();
	
	private int mid;
	private int uid;
	

	@BeforeEach
	public void setUp() throws Exception {
		
		mid = 5;
		uid = 3;
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddToFavFunction() {
		//fail("Not yet implemented");
		int i = movieServlet.addToFavFunction(mid, uid);
		assertTrue(i > 0);
	}

}

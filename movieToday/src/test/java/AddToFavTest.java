import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddToFavTest {
	private MovieServlet movieServlet = new MovieServlet();
	
	private int mid;
	private int uid;
	

	@Before
	public void setUp() throws Exception {
		
		mid = 5;
		uid = 3;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddToFavFunction() {
		//fail("Not yet implemented");
		int i = movieServlet.addToFavFunction(mid, uid);
		assertTrue(i > 0);
	}

}

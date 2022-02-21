import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class movieServletTest {
	
	private MovieServlet movieServlet =new MovieServlet();
	private CMovieServlet cmovieServlet = new CMovieServlet();
	private String movieName;
	private String movieGenre;
	private String movieDescription;
	private String movieCasts;
	private int movieDuration;
	private String movieDateRelease;
	private String movieImage;
	private int id;
	private int testId;

	@BeforeEach
	void setUp() throws Exception {
		movieName = "john wick";
		movieGenre = "action";
		movieDescription = "Man kills enemies";
		movieCasts = "Keanu Reeves";
		movieDuration = 120;
		movieDateRelease = "5/3/14";
		movieImage="nownfaiwofna";
		id = 0;
		
		testId = cmovieServlet.doPostDB("john wick ","action,comedy","Man kills enemies","Keanu Reeves","120","5/8/18","dawsdawsdaws");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testUpdateMovieDB() {
//		fail("Not yet implemented");
		boolean testUpdate = movieServlet.updateMovieDB("john wick 3","action,comedy","Man kills enemies for the 3rd time","Keanu Reeves,obama",150,"5/8/18","dawsdawsdaws",testId);
	}

	@Test
	void testDeleteMovieDB() {
		boolean testDelete = movieServlet.deleteMovieDB(testId);
	}

}

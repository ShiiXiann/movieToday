import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CMovieTest {
	
	private CMovieServlet cmovieServlet =new CMovieServlet();
	private String movieName;
	private String movieGenre;
	private String movieDescription;
	private String movieCasts;
	private String movieDuration;
	private String movieDateRelease;
	private String movieImage;
	

	@BeforeEach
	void setUp() throws Exception {
		movieName = "john wick";
		movieGenre = "action";
		movieDescription = "Man kills enemies";
		movieCasts = "Keanu Reeves";
		movieDuration = "120";
		movieDateRelease = "5/3/14";
		movieImage="nownfaiwofna";
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDoPostDB() {
		int i = cmovieServlet.doPostDB(movieName,movieGenre,movieDescription,movieCasts,movieDuration,movieDateRelease,movieImage);
	}

}

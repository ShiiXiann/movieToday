import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;


import movieToday.FavouriteJoin;

public class FavouriteServletTest {
	private FavouriteServlet favouriteServlet = new FavouriteServlet();
	private String movieName;
	private String movieGenre;
	private String movieDescription;
	private String movieCasts;
	private float movieDuration;
	private String movieDateRelease;
	private String movieImage;
	private int fid;
	

	@BeforeEach
	public void setUp() throws Exception {
		movieName ="Titanic";
		movieGenre= "Romance";
		movieDescription = "Ship";
		movieCasts = "IDK";
		movieDuration = 190;
		movieDateRelease = "22/09/98";
		movieImage = "www";
		fid = 40;
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testJoinTableFunction() {
		//fail("Not yet implemented");
		List<FavouriteJoin> retrieveJoin = favouriteServlet.joinTableFunction();
		assertTrue(!retrieveJoin.equals(null));
		
	}

	@Test
	public void testListFavouritesFunction() {
		//fail("Not yet implemented");
		List<Favourite> retrieveList = favouriteServlet.listFavouritesFunction();
		assertTrue(!retrieveList.equals(null));
	}

	@Test
	public void testDeleteFavFunction() {
		//fail("Not yet implemented");
		boolean checkFavDeleted = favouriteServlet.deleteFavFunction(fid);
		assertEquals(checkFavDeleted, true);
	}

}

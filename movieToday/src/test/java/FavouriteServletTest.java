import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	

	@Before
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

	@After
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

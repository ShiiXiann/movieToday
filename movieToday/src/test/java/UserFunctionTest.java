import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Magdalene
 *
 */
class UserFunctionTest {
	private UserServlet userServlet = new UserServlet();
	private static int userId;
	private static String username;
	private static String password;
	
	private static String inputUsername;
	private static String inputPassword;
	private static int idForDelete;

	/**
	 * @throws java.lang.Exception
	 */

	@BeforeAll
	public static void setup() {
		userId = 134;
		username = "abc";
		password = "abc";
		inputUsername = "a";
		inputPassword = "b";

		// just for delete function itself
		RegisterServlet.RegisterFunction("mag", "mag123", "mag@gmail.com", "999");
		User retrieveLogin = UserServlet.loginFunction("mag", "mag123");
		idForDelete = retrieveLogin.getId();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link UserServlet#loginFunction(java.lang.String, java.lang.String)}.
	 */
	@Test
	void testLoginFunction() {
		// see whether user matches database's credentials
		var trueCredentials = userServlet.loginFunction("mag", "mag123");
		var falseCredentials = userServlet.loginFunction(inputUsername, inputPassword);
		assertTrue(!trueCredentials.equals(falseCredentials));
	}

	/**
	 * Test method for {@link UserServlet#showProfileFunction(int)}.
	 */
	@Test
	void testShowProfileFunction() {
		List<User> retrieveUser = userServlet.showProfileFunction(idForDelete);
		assertTrue(!retrieveUser.equals(null));
	}

	/**
	 * Test method for
	 * {@link UserServlet#updateFunction(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	void testUpdateFunction() {
		boolean checkUpdated = userServlet.updateFunction("peter", "peter", "peterparker@gmail.com", "111111",
				idForDelete);
		assertEquals(checkUpdated, true);
	}

	/**
	 * Test method for {@link UserServlet#deleteFunction(int)}.
	 */
	@Test
	void testDeleteFunction() {
		boolean checkDeleted = userServlet.deleteFunction(idForDelete);
		assertEquals(checkDeleted, true);
	}
}

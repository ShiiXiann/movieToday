
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//Import these libraries from java.io and java.sql
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/movietoday";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String SELECT_ALL_USERS = "select * from user";
	private static final String SELECT_USER_BY_ID = "select * from user where id = ?";
	private static final String DELETE_USERS_SQL = "delete from user where id = ?;";
	private static final String UPDATE_USERS_SQL = "update user set username = ?, password = ?, email = ?, phoneNumber = ? where id = ?;";

	// For login SQL statement
	private static final String LOGIN_USER_SQL = "SELECT * FROM user WHERE username = ? and password = ?";

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.
		String action = request.getServletPath();
		try {
			switch (action) {

			case "/UserServlet/login":
				loginUsers(request, response);
				break;
			case "/UserServlet/logout":
				LogOutUser(request, response);
				break;
			case "/profile":
				ProfileDetails(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;

			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	// For Login
	private void loginUsers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String enteredUsername = request.getParameter("username");
		String enteredPassword = request.getParameter("password");

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_USER_SQL);) {
			preparedStatement.setString(1, enteredUsername);
			preparedStatement.setString(2, enteredPassword);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				if (rs.getString("username").equals(enteredUsername)
						&& (rs.getString("password").equals(enteredPassword))) {
					int uid = rs.getInt("id");
					String username = rs.getString("username");
					// setAttribute() is to save an object in session by assigning a unique string
					// to the object.
					session.setAttribute("id", uid);
					session.setAttribute("username", username);
					session.setAttribute("isLoggedIn", true);
					// getAttribute() the object stored by setAttribute method is fetched from
					// session using getAttribute method
					session.getAttribute("id");
					session.getAttribute("username");
					session.getAttribute("isLoggedIn");
					System.out.println(session.getAttribute("id"));
					System.out.println(session.getAttribute("username"));
					response.sendRedirect("/movieToday/profile?id=" + uid);
				}
			} else {

				System.out.println("Wrong username or password");
				response.sendRedirect("/movieToday/login.jsp");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	// For Logging Out
	private void LogOutUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		System.out.println("You are logged out");
		response.sendRedirect("/movieToday/login.jsp");

	}

	// Display current logged in user's profile
	private void ProfileDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		List<User> users = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			int uid = Integer.parseInt(request.getParameter("id"));
			preparedStatement.setInt(1, uid);
			ResultSet rs = preparedStatement.executeQuery();
			System.out.println("The id for this user profile is: " + uid);
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				users.add(new User(uid, username, password, email, phoneNumber));
				request.setAttribute("ProfileDetails", users);
				request.getRequestDispatcher("/profile.jsp").forward(request, response);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method 1: showEditForm
	// method to get parameter, query database for existing user data and redirect
	// to user edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		int uid = Integer.parseInt(request.getParameter("id"));
		User existingUser = new User(uid,"", "", "", "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, uid);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				uid = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String phoneNumber = rs.getString("phoneNumber");
				existingUser = new User(uid, username, password, email, phoneNumber);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("user", existingUser);
		request.getRequestDispatcher("/userEdit.jsp").forward(request, response);
	}
	
	
	// Method 2: updateUser
		// method to update the user table base on the form data
	// Method 2: updateUser
		// method to update the user table base on the form data
		private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			// Step 1: Retrieve value from the request
			int oriId = Integer.parseInt(request.getParameter("id"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String phoneNumber = request.getParameter("phoneNumber");

			// Step 2: Attempt connection with database and execute update user SQL query
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
				statement.setString(1, username);
				statement.setString(2, password);
				statement.setString(3, email);
				statement.setString(4, phoneNumber);
				statement.setInt(5, oriId);
				System.out.println(username);
				int i = statement.executeUpdate();
			}
			// Step 3: redirect back to UserServlet (note: remember to change the url to
			// your project name)
			// made changes here
			response.sendRedirect("http://localhost:8080/movieToday/profile?id=" + oriId);
		}
		

		// Method 3: deleteUser
		// method to delete user
		private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			// Step 1: Retrieve value from the request
			int uid = Integer.parseInt(request.getParameter("id"));
			// Step 2: Attempt connection with database and execute delete user SQL query
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
				statement.setInt(1, uid);
				int i = statement.executeUpdate();
				// remove session storage when deleting account
				HttpSession session = request.getSession();
				session.removeAttribute("username");
				session.invalidate();
			}
			// Step 3: redirect back to UserServlet dashboard (note: remember to change the
			// url to your project name)
			System.out.println("Account has been deleted");
			response.sendRedirect("http://localhost:8080/movieToday/register.jsp");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

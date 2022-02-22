
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movieToday.Review;

//Import these libraries from java.io and java.sql
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String jdbcURL = "jdbc:mysql://localhost:3306/movietoday";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	private static final String INSERT_REVIEW_SQL = "INSERT INTO review" + " ( movie_id, user_id, review) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_ALL_REVIEWS = "select * from review";
	private static final String SELECT_REVIEW_BY_ID = "select * from review where id=?";
	private static final String SELECT_REVIEW_BY_MOVIE_ID = "select  movie_id ,user_id,review,from review where movie_id =?";
	private static final String DELETE_REVIEW_SQL = "delete from review where id = ?;";
	private static final String UPDATE_REVIEW_SQL = "update review set movie_id= ?, user_id =?,review =? where id = ?;";

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
		response.getWriter().append("Served at:").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println("test edit 2");
		try {
			switch (action) {
			case "/deletesreviews":
				deleteReview(request, response);
				break;
			case "/edits":
				System.out.println("test edit");
				displayEditForm(request, response);
				break;
			case "/postReview":
				System.out.println("test post");
				PostReviewForm(request, response);
				break;
			case "/updatesreviews":
				updateReview(request, response);
				break;
			default:
			case "/reviews":
				listReview(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void PostReviewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1st - frontend
		response.setContentType("text/html");
		// Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		// get user id from the database
		// retrieve the two id from the request from the web form
		int mid = Integer.parseInt(request.getParameter("movie_id"));
		int uid = (int) session.getAttribute("id");
		String r = request.getParameter("review");

		// 2nd - backend
		int i = CreateReview(mid, uid, r);
//		// attempt connection to database using JDBC, you can change the username and
//		// password accordingly using the phpMyAdmin > User Account dashboard

		// 3rd - to show in front end
		if (i > 0) {
			PrintWriter writer = response.getWriter();
			response.sendRedirect("/movieToday/reviews");
			writer.println("<h1>" + "You have successfully create a review" + "</h1>");
			writer.close();

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setContentType("text/html");
//		// Initialize a PrintWriter object to return the html values via the response
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
//		// get user id from the database
//		// retrieve the two id from the request from the web form
//		int mid = Integer.parseInt(request.getParameter("movie_id"));
//		int uid = (int) session.getAttribute("id");
//		String r = request.getParameter("review");
//
		// int i = CreateReview(mid, uid, r) ;
//		// attempt connection to database using JDBC, you can change the username and
//		// password accordingly using the phpMyAdmin > User Account dashboard

//		
//		if (i > 0) {
//			PrintWriter writer = response.getWriter();
//			response.sendRedirect("http://localhost:8080/movieToday/reviews");
//			writer.println("<h1>" + "You have successfully create a review" + "</h1>");
//			writer.close();
//
//		}
		doGet(request, response);
	}

	private void listReview(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Review> reviews = new ArrayList<>();
		System.out.println("testing 2");
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_REVIEWS);) {
			// Step 5.2: Execute the query or update query
			// int id = Integer.parseInt(request.getParameter("id"));
			// System.out.println(id);
			// preparedStatement.setInt(1, id);
			// System.out.println(id);
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				int rid = rs.getInt("id");
				int movie_id = rs.getInt("movie_id");
				int user_id = rs.getInt("user_id");
				String review = rs.getString("review");
				reviews.add(new Review(rid, movie_id, user_id, review));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// userManagement.jsp
		request.setAttribute("listReview", reviews);
		request.getRequestDispatcher("/review.jsp").forward(request, response);
	}

	// method to get parameter, query database for existing user data and redirect
	// to user edit page
	private void displayEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		// get parameter passed in the URL
		int rid = Integer.parseInt(request.getParameter("id"));
		System.out.println(rid);
		int uid = (int) session.getAttribute("id");
		System.out.println("User Id is " + uid);
		int mid = Integer.parseInt(request.getParameter("id"));
		System.out.println("Movie Id is " + mid);
		Review existingReview = new Review(rid, mid, uid, "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEW_BY_ID);) {
			preparedStatement.setInt(1, rid);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				rid = rs.getInt("id");
				int movie_id = rs.getInt("movie_id");
				int user_id = rs.getInt("user_id");
				String review = rs.getString("review");
				System.out.println("review");
				existingReview = new Review(rid, movie_id, user_id, review);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("review", existingReview);
		request.getRequestDispatcher("/reviewEdit.jsp").forward(request, response);

	}

	// method to update the review table base on the form data
	private void updateReview(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		int rid = Integer.parseInt(request.getParameter("id"));
		int mid = Integer.parseInt(request.getParameter("movie_id"));
		int uid = Integer.parseInt(request.getParameter("user_id"));
		String review = request.getParameter("review");

//		// Step 2: Attempt connection with database and execute update review SQL query
//		try (Connection connection = getConnection();
//				PreparedStatement statement = connection.prepareStatement(UPDATE_REVIEW_SQL);) {
//			statement.setInt(1, mid);
//			statement.setInt(2, uid);
//			statement.setString(3, review);
//			statement.setInt(4, rid);
//			int i = statement.executeUpdate();
//		}
		if(UpdateReview(rid, mid, uid, review) == true) {
			response.sendRedirect("/movieToday/reviews");
		}
		//UpdateReview(rid, mid, uid, review);

		// Step 3: redirect back to ReviewServlet (note: remember to change the url to
		// your project name)
		

	}

	// method to delete user
	private void deleteReview(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		int rid = Integer.parseInt(request.getParameter("id"));
		// Step 2: Attempt connection with database and execute delete review SQL query
//		try (Connection connection = getConnection();
//				PreparedStatement statement = connection.prepareStatement(DELETE_REVIEW_SQL);) {
//			statement.setInt(1, rid);
//			int i = statement.executeUpdate();
//		}

		if (DeleteReview(rid) == true) {
			response.sendRedirect("/movieToday/reviews");
		}
		
		// Step 3: redirect back to UserServlet dashboard (note: remember to change the
		// url to your project name)
	
	}

	// adding junit for junit testing
	public Review getReviewById(int rid, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int uid = (int) session.getAttribute("id");
		System.out.println("User Id is " + uid);
		int mid = Integer.parseInt(request.getParameter("id"));
		Review existingReview = new Review(rid, mid, uid, "");
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEW_BY_ID);) {
			preparedStatement.setInt(1, rid);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				rid = rs.getInt("id");
				int movie_id = rs.getInt("movie_id");
				int user_id = rs.getInt("user_id");
				String review = rs.getString("review");
				System.out.println("review");
				existingReview = new Review(rid, movie_id, user_id, review);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return existingReview;

	}

	public int CreateReview(int mid, int uid, String r) {
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movieToday", "root", "password");

			// implement the sql query using prepared statement
			// (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)

			PreparedStatement ps = con.prepareStatement("insert into review values(?,?,?,?)");

			// System.out.println("my sessionstorage is " + session.getAttribute("id"));

			// parse in the data retrieved from the web form request into the prepared
			// statement accordingly

			ps.setInt(1, 0);
			ps.setInt(2, mid);
			ps.setInt(3, uid);
			ps.setString(4, r);

			// perform the query on the database using the prepared statement
			i = ps.executeUpdate();
			// check if the query had been successfully execute, return �You are
			// successfully registered� via the response,
			return i;

		}
		// Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);

		}
		return i;
	}

	public boolean UpdateReview(int rid, int mid, int uid, String review)  {

		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_REVIEW_SQL);) {
			statement.setInt(1, mid);
			statement.setInt(2, uid);
			statement.setString(3, review);
			statement.setInt(4, rid);
			int i = statement.executeUpdate();
		} catch (SQLException e) {
		System.out.println(e.getMessage());
		}
		return true;
	}

	public boolean DeleteReview(int rid)  {

		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_REVIEW_SQL);) {
			statement.setInt(1, rid);
			int i = statement.executeUpdate();
			
//			if(i>0) {
//				return true;
//			} else {
//				return false;
//			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return true;

	}
}

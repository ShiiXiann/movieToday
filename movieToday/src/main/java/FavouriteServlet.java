
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movieToday.FavouriteJoin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class FavouriteServlet
 */
@WebServlet("/FavouriteServlet")
public class FavouriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Step 1: Prepare list of variables used for database connections

	private String jdbcURL = "jdbc:mysql://localhost:3306/movieToday";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	// Step 2: Prepare list of SQL prepared statements to perform CRD to our database

	private static final String INSERT_FAVOURITES_SQL = "INSERT INTO favourite" + " (movie_id, user_id) VALUES "
			+ " (?, ?);";

	private static final String SELECT_FAVOURITES_BY_ID = "select movie_id, user_id from favourite where id = ?";
	private static final String SELECT_ALL_FAVOURITES = "select * from favourite ";
	private static final String DELETE_FAVOURITES_SQL = "delete from favourite where id = ?;";
	
	private static final String SELECT_JOIN_FAVOURITES = "SELECT favourite.id, movie.movieName, movie.movieGenre, movie.movieDescription, movie.movieCasts, movie.movieDuration, movie.movieDateRelease, movie.movieImage FROM movie INNER JOIN favourite ON favourite.movie_id=movie.id;";

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
	 * @see HttpServlet#HttpServlet()
	 */
	public FavouriteServlet() {
		super();
		// TODO Auto-generated constructor stub
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
			case "/FavouriteServlet/deleteFavourites":
				System.out.println("test delete fav");
				deleteFavourite(request, response);
				break;
			case "/postFavourite":
				System.out.println("test post");
				PostFavourite(request, response);
				break;
			default:
			case "/FavouriteServlet/display":
				listFavourites(request, response);
				break;
				
			case "/FavouriteServlet/displayJoinTable":
				joinTable(request, response);
				break;

				
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void joinTable(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		
		List<FavouriteJoin> favourites = new ArrayList<>();
		System.out.println("testing join table");
		try (Connection connection = getConnection();

				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_JOIN_FAVOURITES);) {
			
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				int fid = rs.getInt("id");
				String movieName = rs.getString("movieName");
				String movieGenre = rs.getString("movieGenre");
				String movieDescription = rs.getString("movieDescription");
				String movieCasts = rs.getString("movieCasts");
				int movieDuration = rs.getInt("movieDuration");
				String movieDateRelease = rs.getString("movieDateRelease");
				String movieImage = rs.getString("movieImage");
				favourites.add(new FavouriteJoin(fid, movieName, movieGenre, movieDescription, movieCasts, movieDuration,
						movieDateRelease, movieImage));
				
				System.out.println(rs.getInt("id"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// userManagement.jsp

		request.setAttribute("joinTable", favourites);
		request.getRequestDispatcher("/favDisplay.jsp").forward(request, response);
		
	}

	private void PostFavourite(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	// Step 5: listFavourites function to connect to the database and retrieve all favourite records
	private void listFavourites(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Favourite> favourites = new ArrayList<>();
		System.out.println("testing list fav");
		try (Connection connection = getConnection();

				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FAVOURITES);) {
			
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				int fid = rs.getInt("id");
				int movie_id = rs.getInt("movie_id");
				int user_id = rs.getInt("user_id");
				favourites.add(new Favourite(fid, movie_id, user_id));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		// Step 5.4: Set the users list into the listUsers attribute to be pass to the
		// userManagement.jsp

		request.setAttribute("listFavourites", favourites);
		request.getRequestDispatcher("/favDisplay.jsp").forward(request, response);
	}

	// method to delete favourite
	private void deleteFavourite(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		// Step 1: Retrieve value from the request

		int id = Integer.parseInt(request.getParameter("id"));

		// Step 2: Attempt connection with database and execute delete user SQL query

		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_FAVOURITES_SQL);) {
			statement.setInt(1, id);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to FavouriteServlet dashboard (note: remember to change
		// the url to your project name)
		response.sendRedirect("/movieToday/FavouriteServlet/displayJoinTable");
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

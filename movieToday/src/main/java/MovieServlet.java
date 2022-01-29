
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3306/movietoday";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";

	private static final String INSERT_MOVIES_SQL = "INSERT INTO movie"
			+ " (movieName, movieGenre, movieDescription, movieCasts, movieDuration, movieDateRelease, movieImage) VALUES "
			+ " (?, ?, ?,?,?,?,?,?);";

	private static final String SELECT_MOVIE_BY_ID = "select * from movie where id =?";

	private static final String SELECT_ALL_MOVIES = "select * from movie ";

	private static final String DELETE_MOVIE_SQL = "delete from movie where id = ?;";

	private static final String UPDATE_MOVIE_SQL = "update movie set movieName = ?,movieGenre= ?,movieDescription =?,movieCasts =?,movieDuration=?,movieDateRelease = ?, movieImage = ?  where id = ?;";

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
	public MovieServlet() {
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
		String action = request.getServletPath();
		try {
			switch (action) {
//			case "/insert":
//				break;
//			case "/delete":
//				break;
//			case "/edit":
//				break;
//			case "/update":
//				break;
			case "/MovieServlet/display":
				System.out.println("testing");
				listMovies(request, response);
				break;

			case "/MovieServlet/deleteMovie":
				System.out.println("testing delete");
				deleteMovie(request, response);
				break;

			case "/MovieServlet/editMovie":
				System.out.println("testing edit");
				editMovies(request, response);
				break;

			case "/MovieServlet/updateMovie":
				System.out.println("testing update");
				updateMovie(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void editMovies(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int mid = Integer.parseInt(request.getParameter("id"));
		Movie existingMovie = new Movie(mid,"", "", "", "", 0, "","");
		try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MOVIE_BY_ID);) {
//					int mid = Integer.parseInt(request.getParameter("id"));
//					preparedStatement.setInt(1, mid);
					ResultSet rs = preparedStatement.executeQuery();
					while (rs.next()) {
						mid = rs.getInt("id");
						String movieName = rs.getString("movieName");
						String movieGenre = rs.getString("movieGenre");
						String movieDescription = rs.getString("movieDescription");
						String movieCasts = rs.getString("movieCasts");
						float movieDuration = rs.getInt("movieDuration");
						String movieDateRelease = rs.getString("movieDateRelease");
						String movieImage = rs.getString("movieImage");
						existingMovie = new Movie(mid, movieName, movieGenre, movieDescription,movieCasts,movieDuration,movieDateRelease,movieImage);
					    System.out.println("movie id is=" + mid);
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
		request.setAttribute("movie", existingMovie);
		request.getRequestDispatcher("/editMovie.jsp").forward(request, response);
	}
	
	private void updateMovie(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		 int id = Integer.parseInt(request.getParameter("id"));
		 String movieName = request.getParameter("movieName");
		 String movieGenre = request.getParameter("movieGenre");
		 String movieDescription = request.getParameter("movieDescription");
		 String movieCasts = request.getParameter("movieCasts");
		 int movieDuration = Integer.parseInt(request.getParameter("movieDuration"));
		 String movieDateRelease = request.getParameter("movieDateRelease");
		 String movieImage = request.getParameter("movieImage");
		 try (Connection connection = getConnection(); PreparedStatement statement =
				 connection.prepareStatement(UPDATE_MOVIE_SQL);) {
				  statement.setString(1, movieName);
				  statement.setString(2, movieGenre);
				  statement.setString(3, movieDescription);
				  statement.setString(4, movieCasts);
				  statement.setInt(5, movieDuration);
				  statement.setString(6, movieDateRelease);
				  statement.setString(7, movieImage);
				  statement.setInt(8, id);
				  int i = statement.executeUpdate();
				  }
//		 response.sendRedirect("http://localhost:8080/movieToday/MovieServlet/updateMovie");
		 response.sendRedirect("http://localhost:8080/movieToday/MovieServlet/display");
	}
	
	private void deleteMovie(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try (Connection connection = getConnection(); PreparedStatement statement =
				connection.prepareStatement(DELETE_MOVIE_SQL);) {
				 statement.setInt(1, id);
				 int i = statement.executeUpdate();
				 }
//		 response.sendRedirect("http://localhost:8080/movieToday/MovieServlet/deleteMovie");
		 response.sendRedirect("http://localhost:8080/movieToday/MovieServlet/display");
	}

	private void listMovies(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Movie> movies = new ArrayList<>();
		System.out.println("testing 2");
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOVIES);) {
//			int mid = Integer.parseInt(request.getParameter("id"));
//			preparedStatement.setInt(1, mid);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int mid = rs.getInt("id");
				String movieName = rs.getString("movieName");
				String movieGenre = rs.getString("movieGenre");
				String movieDescription = rs.getString("movieDescription");
				String movieCasts = rs.getString("movieCasts");
				int movieDuration = rs.getInt("movieDuration");
				String movieDateRelease = rs.getString("movieDateRelease");
				String movieImage = rs.getString("movieImage");
				movies.add(new Movie(mid, movieName, movieGenre, movieDescription, movieCasts, movieDuration,
						movieDateRelease, movieImage));
				System.out.println(movies);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("listMovies", movies);
		request.getRequestDispatcher("/movieDisplay.jsp").forward(request, response);

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

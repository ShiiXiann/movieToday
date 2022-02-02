
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class CMovieServlet
 */
@WebServlet("/CMovieServlet")
public class CMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CMovieServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String movieName = request.getParameter("movieName");
		String movieGenre = request.getParameter("movieGenre");
		String movieDescription = request.getParameter("movieDescription");
		String movieCasts = request.getParameter("movieCasts");
		String movieDuration = request.getParameter("movieDuration");
		String movieDateRelease = request.getParameter("movieDateRelease");
		String movieImage = request.getParameter("movieImage");
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection(
			 "jdbc:mysql://localhost:3306/movietoday", "root", "password");
	
		PreparedStatement ps = con.prepareStatement("insert into movie values(?,?,?,?,?,?,?,?)");
		 ps.setInt(1, 0);
		 ps.setString(2, movieName);
		 ps.setString(3, movieGenre);
		 ps.setString(4, movieDescription);
		 ps.setString(5, movieCasts);
		 ps.setString(6, movieDuration);
		 ps.setString(7, movieDateRelease);
		 ps.setString(8, movieImage);
		 int i = ps.executeUpdate();
		 if (i > 0){
//			 PrintWriter writer = response.getWriter();
//			 writer.println("<h1>" + "You have successfully added a movie." +
//			 "</h1>");
//			 writer.close();
			 response.sendRedirect("http://localhost:8080/movieToday/MovieServlet/display");
			 }
		 }
		 
	
		catch (Exception exception) {
			 System.out.println(exception);
			 out.close();
			}
	
	doGet(request, response);

	}
}

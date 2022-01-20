
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String movieName = request.getParameter("movieName");
		String movieGenre = request.getParameter("movieGenre");
		String movieDescription = request.getParameter("movieDescription");
		String movieCasts = request.getParameter("movieCasts");
		String movieDuration = request.getParameter("movieDuration");
		String movieDateRelease = request.getParameter("movieDateRelease");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>" + movieName + " has been added</h1>");
		writer.close();
		doGet(request, response);
	}

}

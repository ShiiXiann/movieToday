
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Import these libraries from java.io and java.sql
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		response.setContentType("text/html");
		// Step 1: Initialize a PrintWriter object to return the html values via the
		// response
		// 1st
		PrintWriter out = response.getWriter();
		// Step 2: retrieve the four parameters from the request from the web form
		String n = request.getParameter("username");
		String p = request.getParameter("password");
		String e = request.getParameter("email");
		String c = request.getParameter("phoneNumber");
		// Step 3: attempt connection to database using JDBC, you can change the
		// username and password accordingly using the phpMyAdmin > User Account
		// dashboard

		// 2nd
		int i = RegisterFunction(n, p, e, c);

		// 3rd
		if (i > 0) {
			PrintWriter writer = response.getWriter();
			writer.println("<h1>" + "You have successfully registered an account!" + "</h1>");
			response.sendRedirect("/movieToday/login.jsp");
			writer.close();
		}

		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static int RegisterFunction(String n, String p, String e, String c)  {
		// PrintWriter out = response.getWriter();
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movietoday", "root", "password");
			// Step 4: implement the sql query using prepared statement
			// (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?)");
			// Step 5: parse in the data retrieved from the web form request into the
			// prepared statement accordingly
			ps.setInt(1, 0);
			ps.setString(2, n);
			ps.setString(3, p);
			ps.setString(4, e);
			ps.setString(5, c);
			// Step 6: perform the query on the database using the prepared statement
			i = ps.executeUpdate();
			// Step 7: check if the query had been successfully execute, return �You are
			// successfully registered� via the response,
			return i;
		}
		// Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
			// out.close();
		}
		return i;
		
	}
}

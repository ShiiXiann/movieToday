
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

	private static final String SELECT_USER_BY_ID = "select name,password,email,phoneNumber from user where id =?";
	private static final String SELECT_ALL_USERS = "select * from user ";
	private static final String DELETE_USERS_SQL = "delete from user where name = ?;";
	private static final String UPDATE_USERS_SQL = "update user set name = ?,password= ?,email =?,language =? where name = ?;";

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
				loginUsers(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}


	private void loginUsers (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException 
	{
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String enteredUsername = request.getParameter("username");
		String enteredPassword = request.getParameter("password");
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_USER_SQL);){
			preparedStatement.setString(1, enteredUsername);
			preparedStatement.setString(2, enteredPassword);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				if (rs.getString("username").equals(enteredUsername) && (rs.getString("password").equals(enteredPassword))) {
					
						int uid = rs.getInt("id");
						String username = rs.getString("username");
						
						session.setAttribute("id", uid);
						session.setAttribute("username", username);
						session.setAttribute("isLoggedIn", true);
						System.out.println(session.getAttribute("id"));
						System.out.println(session.getAttribute("username"));
						response.sendRedirect("http://localhost:8082/movieToday/profile.jsp");
				}
			}
			else {
				request.setAttribute("errorMessage", "Invalid user or password");
				System.out.println("Wrong username or password");
				response.sendRedirect("http://localhost:8082/movieToday/login.jsp");
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
				
	}
	
	private void LogOutUser (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException 
	{
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		System.out.println("You are logged out");
		response.sendRedirect("http://localhost:8082/movieToday/login.jsp");
		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// For login
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

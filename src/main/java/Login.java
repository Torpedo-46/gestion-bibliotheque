

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		String user=request.getParameter("email");
		String pass=request.getParameter("pass");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("OK pour le NomDriver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotique","root","");
				
			PreparedStatement pst =c.prepareStatement("select num from usere where nome=? and pass=? ");
			pst.setString(1, user);
			pst.setString(2,pass);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				session.setAttribute("admin", user);
				response.sendRedirect("dashboard.jsp");
				
				
			}else {
				response.sendRedirect("login.jsp");
				
				
			}
	}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}

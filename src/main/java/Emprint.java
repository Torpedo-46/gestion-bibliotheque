

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Emprint
 */
@WebServlet("/Emprint")
public class Emprint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String apogee=request.getParameter("apogee");
		String name=request.getParameter("name");
		String location=request.getParameter("location");
		
		String emprint=request.getParameter("emprint");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("OK pour le NomDriver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotique","root","");
				
			PreparedStatement pst =c.prepareStatement("INSERT INTO emprint ( apogee, Book_name, location, emprint_d) VALUES ( ?, ?, ?, ?)");
			pst.setString(1, apogee);
			pst.setString(2, name);
			pst.setString(3, location);
		
			pst.setString(4, emprint);
			
			pst.executeUpdate();
			
				
			response.sendRedirect("Dash_emp.jsp");
		     pst.close();
			c.close();
				
				
			
	}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	}



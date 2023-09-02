

import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Ajouter")
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		String genre=request.getParameter("Genre");
		String date=request.getParameter("date");
		String location=request.getParameter("location");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("OK pour le NomDriver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotique","root","");
				
			PreparedStatement pst =c.prepareStatement("INSERT INTO livre ( name, author, genre, date, location) VALUES ( ?, ?, ?, ?, ?)");
			pst.setString(1, name);
			pst.setString(2, author);
			pst.setString(3, genre);
			pst.setString(4, date);
			pst.setString(5, location);
			
			pst.executeUpdate();
			
				
			response.sendRedirect("dashboard.jsp");
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




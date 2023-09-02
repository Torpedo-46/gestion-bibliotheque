

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
 * Servlet implementation class DeleteEmp
 */
@WebServlet("/DeleteEmp")
public class DeleteEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id_emp=request.getParameter("id_emp");
		 try {
   			Class.forName("com.mysql.cj.jdbc.Driver");
   			
   			
   			
   			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotique","root","");
			PreparedStatement pst =c.prepareStatement("delete from emprint where id_emp=?");
			pst.setString(1, id_emp);
			
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

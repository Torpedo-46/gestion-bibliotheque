

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Rechercher
 */
@WebServlet("/r")
public class Rechercher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImtBook met;
	public void init() {
		met=new ImtBook();
	}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mcl=request.getParameter("mcl");
		BookM m=new BookM();
		m.setMcl(mcl);
		List<Book> books=met.getBook(mcl);
		m.setBooks(books);
		request.setAttribute("model", m);
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		
		

}
	
	}



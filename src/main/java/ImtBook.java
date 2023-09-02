import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImtBook implements IntBook {

	@Override
	public List<Book> getBook(String mcl) {
		List<Book> books =new ArrayList<Book>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("OK pour le NomDriver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotique","root","");
				
			PreparedStatement pst =c.prepareStatement("select * from livre where name LIKE ? ");
			pst.setString(1,"%"+mcl+"%");
			
			ResultSet rs=pst.executeQuery();
        while(rs.next()) {
				
			Book book =new Book();	
			book.setId(rs.getInt("id"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setGenre(rs.getString("genre"));
			book.setDate(rs.getString("date"));
			book.setLocation(rs.getString("location"));
			books.add(book);
				
				
				
				
			
				
				
			}
	}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public void addBook() {
		// TODO Auto-generated method stub
		
	}

}

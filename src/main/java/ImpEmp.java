import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImpEmp implements IntEmp {

	@Override
	public List<Student> getStudent(String mc) {
		
		List<Student> std =new ArrayList<Student>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("OK pour le NomDriver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotique","root","");
				
			PreparedStatement pst =c.prepareStatement("select * from emprint where apogee LIKE ? ");
			pst.setString(1,"%"+mc+"%");
			
			ResultSet rs=pst.executeQuery();
        while(rs.next()) {
				
			Student s=new Student();	
			s.setId_emp(rs.getInt("id_emp"));
			s.setApogee(rs.getString("apogee"));
			s.setName(rs.getString("Book_name"));
			s.setLocation(rs.getString("location"));
			s.setEmprint_d(rs.getString("emprint_d"));
			
			std.add(s);
				
				
				
				
			
				
				
			}
	}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return std;
	}

	}



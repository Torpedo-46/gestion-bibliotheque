import java.io.Serializable;

public class Student implements Serializable {
	int id_emp;
	String name;
	String Apogee;
	String location;
	String emprint_d;
	
	
	public Student() {
		
	}
	public Student(String apogee, String location, String emprint_d) {
		super();
		Apogee = apogee;
		this.location = location;
		this.emprint_d = emprint_d;
	}
	public int getId_emp() {
		return id_emp;
	}
	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
	}
	public String getApogee() {
		return Apogee;
	}
	public void setApogee(String apogee) {
		Apogee = apogee;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmprint_d() {
		return emprint_d;
	}
	public void setEmprint_d(String emprint_d) {
		this.emprint_d = emprint_d;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

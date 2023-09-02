import java.io.Serializable;

public class Book implements Serializable{
	int id;
	String name;
	String author;
	String genre;
	String date;
	String location;
	
	
	public Book() {
		
	}
	public Book(String name, String author, String genre, String date, String location) {
		super();
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.date = date;
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	

}

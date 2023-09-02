import java.util.ArrayList;
import java.util.List;

public class BookM {
	private String mcl;
	private List<Book> books=new ArrayList<Book>();
	public String getMcl() {
		return mcl;
	}
	public void setMcl(String mcl) {
		this.mcl = mcl;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	

}

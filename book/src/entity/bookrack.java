package entity;

public class bookrack {
	private int bookrackId;
	private String bookrackName;
	public bookrack() {
		super();
		// TODO Auto-generated constructor stub
	}
	public bookrack(int bookrackId, String bookrackName) {
		super();
		this.bookrackId = bookrackId;
		this.bookrackName = bookrackName;
	}
	public int getBookrackId() {
		return bookrackId;
	}
	public void setBookrackId(int bookrackId) {
		this.bookrackId = bookrackId;
	}
	public String getBookrackName() {
		return bookrackName;
	}
	public void setBookrackName(String bookrackName) {
		this.bookrackName = bookrackName;
	}
	@Override
	public String toString() {
		return "bookrack [bookrackId=" + bookrackId + ", bookrackName=" + bookrackName + "]";
	}
	
}

package entity;

import dao.bookTypeDAO;
import dao.bookrackDAO;
import dao.languageDAO;
import dao.publishDAO;

public class book {
	private int bookId;
	private int typeId;
	private int languageId;
	private String bookTitle;
	private String author;
	private int publishId;
	private int bookrackId;
	private int inventory;
	private int loan;
	private bookType bt;
	private language language;
	private publish publish;
	private bookrack bookrack;
	
	public book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public book(int bookId, int typeId, int languageId, String bookTitle, String author, int publishId, int bookrackId,
			int inventory, int loan, bookType bt, entity.language language, entity.publish publish) {
		super();
		this.bookId = bookId;
		this.typeId = typeId;
		this.languageId = languageId;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publishId = publishId;
		this.bookrackId = bookrackId;
		this.inventory = inventory;
		this.loan = loan;
		this.bt = bt;
		this.language = language;
		this.publish = publish;
	}

	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublishId() {
		return publishId;
	}

	public void setPublishId(int publishId) {
		this.publishId = publishId;
	}

	public int getBookrackId() {
		return bookrackId;
	}

	public void setBookrackId(int bookrackId) {
		this.bookrackId = bookrackId;
	}

	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public int getLoan() {
		return loan;
	}
	public void setLoan(int loan) {
		this.loan = loan;
	}
	public bookType getBt() {
		bookTypeDAO dao=new bookTypeDAO();
		bookType bt=dao.queryId(typeId);
		return bt;
	}
	public language getLanguage() {
		languageDAO dao=new languageDAO();
		language language=dao.queryId(languageId);
		return language;
	}
	public publish getPublish() {
		publishDAO dao=new publishDAO();
		publish publish=dao.queryId(publishId);
		return publish;
	}
	public bookrack getBookrack() {
		bookrackDAO dao=new bookrackDAO();
		bookrack bookrack=dao.queryId(bookrackId);
		return bookrack;
	}
	public void setBt(bookType bt) {
		this.bt = bt;
	}
	@Override
	public String toString() {
		return "book [bookId=" + bookId + ", typeId=" + typeId + ", languageId=" + languageId + ", bookTitle=" + bookTitle
				+ ", author=" + author + ", publishId=" + publishId + ", bookrackId=" + bookrackId + ", inventory="
				+ inventory + ", loan=" + loan + "]";
	}

	
}

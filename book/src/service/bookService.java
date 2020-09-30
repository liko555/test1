package service;

import java.util.List;

import dao.bookDAO;
import entity.book;

public class bookService {
	//查询所有
	public List<book> getBook(){
		bookDAO dao=new bookDAO();
		return dao.query();
	}
	
	//查询根据bookId
	public book getBook(int bookId) {
		bookDAO dao=new bookDAO();
		return dao.query(bookId);
	}

	//查询按照页数
	public List<book> getBook(int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		List<book> list=dao.query(bPageNo, bPageSize);
		return list;
	}
	
	//总页码
	public int getBookLine() {
		bookDAO dao=new bookDAO();
		return dao.queryCount();
	}
	
	//添加
	public boolean addBook(book book) {
		bookDAO dao=new bookDAO();
		int row=dao.insert(book);
		if(row>0) {
			//添加成功
			return true;
		}
		return false;
	}
	
	//修改漫画
	public boolean modifyBook(book book) {
		bookDAO dao=new bookDAO();
		int row=dao.update(book);
		if(row>0) {
			//修改成功
			return true;
		}
		return false;
	}
	public boolean modifyBookLoan(int bookId,int loan) {
		bookDAO dao=new bookDAO();
		int row=dao.updateLoan(bookId,loan);
		if(row>0) {
			//成功
			return true;
		}
		return false;
	}
	//删除图书
	public boolean removeBook(int bookId) {
		bookDAO dao=new bookDAO();
		int row=dao.del(bookId);
		if(row>=0) {
			return true;
		}
		return false;
	}
	
	//查询所有根据图书标题，返回list
	public List<book> titlegetBook(String bookTitle,int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		return dao.queryTitle(bookTitle,bPageNo,bPageSize);
	}
	//总页码
	public int getBookTitleLine(String bookTitle) {
		bookDAO dao=new bookDAO();
		return dao.querytitleCount(bookTitle);
	}
	
	//查询所有根据图书id，返回list
	public List<book> BookIdgetBook(int BookId,int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		return dao.queryBookId(BookId,bPageNo,bPageSize);
	}
	//总页码
	public int getBookIdLine(int BookId) {
		bookDAO dao=new bookDAO();
		return dao.queryBookIdCount(BookId);
	}
	
	//查询所有根据图书标题，返回list
	public List<book> authorgetBook(String author,int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		return dao.queryAuthor(author,bPageNo,bPageSize);
	}
	//title总页码
	public int getauthorLine(String author) {
		bookDAO dao=new bookDAO();
		return dao.queryAuthorCount(author);
	}
	//查询所有根据图书publishName，返回list
	public List<book> publishNamegetBook(int publishId,int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		return dao.queryPublish(publishId,bPageNo,bPageSize);
	}
	//publishName总页码
	public int getpublishNameLine(int publishId) {
		bookDAO dao=new bookDAO();
		return dao.queryPublishNameCount(publishId);
	}
	//查询所有根据图书typeName，返回list
	public List<book> typeNamegetBook(int typeId,int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		return dao.queryType(typeId,bPageNo,bPageSize);
	}
	//TypeName总页码
	public int getTypeNameLine(int typeId) {
		bookDAO dao=new bookDAO();
		return dao.queryTypeNameCount(typeId);
	}
	//查询所有根据图书typeName，返回list
	public List<book> languagegetBook(int languageId,int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		return dao.querylanguage(languageId,bPageNo,bPageSize);
	}
	//TypeName总页码
	public int getlanguageLine(int languageId) {
		bookDAO dao=new bookDAO();
		return dao.querylanguageCount(languageId);
	}
	//查询所有根据图书typeName，返回list
	public List<book> bookrackgetBook(int bookrackId,int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		return dao.querybookrack(bookrackId,bPageNo,bPageSize);
	}
	//TypeName总页码
	public int getbookrackLine(int bookrackId) {
		bookDAO dao=new bookDAO();
		return dao.querybookrackCount(bookrackId);
	}
	//查询根据bookId
	public int getBookId(String bookTitle) {
		bookDAO dao=new bookDAO();
		book book=dao.query(bookTitle);
		return book.getBookId();
	}
}

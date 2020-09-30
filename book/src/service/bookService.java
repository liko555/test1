package service;

import java.util.List;

import dao.bookDAO;
import entity.book;

public class bookService {
	//��ѯ����
	public List<book> getBook(){
		bookDAO dao=new bookDAO();
		return dao.query();
	}
	
	//��ѯ����bookId
	public book getBook(int bookId) {
		bookDAO dao=new bookDAO();
		return dao.query(bookId);
	}

	//��ѯ����ҳ��
	public List<book> getBook(int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		List<book> list=dao.query(bPageNo, bPageSize);
		return list;
	}
	
	//��ҳ��
	public int getBookLine() {
		bookDAO dao=new bookDAO();
		return dao.queryCount();
	}
	
	//���
	public boolean addBook(book book) {
		bookDAO dao=new bookDAO();
		int row=dao.insert(book);
		if(row>0) {
			//��ӳɹ�
			return true;
		}
		return false;
	}
	
	//�޸�����
	public boolean modifyBook(book book) {
		bookDAO dao=new bookDAO();
		int row=dao.update(book);
		if(row>0) {
			//�޸ĳɹ�
			return true;
		}
		return false;
	}
	public boolean modifyBookLoan(int bookId,int loan) {
		bookDAO dao=new bookDAO();
		int row=dao.updateLoan(bookId,loan);
		if(row>0) {
			//�ɹ�
			return true;
		}
		return false;
	}
	//ɾ��ͼ��
	public boolean removeBook(int bookId) {
		bookDAO dao=new bookDAO();
		int row=dao.del(bookId);
		if(row>=0) {
			return true;
		}
		return false;
	}
	
	//��ѯ���и���ͼ����⣬����list
	public List<book> titlegetBook(String bookTitle,int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		return dao.queryTitle(bookTitle,bPageNo,bPageSize);
	}
	//��ҳ��
	public int getBookTitleLine(String bookTitle) {
		bookDAO dao=new bookDAO();
		return dao.querytitleCount(bookTitle);
	}
	
	//��ѯ���и���ͼ��id������list
	public List<book> BookIdgetBook(int BookId,int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		return dao.queryBookId(BookId,bPageNo,bPageSize);
	}
	//��ҳ��
	public int getBookIdLine(int BookId) {
		bookDAO dao=new bookDAO();
		return dao.queryBookIdCount(BookId);
	}
	
	//��ѯ���и���ͼ����⣬����list
	public List<book> authorgetBook(String author,int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		return dao.queryAuthor(author,bPageNo,bPageSize);
	}
	//title��ҳ��
	public int getauthorLine(String author) {
		bookDAO dao=new bookDAO();
		return dao.queryAuthorCount(author);
	}
	//��ѯ���и���ͼ��publishName������list
	public List<book> publishNamegetBook(int publishId,int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		return dao.queryPublish(publishId,bPageNo,bPageSize);
	}
	//publishName��ҳ��
	public int getpublishNameLine(int publishId) {
		bookDAO dao=new bookDAO();
		return dao.queryPublishNameCount(publishId);
	}
	//��ѯ���и���ͼ��typeName������list
	public List<book> typeNamegetBook(int typeId,int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		return dao.queryType(typeId,bPageNo,bPageSize);
	}
	//TypeName��ҳ��
	public int getTypeNameLine(int typeId) {
		bookDAO dao=new bookDAO();
		return dao.queryTypeNameCount(typeId);
	}
	//��ѯ���и���ͼ��typeName������list
	public List<book> languagegetBook(int languageId,int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		return dao.querylanguage(languageId,bPageNo,bPageSize);
	}
	//TypeName��ҳ��
	public int getlanguageLine(int languageId) {
		bookDAO dao=new bookDAO();
		return dao.querylanguageCount(languageId);
	}
	//��ѯ���и���ͼ��typeName������list
	public List<book> bookrackgetBook(int bookrackId,int bPageNo,int bPageSize){
		bookDAO dao=new bookDAO();
		return dao.querybookrack(bookrackId,bPageNo,bPageSize);
	}
	//TypeName��ҳ��
	public int getbookrackLine(int bookrackId) {
		bookDAO dao=new bookDAO();
		return dao.querybookrackCount(bookrackId);
	}
	//��ѯ����bookId
	public int getBookId(String bookTitle) {
		bookDAO dao=new bookDAO();
		book book=dao.query(bookTitle);
		return book.getBookId();
	}
}

package service;

import java.util.List;

import dao.bookrackDAO;
import dao.languageDAO;
import entity.bookrack;
import entity.language;

public class bookrackService {
	//²éÑ¯ËùÓÐ
	public List<bookrack> getBookracks(){
		bookrackDAO dao = new bookrackDAO();
		return dao.queryAll();
	}
	public int getbookrackId(String bookrackName) {
		bookrackDAO dao = new bookrackDAO();
		bookrack bookrack=dao.query(bookrackName);
		if(bookrack==null) {
			return 0;
		}
		return bookrack.getBookrackId();
	}
}

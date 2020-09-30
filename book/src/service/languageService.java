package service;

import java.util.List;

import dao.bookDAO;
import dao.bookTypeDAO;
import dao.languageDAO;
import entity.language;

public class languageService {
	//查询所有
		public List<language> getLanguages(){
			languageDAO dao = new languageDAO();
			return dao.queryAll();
		}
		
		public int getlanguageId(String languageName) {
			languageDAO dao = new languageDAO();
			language language=dao.query(languageName);
			if(language!=null) {
				return language.getLanguageId();
			}
			return 0;
		}
		
		public List<language> getLanguage(int pageNo,int pageSize){
			languageDAO dao=new languageDAO();
			List<language> list=dao.query(pageNo, pageSize);
			return list;
		}
		public int getLanguageLine() {
			languageDAO dao=new languageDAO();
			return dao.queryCount();
		}
		/*删除文种类型*/
		public boolean removeLanguage(int languageId) {
			//删除漫画类型：先删除这个漫画类型下的所有漫画，然后删除这个类型
			bookDAO bdao=new bookDAO();
			int crow=bdao.delLanguageId(languageId);
			
			languageDAO dao=new languageDAO();
			int row = dao.del(languageId);
			if(row>=0&&crow>=0) {
				return true;
			}
			return false;
		}
}

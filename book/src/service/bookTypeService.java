package service;

import java.util.List;

import dao.bookDAO;
import dao.bookTypeDAO;
import entity.bookType;

public class bookTypeService {
	//查询所有
	public List<bookType> getbookTypes(){
		bookTypeDAO dao = new bookTypeDAO();
		return dao.queryAll();
	}
	 /*通过数据库添加漫画类型，结果返回 添加成功or失败*/
	public boolean addType(bookType bookType) {
		//先判断用户新输入的类型名，数据库中是否存在同名的，存在不增加，不存在增加
		bookTypeDAO dao=new bookTypeDAO();
		//存在性判断
		bookType temp = dao.query(bookType.getTypeName());
		if(temp==null) {
			//不存在 添加
			int row = dao.insert(bookType);
			if(row>0) {
				//添加成功
				return true;
			}
		}

		return false;
	}
	/*判断查询（删除）的名字是否存在才能进行更新（删除）操作*/
	//查询相应的数据
	public bookType getbookType(int booktypeId) {
		bookTypeDAO dao = new bookTypeDAO();
		return dao.queryId(booktypeId);
	}
	public int getName(String typeName) {
		bookTypeDAO dao = new bookTypeDAO();
		bookType bookType=dao.query(typeName);
		if(bookType!=null) {
			return bookType.getTypeId();
		}else {
			return 0;
		}
	}
	public List<bookType> getbookType(String typeName) {
		bookTypeDAO dao=new bookTypeDAO();
		return dao.query2(typeName);
	}
	
	//根据bookid查询漫画信息
	public bookType getbookName(int bookId) {
		bookTypeDAO dao = new bookTypeDAO();
		return dao.queryTypeName(bookId);
	}

	/*修改漫画类型*/
	public boolean modifyType(bookType bookType) {
		bookTypeDAO dao=new bookTypeDAO();
		bookType temp=dao.query(bookType.getTypeName());
		if(temp == null) {
			int row = dao.update(bookType);
			if(row >= 0) {
				return true;
			}
		}
		return false;
	}
	/*删除漫画类型*/
	public boolean removeType(int bookTypeId) {
		//删除漫画类型：先删除这个漫画类型下的所有漫画，然后删除这个类型
		bookDAO bdao=new bookDAO();
		int crow=bdao.delTypeID(bookTypeId);
		
		bookTypeDAO dao=new bookTypeDAO();
		int row = dao.del(bookTypeId);
		if(row>=0&&crow>=0) {
			return true;
		}
		return false;
	}
	public List<bookType> getBookType(int pageNo,int pageSize){
		bookTypeDAO dao = new bookTypeDAO();
		List<bookType> list = dao.query(pageNo, pageSize);
		return list;
	}
	public int getBookTypeLine() {
		bookTypeDAO dao = new bookTypeDAO();
		return dao.queryCount();
	}
}

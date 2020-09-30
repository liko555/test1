package service;

import java.util.List;

import dao.bookDAO;
import dao.bookTypeDAO;
import dao.userDAO;
import entity.book;
import entity.bookType;
import entity.user;

public class userService {
	public user login(String userName, String userPwd) {
		userDAO dao=new userDAO();
		return dao.userLogin(userName, userPwd);
	}
	
	//查询按照页数
	public List<user> getUser(int bPageNo,int bPageSize){
		userDAO dao=new userDAO();
		List<user> list=dao.query(bPageNo, bPageSize);
		return list;
	}
	//查询按照名字
	public List<user> getUser(String userName){
		userDAO dao=new userDAO();
		List<user> list=dao.query2(userName);
		return list;
	}
	
	//总页码
	public int getUserLine() {
		userDAO dao=new userDAO();
		return dao.queryCount();
	}
	//查询相应的数据
	public user getUser(int userId) {
		userDAO dao = new userDAO();
		return dao.queryId(userId);
	}
	//查询相应的数据
	public int getUserId(String userName) {
		userDAO dao = new userDAO();
		user user= dao.queryId(userName);
		return user.getUserId(); 
	}
	//插入
	public boolean addUser(user user) {
		//先判断用户新输入的类型名，数据库中是否存在同名的，存在不增加，不存在增加
		userDAO dao=new userDAO();
		int row=dao.insert(user);
		if(row>0) {
			return true;
		}
		return false;
	}
	//修改user
	public boolean modifyUser(user user) {
		userDAO dao=new userDAO();
		int row=dao.update(user);
		if(row>0) {
			//修改成功
			return true;
		}
		return false;
	}
	
	//删除user
	public boolean removeUser(int userId) {
		userDAO dao=new userDAO();
		int row=dao.delUser(userId);
		if(row>=0) {
			return true;
		}
		return false;
	}
}

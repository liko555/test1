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
	
	//��ѯ����ҳ��
	public List<user> getUser(int bPageNo,int bPageSize){
		userDAO dao=new userDAO();
		List<user> list=dao.query(bPageNo, bPageSize);
		return list;
	}
	//��ѯ��������
	public List<user> getUser(String userName){
		userDAO dao=new userDAO();
		List<user> list=dao.query2(userName);
		return list;
	}
	
	//��ҳ��
	public int getUserLine() {
		userDAO dao=new userDAO();
		return dao.queryCount();
	}
	//��ѯ��Ӧ������
	public user getUser(int userId) {
		userDAO dao = new userDAO();
		return dao.queryId(userId);
	}
	//��ѯ��Ӧ������
	public int getUserId(String userName) {
		userDAO dao = new userDAO();
		user user= dao.queryId(userName);
		return user.getUserId(); 
	}
	//����
	public boolean addUser(user user) {
		//���ж��û�������������������ݿ����Ƿ����ͬ���ģ����ڲ����ӣ�����������
		userDAO dao=new userDAO();
		int row=dao.insert(user);
		if(row>0) {
			return true;
		}
		return false;
	}
	//�޸�user
	public boolean modifyUser(user user) {
		userDAO dao=new userDAO();
		int row=dao.update(user);
		if(row>0) {
			//�޸ĳɹ�
			return true;
		}
		return false;
	}
	
	//ɾ��user
	public boolean removeUser(int userId) {
		userDAO dao=new userDAO();
		int row=dao.delUser(userId);
		if(row>=0) {
			return true;
		}
		return false;
	}
}

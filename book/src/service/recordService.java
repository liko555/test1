package service;

import java.util.List;

import dao.recordDAO;
import entity.record;

public class recordService {
	//��ѯ����
	public List<record> getRecord(){
		recordDAO dao=new recordDAO();
		return dao.queryAll();
	}
	//��������û�з������ڵļ�¼
	public List<record> getNotTime(int pageNo,int pageSize){
		recordDAO dao=new recordDAO();
		return dao.queryNotTime(pageNo, pageSize);
	}
	public int getNotTimeLine() {
		recordDAO dao=new recordDAO();
		return dao.queryNotTimeCount();
	}
	//����UserId��ѯ��¼
	public List<record> getUserId(int userId,int pageNo,int pageSize){
		recordDAO dao=new recordDAO();
		return dao.queryUserId(userId, pageNo, pageSize);
	}
	public int getUserIdLine(int userId) {
		recordDAO dao=new recordDAO();
		return dao.queryUserIdCount(userId);
	}
	
	//����bookId��ѯ��¼
	public List<record> getBookId(int bookId,int pageNo,int pageSize){
		recordDAO dao=new recordDAO();
		return dao.queryBookId(bookId, pageNo, pageSize);
	}
	public int getBookIdLine(int bookId) {
		recordDAO dao=new recordDAO();
		return dao.queryBookIdCount(bookId);
	}
	//��ҳ��ѯ
	//��ѯ����ҳ��
	public List<record> getRecord(int bPageNo,int bPageSize){
		recordDAO dao=new recordDAO();
		List<record> list=dao.query(bPageNo, bPageSize);
		return list;
	}
	
	//���
	public boolean addRecord(record record) {
		recordDAO dao=new recordDAO();
		int row=dao.insert(record);
		if(row>0) {
			//��ӳɹ�
			return true;
		}
		return false;
	}
	//��ҳ��
	public int getRecordLine() {
		recordDAO dao=new recordDAO();
		return dao.queryCount();
	}
	
	//�޸�����
	public boolean updateTime(int recordId) {
		recordDAO dao=new recordDAO();
		int row =dao.updateTime(recordId);
		if(row>0) {
			//��ӳɹ�
			return true;
		}
		return false;
	}
	
	//�������г�ʱ�ļ�¼
	public List<record> getExceedTime(int pageNo,int pageSize){
		recordDAO dao=new recordDAO();
		return dao.queryExceedTime(pageNo, pageSize);
	}
	public int getExceedTimeLine() {
		recordDAO dao=new recordDAO();
		return dao.queryExceedTimeCount();
	}
	//userId��ѯ�û���δ�ύ
	public List<record> getUserNotTime(int userId,int pageNo,int pageSize){
		recordDAO dao=new recordDAO();
		return dao.queryUserNotTime(userId, pageNo, pageSize);
	}
	public int getUserNotTimeLine(int userId) {
		recordDAO dao=new recordDAO();
		return dao.queryUserNotTimeCount(userId);
	}
	
	//userId��ѯ�û��Ľ��˵�
	public List<record> getUserHavaTime(int userId,int pageNo,int pageSize){
		recordDAO dao=new recordDAO();
		return dao.queryUserHavaTime(userId, pageNo, pageSize);
	}
	public int getUserHavaTimeLine(int userId) {
		recordDAO dao=new recordDAO();
		return dao.queryUserHaveTimeCount(userId);
	}
	
	public List<record> getUserBookId(int bookId,int userId,int pageNo,int pageSize){
		recordDAO dao=new recordDAO();
		return dao.queryUserBookId(bookId, userId, pageNo, pageSize);
	}
	public int getUserBookIdLine(int bookId,int userId) {
		recordDAO dao=new recordDAO();
		return dao.queryUserBookIdCount(bookId, userId);
	}
	public List<record> getUserExceedTime(int userId,int pageNo,int pageSize){
		recordDAO dao=new recordDAO();
		return dao.queryUserExceedTime(userId, pageNo, pageSize);
	}
	public int getUseExceedTimeLine(int userId) {
		recordDAO dao=new recordDAO();
		return dao.queryUserExceedTimeCount(userId);
	}
	
}

package service;

import java.util.List;

import dao.recordDAO;
import entity.record;

public class recordService {
	//查询所有
	public List<record> getRecord(){
		recordDAO dao=new recordDAO();
		return dao.queryAll();
	}
	//查找所有没有返回日期的记录
	public List<record> getNotTime(int pageNo,int pageSize){
		recordDAO dao=new recordDAO();
		return dao.queryNotTime(pageNo, pageSize);
	}
	public int getNotTimeLine() {
		recordDAO dao=new recordDAO();
		return dao.queryNotTimeCount();
	}
	//按照UserId查询记录
	public List<record> getUserId(int userId,int pageNo,int pageSize){
		recordDAO dao=new recordDAO();
		return dao.queryUserId(userId, pageNo, pageSize);
	}
	public int getUserIdLine(int userId) {
		recordDAO dao=new recordDAO();
		return dao.queryUserIdCount(userId);
	}
	
	//按照bookId查询记录
	public List<record> getBookId(int bookId,int pageNo,int pageSize){
		recordDAO dao=new recordDAO();
		return dao.queryBookId(bookId, pageNo, pageSize);
	}
	public int getBookIdLine(int bookId) {
		recordDAO dao=new recordDAO();
		return dao.queryBookIdCount(bookId);
	}
	//分页查询
	//查询按照页数
	public List<record> getRecord(int bPageNo,int bPageSize){
		recordDAO dao=new recordDAO();
		List<record> list=dao.query(bPageNo, bPageSize);
		return list;
	}
	
	//添加
	public boolean addRecord(record record) {
		recordDAO dao=new recordDAO();
		int row=dao.insert(record);
		if(row>0) {
			//添加成功
			return true;
		}
		return false;
	}
	//总页码
	public int getRecordLine() {
		recordDAO dao=new recordDAO();
		return dao.queryCount();
	}
	
	//修改日期
	public boolean updateTime(int recordId) {
		recordDAO dao=new recordDAO();
		int row =dao.updateTime(recordId);
		if(row>0) {
			//添加成功
			return true;
		}
		return false;
	}
	
	//查找所有超时的记录
	public List<record> getExceedTime(int pageNo,int pageSize){
		recordDAO dao=new recordDAO();
		return dao.queryExceedTime(pageNo, pageSize);
	}
	public int getExceedTimeLine() {
		recordDAO dao=new recordDAO();
		return dao.queryExceedTimeCount();
	}
	//userId查询用户的未提交
	public List<record> getUserNotTime(int userId,int pageNo,int pageSize){
		recordDAO dao=new recordDAO();
		return dao.queryUserNotTime(userId, pageNo, pageSize);
	}
	public int getUserNotTimeLine(int userId) {
		recordDAO dao=new recordDAO();
		return dao.queryUserNotTimeCount(userId);
	}
	
	//userId查询用户的交了的
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

package entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dao.bookDAO;
import dao.userDAO;

public class record {
	private int recordId;
	private int bookId;
	private int userId;
	private int count;
	private Date brrowTime=new Date();
	private Date expectedTime ;
	private Date retuenTime;
	private book book;
	private user user;
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	public record() {
		super();
		// TODO Auto-generated constructor stub
	}
	public record(int recordId, int userId, int count, Date brrowTime, Date expectedTime, Date retuenTime,
			SimpleDateFormat df) {
		super();
		this.recordId = recordId;
		this.userId = userId;
		this.count = count;
		this.brrowTime = brrowTime;
		this.expectedTime = expectedTime;
		this.retuenTime = retuenTime;
		this.df = df;
	}

	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public String getBrrowTime() {
		return df.format(brrowTime);
	}
	
	public void setBrrowTime(Date brrowTime) {
		this.brrowTime = brrowTime;
	}
	public String getExpectedTime() {
		Calendar ca = Calendar.getInstance();
		ca.setTime(brrowTime);
		ca.add(Calendar.DATE, 15);
		expectedTime=ca.getTime();
		return df.format(expectedTime);
	}

	public void setExpectedTime(Date expectedTime) {
/*		Calendar ca = Calendar.getInstance();
		ca.setTime(brrowTime);
		ca.add(Calendar.DATE, 15);
		expectedTime=ca.getTime();*/
		Calendar ca = Calendar.getInstance();
		ca.setTime(brrowTime);
		ca.add(Calendar.DATE, 15);
		expectedTime=ca.getTime();
		this.expectedTime = expectedTime;
	}
	public Date getRetuenTime() {
		return retuenTime;
	}
	public void setRetuenTime(Date retuenTime) {
		this.retuenTime = retuenTime;
	}
	public book getbook() {
		bookDAO dao=new bookDAO();
		book book =dao.query(bookId);
		return book;		
	}
	public user getuser() {
		userDAO dao=new userDAO();
		user user =dao.queryId(userId);
		return user;		
	}
	@Override
	public String toString() {
		return "record [recordId=" + recordId + ", bookId=" + bookId + ", userId=" + userId + ", count=" + count
				+ ", brrowTime=" + brrowTime + ", expectedTime=" + expectedTime + ", retuenTime=" + retuenTime
				+ ", book=" + book + ", user=" + user + ", df=" + df + "]";
	}	
}

package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.record;

public class recordDAO {
	private static Connection conn = null;
	//��ѯ��¼������
	public int queryCount() {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record";
				pstmt = conn.prepareStatement(sql);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//��ѯ��¼
	public List<record> queryAll(){
		List<record> records=new ArrayList<record>();
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// ������ѯ������
		String sql = "select * from record order by returnTime";
		// 3 ����statement
		PreparedStatement pstmt = null;
		// 4 ������ѯ���
		ResultSet rs = null;
		try {
			// ����������
			pstmt = conn.prepareStatement(sql);
			// ִ�з��ؽ�����
			rs = pstmt.executeQuery();
			// ʹ�ý����
			if (rs != null) {
				while (rs.next()) {
					record record = new record();
					record.setRecordId(rs.getInt("recordId"));
					record.setBookId(rs.getInt("bookId"));
					record.setUserId(rs.getInt("userId"));
					record.setCount(rs.getInt("count"));
					record.setBrrowTime(rs.getDate("borrowTime"));
					record.setExpectedTime(rs.getDate("expectedTime"));
					record.setRetuenTime(rs.getDate("returnTime"));
					records.add(record);
				}
				return records;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	
	//��ҳ
	public List<record> query(int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// 3 ����statement
		PreparedStatement pstmt = null;
		// 4 ������ѯ���
		ResultSet rs = null;
		try {
			// ������ѯ������
			String sql = "select * from record order by returnTime limit ?,?";
			// ����������
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo-1)*pageSize);
			pstmt.setInt(2, pageSize);
			// ִ�з��ؽ�����
			rs = pstmt.executeQuery();
			// ʹ�ý����
			if (rs != null) {
				while (rs.next()) {
					record record = new record();
					record.setRecordId(rs.getInt("recordId"));
					record.setBookId(rs.getInt("bookId"));
					record.setUserId(rs.getInt("userId"));
					record.setCount(rs.getInt("count"));
					record.setBrrowTime(rs.getDate("borrowTime"));
					record.setExpectedTime(rs.getDate("expectedTime"));
					record.setRetuenTime(rs.getDate("returnTime"));
					records.add(record);
				}
				return records;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//��ѯ ����ISDN
	public List<record> queryISDN(int bookId){
		List<record> records=new ArrayList<record>();
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// ������ѯ������
		String sql = "select * from record where bookId=? order by returnTime";
		// 3 ����statement
		PreparedStatement pstmt = null;
		// 4 ������ѯ���
		ResultSet rs = null;
		try {
			// ����������
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			// ִ�з��ؽ�����
			rs = pstmt.executeQuery();
			// ʹ�ý����
			if (rs != null) {
				while (rs.next()) {
					record record = new record();
					record.setRecordId(rs.getInt("recordId"));
					record.setBookId(rs.getInt("bookId"));
					record.setUserId(rs.getInt("userId"));
					record.setCount(rs.getInt("count"));
					record.setBrrowTime(rs.getDate("borrowTime"));
					record.setExpectedTime(rs.getDate("expectedTime"));
					record.setRetuenTime(rs.getDate("returnTime"));
					records.add(record);
				}
				return records;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//��ѯ ����userId
	public List<record> queryUserId(int userId){
		List<record> records=new ArrayList<record>();
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// ������ѯ������
		String sql = "select * from record where userId=? order by returnTime";
		// 3 ����statement
		PreparedStatement pstmt = null;
		// 4 ������ѯ���
		ResultSet rs = null;
		try {
			// ����������
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			// ִ�з��ؽ�����
			rs = pstmt.executeQuery();
			// ʹ�ý����
			if (rs != null) {
				while (rs.next()) {
					record record = new record();
					record.setRecordId(rs.getInt("recordId"));
					record.setBookId(rs.getInt("bookId"));
					record.setUserId(rs.getInt("userId"));
					record.setCount(rs.getInt("count"));
					record.setBrrowTime(rs.getDate("borrowTime"));
					record.setExpectedTime(rs.getDate("expectedTime"));
					record.setRetuenTime(rs.getDate("returnTime"));
					records.add(record);
				}
				return records;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	
	//����
	public int insert(record record) {
		//2 �������� connection
		conn=BaseDAO.getConn();
		if(conn==null) {
			return 0;
		}
		//3 ����statement  
		PreparedStatement pstmt = null;
		try {
			//3 sql���
			String sql="insert into record(bookId,userId,count,borrowTime,expectedTime)"
					+ "values(?,?,?,?,?); ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, record.getBookId());
			pstmt.setInt(2, record.getUserId());
			pstmt.setInt(3,record.getCount());
			pstmt.setString(4, record.getBrrowTime());
			pstmt.setString(5, record.getExpectedTime());
			int row = pstmt.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//�ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return 0;
	}
	public int updateTime(int recordId) {
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return -1;
		}
	    //sql���
	    String sql = "update record set returnTime=? where recordId ="+recordId;
	    //����statement  
	  	PreparedStatement pstmt = null;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);	  
	        Date retuenTime=new Date();
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			pstmt.setString(1, df.format(retuenTime));
			int row = pstmt.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//�ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return -1;
	}
	//��ѯ��¼
	public List<record> queryNotTime(int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 ����statement
		PreparedStatement pstmt = null;
		// 4 ������ѯ���
		ResultSet rs = null;
		try {
			// ������ѯ������
			String sql = "select * from record where returnTime is null order by returnTime limit ?,?";
			// ����������
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo-1)*pageSize);
			pstmt.setInt(2, pageSize);
			// ִ�з��ؽ�����
			rs = pstmt.executeQuery();
			// ʹ�ý����
			if (rs != null) {
				while (rs.next()) {
					record record = new record();
					record.setRecordId(rs.getInt("recordId"));
					record.setBookId(rs.getInt("bookId"));
					record.setUserId(rs.getInt("userId"));
					record.setCount(rs.getInt("count"));
					record.setBrrowTime(rs.getDate("borrowTime"));
					record.setExpectedTime(rs.getDate("expectedTime"));
					record.setRetuenTime(rs.getDate("returnTime"));
					records.add(record);
				}
				return records;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//��ѯ��¼������
	public int queryNotTimeCount() {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where returnTime is null";
				pstmt = conn.prepareStatement(sql);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//��ѯ��¼
	public List<record> queryUserId(int userId,int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 ����statement
		PreparedStatement pstmt = null;
		// 4 ������ѯ���
		ResultSet rs = null;
		try {
			// ������ѯ������
			String sql = "select * from record where userId = ? order by returnTime limit ?,?";
			// ����������
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			pstmt.setInt(3, pageSize);
			// ִ�з��ؽ�����
			rs = pstmt.executeQuery();
			// ʹ�ý����
			if (rs != null) {
				while (rs.next()) {
					record record = new record();
					record.setRecordId(rs.getInt("recordId"));
					record.setBookId(rs.getInt("bookId"));
					record.setUserId(rs.getInt("userId"));
					record.setCount(rs.getInt("count"));
					record.setBrrowTime(rs.getDate("borrowTime"));
					record.setExpectedTime(rs.getDate("expectedTime"));
					record.setRetuenTime(rs.getDate("returnTime"));
					records.add(record);
				}
				return records;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//��ѯ��¼������
	public int queryUserIdCount(int userId) {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where userId = "+userId;
				pstmt = conn.prepareStatement(sql);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//��ѯ��¼
	public List<record> queryBookId(int bookId,int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 ����statement
		PreparedStatement pstmt = null;
		// 4 ������ѯ���
		ResultSet rs = null;
		try {
			// ������ѯ������
			String sql = "select * from record where bookId = ? order by returnTime limit ?,?";
			// ����������
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			pstmt.setInt(3, pageSize);
			// ִ�з��ؽ�����
			rs = pstmt.executeQuery();
			// ʹ�ý����
			if (rs != null) {
				while (rs.next()) {
					record record = new record();
					record.setRecordId(rs.getInt("recordId"));
					record.setBookId(rs.getInt("bookId"));
					record.setUserId(rs.getInt("userId"));
					record.setCount(rs.getInt("count"));
					record.setBrrowTime(rs.getDate("borrowTime"));
					record.setExpectedTime(rs.getDate("expectedTime"));
					record.setRetuenTime(rs.getDate("returnTime"));
					records.add(record);
				}
				return records;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//��ѯ��¼������
	public int queryBookIdCount(int bookId) {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where bookId = "+bookId;
				pstmt = conn.prepareStatement(sql);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//��ѯ��¼
	public List<record> queryUserBookId(int bookId,int userId,int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 ����statement
		PreparedStatement pstmt = null;
		// 4 ������ѯ���
		ResultSet rs = null;
		try {
			// ������ѯ������
			String sql = "select * from record where bookId = ? and userId=? order by returnTime limit ?,?";
			// ����������
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			pstmt.setInt(2, userId);
			pstmt.setInt(3, (pageNo-1)*pageSize);
			pstmt.setInt(4, pageSize);
			// ִ�з��ؽ�����
			rs = pstmt.executeQuery();
			// ʹ�ý����
			if (rs != null) {
				while (rs.next()) {
					record record = new record();
					record.setRecordId(rs.getInt("recordId"));
					record.setBookId(rs.getInt("bookId"));
					record.setUserId(rs.getInt("userId"));
					record.setCount(rs.getInt("count"));
					record.setBrrowTime(rs.getDate("borrowTime"));
					record.setExpectedTime(rs.getDate("expectedTime"));
					record.setRetuenTime(rs.getDate("returnTime"));
					records.add(record);
				}
				return records;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//��ѯ��¼������
	public int queryUserBookIdCount(int bookId,int userId) {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where bookId = ? and userId=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bookId);
				pstmt.setInt(2, userId);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//����userId��ѯ��¼ �Լ����û���δ�ύ
	public List<record> queryUserNotTime(int userId,int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 ����statement
		PreparedStatement pstmt = null;
		// 4 ������ѯ���
		ResultSet rs = null;
		try {
			// ������ѯ������
			String sql = "select * from record where userId = ? and returnTime is null limit ?,?";
			// ����������
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			pstmt.setInt(3, pageSize);
			// ִ�з��ؽ�����
			rs = pstmt.executeQuery();
			// ʹ�ý����
			if (rs != null) {
				while (rs.next()) {
					record record = new record();
					record.setRecordId(rs.getInt("recordId"));
					record.setBookId(rs.getInt("bookId"));
					record.setUserId(rs.getInt("userId"));
					record.setCount(rs.getInt("count"));
					record.setBrrowTime(rs.getDate("borrowTime"));
					record.setExpectedTime(rs.getDate("expectedTime"));
					record.setRetuenTime(rs.getDate("returnTime"));
					records.add(record);
				}
				return records;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//��ѯ��¼������
	public int queryUserNotTimeCount(int userId) {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where userId = "+userId+" and returnTime is null";
				pstmt = conn.prepareStatement(sql);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//����userId��ѯ��¼ �Լ����û��ѹ黹
	public List<record> queryUserHavaTime(int userId,int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 ����statement
		PreparedStatement pstmt = null;
		// 4 ������ѯ���
		ResultSet rs = null;
		try {
			// ������ѯ������
			String sql = "select * from record where userId = ? and returnTime !='' limit ?,?";
			// ����������
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			pstmt.setInt(3, pageSize);
			// ִ�з��ؽ�����
			rs = pstmt.executeQuery();
			// ʹ�ý����
			if (rs != null) {
				while (rs.next()) {
					record record = new record();
					record.setRecordId(rs.getInt("recordId"));
					record.setBookId(rs.getInt("bookId"));
					record.setUserId(rs.getInt("userId"));
					record.setCount(rs.getInt("count"));
					record.setBrrowTime(rs.getDate("borrowTime"));
					record.setExpectedTime(rs.getDate("expectedTime"));
					record.setRetuenTime(rs.getDate("returnTime"));
					records.add(record);
				}
				return records;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//��ѯ�ѹ黹��¼������
	public int queryUserHaveTimeCount(int userId) {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where userId = "+userId+" and returnTime !=''";
				pstmt = conn.prepareStatement(sql);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//��ѯ��ʱ��¼
	public List<record> queryExceedTime(int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 ����statement
		PreparedStatement pstmt = null;
		// 4 ������ѯ���
		ResultSet rs = null;
		try {
			// ������ѯ������
			String sql = "select * from record where expectedTime < now() and returnTime is null order by returnTime limit ?,?";
			// ����������
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo-1)*pageSize);
			pstmt.setInt(2, pageSize);
			// ִ�з��ؽ�����
			rs = pstmt.executeQuery();
			// ʹ�ý����
			if (rs != null) {
				while (rs.next()) {
					record record = new record();
					record.setRecordId(rs.getInt("recordId"));
					record.setBookId(rs.getInt("bookId"));
					record.setUserId(rs.getInt("userId"));
					record.setCount(rs.getInt("count"));
					record.setBrrowTime(rs.getDate("borrowTime"));
					record.setExpectedTime(rs.getDate("expectedTime"));
					record.setRetuenTime(rs.getDate("returnTime"));
					records.add(record);
				}
				return records;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//��ѯ��ʱ��¼������
	public int queryExceedTimeCount() {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where expectedTime < now() and returnTime is null";
				pstmt = conn.prepareStatement(sql);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//����userId��ѯ��¼ �Լ����û���δ�ύ
	public List<record> queryUserExceedTime(int userId,int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 ����statement
		PreparedStatement pstmt = null;
		// 4 ������ѯ���
		ResultSet rs = null;
		try {
			// ������ѯ������
			String sql = "select * from record where userId = ? and returnTime is null and  expectedTime < now() limit ?,?";
			// ����������
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			pstmt.setInt(3, pageSize);
			// ִ�з��ؽ�����
			rs = pstmt.executeQuery();
			// ʹ�ý����
			if (rs != null) {
				while (rs.next()) {
					record record = new record();
					record.setRecordId(rs.getInt("recordId"));
					record.setBookId(rs.getInt("bookId"));
					record.setUserId(rs.getInt("userId"));
					record.setCount(rs.getInt("count"));
					record.setBrrowTime(rs.getDate("borrowTime"));
					record.setExpectedTime(rs.getDate("expectedTime"));
					record.setRetuenTime(rs.getDate("returnTime"));
					records.add(record);
				}
				return records;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//��ѯ��¼������
	public int queryUserExceedTimeCount(int userId) {
		//��������
		conn=BaseDAO.getConn();
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where userId = "+userId+" and returnTime is null and  expectedTime < now()";
				pstmt = conn.prepareStatement(sql);
				//������ѯ���
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//�ر���Դ
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	public static void main(String[] args) throws SQLException, IOException {
		// ��ѯ����
		/*recordDAO dao=new recordDAO(); 
		List<record> list=dao.queryAll();
		for(record record: list) { 
			 System.out.println(record.toString()); 
		}*/
		
		//�������
		/*recordDAO dao=new recordDAO(); 
		record record=new record();
		record.setBookId(1);
		record.setUserId(1);
		record.setCount(1);
		int a=dao.insert(record);
		System.out.println(a);*/
		
		recordDAO dao=new recordDAO();
		int a=dao.queryCount();
		System.out.println(a);
		//��ѯ����ISDN
		/*recordDAO dao=new recordDAO(); 
		List<record> list=dao.queryISDN(1);
		for(record record: list) { 
			 System.out.println(record.toString()); 
		}*/
		
		/*recordDAO dao=new recordDAO(); 
		List<record> list=dao.queryUserId(1);
		for(record record: list) { 
			 System.out.println(record.toString()); 
		}*/
		
		//��ҳ��ѯ
		/*recordDAO dao=new recordDAO(); 
		List<record> list=dao.query(1, 4);
		for(record record: list) { 
			 System.out.println(record.toString()); 
		}*/
	}
}

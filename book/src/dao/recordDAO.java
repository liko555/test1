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
	//查询记录的数量
	public int queryCount() {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record";
				pstmt = conn.prepareStatement(sql);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//查询记录
	public List<record> queryAll(){
		List<record> records=new ArrayList<record>();
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// 创建查询语句对象
		String sql = "select * from record order by returnTime";
		// 3 创建statement
		PreparedStatement pstmt = null;
		// 4 创建查询语句
		ResultSet rs = null;
		try {
			// 创建语句对象
			pstmt = conn.prepareStatement(sql);
			// 执行返回结果语句
			rs = pstmt.executeQuery();
			// 使用结果集
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
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	
	//分页
	public List<record> query(int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// 3 创建statement
		PreparedStatement pstmt = null;
		// 4 创建查询语句
		ResultSet rs = null;
		try {
			// 创建查询语句对象
			String sql = "select * from record order by returnTime limit ?,?";
			// 创建语句对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo-1)*pageSize);
			pstmt.setInt(2, pageSize);
			// 执行返回结果语句
			rs = pstmt.executeQuery();
			// 使用结果集
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
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//查询 根据ISDN
	public List<record> queryISDN(int bookId){
		List<record> records=new ArrayList<record>();
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// 创建查询语句对象
		String sql = "select * from record where bookId=? order by returnTime";
		// 3 创建statement
		PreparedStatement pstmt = null;
		// 4 创建查询语句
		ResultSet rs = null;
		try {
			// 创建语句对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			// 执行返回结果语句
			rs = pstmt.executeQuery();
			// 使用结果集
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
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//查询 根据userId
	public List<record> queryUserId(int userId){
		List<record> records=new ArrayList<record>();
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// 创建查询语句对象
		String sql = "select * from record where userId=? order by returnTime";
		// 3 创建statement
		PreparedStatement pstmt = null;
		// 4 创建查询语句
		ResultSet rs = null;
		try {
			// 创建语句对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			// 执行返回结果语句
			rs = pstmt.executeQuery();
			// 使用结果集
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
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	
	//插入
	public int insert(record record) {
		//2 创建连接 connection
		conn=BaseDAO.getConn();
		if(conn==null) {
			return 0;
		}
		//3 创建statement  
		PreparedStatement pstmt = null;
		try {
			//3 sql语句
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
		}finally {//关闭资源
			BaseDAO.close(conn, pstmt);
		}
		return 0;
	}
	public int updateTime(int recordId) {
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return -1;
		}
	    //sql语句
	    String sql = "update record set returnTime=? where recordId ="+recordId;
	    //创建statement  
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
		}finally {//关闭资源
			BaseDAO.close(conn, pstmt);
		}
		return -1;
	}
	//查询记录
	public List<record> queryNotTime(int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 创建statement
		PreparedStatement pstmt = null;
		// 4 创建查询语句
		ResultSet rs = null;
		try {
			// 创建查询语句对象
			String sql = "select * from record where returnTime is null order by returnTime limit ?,?";
			// 创建语句对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo-1)*pageSize);
			pstmt.setInt(2, pageSize);
			// 执行返回结果语句
			rs = pstmt.executeQuery();
			// 使用结果集
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
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//查询记录的数量
	public int queryNotTimeCount() {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where returnTime is null";
				pstmt = conn.prepareStatement(sql);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//查询记录
	public List<record> queryUserId(int userId,int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 创建statement
		PreparedStatement pstmt = null;
		// 4 创建查询语句
		ResultSet rs = null;
		try {
			// 创建查询语句对象
			String sql = "select * from record where userId = ? order by returnTime limit ?,?";
			// 创建语句对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			pstmt.setInt(3, pageSize);
			// 执行返回结果语句
			rs = pstmt.executeQuery();
			// 使用结果集
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
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//查询记录的数量
	public int queryUserIdCount(int userId) {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where userId = "+userId;
				pstmt = conn.prepareStatement(sql);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//查询记录
	public List<record> queryBookId(int bookId,int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 创建statement
		PreparedStatement pstmt = null;
		// 4 创建查询语句
		ResultSet rs = null;
		try {
			// 创建查询语句对象
			String sql = "select * from record where bookId = ? order by returnTime limit ?,?";
			// 创建语句对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			pstmt.setInt(3, pageSize);
			// 执行返回结果语句
			rs = pstmt.executeQuery();
			// 使用结果集
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
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//查询记录的数量
	public int queryBookIdCount(int bookId) {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where bookId = "+bookId;
				pstmt = conn.prepareStatement(sql);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//查询记录
	public List<record> queryUserBookId(int bookId,int userId,int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 创建statement
		PreparedStatement pstmt = null;
		// 4 创建查询语句
		ResultSet rs = null;
		try {
			// 创建查询语句对象
			String sql = "select * from record where bookId = ? and userId=? order by returnTime limit ?,?";
			// 创建语句对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			pstmt.setInt(2, userId);
			pstmt.setInt(3, (pageNo-1)*pageSize);
			pstmt.setInt(4, pageSize);
			// 执行返回结果语句
			rs = pstmt.executeQuery();
			// 使用结果集
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
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//查询记录的数量
	public int queryUserBookIdCount(int bookId,int userId) {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where bookId = ? and userId=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bookId);
				pstmt.setInt(2, userId);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//按照userId查询记录 以及该用户的未提交
	public List<record> queryUserNotTime(int userId,int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 创建statement
		PreparedStatement pstmt = null;
		// 4 创建查询语句
		ResultSet rs = null;
		try {
			// 创建查询语句对象
			String sql = "select * from record where userId = ? and returnTime is null limit ?,?";
			// 创建语句对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			pstmt.setInt(3, pageSize);
			// 执行返回结果语句
			rs = pstmt.executeQuery();
			// 使用结果集
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
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//查询记录的数量
	public int queryUserNotTimeCount(int userId) {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where userId = "+userId+" and returnTime is null";
				pstmt = conn.prepareStatement(sql);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//按照userId查询记录 以及该用户已归还
	public List<record> queryUserHavaTime(int userId,int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 创建statement
		PreparedStatement pstmt = null;
		// 4 创建查询语句
		ResultSet rs = null;
		try {
			// 创建查询语句对象
			String sql = "select * from record where userId = ? and returnTime !='' limit ?,?";
			// 创建语句对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			pstmt.setInt(3, pageSize);
			// 执行返回结果语句
			rs = pstmt.executeQuery();
			// 使用结果集
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
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//查询已归还记录的数量
	public int queryUserHaveTimeCount(int userId) {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where userId = "+userId+" and returnTime !=''";
				pstmt = conn.prepareStatement(sql);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//查询超时记录
	public List<record> queryExceedTime(int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 创建statement
		PreparedStatement pstmt = null;
		// 4 创建查询语句
		ResultSet rs = null;
		try {
			// 创建查询语句对象
			String sql = "select * from record where expectedTime < now() and returnTime is null order by returnTime limit ?,?";
			// 创建语句对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (pageNo-1)*pageSize);
			pstmt.setInt(2, pageSize);
			// 执行返回结果语句
			rs = pstmt.executeQuery();
			// 使用结果集
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
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//查询超时记录的数量
	public int queryExceedTimeCount() {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where expectedTime < now() and returnTime is null";
				pstmt = conn.prepareStatement(sql);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	//按照userId查询记录 以及该用户的未提交
	public List<record> queryUserExceedTime(int userId,int pageNo,int pageSize){
		List<record> records=new ArrayList<record>();
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}

		// 3 创建statement
		PreparedStatement pstmt = null;
		// 4 创建查询语句
		ResultSet rs = null;
		try {
			// 创建查询语句对象
			String sql = "select * from record where userId = ? and returnTime is null and  expectedTime < now() limit ?,?";
			// 创建语句对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, (pageNo-1)*pageSize);
			pstmt.setInt(3, pageSize);
			// 执行返回结果语句
			rs = pstmt.executeQuery();
			// 使用结果集
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
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return records;
	}
	//查询记录的数量
	public int queryUserExceedTimeCount(int userId) {
		//创建连接
		conn=BaseDAO.getConn();
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		if(conn!=null) {
			try {
				String sql="select count(*) from record where userId = "+userId+" and returnTime is null and  expectedTime < now()";
				pstmt = conn.prepareStatement(sql);
				//创建查询语句
				rs = pstmt.executeQuery();
				if(rs!=null&&rs.next()) {
					int count=rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {//关闭资源
				BaseDAO.close(conn, rs,pstmt);
			}
		}
		return 0;
	}
	public static void main(String[] args) throws SQLException, IOException {
		// 查询所有
		/*recordDAO dao=new recordDAO(); 
		List<record> list=dao.queryAll();
		for(record record: list) { 
			 System.out.println(record.toString()); 
		}*/
		
		//插入测试
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
		//查询根据ISDN
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
		
		//分页查询
		/*recordDAO dao=new recordDAO(); 
		List<record> list=dao.query(1, 4);
		for(record record: list) { 
			 System.out.println(record.toString()); 
		}*/
	}
}

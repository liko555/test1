package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.bookType;
import entity.user;

public class userDAO {
	private static Connection conn=null;
	//登录
	public user userLogin(String userName, String userPwd) {
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		
		//创建查询语句对象
		String sql = "select * from user where userName=? and userPwd=?";
		
		try {
			//创建语句对象
			pstmt=conn.prepareStatement(sql);
			
			//执行SQL语句
			pstmt.setString(1, userName);
			pstmt.setString(2, userPwd);
			
			//执行返回结果语句
			rs=pstmt.executeQuery();
			
			// 5. 使用结果集
			// 判断结果集中是否有数据行，有说明用户合法；没有说明用户非法
			if(rs != null && rs.next()) {
				// 合法的时候返回管理员对象
				user user = new user();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPwd(rs.getString("userPwd"));
				user.setTrueName(rs.getString("trueName"));
				user.setPhone(rs.getString("phone"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn, rs,pstmt);
		}
		return null; 	
	}
	
	// 显示全部 分页
	public List<user> query(int pageNo, int pageSize) {
//			select * from cartoonType limit
		// 创建连接
		conn = BaseDAO.getConn();
		// 创建statement
		PreparedStatement pstmt = null;
		// 创建查询语句
		ResultSet rs = null;
		if (conn != null) {
			try {
				String sql = "select * from user limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (pageNo - 1) * pageSize);
				pstmt.setInt(2, pageSize);

				// 创建查询语句
				rs = pstmt.executeQuery();

				if (rs != null) {
					List<user> list = new ArrayList<user>();
					while (rs.next()) {
						user user = new user();
						user.setUserId(rs.getInt("userId"));
						user.setUserName(rs.getString("userName"));
						user.setUserPwd(rs.getString("userPwd"));
						user.setTrueName(rs.getString("trueName"));
						user.setPhone(rs.getString("phone"));
						list.add(user);
					}
					return list;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {// 关闭资源
				BaseDAO.close(conn, rs, pstmt);
			}
		}
		return null;
	}
	// 显示全部 分页
	public List<user> query2(String userName) {
//			select * from cartoonType limit
		// 创建连接
		conn = BaseDAO.getConn();
		// 创建statement
		PreparedStatement pstmt = null;
		// 创建查询语句
		ResultSet rs = null;
		if (conn != null) {
			try {
				String sql = "select * from user where userName=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userName);
				// 创建查询语句
				rs = pstmt.executeQuery();

				if (rs != null) {
					List<user> list = new ArrayList<user>();
					while (rs.next()) {
						user user = new user();
						user.setUserId(rs.getInt("userId"));
						user.setUserName(rs.getString("userName"));
						user.setUserPwd(rs.getString("userPwd"));
						user.setTrueName(rs.getString("trueName"));
						user.setPhone(rs.getString("phone"));
						list.add(user);
					}
					return list;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {// 关闭资源
				BaseDAO.close(conn, rs, pstmt);
			}
		}
		return null;
	}
	// 查询类型的数量
	public int queryCount() {
		// 创建连接
		conn = BaseDAO.getConn();
		// 创建statement
		PreparedStatement pstmt = null;
		// 创建查询语句
		ResultSet rs = null;
		if (conn != null) {
			try {
				String sql = "select count(*) from user";
				pstmt = conn.prepareStatement(sql);
				// 创建查询语句
				rs = pstmt.executeQuery();
				if (rs != null && rs.next()) {
					int count = rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {// 关闭资源
				BaseDAO.close(conn, rs, pstmt);
			}
		}
		return 0;
	}
	// 增
	public int insert(user user) {
		// 2 创建连接 connection
		conn = BaseDAO.getConn();
		if (conn == null) {
			return 0;
		}
		// 3 创建statement
		PreparedStatement pstmt = null;
		try {
			// 3 sql语句
			String sql = "insert into user(userName,userPwd,trueName,phone) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPwd());
			pstmt.setString(3, user.getTrueName());
			pstmt.setString(4,user.getPhone());
			int row = pstmt.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 关闭资源
			BaseDAO.close(conn, pstmt);
		}
		return 0;
	}
	// 根据主键id查询
	public user queryId(int userId) {
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
			// 3 sql语句
			String sql = "select * from user where userId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			// 4 创建查询语句
			rs = pstmt.executeQuery();
			// 5 返回查询结果result
			if (rs != null && rs.next()) {
				user user = new user();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPwd(rs.getString("userPwd"));
				user.setTrueName(rs.getString("trueName"));
				user.setPhone(rs.getString("phone"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return null;
	}
	// 根据主键查询
	public user queryId(String userName) {
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
			// 3 sql语句
			String sql = "select * from user where userName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			// 4 创建查询语句
			rs = pstmt.executeQuery();
			// 5 返回查询结果result
			if (rs != null && rs.next()) {
				user user = new user();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPwd(rs.getString("userPwd"));
				user.setTrueName(rs.getString("trueName"));
				user.setPhone(rs.getString("phone"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return null;
	}
	// 改
	public int update(user user) {
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return -1;
		}
		// sql语句
		String sql = "update user set userName=?,userPwd=?,trueName=?,phone=? where userId=?";
		// 创建statement
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPwd());
			pstmt.setString(3, user.getTrueName());
			pstmt.setString(4,user.getPhone());
			pstmt.setInt(5, user.getUserId());
			int row = pstmt.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 关闭资源
			BaseDAO.close(conn, pstmt);
		}
		return -1;
	}
	//删除根据typeid
	public int delUser(int userId) {
		conn=BaseDAO.getConn();
		if(conn==null) {
			return 0;
		}
         //数据库语句
 		String sql = "delete from user where userId="+userId;
 		PreparedStatement pstmt = null;
 		 try {
 			pstmt = (PreparedStatement) conn.prepareStatement(sql);
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
	public static void main(String[] args) throws SQLException, IOException {
		//登录测试
		/*userDAO dao=new userDAO();
		user user=dao.userLogin("user1", "111");
		System.out.println(user.toString());*/
	}
}

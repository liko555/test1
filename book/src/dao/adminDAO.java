package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.admin;
import entity.book;

public class adminDAO {
	private static Connection conn = null;
	// 登录

	// 方法的定义
	// 访问修饰符 返回值类型 方法名(参数) { 方法体 }
	// 根据什么才能来做这个动作——根据内容——参数
	// 返回什么——返回内容的类型——返回值类型
	public admin adminLogin(String adminName, String adminPwd) {
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// 3. 创建语句对象
		PreparedStatement pstmt = null;
		// 4. 定义个结果集对象
		ResultSet rs = null;
		try {
			// 3. 创建语句对象
			String sql = "select * from admin where adminName=? and adminPwd=?";
			pstmt = conn.prepareStatement(sql);
			// 4. 执行语句
			pstmt.setString(1, adminName);
			pstmt.setString(2, adminPwd);
			rs = pstmt.executeQuery();
			// 5. 使用结果集
			// 判断结果集中是否有数据行，有说明用户合法；没有说明用户非法
			if (rs != null && rs.next()) {
				// 合法的时候返回管理员对象
				admin admin = new admin();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminPwd(rs.getString("adminPwd"));
				admin.setTrueName(rs.getString("truename"));
				admin.setPhone(rs.getString("phone"));
				return admin;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDAO.close(conn, rs, pstmt);
		}
		return null;
	}
	//修改
	public int update(admin admin) {
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return -1;
		}
	    //sql语句
	    String sql = "update admin set adminName=?,adminPwd=?,trueName=?,phone=? where adminId=?";
	    //创建statement  
	  	PreparedStatement pstmt = null;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1,admin.getAdminName());
			pstmt.setString(2,admin.getAdminPwd());
			pstmt.setString(3, admin.getTrueName());
			pstmt.setString(4, admin.getPhone());
			pstmt.setInt(5,admin.getAdminId());
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
	
	public admin query(int adminId) {
		//创建连接
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//创建statement  
		PreparedStatement pstmt = null;
		//创建查询语句
		ResultSet rs = null;
		try {
			//sql语句
			String sql="select * from admin where adminId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adminId);
			//创建查询语句
			rs = pstmt.executeQuery();
			//返回查询结果result
			if(rs!=null&&rs.next()) {
				admin admin=new admin();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminPwd(rs.getString("adminPwd"));
				admin.setTrueName(rs.getString("truename"));
				admin.setPhone(rs.getString("phone"));
				return admin;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//关闭资源
			BaseDAO.close(conn, rs,pstmt);
		}
		return null;
	}
	public static void main(String[] args) throws SQLException, IOException {
		// 登录测试
		adminDAO dao = new adminDAO();
		admin admin = dao.adminLogin("admin1", "123");
		System.out.println(admin.toString());
	}
}

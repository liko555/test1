package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.bookrack;
import entity.language;

public class bookrackDAO {
	private static Connection conn = null;
	// 根据主键id查询
		public bookrack queryId(int bookrackId) {
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
				String sql = "select * from bookrack where bookrackId=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bookrackId);
				// 4 创建查询语句
				rs = pstmt.executeQuery();
				// 5 返回查询结果result
				if (rs != null && rs.next()) {
					bookrack bookrack = new bookrack();
					bookrack.setBookrackId(rs.getInt("bookrackId"));;
					bookrack.setBookrackName(rs.getString("bookrackName"));
					return bookrack;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {// 关闭资源
				BaseDAO.close(conn, rs, pstmt);
			}
			return null;
		}
		// 显示全部 分页
		public List<bookrack> query(int pageNo, int pageSize) {
//				select * from cartoonType limit
			// 创建连接
			conn = BaseDAO.getConn();
			// 创建statement
			PreparedStatement pstmt = null;
			// 创建查询语句
			ResultSet rs = null;
			if (conn != null) {
				try {
					String sql = "select * from bookrack limit ?,?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, (pageNo - 1) * pageSize);
					pstmt.setInt(2, pageSize);

					// 创建查询语句
					rs = pstmt.executeQuery();

					if (rs != null) {
						List<bookrack> list = new ArrayList<bookrack>();
						while (rs.next()) {
							bookrack bookrack = new bookrack();
							bookrack.setBookrackId(rs.getInt("bookrackId"));
							bookrack.setBookrackName(rs.getString("bookrackName"));
							list.add(bookrack);
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
		// 2、查询所有的漫画类型实体对象
		public List<bookrack> queryAll() {
			List<bookrack> bookracks = new ArrayList<bookrack>();
			// 创建连接
			conn = BaseDAO.getConn();
			if (conn == null) {
				return null;
			}
			// 创建查询语句对象
			String sql = "select * from bookrack";
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
						bookrack bookrack = new bookrack();
						bookrack.setBookrackId(rs.getInt("bookrackId"));
						bookrack.setBookrackName(rs.getString("bookrackName"));
						bookracks.add(bookrack);
					}
					return bookracks;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {// 关闭资源
				BaseDAO.close(conn, rs, pstmt);
			}
			return bookracks;
		}
		// 1、根据名称查询_查到响应数据
		public bookrack query(String bookrackName) {
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
				String sql = "select * from bookrack where bookrackName=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bookrackName);
				// 4 创建查询语句
				rs = pstmt.executeQuery();
				// 5 返回查询结果result
				if (rs != null && rs.next()) {
					bookrack bookrack = new bookrack();
					bookrack.setBookrackName(rs.getString("bookrackName"));
					bookrack.setBookrackId(rs.getInt("bookrackId"));
					return bookrack;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {// 关闭资源
				BaseDAO.close(conn, rs, pstmt);
			}
			return null;
		}
}

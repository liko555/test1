package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.bookType;

public class bookTypeDAO {
	private static Connection conn = null;

	// 显示全部 分页
	public List<bookType> query(int pageNo, int pageSize) {
//			select * from cartoonType limit
		// 创建连接
		conn = BaseDAO.getConn();
		// 创建statement
		PreparedStatement pstmt = null;
		// 创建查询语句
		ResultSet rs = null;
		if (conn != null) {
			try {
				String sql = "select * from bookType limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (pageNo - 1) * pageSize);
				pstmt.setInt(2, pageSize);

				// 创建查询语句
				rs = pstmt.executeQuery();

				if (rs != null) {
					List<bookType> list = new ArrayList<bookType>();
					while (rs.next()) {
						bookType type = new bookType();
						type.setTypeId(rs.getInt("typeId"));
						type.setTypeName(rs.getString("typeName"));
						list.add(type);
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
				String sql = "select count(*) from bookType";
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

	// 查询 根据ISDN返回所需的漫画类型
	public bookType queryTypeName(int bookId) {
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
			String sql = "select typeId,typeName from book inner join booktype using(typeId) where bookId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			// 4 创建查询语句
			rs = pstmt.executeQuery();
			// 5 返回查询结果result
			if (rs != null && rs.next()) {
				bookType type = new bookType();
				type.setTypeId(rs.getInt("typeId"));
				type.setTypeName(rs.getString("typeName"));
				return type;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return null;
	}

	// 1、根据名称查询_查到响应数据
	public bookType query(String typeName) {
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
			String sql = "select * from booktype where typeName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, typeName);
			// 4 创建查询语句
			rs = pstmt.executeQuery();
			// 5 返回查询结果result
			if (rs != null && rs.next()) {
				bookType type = new bookType();
				type.setTypeId(rs.getInt("typeId"));
				type.setTypeName(rs.getString("typeName"));
				return type;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return null;
	}
	// 1、根据名称查询_查到响应数据
	public List<bookType> query2(String typeName) {
		List<bookType> ctypes = new ArrayList<bookType>();
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
			String sql = "select * from booktype where typeName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, typeName);
			// 4 创建查询语句
			rs = pstmt.executeQuery();
			// 5 返回查询结果result
			if (rs != null ) {
				while (rs.next()) {
					bookType ctype = new bookType();
					ctype.setTypeId(rs.getInt("typeId"));
					ctype.setTypeName(rs.getString("typeName"));
					ctypes.add(ctype);
				}
				return ctypes;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return null;
	}
	// 根据主键id查询
	public bookType queryId(int typeId) {
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
			String sql = "select * from booktype where typeId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, typeId);
			// 4 创建查询语句
			rs = pstmt.executeQuery();
			// 5 返回查询结果result
			if (rs != null && rs.next()) {
				bookType type = new bookType();
				type.setTypeId(rs.getInt("typeId"));
				type.setTypeName(rs.getString("typeName"));
				return type;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return null;
	}

	// 2、查询所有的漫画类型实体对象
	public List<bookType> queryAll() {
		List<bookType> ctypes = new ArrayList<bookType>();
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// 创建查询语句对象
		String sql = "select * from bookType";
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
					bookType ctype = new bookType();
					ctype.setTypeId(rs.getInt("typeId"));
					ctype.setTypeName(rs.getString("typeName"));
					ctypes.add(ctype);
				}
				return ctypes;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return ctypes;
	}

	// 增
	public int insert(bookType type) {
		// 2 创建连接 connection
		conn = BaseDAO.getConn();
		if (conn == null) {
			return 0;
		}
		// 3 创建statement
		PreparedStatement pstmt = null;
		try {
			// 3 sql语句
			String sql = "insert into booktype(typeName) values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type.getTypeName());
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

	// 改
	public int update(bookType type) {
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return -1;
		}
		// sql语句
		String sql = "update bookType set typeName=? where typeId=?";
		// 创建statement
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, type.getTypeName());
			pstmt.setInt(2, type.getTypeId());
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

	// 删
	public int del(int typeId) {
		bookType type = new bookType();
		conn = BaseDAO.getConn();
		if (conn == null) {
			return -1;
		}
		// 数据库语句
		String sql = "delete from bookType where TypeId=" + typeId;
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
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
	public static void main(String[] args) throws SQLException, IOException {
		// 分页测试
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); List<bookType> list=dao.query(1, 4);
		 * for(bookType bookType: list) { System.out.println(bookType.toString()); }
		 */

		// 查询条数
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); System.out.println(dao.queryCount());
		 */

		// 查询根据ISDN
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); bookType bookType=dao.queryTypeName(1);
		 * if(bookType!=null) { System.out.println(bookType.toString()); }else {
		 * System.out.println("无"); }
		 */

		// 查询根据名称
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); bookType bt=dao.query("文学");
		 * System.out.println(bt.toString());
		 */

		// 查询根据类型id
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); bookType bt=dao.queryId(9);
		 * System.out.println(bt.toString());
		 */

		// 查询所有
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); List<bookType> list=dao.queryAll();
		 * for(bookType bookType: list) { System.out.println(bookType.toString()); }
		 */

		// 增
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); bookType bt=new bookType();
		 * bt.setTypeName("测试"); int a=dao.insert(bt); System.out.println(a);
		 */

		// 改
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); bookType bt=new bookType();
		 * bt.setTypeId(23); bt.setTypeName("测试修改"); int a= dao.update(bt);
		 * System.out.println(a);
		 */

		// 删除
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); bookType bt=new bookType(); int
		 * a=dao.del(23); System.out.println(a);
		 */
	}
}

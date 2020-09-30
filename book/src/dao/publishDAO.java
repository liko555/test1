package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.language;
import entity.publish;

public class publishDAO {
	private static Connection conn = null;

	// 显示全部 分页
	public List<publish> query(int pageNo, int pageSize) {
//			select * from cartoonType limit
		// 创建连接
		conn = BaseDAO.getConn();
		// 创建statement
		PreparedStatement pstmt = null;
		// 创建查询语句
		ResultSet rs = null;
		if (conn != null) {
			try {
				String sql = "select * from publish limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (pageNo - 1) * pageSize);
				pstmt.setInt(2, pageSize);

				// 创建查询语句
				rs = pstmt.executeQuery();

				if (rs != null) {
					List<publish> list = new ArrayList<publish>();
					while (rs.next()) {
						publish publish = new publish();
						publish.setPublishId(rs.getInt("publishId"));
						publish.setPublicName(rs.getString("publishName"));
						list.add(publish);
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
				String sql = "select count(*) from publish";
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
	public publish queryPublishName(int ISDN) {
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
			String sql = "select publishId,publishName from book inner join publish using(publishId) where ISDN=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ISDN);
			// 4 创建查询语句
			rs = pstmt.executeQuery();
			// 5 返回查询结果result
			if (rs != null && rs.next()) {
				publish publish = new publish();
				publish.setPublishId(rs.getInt("publishId"));
				publish.setPublicName(rs.getString("publishName"));
				return publish;
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
	public publish query(String publishName) {
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
			String sql = "select * from publish where publishName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publishName);
			// 4 创建查询语句
			rs = pstmt.executeQuery();
			// 5 返回查询结果result
			if (rs != null && rs.next()) {
				publish publish = new publish();
				publish.setPublishId(rs.getInt("publishId"));
				publish.setPublicName(rs.getString("publishName"));
				return publish;
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
	public publish queryId(int publishId) {
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
			String sql = "select * from publish where publishId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, publishId);
			// 4 创建查询语句
			rs = pstmt.executeQuery();
			// 5 返回查询结果result
			if (rs != null && rs.next()) {
				publish publish = new publish();
				publish.setPublishId(rs.getInt("publishId"));
				publish.setPublicName(rs.getString("publishName"));
				return publish;
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
	public List<publish> queryAll() {
		List<publish> publishs = new ArrayList<publish>();
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// 创建查询语句对象
		String sql = "select * from publish";
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
					publish publish = new publish();
					publish.setPublishId(rs.getInt("publishId"));
					publish.setPublicName(rs.getString("publishName"));
					publishs.add(publish);
				}
				return publishs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return publishs;
	}

	// 增
	public int insert(publish publish) {
		// 2 创建连接 connection
		conn = BaseDAO.getConn();
		if (conn == null) {
			return 0;
		}
		// 3 创建statement
		PreparedStatement pstmt = null;
		try {
			// 3 sql语句
			String sql = "insert into publish(publishName) values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publish.getPublicName());
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
	public int update(publish publish) {
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return -1;
		}
		// sql语句
		String sql = "update publish set publishName=? where publishId=?";
		// 创建statement
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, publish.getPublicName());
			pstmt.setInt(2, publish.getPublishId());
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
	public int del(int publishId) {
		publish publish = new publish();
		conn = BaseDAO.getConn();
		if (conn == null) {
			return -1;
		}
		// 数据库语句
		String sql = "delete from publish where publishId=" + publishId;
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
		/*publishDAO dao=new publishDAO(); 
		 List<publish> list=dao.query(1, 4);
		 for(publish publish: list) { 
			 System.out.println(publish.toString());
		}*/
		

		// 查询条数
		/*publishDAO dao=new publishDAO(); 
		System.out.println(dao.queryCount());*/
		 

		// 查询根据ISDN
		/*publishDAO dao=new publishDAO(); 
		publish publish=dao.queryPublishName(1);
		 if(publish!=null) { 
			System.out.println(publish.toString()); 
		 }else {
			System.out.println("无"); 
		 }*/
		 

		// 查询根据名称
		/*publishDAO dao=new publishDAO(); 
		publish publish=dao.query("北京联合");
		System.out.println(publish.toString());*/
		 

		// 查询根据类型id
		/*publishDAO dao=new publishDAO();
		publish publish=dao.queryId(1);
		System.out.println(publish.toString());*/
		 

		// 查询所有
		/*publishDAO dao=new publishDAO(); 
		List<publish> list=dao.queryAll();
		for(publish publish: list) { 
			 System.out.println(publish.toString()); 
		}*/


		// 增
		/*publishDAO dao=new publishDAO(); 
		publish publish=new publish();
		publish.setPublicName("测试"); 
		 int a=dao.insert(publish); 
		 System.out.println(a);*/

		// 改	
		/*publishDAO dao=new publishDAO(); 
		publish publish=new publish();
		publish.setPublishId(5);
		publish.setPublicName("测试修改");
		 int a= dao.update(publish);
		 System.out.println(a);*/
		 

		// 删除
		/*publishDAO dao=new publishDAO(); 
		publish publish=new publish(); 
		int a=dao.del(5); 
		System.out.println(a);*/
	}
}

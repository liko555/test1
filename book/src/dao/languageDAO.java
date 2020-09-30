package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.bookType;
import entity.language;

public class languageDAO {
	private static Connection conn = null;

	// 显示全部 分页
	public List<language> query(int pageNo, int pageSize) {
//			select * from cartoonType limit
		// 创建连接
		conn = BaseDAO.getConn();
		// 创建statement
		PreparedStatement pstmt = null;
		// 创建查询语句
		ResultSet rs = null;
		if (conn != null) {
			try {
				String sql = "select * from language limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (pageNo - 1) * pageSize);
				pstmt.setInt(2, pageSize);

				// 创建查询语句
				rs = pstmt.executeQuery();

				if (rs != null) {
					List<language> list = new ArrayList<language>();
					while (rs.next()) {
						language language = new language();
						language.setLanguageId(rs.getInt("languageId"));
						language.setLanguage(rs.getString("languageName"));
						list.add(language);
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
				String sql = "select count(*) from language";
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
	public language queryLanguageName(int ISDN) {
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
			String sql = "select languageId,languageName from book inner join language using(languageId) where ISDN=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ISDN);
			// 4 创建查询语句
			rs = pstmt.executeQuery();
			// 5 返回查询结果result
			if (rs != null && rs.next()) {
				language language = new language();
				language.setLanguageId(rs.getInt("languageId"));
				language.setLanguage(rs.getString("languageName"));
				return language;
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
	public language query(String languageName) {
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
			String sql = "select * from language where languageName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, languageName);
			// 4 创建查询语句
			rs = pstmt.executeQuery();
			// 5 返回查询结果result
			if (rs != null && rs.next()) {
				language language = new language();
				language.setLanguageId(rs.getInt("languageId"));
				language.setLanguage(rs.getString("languageName"));
				return language;
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
	public language queryId(int languageId) {
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
			String sql = "select * from language where languageId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, languageId);
			// 4 创建查询语句
			rs = pstmt.executeQuery();
			// 5 返回查询结果result
			if (rs != null && rs.next()) {
				language language = new language();
				language.setLanguageId(rs.getInt("languageId"));
				language.setLanguage(rs.getString("languageName"));
				return language;
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
	public List<language> queryAll() {
		List<language> languages = new ArrayList<language>();
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// 创建查询语句对象
		String sql = "select * from language";
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
					language language = new language();
					language.setLanguageId(rs.getInt("languageId"));
					language.setLanguage(rs.getString("languageName"));
					languages.add(language);
				}
				return languages;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// 关闭资源
			BaseDAO.close(conn, rs, pstmt);
		}
		return languages;
	}

	// 增
	public int insert(language language) {
		// 2 创建连接 connection
		conn = BaseDAO.getConn();
		if (conn == null) {
			return 0;
		}
		// 3 创建statement
		PreparedStatement pstmt = null;
		try {
			// 3 sql语句
			String sql = "insert into language(languageName) values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, language.getLanguage());
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
	public int update(language language) {
		// 创建连接
		conn = BaseDAO.getConn();
		if (conn == null) {
			return -1;
		}
		// sql语句
		String sql = "update language set languageName=? where languageId=?";
		// 创建statement
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, language.getLanguage());
			pstmt.setInt(2, language.getLanguageId());
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
	public int del(int languageId) {
		bookType type = new bookType();
		conn = BaseDAO.getConn();
		if (conn == null) {
			return -1;
		}
		// 数据库语句
		String sql = "delete from language where languageId=" + languageId;
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
		/*languageDAO dao=new languageDAO(); 
		 List<language> list=dao.query(1, 4);
		 for(language language: list) { 
			 System.out.println(language.toString());
		}
		*/

		// 查询条数
		
		/*languageDAO dao=new languageDAO(); 
		System.out.println(dao.queryCount());*/
		 

		// 查询根据ISDN
		 /*languageDAO dao=new languageDAO(); 
		 language language=dao.queryLanguageName(1);
		 if(language!=null) { 
			System.out.println(language.toString()); 
		 }else {
			System.out.println("无"); 
		 }*/
		 

		// 查询根据名称
		/*languageDAO dao=new languageDAO(); 
		language language=dao.query("汉语");
		System.out.println(language.toString());*/
		 

		// 查询根据类型id
		
		/*languageDAO dao=new languageDAO();
		language language=dao.queryId(1);
		System.out.println(language.toString());*/
		 

		// 查询所有
		/*languageDAO dao=new languageDAO(); 
		List<language> list=dao.queryAll();
		for(language language: list) { 
			 System.out.println(language.toString()); 
		}*/


		// 增
		/*languageDAO dao=new languageDAO(); 
		language language=new language();
		language.setLanguage("测试");; 
		 int a=dao.insert(language); 
		 System.out.println(a);*/

		// 改	
		/*languageDAO dao=new languageDAO(); 
		language language=new language();
		language.setLanguageId(8);; 
		language.setLanguage("测试修改");; 
		 int a= dao.update(language);
		 System.out.println(a);*/
		 

		// 删除
		/*languageDAO dao=new languageDAO(); 
		language language=new language(); 
		int a=dao.del(8); 
		System.out.println(a);*/
	}
}

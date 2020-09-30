package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class BaseDAO {
	// 用一个变量表示一个驱动 类，这个变量从属性文件中读取出来，在getConnection()方法中进行使用
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;

	public static void getDB() {
		// 从指定的文件中读取数据--输入流
		// getResourceAsStream资源文件路径；根据资源信息形成输入流
		try {
			InputStream is = BaseDAO.class.getClassLoader().getResourceAsStream("\\dao\\db.prop");
			Properties props = new Properties();
			props.load(is);
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			
//			System.out.println(driver);
//			System.out.println(url);
//			System.out.println(user);
//			System.out.println(password);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读取属性文件出错");
		}
	}

	// 把相同的第一步和第二部的代码放到一个方法里面
	public static Connection getConn() {
		getDB();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
//			System.out.println(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String[] args) {
		getConn();
	}

	public static void close(Connection conn, ResultSet rs, PreparedStatement pstmt) {
		try {
			// 6.关闭结果集对象
			if (rs != null)
				rs.close();
			// 7.关闭语句对象
			if (pstmt != null)
				pstmt.close();
			// 8. 关闭链接对象
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void close(Connection conn, PreparedStatement pstmt) {
		close(conn, null, pstmt);
		/*
		 * try { // 7.关闭语句对象 if(pstmt != null) pstmt.close(); // 8. 关闭链接对象 if(conn !=
		 * null && !conn.isClosed()) conn.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}
}

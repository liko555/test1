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
	// ��һ��������ʾһ������ �࣬��������������ļ��ж�ȡ��������getConnection()�����н���ʹ��
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String password = null;

	public static void getDB() {
		// ��ָ�����ļ��ж�ȡ����--������
		// getResourceAsStream��Դ�ļ�·����������Դ��Ϣ�γ�������
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
			System.out.println("��ȡ�����ļ�����");
		}
	}

	// ����ͬ�ĵ�һ���͵ڶ����Ĵ���ŵ�һ����������
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
			// 6.�رս��������
			if (rs != null)
				rs.close();
			// 7.�ر�������
			if (pstmt != null)
				pstmt.close();
			// 8. �ر����Ӷ���
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
		 * try { // 7.�ر������� if(pstmt != null) pstmt.close(); // 8. �ر����Ӷ��� if(conn !=
		 * null && !conn.isClosed()) conn.close(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	}
}

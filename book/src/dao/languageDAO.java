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

	// ��ʾȫ�� ��ҳ
	public List<language> query(int pageNo, int pageSize) {
//			select * from cartoonType limit
		// ��������
		conn = BaseDAO.getConn();
		// ����statement
		PreparedStatement pstmt = null;
		// ������ѯ���
		ResultSet rs = null;
		if (conn != null) {
			try {
				String sql = "select * from language limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (pageNo - 1) * pageSize);
				pstmt.setInt(2, pageSize);

				// ������ѯ���
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
			} finally {// �ر���Դ
				BaseDAO.close(conn, rs, pstmt);
			}
		}
		return null;
	}

	// ��ѯ���͵�����
	public int queryCount() {
		// ��������
		conn = BaseDAO.getConn();
		// ����statement
		PreparedStatement pstmt = null;
		// ������ѯ���
		ResultSet rs = null;
		if (conn != null) {
			try {
				String sql = "select count(*) from language";
				pstmt = conn.prepareStatement(sql);
				// ������ѯ���
				rs = pstmt.executeQuery();
				if (rs != null && rs.next()) {
					int count = rs.getInt(1);
					return count;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {// �ر���Դ
				BaseDAO.close(conn, rs, pstmt);
			}
		}
		return 0;
	}

	// ��ѯ ����ISDN�����������������
	public language queryLanguageName(int ISDN) {
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
			// 3 sql���
			String sql = "select languageId,languageName from book inner join language using(languageId) where ISDN=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ISDN);
			// 4 ������ѯ���
			rs = pstmt.executeQuery();
			// 5 ���ز�ѯ���result
			if (rs != null && rs.next()) {
				language language = new language();
				language.setLanguageId(rs.getInt("languageId"));
				language.setLanguage(rs.getString("languageName"));
				return language;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return null;
	}

	// 1���������Ʋ�ѯ_�鵽��Ӧ����
	public language query(String languageName) {
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
			// 3 sql���
			String sql = "select * from language where languageName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, languageName);
			// 4 ������ѯ���
			rs = pstmt.executeQuery();
			// 5 ���ز�ѯ���result
			if (rs != null && rs.next()) {
				language language = new language();
				language.setLanguageId(rs.getInt("languageId"));
				language.setLanguage(rs.getString("languageName"));
				return language;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return null;
	}

	// ��������id��ѯ
	public language queryId(int languageId) {
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
			// 3 sql���
			String sql = "select * from language where languageId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, languageId);
			// 4 ������ѯ���
			rs = pstmt.executeQuery();
			// 5 ���ز�ѯ���result
			if (rs != null && rs.next()) {
				language language = new language();
				language.setLanguageId(rs.getInt("languageId"));
				language.setLanguage(rs.getString("languageName"));
				return language;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return null;
	}

	// 2����ѯ���е���������ʵ�����
	public List<language> queryAll() {
		List<language> languages = new ArrayList<language>();
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// ������ѯ������
		String sql = "select * from language";
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
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return languages;
	}

	// ��
	public int insert(language language) {
		// 2 �������� connection
		conn = BaseDAO.getConn();
		if (conn == null) {
			return 0;
		}
		// 3 ����statement
		PreparedStatement pstmt = null;
		try {
			// 3 sql���
			String sql = "insert into language(languageName) values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, language.getLanguage());
			int row = pstmt.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return 0;
	}

	// ��
	public int update(language language) {
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return -1;
		}
		// sql���
		String sql = "update language set languageName=? where languageId=?";
		// ����statement
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
		} finally {// �ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return -1;
	}

	// ɾ
	public int del(int languageId) {
		bookType type = new bookType();
		conn = BaseDAO.getConn();
		if (conn == null) {
			return -1;
		}
		// ���ݿ����
		String sql = "delete from language where languageId=" + languageId;
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			int row = pstmt.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return -1;
	}

	public static void main(String[] args) throws SQLException, IOException {
		// ��ҳ����
		/*languageDAO dao=new languageDAO(); 
		 List<language> list=dao.query(1, 4);
		 for(language language: list) { 
			 System.out.println(language.toString());
		}
		*/

		// ��ѯ����
		
		/*languageDAO dao=new languageDAO(); 
		System.out.println(dao.queryCount());*/
		 

		// ��ѯ����ISDN
		 /*languageDAO dao=new languageDAO(); 
		 language language=dao.queryLanguageName(1);
		 if(language!=null) { 
			System.out.println(language.toString()); 
		 }else {
			System.out.println("��"); 
		 }*/
		 

		// ��ѯ��������
		/*languageDAO dao=new languageDAO(); 
		language language=dao.query("����");
		System.out.println(language.toString());*/
		 

		// ��ѯ��������id
		
		/*languageDAO dao=new languageDAO();
		language language=dao.queryId(1);
		System.out.println(language.toString());*/
		 

		// ��ѯ����
		/*languageDAO dao=new languageDAO(); 
		List<language> list=dao.queryAll();
		for(language language: list) { 
			 System.out.println(language.toString()); 
		}*/


		// ��
		/*languageDAO dao=new languageDAO(); 
		language language=new language();
		language.setLanguage("����");; 
		 int a=dao.insert(language); 
		 System.out.println(a);*/

		// ��	
		/*languageDAO dao=new languageDAO(); 
		language language=new language();
		language.setLanguageId(8);; 
		language.setLanguage("�����޸�");; 
		 int a= dao.update(language);
		 System.out.println(a);*/
		 

		// ɾ��
		/*languageDAO dao=new languageDAO(); 
		language language=new language(); 
		int a=dao.del(8); 
		System.out.println(a);*/
	}
}

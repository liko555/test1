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
	// ��������id��ѯ
		public bookrack queryId(int bookrackId) {
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
				String sql = "select * from bookrack where bookrackId=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bookrackId);
				// 4 ������ѯ���
				rs = pstmt.executeQuery();
				// 5 ���ز�ѯ���result
				if (rs != null && rs.next()) {
					bookrack bookrack = new bookrack();
					bookrack.setBookrackId(rs.getInt("bookrackId"));;
					bookrack.setBookrackName(rs.getString("bookrackName"));
					return bookrack;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {// �ر���Դ
				BaseDAO.close(conn, rs, pstmt);
			}
			return null;
		}
		// ��ʾȫ�� ��ҳ
		public List<bookrack> query(int pageNo, int pageSize) {
//				select * from cartoonType limit
			// ��������
			conn = BaseDAO.getConn();
			// ����statement
			PreparedStatement pstmt = null;
			// ������ѯ���
			ResultSet rs = null;
			if (conn != null) {
				try {
					String sql = "select * from bookrack limit ?,?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, (pageNo - 1) * pageSize);
					pstmt.setInt(2, pageSize);

					// ������ѯ���
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
				} finally {// �ر���Դ
					BaseDAO.close(conn, rs, pstmt);
				}
			}
			return null;
		}
		// 2����ѯ���е���������ʵ�����
		public List<bookrack> queryAll() {
			List<bookrack> bookracks = new ArrayList<bookrack>();
			// ��������
			conn = BaseDAO.getConn();
			if (conn == null) {
				return null;
			}
			// ������ѯ������
			String sql = "select * from bookrack";
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
			} finally {// �ر���Դ
				BaseDAO.close(conn, rs, pstmt);
			}
			return bookracks;
		}
		// 1���������Ʋ�ѯ_�鵽��Ӧ����
		public bookrack query(String bookrackName) {
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
				String sql = "select * from bookrack where bookrackName=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bookrackName);
				// 4 ������ѯ���
				rs = pstmt.executeQuery();
				// 5 ���ز�ѯ���result
				if (rs != null && rs.next()) {
					bookrack bookrack = new bookrack();
					bookrack.setBookrackName(rs.getString("bookrackName"));
					bookrack.setBookrackId(rs.getInt("bookrackId"));
					return bookrack;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {// �ر���Դ
				BaseDAO.close(conn, rs, pstmt);
			}
			return null;
		}
}

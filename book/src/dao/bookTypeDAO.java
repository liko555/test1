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

	// ��ʾȫ�� ��ҳ
	public List<bookType> query(int pageNo, int pageSize) {
//			select * from cartoonType limit
		// ��������
		conn = BaseDAO.getConn();
		// ����statement
		PreparedStatement pstmt = null;
		// ������ѯ���
		ResultSet rs = null;
		if (conn != null) {
			try {
				String sql = "select * from bookType limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (pageNo - 1) * pageSize);
				pstmt.setInt(2, pageSize);

				// ������ѯ���
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
				String sql = "select count(*) from bookType";
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
	public bookType queryTypeName(int bookId) {
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
			String sql = "select typeId,typeName from book inner join booktype using(typeId) where bookId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			// 4 ������ѯ���
			rs = pstmt.executeQuery();
			// 5 ���ز�ѯ���result
			if (rs != null && rs.next()) {
				bookType type = new bookType();
				type.setTypeId(rs.getInt("typeId"));
				type.setTypeName(rs.getString("typeName"));
				return type;
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
	public bookType query(String typeName) {
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
			String sql = "select * from booktype where typeName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, typeName);
			// 4 ������ѯ���
			rs = pstmt.executeQuery();
			// 5 ���ز�ѯ���result
			if (rs != null && rs.next()) {
				bookType type = new bookType();
				type.setTypeId(rs.getInt("typeId"));
				type.setTypeName(rs.getString("typeName"));
				return type;
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
	public List<bookType> query2(String typeName) {
		List<bookType> ctypes = new ArrayList<bookType>();
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
			String sql = "select * from booktype where typeName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, typeName);
			// 4 ������ѯ���
			rs = pstmt.executeQuery();
			// 5 ���ز�ѯ���result
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
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return null;
	}
	// ��������id��ѯ
	public bookType queryId(int typeId) {
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
			String sql = "select * from booktype where typeId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, typeId);
			// 4 ������ѯ���
			rs = pstmt.executeQuery();
			// 5 ���ز�ѯ���result
			if (rs != null && rs.next()) {
				bookType type = new bookType();
				type.setTypeId(rs.getInt("typeId"));
				type.setTypeName(rs.getString("typeName"));
				return type;
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
	public List<bookType> queryAll() {
		List<bookType> ctypes = new ArrayList<bookType>();
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// ������ѯ������
		String sql = "select * from bookType";
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
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return ctypes;
	}

	// ��
	public int insert(bookType type) {
		// 2 �������� connection
		conn = BaseDAO.getConn();
		if (conn == null) {
			return 0;
		}
		// 3 ����statement
		PreparedStatement pstmt = null;
		try {
			// 3 sql���
			String sql = "insert into booktype(typeName) values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, type.getTypeName());
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
	public int update(bookType type) {
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return -1;
		}
		// sql���
		String sql = "update bookType set typeName=? where typeId=?";
		// ����statement
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
		} finally {// �ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return -1;
	}

	// ɾ
	public int del(int typeId) {
		bookType type = new bookType();
		conn = BaseDAO.getConn();
		if (conn == null) {
			return -1;
		}
		// ���ݿ����
		String sql = "delete from bookType where TypeId=" + typeId;
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
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); List<bookType> list=dao.query(1, 4);
		 * for(bookType bookType: list) { System.out.println(bookType.toString()); }
		 */

		// ��ѯ����
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); System.out.println(dao.queryCount());
		 */

		// ��ѯ����ISDN
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); bookType bookType=dao.queryTypeName(1);
		 * if(bookType!=null) { System.out.println(bookType.toString()); }else {
		 * System.out.println("��"); }
		 */

		// ��ѯ��������
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); bookType bt=dao.query("��ѧ");
		 * System.out.println(bt.toString());
		 */

		// ��ѯ��������id
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); bookType bt=dao.queryId(9);
		 * System.out.println(bt.toString());
		 */

		// ��ѯ����
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); List<bookType> list=dao.queryAll();
		 * for(bookType bookType: list) { System.out.println(bookType.toString()); }
		 */

		// ��
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); bookType bt=new bookType();
		 * bt.setTypeName("����"); int a=dao.insert(bt); System.out.println(a);
		 */

		// ��
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); bookType bt=new bookType();
		 * bt.setTypeId(23); bt.setTypeName("�����޸�"); int a= dao.update(bt);
		 * System.out.println(a);
		 */

		// ɾ��
		/*
		 * bookTypeDAO dao=new bookTypeDAO(); bookType bt=new bookType(); int
		 * a=dao.del(23); System.out.println(a);
		 */
	}
}

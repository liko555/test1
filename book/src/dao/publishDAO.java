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

	// ��ʾȫ�� ��ҳ
	public List<publish> query(int pageNo, int pageSize) {
//			select * from cartoonType limit
		// ��������
		conn = BaseDAO.getConn();
		// ����statement
		PreparedStatement pstmt = null;
		// ������ѯ���
		ResultSet rs = null;
		if (conn != null) {
			try {
				String sql = "select * from publish limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (pageNo - 1) * pageSize);
				pstmt.setInt(2, pageSize);

				// ������ѯ���
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
				String sql = "select count(*) from publish";
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
	public publish queryPublishName(int ISDN) {
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
			String sql = "select publishId,publishName from book inner join publish using(publishId) where ISDN=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ISDN);
			// 4 ������ѯ���
			rs = pstmt.executeQuery();
			// 5 ���ز�ѯ���result
			if (rs != null && rs.next()) {
				publish publish = new publish();
				publish.setPublishId(rs.getInt("publishId"));
				publish.setPublicName(rs.getString("publishName"));
				return publish;
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
	public publish query(String publishName) {
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
			String sql = "select * from publish where publishName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publishName);
			// 4 ������ѯ���
			rs = pstmt.executeQuery();
			// 5 ���ز�ѯ���result
			if (rs != null && rs.next()) {
				publish publish = new publish();
				publish.setPublishId(rs.getInt("publishId"));
				publish.setPublicName(rs.getString("publishName"));
				return publish;
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
	public publish queryId(int publishId) {
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
			String sql = "select * from publish where publishId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, publishId);
			// 4 ������ѯ���
			rs = pstmt.executeQuery();
			// 5 ���ز�ѯ���result
			if (rs != null && rs.next()) {
				publish publish = new publish();
				publish.setPublishId(rs.getInt("publishId"));
				publish.setPublicName(rs.getString("publishName"));
				return publish;
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
	public List<publish> queryAll() {
		List<publish> publishs = new ArrayList<publish>();
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// ������ѯ������
		String sql = "select * from publish";
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
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return publishs;
	}

	// ��
	public int insert(publish publish) {
		// 2 �������� connection
		conn = BaseDAO.getConn();
		if (conn == null) {
			return 0;
		}
		// 3 ����statement
		PreparedStatement pstmt = null;
		try {
			// 3 sql���
			String sql = "insert into publish(publishName) values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, publish.getPublicName());
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
	public int update(publish publish) {
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return -1;
		}
		// sql���
		String sql = "update publish set publishName=? where publishId=?";
		// ����statement
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
		} finally {// �ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return -1;
	}

	// ɾ
	public int del(int publishId) {
		publish publish = new publish();
		conn = BaseDAO.getConn();
		if (conn == null) {
			return -1;
		}
		// ���ݿ����
		String sql = "delete from publish where publishId=" + publishId;
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
		/*publishDAO dao=new publishDAO(); 
		 List<publish> list=dao.query(1, 4);
		 for(publish publish: list) { 
			 System.out.println(publish.toString());
		}*/
		

		// ��ѯ����
		/*publishDAO dao=new publishDAO(); 
		System.out.println(dao.queryCount());*/
		 

		// ��ѯ����ISDN
		/*publishDAO dao=new publishDAO(); 
		publish publish=dao.queryPublishName(1);
		 if(publish!=null) { 
			System.out.println(publish.toString()); 
		 }else {
			System.out.println("��"); 
		 }*/
		 

		// ��ѯ��������
		/*publishDAO dao=new publishDAO(); 
		publish publish=dao.query("��������");
		System.out.println(publish.toString());*/
		 

		// ��ѯ��������id
		/*publishDAO dao=new publishDAO();
		publish publish=dao.queryId(1);
		System.out.println(publish.toString());*/
		 

		// ��ѯ����
		/*publishDAO dao=new publishDAO(); 
		List<publish> list=dao.queryAll();
		for(publish publish: list) { 
			 System.out.println(publish.toString()); 
		}*/


		// ��
		/*publishDAO dao=new publishDAO(); 
		publish publish=new publish();
		publish.setPublicName("����"); 
		 int a=dao.insert(publish); 
		 System.out.println(a);*/

		// ��	
		/*publishDAO dao=new publishDAO(); 
		publish publish=new publish();
		publish.setPublishId(5);
		publish.setPublicName("�����޸�");
		 int a= dao.update(publish);
		 System.out.println(a);*/
		 

		// ɾ��
		/*publishDAO dao=new publishDAO(); 
		publish publish=new publish(); 
		int a=dao.del(5); 
		System.out.println(a);*/
	}
}

package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.admin;
import entity.book;

public class adminDAO {
	private static Connection conn = null;
	// ��¼

	// �����Ķ���
	// �������η� ����ֵ���� ������(����) { ������ }
	// ����ʲô��������������������������ݡ�������
	// ����ʲô�����������ݵ����͡�������ֵ����
	public admin adminLogin(String adminName, String adminPwd) {
		conn = BaseDAO.getConn();
		if (conn == null) {
			return null;
		}
		// 3. ����������
		PreparedStatement pstmt = null;
		// 4. ��������������
		ResultSet rs = null;
		try {
			// 3. ����������
			String sql = "select * from admin where adminName=? and adminPwd=?";
			pstmt = conn.prepareStatement(sql);
			// 4. ִ�����
			pstmt.setString(1, adminName);
			pstmt.setString(2, adminPwd);
			rs = pstmt.executeQuery();
			// 5. ʹ�ý����
			// �жϽ�������Ƿ��������У���˵���û��Ϸ���û��˵���û��Ƿ�
			if (rs != null && rs.next()) {
				// �Ϸ���ʱ�򷵻ع���Ա����
				admin admin = new admin();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminPwd(rs.getString("adminPwd"));
				admin.setTrueName(rs.getString("truename"));
				admin.setPhone(rs.getString("phone"));
				return admin;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			BaseDAO.close(conn, rs, pstmt);
		}
		return null;
	}
	//�޸�
	public int update(admin admin) {
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return -1;
		}
	    //sql���
	    String sql = "update admin set adminName=?,adminPwd=?,trueName=?,phone=? where adminId=?";
	    //����statement  
	  	PreparedStatement pstmt = null;
	    try {
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);
	        pstmt.setString(1,admin.getAdminName());
			pstmt.setString(2,admin.getAdminPwd());
			pstmt.setString(3, admin.getTrueName());
			pstmt.setString(4, admin.getPhone());
			pstmt.setInt(5,admin.getAdminId());
			int row = pstmt.executeUpdate();
			return row;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//�ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return -1;
	}
	
	public admin query(int adminId) {
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		try {
			//sql���
			String sql="select * from admin where adminId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, adminId);
			//������ѯ���
			rs = pstmt.executeQuery();
			//���ز�ѯ���result
			if(rs!=null&&rs.next()) {
				admin admin=new admin();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminName(rs.getString("adminName"));
				admin.setAdminPwd(rs.getString("adminPwd"));
				admin.setTrueName(rs.getString("truename"));
				admin.setPhone(rs.getString("phone"));
				return admin;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//�ر���Դ
			BaseDAO.close(conn, rs,pstmt);
		}
		return null;
	}
	public static void main(String[] args) throws SQLException, IOException {
		// ��¼����
		adminDAO dao = new adminDAO();
		admin admin = dao.adminLogin("admin1", "123");
		System.out.println(admin.toString());
	}
}

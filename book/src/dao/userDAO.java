package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.bookType;
import entity.user;

public class userDAO {
	private static Connection conn=null;
	//��¼
	public user userLogin(String userName, String userPwd) {
		//��������
		conn=BaseDAO.getConn();
		if(conn==null) {
			return null;
		}
		//����statement  
		PreparedStatement pstmt = null;
		//������ѯ���
		ResultSet rs = null;
		
		//������ѯ������
		String sql = "select * from user where userName=? and userPwd=?";
		
		try {
			//����������
			pstmt=conn.prepareStatement(sql);
			
			//ִ��SQL���
			pstmt.setString(1, userName);
			pstmt.setString(2, userPwd);
			
			//ִ�з��ؽ�����
			rs=pstmt.executeQuery();
			
			// 5. ʹ�ý����
			// �жϽ�������Ƿ��������У���˵���û��Ϸ���û��˵���û��Ƿ�
			if(rs != null && rs.next()) {
				// �Ϸ���ʱ�򷵻ع���Ա����
				user user = new user();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPwd(rs.getString("userPwd"));
				user.setTrueName(rs.getString("trueName"));
				user.setPhone(rs.getString("phone"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//�ر���Դ
			BaseDAO.close(conn, rs,pstmt);
		}
		return null; 	
	}
	
	// ��ʾȫ�� ��ҳ
	public List<user> query(int pageNo, int pageSize) {
//			select * from cartoonType limit
		// ��������
		conn = BaseDAO.getConn();
		// ����statement
		PreparedStatement pstmt = null;
		// ������ѯ���
		ResultSet rs = null;
		if (conn != null) {
			try {
				String sql = "select * from user limit ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, (pageNo - 1) * pageSize);
				pstmt.setInt(2, pageSize);

				// ������ѯ���
				rs = pstmt.executeQuery();

				if (rs != null) {
					List<user> list = new ArrayList<user>();
					while (rs.next()) {
						user user = new user();
						user.setUserId(rs.getInt("userId"));
						user.setUserName(rs.getString("userName"));
						user.setUserPwd(rs.getString("userPwd"));
						user.setTrueName(rs.getString("trueName"));
						user.setPhone(rs.getString("phone"));
						list.add(user);
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
	// ��ʾȫ�� ��ҳ
	public List<user> query2(String userName) {
//			select * from cartoonType limit
		// ��������
		conn = BaseDAO.getConn();
		// ����statement
		PreparedStatement pstmt = null;
		// ������ѯ���
		ResultSet rs = null;
		if (conn != null) {
			try {
				String sql = "select * from user where userName=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userName);
				// ������ѯ���
				rs = pstmt.executeQuery();

				if (rs != null) {
					List<user> list = new ArrayList<user>();
					while (rs.next()) {
						user user = new user();
						user.setUserId(rs.getInt("userId"));
						user.setUserName(rs.getString("userName"));
						user.setUserPwd(rs.getString("userPwd"));
						user.setTrueName(rs.getString("trueName"));
						user.setPhone(rs.getString("phone"));
						list.add(user);
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
				String sql = "select count(*) from user";
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
	// ��
	public int insert(user user) {
		// 2 �������� connection
		conn = BaseDAO.getConn();
		if (conn == null) {
			return 0;
		}
		// 3 ����statement
		PreparedStatement pstmt = null;
		try {
			// 3 sql���
			String sql = "insert into user(userName,userPwd,trueName,phone) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPwd());
			pstmt.setString(3, user.getTrueName());
			pstmt.setString(4,user.getPhone());
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
	// ��������id��ѯ
	public user queryId(int userId) {
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
			String sql = "select * from user where userId=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			// 4 ������ѯ���
			rs = pstmt.executeQuery();
			// 5 ���ز�ѯ���result
			if (rs != null && rs.next()) {
				user user = new user();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPwd(rs.getString("userPwd"));
				user.setTrueName(rs.getString("trueName"));
				user.setPhone(rs.getString("phone"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return null;
	}
	// ����������ѯ
	public user queryId(String userName) {
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
			String sql = "select * from user where userName=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			// 4 ������ѯ���
			rs = pstmt.executeQuery();
			// 5 ���ز�ѯ���result
			if (rs != null && rs.next()) {
				user user = new user();
				user.setUserId(rs.getInt("userId"));
				user.setUserName(rs.getString("userName"));
				user.setUserPwd(rs.getString("userPwd"));
				user.setTrueName(rs.getString("trueName"));
				user.setPhone(rs.getString("phone"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {// �ر���Դ
			BaseDAO.close(conn, rs, pstmt);
		}
		return null;
	}
	// ��
	public int update(user user) {
		// ��������
		conn = BaseDAO.getConn();
		if (conn == null) {
			return -1;
		}
		// sql���
		String sql = "update user set userName=?,userPwd=?,trueName=?,phone=? where userId=?";
		// ����statement
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserPwd());
			pstmt.setString(3, user.getTrueName());
			pstmt.setString(4,user.getPhone());
			pstmt.setInt(5, user.getUserId());
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
	//ɾ������typeid
	public int delUser(int userId) {
		conn=BaseDAO.getConn();
		if(conn==null) {
			return 0;
		}
         //���ݿ����
 		String sql = "delete from user where userId="+userId;
 		PreparedStatement pstmt = null;
 		 try {
 			pstmt = (PreparedStatement) conn.prepareStatement(sql);
 		    int row = pstmt.executeUpdate();
 		    return row;
 		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {//�ر���Դ
			BaseDAO.close(conn, pstmt);
		}
		return 0;
	}
	public static void main(String[] args) throws SQLException, IOException {
		//��¼����
		/*userDAO dao=new userDAO();
		user user=dao.userLogin("user1", "111");
		System.out.println(user.toString());*/
	}
}

package service;

import dao.adminDAO;
import entity.admin;

public class adminService {
	public admin login(String adminName, String adminPwd) {
		adminDAO dao=new adminDAO();
		return dao.adminLogin(adminName, adminPwd);
	}
	//�޸�����
	public boolean modifyAdmin(admin admin) {
		adminDAO dao=new adminDAO();
		int row=dao.update(admin);
		if(row>0) {
			//�޸ĳɹ�
			return true;
		}
		return false;
	}
	
	public admin getAdmin(int adminId) {
		adminDAO dao=new adminDAO();
		return dao.query(adminId);
	}
}

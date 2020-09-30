package service;

import dao.adminDAO;
import entity.admin;

public class adminService {
	public admin login(String adminName, String adminPwd) {
		adminDAO dao=new adminDAO();
		return dao.adminLogin(adminName, adminPwd);
	}
	//修改漫画
	public boolean modifyAdmin(admin admin) {
		adminDAO dao=new adminDAO();
		int row=dao.update(admin);
		if(row>0) {
			//修改成功
			return true;
		}
		return false;
	}
	
	public admin getAdmin(int adminId) {
		adminDAO dao=new adminDAO();
		return dao.query(adminId);
	}
}

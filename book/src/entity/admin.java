package entity;

public class admin {
	private int adminId;
	private String adminName;
	private String adminPwd;
	private String trueName;
	private String phone;
	public admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public admin(int adminId, String adminName, String adminPwd, String trueName, String phone) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.trueName = trueName;
		this.phone = phone;
	}

	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPwd=" + adminPwd + ", trueName="
				+ trueName + ", phone=" + phone + "]";
	}
	
}

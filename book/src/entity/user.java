package entity;

public class user {
	private int userId;
	private String userName;
	private String userPwd;
	private String trueName;
	private String phone;
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
	public user(int userId, String userName, String userPwd, String trueName, String phone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.trueName = trueName;
		this.phone = phone;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
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
		return "user [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", trueName=" + trueName
				+ ", phone=" + phone + "]";
	}
	
}

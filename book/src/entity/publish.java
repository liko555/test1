package entity;

public class publish {
	private int publishId;
	private String publicName;
	public publish() {
		super();
		// TODO Auto-generated constructor stub
	}
	public publish(int publishId, String publicName) {
		super();
		this.publishId = publishId;
		this.publicName = publicName;
	}
	public int getPublishId() {
		return publishId;
	}
	public void setPublishId(int publishId) {
		this.publishId = publishId;
	}
	public String getPublicName() {
		return publicName;
	}
	public void setPublicName(String publicName) {
		this.publicName = publicName;
	}
	@Override
	public String toString() {
		return "publish [publishId=" + publishId + ", publicName=" + publicName + "]";
	}
	
}

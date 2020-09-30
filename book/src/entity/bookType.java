package entity;

public class bookType {
	private int typeId;
	private String typeName;
	public bookType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public bookType(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "bookType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	
}

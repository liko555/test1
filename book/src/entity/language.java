package entity;

public class language {
	private int languageId;
	private String language;
	public language() {
		super();
		// TODO Auto-generated constructor stub
	}
	public language(int languageId, String language) {
		super();
		this.languageId = languageId;
		this.language = language;
	}
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "language [languageId=" + languageId + ", language=" + language + "]";
	}
	
}

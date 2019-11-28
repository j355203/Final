package finalProject.eeit10907.model;

public class titleBean implements java.io.Serializable{
	
	private static final long serialVersionUID=1L;
	
//	title.html
	private String titleno1; //新增：職稱編號
	private String titlename1;//新增：職稱名稱
	private String subjectt1;//新增：預設學門一
	private String subjectt2;//新增：預設學門二
	private String subjectt3;//新增：預設學門三
	private String titleno2; //查詢：職稱編號
	private String titlename2;//查詢：職稱名稱
	private String titleSubject;


	
	
	

	public String getTitleno1() {
		return titleno1;
	}
	public void setTitleno1(String titleno1) {
		this.titleno1 = titleno1;
	}
	public String getTitlename1() {
		return titlename1;
	}
	public void setTitlename1(String titlename1) {
		this.titlename1 = titlename1;
	}
	public String getSubjectt1() {
		return subjectt1;
	}
	public void setSubjectt1(String subjectt1) {
		this.subjectt1 = subjectt1;
	}
	public String getSubjectt2() {
		return subjectt2;
	}
	public void setSubjectt2(String subjectt2) {
		this.subjectt2 = subjectt2;
	}
	public String getSubjectt3() {
		return subjectt3;
	}
	public void setSubjectt3(String subjectt3) {
		this.subjectt3 = subjectt3;
	}
	public String getTitleno2() {
		return titleno2;
	}
	public void setTitleno2(String titleno2) {
		this.titleno2 = titleno2;
	}
	public String getTitlename2() {
		return titlename2;
	}
	public void setTitlename2(String titlename2) {
		this.titlename2 = titlename2;
	}

		public String getTitleSubject() {
		return titleSubject;
	}

	
}

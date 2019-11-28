package finalProject.eeit10911.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICLE")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer articleId;
	private String articleClass;
	private Integer empId;
	private String topic;
	private String articleContent;
	private String createDate;
	private Integer reportStatus;

//	public Article(Integer articleId, String articleClass, Integer empId, String topic, String articleContent,
//			String createDate, Integer reportStatus) {
//		this.articleId = articleId;
//		this.articleClass = articleClass;
//		this.empId = empId;
//		this.topic = topic;
//		this.articleContent = articleContent;
//		this.createDate = createDate;
//		this.reportStatus = reportStatus;
//	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getArticleClass() {
		return articleClass;
	}

	public void setArticleClass(String articleClass) {
		this.articleClass = articleClass;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(Integer reportStatus) {
		this.reportStatus = reportStatus;
	}

}

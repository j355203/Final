package finalProject.eeit10911.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REPLY")
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer replyId;
	private Integer articleId;
	private Integer empId;
	private String empName;
	private String replyContent;
	private String replyDate;

//	public Reply(Integer replyId, Integer articleId, Integer empId, String replyContent, String replyDate) {
//		this.replyId = replyId;
//		this.articleId = articleId;
//		this.empId = empId;
//		this.replyContent = replyContent;
//		this.replyDate = replyDate;
//	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

}

package finalProject.eeit10907.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class SubjectBean {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int SubjectID;
	private String SubjectName;
	private int	 SubjectScore;
	private String subjectname_a1;//?
	
	
	

	
	public int getSubjectID() {
		return SubjectID;
	}
	public void setSubjectID(int subjectID) {
		SubjectID = subjectID;
	}
	public String getSubjectName() {
		return SubjectName;
	}
	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}
	public int getSubjectScore() {
		return SubjectScore;
	}
	public void setSubjectScore(int subjectScore) {
		SubjectScore = subjectScore;
	}

		public String getSubjectname_a1() {
		return subjectname_a1;
	}
	public void setSubjectname_a1(String subjectname_a1) {
		this.subjectname_a1 = subjectname_a1;
	}
	
	
}

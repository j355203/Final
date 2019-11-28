package finalProject.eeit10937.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RegistrationForm")
public class RegistrationFormBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer formId;
	private Integer empid;
	private String empname;
	private Integer depno;
	private Integer activityId;

	public RegistrationFormBean(Integer formId, Integer empid, String empname, Integer depno, Integer activityId) {
		this.empid = empid;
		this.empname = empname;
		this.formId = formId;
		this.depno = depno;
		this.activityId = activityId;
	}

	public RegistrationFormBean() {

	}

	public Integer getFormId() {
		return formId;
	}

	public void setFormId(Integer formId) {
		this.formId = formId;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Integer getDepno() {
		return depno;
	}

	public void setDepno(Integer depno) {
		this.depno = depno;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

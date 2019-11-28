package finalProject.eeit10904.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employee")
public class EmployeeBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empid;
	private String empname;
	private String empgender;
	private String empbirth;
	private String emptitle;
	private Integer emplevel;
	private String empphone;
	private String empaddress;
	private String emponboard;
	private String emppassword;
	
	@Transient
	private Integer depno;
	@Transient
	private Integer empleave;



	@JsonIgnoreProperties("empBean")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "depno")
	private DepartmentBean depBean;

	public EmployeeBean(Integer empid, String empname, String empgender, 
			String empbirth, DepartmentBean depBean, String emptitle, Integer emplevel, String empphone, 
			String empaddress, String emponboard, Integer empleave) {
		this.empid = empid;
		this.empname = empname;
		this.empgender = empgender;
		this.depno = depBean.getDepno();
		this.empbirth = empbirth;
		this.emptitle = emptitle;
		this.emplevel = emplevel;
		this.empphone = empphone;
		this.empaddress = empaddress;
		this.emponboard = emponboard;
		this.empleave = empleave;
	}
	
	public EmployeeBean() {
		
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

	public String getEmpgender() {
		return empgender;
	}

	public void setEmpgender(String empgender) {
		this.empgender = empgender;
	}

	public String getEmpbirth() {
		return empbirth;
	}

	public void setEmpbirth(String empbirth) {
		this.empbirth = empbirth;
	}

	public DepartmentBean getDepBean() {
		return depBean;
	}

	public void setDepBean(DepartmentBean depBean) {
		this.depBean = depBean;
	}

	public Integer getDepno() {
		return depno;
	}

	public void setDepno(Integer depno) {
		this.depno = depno;
	}

	public String getEmptitle() {
		return emptitle;
	}

	public void setEmptitle(String emptitle) {
		this.emptitle = emptitle;
	}

	public String getEmpphone() {
		return empphone;
	}

	public void setEmpphone(String empphone) {
		this.empphone = empphone;
	}

	public String getEmpaddress() {
		return empaddress;
	}

	public void setEmpaddress(String empaddress) {
		this.empaddress = empaddress;
	}

	public String getEmponboard() {
		return emponboard;
	}

	public void setEmponboard(String emponboard) {
		this.emponboard = emponboard;
	}

	public Integer getEmpleave() {
		return empleave;
	}

	public void setEmpleave(Integer empleave) {
		this.empleave = empleave;
	}

	public String getEmppassword() {
		return emppassword;
	}

	public void setEmppassword(String emppassword) {
		this.emppassword = emppassword;
	}

	public Integer getEmplevel() {
		return emplevel;
	}

	public void setEmplevel(Integer emplevel) {
		this.emplevel = emplevel;
	}
}

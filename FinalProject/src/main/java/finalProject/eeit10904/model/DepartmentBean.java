package finalProject.eeit10904.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "department")
public class DepartmentBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer depno;
	private String depname;
	
	@JsonIgnore
	@OneToMany(mappedBy = "depBean")
	private Set<EmployeeBean> empSet = new LinkedHashSet<>();
	
	public DepartmentBean(Integer depno, String depname, Set<EmployeeBean> empSet) {
		this.depno = depno;
		this.depname = depname;
		this.empSet = empSet;
	}
	
	public DepartmentBean() {
		
	}
	
	public Integer getDepno() {
		return depno;
	}

	public void setDepno(Integer depno) {
		this.depno = depno;
	}

	public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public Set<EmployeeBean> getEmpSet() {
		return empSet;
	}

	public void setEmpSet(Set<EmployeeBean> empSet) {
		this.empSet = empSet;
	}
	
}

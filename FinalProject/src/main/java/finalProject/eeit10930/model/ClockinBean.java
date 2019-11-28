package finalProject.eeit10930.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clockin")
public class ClockinBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer clockinid;
	private Integer empid;
	private String clkintime;
	private String clkouttime;
	private Integer overtime;
	private String verify;
	private Integer depno;

	public ClockinBean(Integer clockinid, Integer empid, String clkintime, 
			String clkouttime, Integer overtime, String verify, Integer depno) {
		this.clockinid = clockinid;
		this.empid = empid;
		this.clkintime = clkintime;
		this.clkouttime = clkouttime;
		this.overtime = overtime;
		this.verify = verify;
		this.depno = depno;
	}
	
	public ClockinBean() {
		
	}
	
	public Integer getClockinid() {
		return clockinid;
	}

	public void setClockinid(Integer clockinid) {
		this.clockinid = clockinid;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getClkintime() {
		return clkintime;
	}

	public void setClkintime(String clkintime) {
		this.clkintime = clkintime;
	}

	public String getClkouttime() {
		return clkouttime;
	}

	public void setClkouttime(String clkouttime) {
		this.clkouttime = clkouttime;
	}

	public Integer getOvertime() {
		return overtime;
	}

	public void setOvertime(Integer overtime) {
		this.overtime = overtime;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	public Integer getDepno() {
		return depno;
	}

	public void setDepno(Integer depno) {
		this.depno = depno;
	}
	
	

}

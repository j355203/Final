package finalProject.eeit10930.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leave")
public class LeaveBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer leaveid;
	private Integer empid;
	private String ename;
	private String dayoffstart;
	private String dayoffend;
	private	String leavestyle;
	private Integer deptno;
	private	String verify;
	private String imgpath;
	
	public LeaveBean(Integer leaveid, Integer empid, 
			String ename, String dayoffstart, String dayoffend, 
			String leavestyle, Integer deptno) {
		this.leaveid = leaveid;
		this.empid = empid;
		this.ename = ename;
		this.dayoffstart = dayoffstart;
		this.dayoffend = dayoffend;
		this.leavestyle = leavestyle;
		this.deptno = deptno;
		
	}
	
	public LeaveBean() {
		
	}
	
	public Integer getLeaveid() {
		return leaveid;
	}
	public void setLeaveid(Integer leaveid) {
		this.leaveid = leaveid;
	}
	
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDayoffstart() {
		return dayoffstart;
	}
	public void setDayoffstart(String dayoffstart) {
		this.dayoffstart = dayoffstart;
	}
	public String getDayoffend() {
		return dayoffend;
	}
	public void setDayoffend(String dayoffend) {
		this.dayoffend = dayoffend;
	}
	public String getLeavestyle() {
		return leavestyle;
	}
	public void setLeavestyle(String leavestyle) {
		this.leavestyle = leavestyle;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	public String getImgpath() {
		return imgpath;
	}

	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	
	
}

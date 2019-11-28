package finalProject.eeit10930.service;

import java.util.List;

import finalProject.eeit10930.model.LeaveBean;

public interface LeaveService {
	void addleave(LeaveBean lb) ;
	List<LeaveBean> queryleave(Integer empid);
	LeaveBean updateleave(LeaveBean lb);
	void deleteleave(Integer leaveid);
	LeaveBean findbyleaveId(Integer leaveid); 
	List<LeaveBean> findbydeptno(Integer deptno);
	void updateverify (LeaveBean lb);
}

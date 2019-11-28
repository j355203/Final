package finalProject.eeit10904.service;

import java.util.List;

import finalProject.eeit10904.model.DepartmentBean;
import finalProject.eeit10904.model.EmployeeBean;

public interface EmployeeService {
	boolean verify(EmployeeBean emp);
	Integer add(EmployeeBean emp);
	EmployeeBean update(EmployeeBean emp);
	boolean updatepassword(EmployeeBean emp);
	EmployeeBean leave(Integer empid);
	EmployeeBean repatriation(Integer empid);
	EmployeeBean findById(Integer empid);
	List<EmployeeBean> findAll();
	List<EmployeeBean> findLeaves();
	DepartmentBean getDepByNo(Integer depno);
	byte[] exportUsersToCsv(List<EmployeeBean> emps);
}

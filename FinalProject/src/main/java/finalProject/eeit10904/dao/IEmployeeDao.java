package finalProject.eeit10904.dao;

import java.util.List;

import finalProject.eeit10904.model.DepartmentBean;
import finalProject.eeit10904.model.EmployeeBean;

public interface IEmployeeDao {
	boolean verify(EmployeeBean emp);			//員工登入
	Integer add(EmployeeBean emp);				//新增員工
	EmployeeBean update(EmployeeBean emp);		//更新員工
	boolean updatepassword(EmployeeBean emp);	//更新密碼
	EmployeeBean leave(Integer empid);			//員工離職
	EmployeeBean repatriation(Integer empid);	//員工回任
	EmployeeBean findById(Integer empid);		//找在職單一員工
	List<EmployeeBean> findAll();				//找在職所有員工
	List<EmployeeBean> findLeaves();			//找離職所有員工
	DepartmentBean getDepByNo(Integer depno);
	byte[] exportUsersToCsv(List<EmployeeBean> emps);
}
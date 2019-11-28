package finalProject.eeit10930.dao;

import java.util.List;
import java.util.Map;

import finalProject.eeit10904.model.DepartmentBean;
import finalProject.eeit10930.model.LeaveBean;

public interface LeaveDao {
	void addleave(LeaveBean lb) ; //員工申請請假
	List<LeaveBean> queryleave(Integer empid) ; //員工查詢請假
	LeaveBean updateleave(LeaveBean lb); //員工修改請假
	void deleteleave(Integer leaveid); //員工刪除請假
	LeaveBean findbyleaveId(Integer leaveid); //查詢單筆請假ID
	List<LeaveBean> findbydeptno(Integer deptno);//管理員查詢部門請假
	void updateverify (LeaveBean lb);//管理員修改審核欄位
	
}

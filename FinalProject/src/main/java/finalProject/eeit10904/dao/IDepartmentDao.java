package finalProject.eeit10904.dao;

import java.util.List;

import finalProject.eeit10904.model.DepartmentBean;

public interface IDepartmentDao {
	Integer add(DepartmentBean dep);			//新增部門
	DepartmentBean update(DepartmentBean dep);	//更新部門
	boolean delete(Integer depno);				//刪除部門
	DepartmentBean findByNo(Integer depno);		//找單一部門
	List<DepartmentBean> findAll();				//找全部部門
}
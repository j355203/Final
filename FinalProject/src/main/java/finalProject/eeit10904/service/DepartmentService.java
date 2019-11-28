package finalProject.eeit10904.service;

import java.util.List;

import finalProject.eeit10904.model.DepartmentBean;

public interface DepartmentService {
	Integer add(DepartmentBean dep);
	DepartmentBean update(DepartmentBean dep);
	boolean delete(Integer depno);
	DepartmentBean findByNo(Integer depno);
	List<DepartmentBean> findAll();
	
}

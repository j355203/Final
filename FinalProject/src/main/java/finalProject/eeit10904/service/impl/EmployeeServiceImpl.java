package finalProject.eeit10904.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10904.dao.IEmployeeDao;
import finalProject.eeit10904.model.DepartmentBean;
import finalProject.eeit10904.model.EmployeeBean;
import finalProject.eeit10904.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	IEmployeeDao dao;
	
	@Autowired
	public void setDao(IEmployeeDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public boolean verify(EmployeeBean emp) {
		return dao.verify(emp);
	}
	
	@Transactional
	@Override
	public Integer add(EmployeeBean emp) {
		return dao.add(emp);
	}

	@Transactional
	@Override
	public EmployeeBean update(EmployeeBean emp) {
		return dao.update(emp);
	}

	@Transactional
	@Override
	public boolean updatepassword(EmployeeBean emp) {
		return dao.updatepassword(emp);
	}

	@Transactional
	@Override
	public EmployeeBean leave(Integer empid) {
		return dao.leave(empid);
	}

	@Transactional
	@Override
	public EmployeeBean repatriation(Integer empid) {
		return dao.repatriation(empid);
	}

	@Transactional
	@Override
	public EmployeeBean findById(Integer empid) {
		return dao.findById(empid);
	}

	@Transactional
	@Override
	public List<EmployeeBean> findAll() {
		return dao.findAll();
	}

	@Transactional
	@Override
	public List<EmployeeBean> findLeaves() {
		return dao.findLeaves();
	}

	@Transactional
	@Override
	public DepartmentBean getDepByNo(Integer depno) {
		return dao.getDepByNo(depno);
	}

	@Transactional
	@Override
	public byte[] exportUsersToCsv(List<EmployeeBean> emps) {
		return dao.exportUsersToCsv(emps);
	}


}

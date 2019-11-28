package finalProject.eeit10904.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10904.dao.IDepartmentDao;
import finalProject.eeit10904.model.DepartmentBean;
import finalProject.eeit10904.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	IDepartmentDao dao;
	
	@Autowired
	public void setDao(IDepartmentDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public Integer add(DepartmentBean dep) {
		return dao.add(dep);
	}

	@Transactional
	@Override
	public DepartmentBean update(DepartmentBean dep) {
		return dao.update(dep);
	}

	@Transactional
	@Override
	public boolean delete(Integer depno) {
		return dao.delete(depno);
	}

	@Transactional
	@Override
	public DepartmentBean findByNo(Integer depno) {
		return dao.findByNo(depno);
	}

	@Transactional
	@Override
	public List<DepartmentBean> findAll() {
		return dao.findAll();
	}

}

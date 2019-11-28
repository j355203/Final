package finalProject.eeit10930.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10930.dao.LeaveDao;
import finalProject.eeit10930.model.LeaveBean;
import finalProject.eeit10930.service.LeaveService;

@Transactional
@Service
public class LeaveServiceImpl implements LeaveService {

	LeaveDao leaveDao;
	@Autowired
	public void setLeaveDao(LeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}

	@Override
	public void addleave(LeaveBean lb) {
		leaveDao.addleave(lb);
	}

	@Override
	public List<LeaveBean> queryleave(Integer empid) {
		return leaveDao.queryleave(empid);
	}

	@Override
	public LeaveBean updateleave(LeaveBean lb) {
		return leaveDao.updateleave(lb);
	}

	@Override
	public void deleteleave(Integer leaveid) {
		leaveDao.deleteleave(leaveid);

	}

	@Override
	public LeaveBean findbyleaveId(Integer leaveid) {
		
		return leaveDao.findbyleaveId(leaveid);
	}

	@Override
	public List<LeaveBean> findbydeptno(Integer deptno) {
		return leaveDao.findbydeptno(deptno);
	}

	@Override
	public void updateverify(LeaveBean lb) {
		this.leaveDao.updateverify(lb);
	}

}

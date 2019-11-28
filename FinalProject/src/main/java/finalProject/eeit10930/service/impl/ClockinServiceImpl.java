package finalProject.eeit10930.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finalProject.eeit10930.dao.ClockinDao;
import finalProject.eeit10930.model.ClockinBean;
import finalProject.eeit10930.service.ClockinService;

@Service
public class ClockinServiceImpl implements ClockinService{

	ClockinDao clockinDao;
	@Autowired
	public void setClockinDao(ClockinDao clockinDao) {
		this.clockinDao = clockinDao;
	}
	
	@Transactional
	@Override
	public void addclockin(ClockinBean cb) {
		clockinDao.addclockin(cb);
	}

	@Transactional
	@Override
	public void updateclockout(ClockinBean cb) {
		clockinDao.updateclockout(cb);
	}

	@Transactional
	@Override
	public List<ClockinBean> selectclockin(Integer empid) {
		return clockinDao.selectclockin(empid);
	}
	@Transactional
	@Override
	public ClockinBean findbyempid(Integer empid) {
		return clockinDao.findbyempid(empid);
	}
	@Transactional
	@Override
	public ClockinBean findbyclockinid(Integer clockinid) {
		return clockinDao.findbyclockinid(clockinid);
	}
	@Transactional
	@Override
	public List<ClockinBean> findbydepno(Integer depno) {
		return clockinDao.findbydepno(depno);
	}
	@Transactional
	@Override
	public ClockinBean updateovertime(ClockinBean cb) {
		return clockinDao.updateovertime(cb);
	}
	@Transactional
	@Override
	public void updateverify(ClockinBean cb) {
		this.clockinDao.updateverify(cb);
		
	}

}

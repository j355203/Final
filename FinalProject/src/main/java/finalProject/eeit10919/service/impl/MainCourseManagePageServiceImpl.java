package finalProject.eeit10919.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10919.dao.MainCourseManagePageDao;
import finalProject.eeit10919.model.MainCourseBean;
import finalProject.eeit10919.model.PageFormat;
import finalProject.eeit10919.service.MainCourseManagePageService;

@Service
@Transactional
public class MainCourseManagePageServiceImpl implements MainCourseManagePageService {

	MainCourseManagePageDao mainCourseManagePageDao;
	
	@Autowired
	public void setMainCourseManagePageDao(MainCourseManagePageDao mainCourseManagePageDao) {
		this.mainCourseManagePageDao = mainCourseManagePageDao;
	}

	@Override
	public int getMainCourseNumberByStoreId(int id) {
		return mainCourseManagePageDao.getMainCourseNumberByStoreId(id);
	}

	@Override
	public List<Integer> getMainCourseIdByStoreId(int id) {
		return mainCourseManagePageDao.getMainCourseIdByStoreId(id);
	}

	@Override
	public List<MainCourseBean> getAllMainCourseByStoreIdAndPage(int id, PageFormat pageInfo) {
		return mainCourseManagePageDao.getAllMainCourseByStoreIdAndPage(id, pageInfo);
	}

	@Override
	public void addMainCourse(MainCourseBean mainCourse) {
		mainCourseManagePageDao.addMainCourse(mainCourse);
		
	}

	@Override
	public void updateMainCourse(MainCourseBean mainCourse) {
		mainCourseManagePageDao.updateMainCourse(mainCourse);		
	}

	@Override
	public List<MainCourseBean> getMainCourseByProductId(int id) {
		return mainCourseManagePageDao.getMainCourseByProductId(id);
	}

}

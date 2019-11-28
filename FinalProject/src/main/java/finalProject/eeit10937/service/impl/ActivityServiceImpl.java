 package finalProject.eeit10937.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10937.dao.activityDao;
import finalProject.eeit10937.model.activityBean;
import finalProject.eeit10937.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService{
	activityDao dao;
	
	@Autowired
	public void setDao(activityDao dao) {
	    this.dao=dao;
	}
	@Transactional
	@Override
	public List<activityBean> getAllActivity(){
		return dao.getAllActivity();
	}
	@Transactional
	@Override
	public activityBean getActivityById(int activityId) {
		return dao.getActivityById(activityId);
	}
	
	
	@Transactional
	@Override
	public void updateAllActivityStatus() {
		List<activityBean> allActivity = dao.getAllActivity();
		for(activityBean ab : allActivity) {
			if(ab.getActivityStatus()!=null && ab.getActivityStatus() < 3) {
				dao.updateActivityStatus(ab.getActivityId(), ab.getActivityStatus()+3);
			}
		}
	}
	@Transactional
	@Override
	public void addActivity(activityBean activity) {
		dao.addActivity(activity);
	}
	@Transactional
	@Override
	public void updateActivity(activityBean bean) {
		dao.updateActivity(bean);
	}
	@Transactional
	@Override
	public List<activityBean> getUserActivity() {
		return dao.getUserActivity();
	}
	
	@Transactional
	@Override
	public void updateActivityNoImage(activityBean bean) {
		dao.updateActivityNoImage(bean);
	}
	
	
	
}

package finalProject.eeit10937.service;

import java.util.List;

import finalProject.eeit10937.model.activityBean;


public interface ActivityService {
	List<activityBean> getAllActivity();
	
	void updateAllActivityStatus();
	
	public activityBean getActivityById(int activityId);
	
	void addActivity (activityBean activity);
	
	void updateActivity(activityBean bean); 
	
	 List<activityBean> getUserActivity();
	 
	 public void updateActivityNoImage(activityBean bean);
}

package finalProject.eeit10937.dao;

import java.util.List;

import finalProject.eeit10937.model.activityBean;

public interface activityDao {
	 List<activityBean> getAllActivity();
	 
	 void updateActivityStatus(int activityId,int newQuantity);
	 
	 public activityBean getActivityById(int activityId);
	 
	 void addActivity (activityBean activity);
	 
	 void updateActivity(activityBean bean);
	 
	 List<activityBean> getUserActivity();
	 
	 public void updateActivityNoImage(activityBean bean);
}

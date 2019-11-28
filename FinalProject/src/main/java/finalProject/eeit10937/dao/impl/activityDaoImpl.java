package finalProject.eeit10937.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalProject.eeit10937.dao.activityDao;
import finalProject.eeit10937.model.activityBean;

@Repository
public class activityDaoImpl implements activityDao {
	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<activityBean> getAllActivity() {
		String hql = "FROM activityBean";
		Session session = null;
		List<activityBean> list = new ArrayList<>();
		session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void updateActivityStatus(int activityId, int newQuantity) {
		String hql = "UPDATE activityBean SET stock= :newQuantity WHERE activityId=:id";
		Session session = factory.getCurrentSession();

		int n = session.createQuery(hql).setParameter("newQuantity", newQuantity).setParameter("id", activityId)
				.executeUpdate();
	}

	@Override
	public activityBean getActivityById(int activityId) {
		Session session = factory.getCurrentSession();
		activityBean ab = session.get(activityBean.class, activityId);
		return ab;
	}

	@Override
	public void addActivity(activityBean activity) {
		Session session = factory.getCurrentSession();
		session.save(activity);
	}

	@Override
	public void updateActivity(activityBean bean) {
		Session session = factory.getCurrentSession();
		session.update(bean);
	}
	
	@Override
	public void updateActivityNoImage(activityBean bean) {
		String hql = "from activityBean where activityId = ?0";
		Session session = factory.getCurrentSession();
		activityBean result = session.createQuery(hql, activityBean.class)
			.setParameter(0, bean.getActivityId())
			.uniqueResult();
		result.setActivityAddress(bean.getActivityAddress());
		result.setActivityStatus(bean.getActivityStatus());
		result.setActivityTime(bean.getActivityTime());
		result.setContent(bean.getContent());
		result.setTitle(bean.getTitle());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<activityBean> getUserActivity() {
		String hql = "FROM activityBean where activityStatus=1";
		Session session=null;
		List <activityBean> list=new ArrayList<>();
		session = factory.getCurrentSession();
		list= session.createQuery(hql).getResultList();
		return list;
	}
}

package finalProject.eeit10919.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalProject.eeit10919.dao.MainCourseManagePageDao;
import finalProject.eeit10919.model.MainCourseBean;
import finalProject.eeit10919.model.PageFormat;

@Repository
public class MainCourseManagePageDaoImpl implements MainCourseManagePageDao {

	SessionFactory factory;

	@Autowired
	public void setSessionFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public int getMainCourseNumberByStoreId(int id) {
		String hql = "SELECT count(*) FROM MainCourseBean WHERE storeBean.storeId = :id";
		Session session = factory.getCurrentSession();
		int count = Math.toIntExact((long) session.createQuery(hql).setParameter("id", id).uniqueResult());
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getMainCourseIdByStoreId(int id) {
		String hql = "SELECT productId FROM MainCourseBean WHERE storeBean.storeId = :id";
		List<Integer> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("id", id).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MainCourseBean> getAllMainCourseByStoreIdAndPage(int id, PageFormat pageInfo) {
		String hql = "FROM MainCourseBean WHERE storeBean.storeId = :id AND productId >= :startRec";
		List<MainCourseBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql)
				.setParameter("id", id)
				.setParameter("startRec", pageInfo.getStartRec())
				.setMaxResults(pageInfo.getRecPerPage()).list();
		return list;
	}

	@Override
	public void addMainCourse(MainCourseBean mainCourse) {
		Session session = factory.getCurrentSession();
		session.save(mainCourse);
	}

	@Override
	public void updateMainCourse(MainCourseBean mainCourse) {
		Session session = factory.getCurrentSession();
		session.update(mainCourse);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MainCourseBean> getMainCourseByProductId(int id) {
		String hql = "FROM MainCourseBean WHERE productId = :id";
		List<MainCourseBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("id", id).getResultList();
		return list;
	}

}

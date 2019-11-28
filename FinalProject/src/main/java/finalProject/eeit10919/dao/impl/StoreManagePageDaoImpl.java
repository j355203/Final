package finalProject.eeit10919.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalProject.eeit10919.dao.StoreManagePageDao;
import finalProject.eeit10919.model.PageFormat;
import finalProject.eeit10919.model.StoreBean;

@Repository
public class StoreManagePageDaoImpl implements StoreManagePageDao {
	
	SessionFactory factory;

	@Autowired
	public void setSessionFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StoreBean> getAllStoreDataByPage(PageFormat page) {
		String hql = "FROM StoreBean";
		List<StoreBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setMaxResults(page.getRecPerPage()).list();
		return list;
	}
	
	@Override
	public int getAllStoreNumber() {
		String hql = "SELECT count(*) FROM StoreBean";
		Session session = factory.getCurrentSession();
		int count = Math.toIntExact((long) session.createQuery(hql).uniqueResult());
		return count;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getAllStoreId() {
		String hql = "SELECT storeId FROM StoreBean";
		List<Integer> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public void addStore(StoreBean store) {
		Session session = factory.getCurrentSession();
		session.save(store);
	}

	@Override
	public void updateStoreData(StoreBean store) {
		Session session = factory.getCurrentSession();
		session.update(store);
	}

}

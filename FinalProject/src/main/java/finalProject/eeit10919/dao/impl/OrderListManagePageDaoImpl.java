package finalProject.eeit10919.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalProject.eeit10919.dao.OrderListManagePageDao;
import finalProject.eeit10919.model.OrderMainBean;

@Repository
public class OrderListManagePageDaoImpl implements OrderListManagePageDao {

	SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<OrderMainBean> getAllTodayOrder(String date) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM OrderMainBean WHERE enterTime LIKE :date";
		List<OrderMainBean> result = session.createQuery(hql).setParameter("date", "%" + date + "%").getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderMainBean> getOrderMainByOrderId(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM OrderMainBean WHERE orderId = :id";
		List<OrderMainBean> targetOrder = session.createQuery(hql).setParameter("id", id).getResultList();
		return targetOrder;
	}


	@Override
	public void updateOrderStatus(OrderMainBean orderMainBean) {
		Session session = sessionFactory.getCurrentSession();
		session.update(orderMainBean);
	}


	@Override
	public void updateOrderListStatus(int status, int id) {
		String hql="update OrderListBean set status = :status where id = :id";
		Session session = sessionFactory.getCurrentSession();
		session.createQuery(hql).
				setParameter("status", status).
				setParameter("id", id).executeUpdate();
	}

}

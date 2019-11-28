package finalProject.eeit10919.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalProject.eeit10919.dao.OrderListPageDao;
import finalProject.eeit10919.model.OrderMainBean;
import finalProject.eeit10919.model.PageFormat;

@Repository
public class OrderListPageDaoImpl implements OrderListPageDao {

	SessionFactory factory;
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	//根據員工ID取得對應的訂單資料
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderMainBean> getOrderByEmpId(int id) {
		String hql = "FROM OrderMainBean WHERE empid = :id";
		List<OrderMainBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("id", id).getResultList();
		return list;
	}
	
	//取得對應員工的訂單總比數
	@Override
	public int getAllOrderNumber(int empId) {
		String hql = "SELECT count(*) FROM OrderMainBean WHERE employeeBean.empid = :empId";
		Session session = factory.getCurrentSession();
		int count = Math.toIntExact((long) session.createQuery(hql).setParameter("empId", empId).uniqueResult());
		return count;
	}
	
	//取得目標員工在特定日期的訂單總數
	@Override
	public int getOrderNumberByDate(String date, int empId) {
		String hql = "SELECT count(*) FROM OrderMainBean WHERE employeeBean.empid = :empId AND updateTime LIKE :date";
		Session session = factory.getCurrentSession();
		int count = Math.toIntExact((long) session.createQuery(hql).setParameter("empId", empId).setParameter("date", "%" + date + "%").uniqueResult());
		return count;
	}
	
	//取得目標員工對應特定店家的訂單總數
	@Override
	public int getOrderNumberByStoreName(String storeName, int empId) {
		String hql = "SELECT count(*) FROM OrderMainBean WHERE employeeBean.empid = :empId AND storeBean.storeName LIKE :storeName";
		Session session = factory.getCurrentSession();
		int count = Math.toIntExact((long) session.createQuery(hql).setParameter("empId", empId).setParameter("storeName", "%" + storeName + "%").uniqueResult());
		return count;
	}
	
	//取得目標員工的所有訂單ID
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getAllOrderId(int id) {
		String hql = "SELECT orderId FROM OrderMainBean WHERE empid = :id";
		List<Integer> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("id", id).getResultList();
		return list;
	}
	
	//取得目標員工在特定日期的所有訂單的ID
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getOrderIdByDate(int empId, String date) {
		String hql = "SELECT orderId FROM OrderMainBean WHERE empid = :id AND enterTime LIKE :date";
		List<Integer> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("id", empId).setParameter("date", "%" + date + "%").getResultList();
		return list;
	}
	
	//取得目標員工在特定店家的所有訂單ID
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getOrderIdByStoreName(String storeName, int empId) {
		String hql = "SELECT orderId FROM OrderMainBean WHERE empid = :id AND storeBean.storeName LIKE :storeName";
		List<Integer> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("id", empId).setParameter("storeName", "%" + storeName + "%").getResultList();
		return list;
	}
	
	//根據換頁資料取得目標員工對應的所有訂單(利用換頁資料中的開始資料和每頁最大筆數資料取得對應的訂單資料)
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderMainBean> getAllOrderByPage(int id, PageFormat pageData) {
		String hql = "FROM OrderMainBean WHERE empid = :id AND orderId >= :startRec";
		List<OrderMainBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql)
				.setParameter("id", id)
				.setParameter("startRec", pageData.getStartRec())
				.setMaxResults(pageData.getRecPerPage()).list();
		return list;
	}

	//根據換頁資料取得目標員工對應日期的所有訂單
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderMainBean> getOrderByPageAndDate(int id, PageFormat pageData, String date) {
		String hql = "FROM OrderMainBean WHERE empid = :id AND enterTime LIKE :date AND orderId >= :startRec";
		List<OrderMainBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql)
				.setParameter("id", id)
				.setParameter("date", "%" + date + "%")
				.setParameter("startRec", pageData.getStartRec())
				.setMaxResults(pageData.getRecPerPage()).list();
		return list;
	}

	//根據換頁資料取得目標員工對應店家名稱的所有訂單
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderMainBean> getOrderByPageAndStoreId(int id, PageFormat pageData, int storeId) {
		String hql = "FROM OrderMainBean WHERE empid = :id AND storeId = :storeId AND orderId >= :startRec";
		List<OrderMainBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql)
				.setParameter("id", id)
				.setParameter("storeId", storeId)
				.setParameter("startRec", pageData.getStartRec())
				.setMaxResults(pageData.getRecPerPage()).list();
		return list;
	}

	
}

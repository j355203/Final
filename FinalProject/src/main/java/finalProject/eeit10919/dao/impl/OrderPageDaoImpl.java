package finalProject.eeit10919.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalProject.eeit10919.dao.OrderPageDao;
import finalProject.eeit10919.model.MainCourseBean;
import finalProject.eeit10919.model.OrderListBean;
import finalProject.eeit10919.model.OrderMainBean;
import finalProject.eeit10919.model.StoreBean;
import finalProject.eeit10919.model.WeekStoreBean;

@Repository
public class OrderPageDaoImpl implements OrderPageDao {

	SessionFactory factory;
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	//在品項表單利用店家ID查詢對應品項
	@SuppressWarnings("unchecked")
	@Override
	public List<MainCourseBean> getStoreById(int id) {
		String hql = "FROM MainCourseBean mcb WHERE mcb.storeBean.storeId = :storeid";
		List<MainCourseBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("storeid", id).getResultList();
		return list;
	}

	//在商店表單用商店ID查詢商店相關資訊
	@SuppressWarnings("unchecked")
	@Override
	public List<StoreBean> getStoreDataById(int id) {
		String hql = "FROM StoreBean WHERE storeId = :storeid";
		List<StoreBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("storeid", id).getResultList();
		return list;
	}
	
	//用店家名稱在店家表單進行模糊查詢(此功能實際上是在OrderListPage中使用)
	@SuppressWarnings("unchecked")
	@Override
	public List<StoreBean> getStoreDataByName(String name) {
		String hql = "FROM StoreBean WHERE storeName LIKE :storeName";
		List<StoreBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("storeName", "%" + name + "%").getResultList();
		return list;
	}
	
	//從每周店家表中查詢對應日期的店家
	@SuppressWarnings("unchecked")
	@Override
	public List<WeekStoreBean> getStoreIdByDate(String date) {
		String hql = "FROM WeekStoreBean WHERE bookDate LIKE :date";
		List<WeekStoreBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("date", date).getResultList();
		return list;
	}

	//新增訂單到訂單資料主表
	@Override
	public void addOrder(OrderMainBean order) {
		Session session = factory.getCurrentSession();
		session.save(order);
	}

	//用商品ID取得對應商品
	@Override
	public MainCourseBean getProductById(int id) {
		Session session = factory.getCurrentSession();
		return session.get(MainCourseBean.class, id);
	}

	//用日期查詢訂單主表的訂單資料(這個也是OrderListPage用的功能)
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderMainBean> getOrderByDate(String date, int empId) {
		String hql = "FROM OrderMainBean WHERE cast(updateTime as string) LIKE :date AND employeeBean.empid = :empId";
		List<OrderMainBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("date", "%" + date + "%").setParameter("empId", empId).getResultList();
		return list;
	}
	
	//用更新時間查詢訂單明細表資料
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderListBean> getOrderListByDate(String date) {
		String hql = "FROM OrderListBean WHERE updateTime LIKE :date";
		List<OrderListBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("date", "%" + date + "%").getResultList();
		return list;
	}

	//新增訂單到訂單主表
	@Override
	public void addOrderList(OrderListBean orderListItem) {
		Session session = factory.getCurrentSession();
		session.save(orderListItem);	
	}

	//更新訂單到訂單主表
	@Override
	public void updateOrder(OrderMainBean order) {
		Session session = factory.getCurrentSession();
		session.update(order);
	}

	//更新訂單明細資料到訂單明細表
	@Override
	public void updateOrderList(OrderListBean orderListItem) {
		Session session = factory.getCurrentSession();
		session.update(orderListItem);		
	}

	//根據訂單ID取得訂單明細對應資料
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderListBean> getOrderListByOrderId(int orderId) {
		String hql = "FROM OrderListBean WHERE OrderMainBean.orderId = :orderId";
		List<OrderListBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).setParameter("orderId", orderId).getResultList();
		return list;
	}

}

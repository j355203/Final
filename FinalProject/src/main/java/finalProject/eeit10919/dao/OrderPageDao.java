package finalProject.eeit10919.dao;

import java.util.List;

import finalProject.eeit10919.model.MainCourseBean;
import finalProject.eeit10919.model.OrderListBean;
import finalProject.eeit10919.model.OrderMainBean;
import finalProject.eeit10919.model.StoreBean;
import finalProject.eeit10919.model.WeekStoreBean;

public interface OrderPageDao {
	public List<MainCourseBean> getStoreById(int id);
	public List<StoreBean> getStoreDataById(int id);
	public List<StoreBean> getStoreDataByName(String name);
	public List<WeekStoreBean> getStoreIdByDate(String date);
	public void addOrder(OrderMainBean order);
	public MainCourseBean getProductById(int id);
	public List<OrderMainBean> getOrderByDate(String date, int empId);
	public List<OrderListBean> getOrderListByDate(String date);
	public void addOrderList(OrderListBean orderListItem);
	public void updateOrder(OrderMainBean order);
	public void updateOrderList(OrderListBean orderListItem);
	public List<OrderListBean> getOrderListByOrderId(int orderId);
}

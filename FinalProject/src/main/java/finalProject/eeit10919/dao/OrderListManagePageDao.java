package finalProject.eeit10919.dao;

import java.util.List;

import finalProject.eeit10919.model.OrderMainBean;

public interface OrderListManagePageDao {
	public List<OrderMainBean> getAllTodayOrder(String date);
	public List<OrderMainBean> getOrderMainByOrderId(int id);
	public void updateOrderStatus(OrderMainBean orderMainBean);
	public void updateOrderListStatus(int status, int id);
}

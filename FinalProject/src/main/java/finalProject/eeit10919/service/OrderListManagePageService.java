package finalProject.eeit10919.service;

import java.util.List;

import finalProject.eeit10919.model.OrderMainBean;

public interface OrderListManagePageService {
	public List<OrderMainBean> getAllTodayOrder();
	public List<OrderMainBean> getOrderMainByOrderId(int id);
	public void updateOrderStatus(OrderMainBean orderMainBean);
	public void updateOrderListStatus(int status, int id);
}

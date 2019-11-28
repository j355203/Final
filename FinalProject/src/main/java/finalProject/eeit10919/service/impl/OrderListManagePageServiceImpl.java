package finalProject.eeit10919.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10919.dao.OrderListManagePageDao;
import finalProject.eeit10919.model.OrderMainBean;
import finalProject.eeit10919.service.OrderListManagePageService;

@Service
@Transactional
public class OrderListManagePageServiceImpl implements OrderListManagePageService {

	OrderListManagePageDao orderListManagePageDao; 
	
	@Autowired
	public void setOrderListManagePageDao(OrderListManagePageDao orderListManagePageDao) {
		this.orderListManagePageDao = orderListManagePageDao;
	}


	@Override
	public List<OrderMainBean> getAllTodayOrder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		return orderListManagePageDao.getAllTodayOrder(today);
	}
	
	@Override
	public List<OrderMainBean> getOrderMainByOrderId(int id) {
		return orderListManagePageDao.getOrderMainByOrderId(id);
	}


	@Override
	public void updateOrderStatus(OrderMainBean orderMainBean) {
		orderListManagePageDao.updateOrderStatus(orderMainBean);		
	}


	@Override
	public void updateOrderListStatus(int status, int id) {
		orderListManagePageDao.updateOrderListStatus(status, id);
	}

}

package finalProject.eeit10919.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10919.dao.OrderListPageDao;
import finalProject.eeit10919.dao.OrderPageDao;
import finalProject.eeit10919.model.OrderMainBean;
import finalProject.eeit10919.model.PageFormat;
import finalProject.eeit10919.service.OrderListPageService;

@Service
public class OrderListPageServiceImpl implements OrderListPageService {

	OrderListPageDao orderListPageDao;

	@Autowired
	public void setOrderListPageDao(OrderListPageDao orderListPageDao) {
		this.orderListPageDao = orderListPageDao;
	}

	OrderPageDao orderPageDao;

	@Autowired
	public void setOrderPageDao(OrderPageDao orderPageDao) {
		this.orderPageDao = orderPageDao;
	}

	@Transactional
	@Override
	public List<OrderMainBean> getOrderByEmpId(int id) {
		List<OrderMainBean> orderList = orderListPageDao.getOrderByEmpId(id);
		return orderList;
	}

	@Transactional
	@Override
	public int totalRecCount(int empId, String text, int type) {
		int totalRec = 0;
		switch (type) {
		case 1:
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(new Date());
			totalRec = orderListPageDao.getOrderNumberByDate(date, empId);
			break;
		case 2:
			totalRec = orderListPageDao.getAllOrderNumber(empId);
			break;
		case 3:
			totalRec = orderListPageDao.getOrderNumberByStoreName(text, empId);
			break;
		}
		return totalRec;
	}

	@Transactional
	@Override
	public List<Integer> getIdList(int empId, String text, int type) {
		List<Integer> idList = new ArrayList<Integer>();
		switch (type) {
		case 1:
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(new Date());
			idList = orderListPageDao.getOrderIdByDate(empId, date);
			break;
		case 2:
			idList = orderListPageDao.getAllOrderId(empId);
			break;
		case 3:
			idList = orderListPageDao.getOrderIdByStoreName(text, empId);
			break;
		}
		return idList;
	}

	@Override
	public PageFormat pageDataWraper(int totalRec, int currentPage, int recPerPage, List<Integer> idList) {
		PageFormat pageData = new PageFormat();
		pageData.setCurrentPage(currentPage);
		pageData.setTotalPage((int) Math.ceil((float) totalRec / recPerPage));
		pageData.setRecPerPage(recPerPage);
		if(totalRec != 0) {
			pageData.setStartRec(idList.get(0 + (recPerPage * (currentPage - 1))));
			if ((totalRec - recPerPage * (currentPage - 1)) > recPerPage) {
				pageData.setEndRec(idList.get(currentPage * recPerPage - 1));
			} else {
				pageData.setEndRec(idList.get(totalRec - 1));
			}
		}else {
			pageData.setStartRec(0);
			pageData.setEndRec(0);
		}
		System.out.println(pageData);
		return pageData;
	}

	@Transactional
	@Override
	public List<OrderMainBean> getOrderByPage(int id, String text, PageFormat pageData, int type) {
		List<OrderMainBean> todayOrderData = new ArrayList<OrderMainBean>();
		if(pageData.getEndRec() != 0) {
			switch (type) {
			case 1:
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = sdf.format(new Date());
				todayOrderData = orderListPageDao.getOrderByPageAndDate(id, pageData, date);
				break;
			case 2:
				todayOrderData = orderListPageDao.getAllOrderByPage(id, pageData);
				break;
			case 3:
				int targetStoreId = orderPageDao.getStoreDataByName(text).get(0).getStoreId();
				todayOrderData = orderListPageDao.getOrderByPageAndStoreId(id, pageData, targetStoreId);
				break;
			}
		}		
		return todayOrderData;
	}

}

package finalProject.eeit10919.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10904.model.EmployeeBean;
import finalProject.eeit10919.dao.OrderPageDao;
import finalProject.eeit10919.model.MainCourseBean;
import finalProject.eeit10919.model.OrderListBean;
import finalProject.eeit10919.model.OrderMainBean;
import finalProject.eeit10919.model.StoreBean;
import finalProject.eeit10919.model.WeekStoreBean;
import finalProject.eeit10919.service.OrderPageService;

@Service
public class OrderPageServiceImpl implements OrderPageService {

	OrderPageDao orderPageDao;

	@Autowired
	public void setDao(OrderPageDao orderPageDao) {
		this.orderPageDao = orderPageDao;
	}

	// 第一版測試取得店家資訊用(暫時不會再使用)
	@Transactional
	@Override
	public List<MainCourseBean> getStoreById(int id) {
		return orderPageDao.getStoreById(id);
	}

	// 依照日期當作隨機種子產出當日店家對應的品項
	private Set<MainCourseBean> getProductLoc(Set<MainCourseBean> storeProducts) {
		int productNum = storeProducts.size();
		Iterator<MainCourseBean> value = storeProducts.iterator();
		ArrayList<MainCourseBean> productList = new ArrayList<MainCourseBean>();
		while (value.hasNext()) {
			productList.add(value.next());
		}
		Set<MainCourseBean> selectProduct = new LinkedHashSet<>();
		int[] nums = new int[3];
		Random r = new Random();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		long s = Integer.parseInt(sdf.format(new Date()));
		r.setSeed(s);
		for (int i = 0; i < 3; i++) {
			nums[i] = r.nextInt(productNum);
			for (int j = 0; j < i;) {
				if (nums[j] == nums[i]) {
					nums[i] = r.nextInt(productNum);
					j = 0;
				} else {
					j++;
				}
			}
			System.out.println("i : " + nums[i]);
			selectProduct.add(productList.get(nums[i]));
		}
		Iterator<MainCourseBean> value2 = selectProduct.iterator();
		while (value2.hasNext()) {
			System.out.println("value2 : " + value2.next().getProductName());
		}
		return selectProduct;
	}

	// 根據id取得店家資料
	@Transactional
	@Override
	public List<StoreBean> getStoreDataById(int id) {
		List<StoreBean> storeData = orderPageDao.getStoreDataById(id);
		Set<MainCourseBean> products = getProductLoc(storeData.get(0).getMainCourse());
		storeData.get(0).setMainCourse(products);
		return storeData;
	}
	
	@Override
	public List<StoreBean> getStoreDataByIdWithOutRandom(int id) {		
		return orderPageDao.getStoreDataById(id);
	}

	// 根據日期取得店家的id
	@Transactional
	@Override
	public List<WeekStoreBean> getStoreIdByDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String targetDate = sdf.format(date);
		return orderPageDao.getStoreIdByDate(targetDate);
	}
	
	

	// 新增訂單到訂單主表
	private OrderMainBean createOrder(String orderDateTime, String orderNameDate, EmployeeBean emp, int orderNumber,
			StoreBean store) {
		OrderMainBean order = new OrderMainBean();
		order.setOrderName("Trv" + emp.getEmpid() + orderNameDate + "_" + (orderNumber + 1));
		order.setEmployeeBean(emp);
		order.setStoreBean(store);
		order.setEnterTime(orderDateTime);
		order.setUpdateTime(orderDateTime);
		return order;
	}

	// 新增物品到訂單明細
	private void addItemData(String orderDateTime, OrderMainBean order, List<MainCourseBean> cartList) {
		int total = 0;
		for (MainCourseBean item : cartList) {
			OrderListBean orderItem = new OrderListBean();
			orderItem.setOrderMainBean(order);
			orderItem.setMainCourse(item);
			orderItem.setAmount(item.getAmount());
			orderItem.setEnterTime(orderDateTime);
			orderItem.setUpdateTime(orderDateTime);
			orderItem.setStatus(0);
			total = total + (item.getAmount() * item.getPrice());
			orderPageDao.addOrderList(orderItem);
		}
		order.setTotalPrice(total);
		orderPageDao.updateOrder(order);
	}

	// 更新未付款訂單內容(廢棄)
//	private void updateOrderList(String orderDate, String orderDateTime, OrderMainBean order,
//			List<MainCourseBean> cartList) {
//		List<OrderListBean> preOrders = orderPageDao.getOrderListByDate(orderDate);
//		String name;
//		for (MainCourseBean cartItem : cartList) {
//			name = cartItem.getProductName();
//			for (OrderListBean preOrder : preOrders) {
//				if (name.equals(preOrder.getMainCourse().getProductName())) {
//					preOrder.setStatus(1);
//					orderPageDao.updateOrderList(preOrder);
//				}
//			}
//			addItemData(orderDateTime, order, cartList);
//		}
//	}

	@Transactional
	@Override
	public void addOrUpdateOrder(Date date, EmployeeBean emp, List<MainCourseBean> cartList, List<StoreBean> store) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
		String orderDateTime = sdf1.format(date);
		String orderDate = sdf2.format(date);
		String orderNameDate = sdf3.format(date);
		System.out.println(cartList.get(0).getStoreBean());
		List<OrderMainBean> orders = orderPageDao.getOrderByDate(orderDate, emp.getEmpid());
		OrderMainBean newOrder = createOrder(orderDateTime, orderNameDate, emp, orders.size(), store.get(0));
		orderPageDao.addOrder(newOrder);
		addItemData(orderDateTime, newOrder, cartList);
	}

}

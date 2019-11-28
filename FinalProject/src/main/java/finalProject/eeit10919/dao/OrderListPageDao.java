package finalProject.eeit10919.dao;

import java.util.List;

import finalProject.eeit10919.model.OrderMainBean;
import finalProject.eeit10919.model.PageFormat;

public interface OrderListPageDao {
	public List<OrderMainBean> getOrderByEmpId(int id);
	public int getAllOrderNumber(int empId);
	public int getOrderNumberByDate(String date, int empId);
	public int getOrderNumberByStoreName(String storeName, int empId);
	public List<Integer> getAllOrderId(int id);
	public List<Integer> getOrderIdByDate(int id, String date);
	public List<Integer> getOrderIdByStoreName(String storeName, int empId);
	public List<OrderMainBean> getAllOrderByPage(int id, PageFormat pageData);
	public List<OrderMainBean> getOrderByPageAndDate(int id, PageFormat pageData, String date);
	public List<OrderMainBean> getOrderByPageAndStoreId(int id, PageFormat pageData, int storeId);
}

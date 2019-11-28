package finalProject.eeit10919.service;

import java.util.List;

import finalProject.eeit10919.model.OrderMainBean;
import finalProject.eeit10919.model.PageFormat;

public interface OrderListPageService {
	public List<OrderMainBean> getOrderByEmpId(int id);
	public int totalRecCount(int empId, String text, int type);
	public List<Integer> getIdList(int empId, String text, int type);
	public PageFormat pageDataWraper(int totalRec, int currentPage, int recPerPage, List<Integer> idList);
	public List<OrderMainBean> getOrderByPage(int id, String text, PageFormat pageData, int type);
}

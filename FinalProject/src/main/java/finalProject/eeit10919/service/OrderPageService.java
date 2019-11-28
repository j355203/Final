package finalProject.eeit10919.service;

import java.util.Date;
import java.util.List;

import finalProject.eeit10904.model.EmployeeBean;
import finalProject.eeit10919.model.MainCourseBean;
import finalProject.eeit10919.model.StoreBean;
import finalProject.eeit10919.model.WeekStoreBean;

public interface OrderPageService {
	public List<MainCourseBean> getStoreById(int id);
	public List<StoreBean> getStoreDataById(int id);
	public List<StoreBean> getStoreDataByIdWithOutRandom(int id);
	public List<WeekStoreBean> getStoreIdByDate(Date date);
	public void addOrUpdateOrder(Date date, EmployeeBean emp, List<MainCourseBean> cartList, List<StoreBean> store);
}

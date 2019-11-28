package finalProject.eeit10919.dao;

import java.util.List;

import finalProject.eeit10919.model.MainCourseBean;
import finalProject.eeit10919.model.PageFormat;

public interface MainCourseManagePageDao {
	public int getMainCourseNumberByStoreId(int id);
	public List<Integer> getMainCourseIdByStoreId(int id); 
	public List<MainCourseBean> getAllMainCourseByStoreIdAndPage(int id, PageFormat pageInfo);
	public void addMainCourse(MainCourseBean mainCourse);
	public void updateMainCourse(MainCourseBean mainCourse);
	public List<MainCourseBean> getMainCourseByProductId(int id);
}

package finalProject.eeit10919.service;

import java.util.List;

import finalProject.eeit10919.model.MainCourseBean;
import finalProject.eeit10919.model.PageFormat;

public interface MainCourseManagePageService {
	public int getMainCourseNumberByStoreId(int id);
	public List<Integer> getMainCourseIdByStoreId(int id); 
	public List<MainCourseBean> getAllMainCourseByStoreIdAndPage(int id, PageFormat pageInfo);
	public void addMainCourse(MainCourseBean mainCourse);
	public void updateMainCourse(MainCourseBean mainCourse);
	public List<MainCourseBean> getMainCourseByProductId(int id);
}

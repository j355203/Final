package finalProject.eeit10919.dao;

import java.util.List;

import finalProject.eeit10919.model.PageFormat;
import finalProject.eeit10919.model.StoreBean;

public interface StoreManagePageDao {
	public List<StoreBean> getAllStoreDataByPage(PageFormat page);
	public int getAllStoreNumber();
	public List<Integer> getAllStoreId();
	public void addStore(StoreBean store);
	public void updateStoreData(StoreBean store);

}

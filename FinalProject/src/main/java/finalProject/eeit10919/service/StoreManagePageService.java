package finalProject.eeit10919.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import finalProject.eeit10919.model.PageFormat;
import finalProject.eeit10919.model.StoreBean;

public interface StoreManagePageService {
	public List<StoreBean> getAllStoreDataByPage(PageFormat page);
	public int getAllStoreNumber();
	public List<Integer> getAllStoreId();
	public void addStore(StoreBean store);
	public void updateStoreData(StoreBean store);
	public void writeImgToFolder(MultipartFile files, String dirName, String fileName);
}

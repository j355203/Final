package finalProject.eeit10919.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import finalProject.eeit10919.dao.StoreManagePageDao;
import finalProject.eeit10919.model.PageFormat;
import finalProject.eeit10919.model.StoreBean;
import finalProject.eeit10919.service.StoreManagePageService;

@Service
@Transactional
public class StoreManagePageServiceImpl implements StoreManagePageService {

	StoreManagePageDao storeManagePageDao;
	
	@Autowired
	public void setStoreManagePageDao(StoreManagePageDao storeManagePageDao) {
		this.storeManagePageDao = storeManagePageDao;
	}

	@Override
	public List<StoreBean> getAllStoreDataByPage(PageFormat page) {		
		return storeManagePageDao.getAllStoreDataByPage(page);
	}
	
	@Override
	public int getAllStoreNumber() {
		return storeManagePageDao.getAllStoreNumber();
	}

	@Override
	public List<Integer> getAllStoreId() {
		return storeManagePageDao.getAllStoreId();
	}

	@Override
	public void addStore(StoreBean store) {
		storeManagePageDao.addStore(store);
	}

	@Override
	public void updateStoreData(StoreBean store) {
		storeManagePageDao.updateStoreData(store);
	}

	@Override
	public void writeImgToFolder(MultipartFile files, String dirName, String fileName) {
		Path filepath = Paths.get("D:\\SpringMVC\\Img\\eeit10919\\"+ dirName + "\\",  fileName);
		Path path = Paths.get("D:\\SpringMVC\\Img\\eeit10919\\"+ dirName + "\\");
		System.out.println(fileName);
		System.out.println(Files.exists(path));
		if(Files.exists(path)) {
			try (OutputStream os = Files.newOutputStream(filepath)) {
		        os.write(files.getBytes());
		        os.close();
		    } catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			File file =  new File("D:\\SpringMVC\\Img\\eeit10919\\"+ dirName + "\\");
	        file.mkdir();
			try (OutputStream os = Files.newOutputStream(filepath)) {		
				os.write(files.getBytes());
		        os.close();
		    } catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

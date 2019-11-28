package finalProject.eeit10919.model;

import org.springframework.web.multipart.MultipartFile;

public class ImageInfo {
	private MultipartFile imgData;
	private String storeData;

	public MultipartFile getImgData() {
		return imgData;
	}

	public void setImgData(MultipartFile imgData) {
		this.imgData = imgData;
	}

	public String getStoreData() {
		return storeData;
	}

	public void setStoreData(String storeData) {
		this.storeData = storeData;
	}


}

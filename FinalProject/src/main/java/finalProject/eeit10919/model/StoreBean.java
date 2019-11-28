package finalProject.eeit10919.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "store")
public class StoreBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;
	private String storeName;
	private int storeStatus;
	private String storeType;
	private String storeImg;
	private String storeMapLink;
	private int count;
	@Transient
	private String enterdate;
	@JsonIgnoreProperties("storeBean")
	@OneToMany(mappedBy = "storeBean")
	@OrderBy(value = "productId ASC")
	private Set<MainCourseBean> mainCourse = new LinkedHashSet<>();
	
	public StoreBean(int storeId, String storeName, int storeStatus, String storeType, String storeImg, String storeMapLink, int count, String enterdate, Set<MainCourseBean> mainCourse) {
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeStatus = storeStatus;
		this.storeType = storeType;
		this.storeImg = storeImg;
		this.storeMapLink = storeMapLink;
		this.count = count;
		this.enterdate = enterdate;
		this.mainCourse = mainCourse;
	}

	public StoreBean() {

	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(int storeStatus) {
		this.storeStatus = storeStatus;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public String getStoreImg() {
		return storeImg;
	}

	public void setStoreImg(String storeImg) {
		this.storeImg = storeImg;
	}

	public String getStoreMapLink() {
		return storeMapLink;
	}

	public void setStoreMapLink(String storeMapLink) {
		this.storeMapLink = storeMapLink;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getEnterdate() {
		return enterdate;
	}

	public void setEnterdate(String enterdate) {
		this.enterdate = enterdate;
	}

	public Set<MainCourseBean> getMainCourse() {
		return mainCourse;
	}

	public void setMainCourse(Set<MainCourseBean> mainCourse) {
		this.mainCourse = mainCourse;
	}

}

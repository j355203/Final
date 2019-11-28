package finalProject.eeit10919.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "maincourse")
public class MainCourseBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private int productType;
	private String productImg;
	private int price;
	private int productStatus;
	private int count;
	@Transient
	private String enterdate;
	@JsonIgnoreProperties("mainCourse")
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="storeid")
	private StoreBean storeBean;
	
	@Transient
	private int amount;
	@Transient
	private int totalPrice;

	public MainCourseBean(int productId, String productName, int productType, String productImg, int price, int productStatus, int count, String enterdate) {
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
		this.productImg = productImg;
		this.price = price;
		this.productStatus = productStatus;
		this.count = count;
		this.enterdate = enterdate;
	}

	public MainCourseBean() {

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
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
	
	public StoreBean getStoreBean() {
		return storeBean;
	}

	public void setStoreBean(StoreBean storeBean) {
		this.storeBean = storeBean;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	
}

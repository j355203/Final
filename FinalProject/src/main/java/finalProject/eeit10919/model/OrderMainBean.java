package finalProject.eeit10919.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import finalProject.eeit10904.model.EmployeeBean;

@Entity
@Table(name = "ordermain")
public class OrderMainBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private String orderName;
	@ManyToOne
	@JoinColumn(name = "empid")
	private EmployeeBean employeeBean;
	@ManyToOne
	@JoinColumn(name = "storeid")
	private StoreBean storeBean;
	private int totalPrice;
	private int orderStatus;
	private String enterTime;
	private String updateTime;
	@JsonIgnoreProperties("orderMainBean")
	@OneToMany(mappedBy = "orderMainBean")
	@OrderBy(value = "id ASC")
	private Set<OrderListBean> orderItem = new LinkedHashSet<>();
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public EmployeeBean getEmployeeBean() {
		return employeeBean;
	}

	public void setEmployeeBean(EmployeeBean employeeBean) {
		this.employeeBean = employeeBean;
	}
	
	public StoreBean getStoreBean() {
		return storeBean;
	}

	public void setStoreBean(StoreBean storeBean) {
		this.storeBean = storeBean;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(String enterTime) {
		this.enterTime = enterTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Set<OrderListBean> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(Set<OrderListBean> orderItem) {
		this.orderItem = orderItem;
	}
	
	

}

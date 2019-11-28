package finalProject.eeit10919.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="orderlist")
public class OrderListBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@JsonIgnoreProperties("orderItem")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderid")
	private OrderMainBean orderMainBean;
	@ManyToOne
	@JoinColumn(name = "productid")
	private MainCourseBean mainCourse;
	private int amount;
	private String enterTime;
	private String updateTime;
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderMainBean getOrderMainBean() {
		return orderMainBean;
	}

	public void setOrderMainBean(OrderMainBean orderMainBean) {
		this.orderMainBean = orderMainBean;
	}

	public MainCourseBean getMainCourse() {
		return mainCourse;
	}

	public void setMainCourse(MainCourseBean mainCourse) {
		this.mainCourse = mainCourse;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}

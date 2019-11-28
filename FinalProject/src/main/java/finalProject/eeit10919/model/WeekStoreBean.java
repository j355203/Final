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
@Table(name = "weekstore")
public class WeekStoreBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bookDate;
	
	@JsonIgnoreProperties("mainCourse")
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="storeid")
	private StoreBean storeBean;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookDate() {
		return bookDate;
	}

	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	public StoreBean getStoreBean() {
		return storeBean;
	}

	public void setStoreBean(StoreBean storeBean) {
		this.storeBean = storeBean;
	}
	
	
}

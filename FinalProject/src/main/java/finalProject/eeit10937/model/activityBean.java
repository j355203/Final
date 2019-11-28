package finalProject.eeit10937.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "activity")
public class activityBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer activityId;// 活動id

	private String title;// 活動標題
	private String activityTime;// 舉辦時間
	private String activityAddress;// 活動地點
	private Integer activityStatus;// 狀態(上或下架)
	private Integer quantity;// 報名人數
	private String content;// 內文
	private String fileName;

	@Transient
	private MultipartFile activityImage;

	public MultipartFile getActivityImage() {
		return activityImage;
	}

	public void setActivityImage(MultipartFile activityImage) {
		this.activityImage = activityImage;
	}

//	@Transient
	private Blob coverImage;

	public Blob getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(Blob coverImage) {
		this.coverImage = coverImage;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

//	@JsonIgnore
//	@Transient
//	private MultipartFile productImage;
//
//	public MultipartFile getProductImage() {
//		return productImage;
//	}
//
//	public void setProductImage(MultipartFile productImage) {
//		this.productImage = productImage;
//	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}

	public String getActivityAddress() {
		return activityAddress;
	}

	public void setActivityAddress(String activityAddress) {
		this.activityAddress = activityAddress;
	}

	public Integer getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(Integer activityStatus) {
		this.activityStatus = activityStatus;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

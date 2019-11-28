package finalProject.eeit10919.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mapinfo")
public class MapInfoBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeid;
	private String storename;
	private int storestatus;
	private Double lat;
	private Double lng;
	private String enterdate;
	@JsonIgnoreProperties("mapInfo")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "typeid")
	private StoreTypeBean storeTypeBean;

	public MapInfoBean(int storeid, String storename, int storestatus, Double lat, Double lng, String enterdate, StoreTypeBean storeTypeBean) {
		this.storeid = storeid;
		this.storename = storename;
		this.storestatus = storestatus;
		this.lat = lat;
		this.lng = lng;
		this.enterdate = enterdate;
		this.storeTypeBean = storeTypeBean;
	}

	public MapInfoBean() {

	}

	public int getStoreid() {
		return storeid;
	}

	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public int getStorestatus() {
		return storestatus;
	}

	public void setStorestatus(int storestatus) {
		this.storestatus = storestatus;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public String getEnterdate() {
		return enterdate;
	}

	public void setEnterdate(String enterdate) {
		this.enterdate = enterdate;
	}

	public StoreTypeBean getStoreTypeBean() {
		return storeTypeBean;
	}

	public void setStoreTypeBean(StoreTypeBean storeTypeBean) {
		this.storeTypeBean = storeTypeBean;
	}

}

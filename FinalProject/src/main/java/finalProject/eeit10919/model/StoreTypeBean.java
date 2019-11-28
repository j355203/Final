package finalProject.eeit10919.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "storetype")
public class StoreTypeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int typeId;
	private String typeName;
	@Transient
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "storeTypeBean", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<MapInfoBean> mapInfo = new LinkedHashSet<>();

	public StoreTypeBean(int typeid, String typeName) {
		this.typeId = typeid;
		this.typeName = typeName;
	}

	public StoreTypeBean() {

	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set<MapInfoBean> getMapInfo() {
		return mapInfo;
	}

	public void setMapInfo(Set<MapInfoBean> mapInfo) {
		this.mapInfo = mapInfo;
	}

}

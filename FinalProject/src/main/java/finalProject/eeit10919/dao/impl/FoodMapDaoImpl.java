package finalProject.eeit10919.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalProject.eeit10919.dao.FoodMapDao;
import finalProject.eeit10919.model.MapInfoBean;

@Repository
public class FoodMapDaoImpl implements FoodMapDao {

	SessionFactory factory;
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MapInfoBean> getAllFoodMapStore() {
		List<MapInfoBean> list = new ArrayList<>();
		String hql = "FROM MapInfoBean";
		Session session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;
	}

}

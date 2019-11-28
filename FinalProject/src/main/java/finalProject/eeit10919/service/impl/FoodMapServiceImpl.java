package finalProject.eeit10919.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10919.dao.FoodMapDao;
import finalProject.eeit10919.model.MapInfoBean;
import finalProject.eeit10919.service.FoodMapService;

@Service
public class FoodMapServiceImpl implements FoodMapService {
	
	FoodMapDao dao;
	@Autowired
	public void setDao(FoodMapDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public List<MapInfoBean> getAllFoodMapStore() {
		return dao.getAllFoodMapStore();
	}

}

package finalProject.eeit10919.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import finalProject.eeit10919.model.MapInfoBean;
import finalProject.eeit10919.service.FoodMapService;

@Controller
public class FoodMapController {
	FoodMapService service;

	@Autowired
	public void setService(FoodMapService service) {
		this.service = service;
	}
	
	Gson gson = new Gson();
	
	@RequestMapping("/foodmap")
	public String storeMap(Model model) {
		List<MapInfoBean> foodMapStores = service.getAllFoodMapStore();
		String foodMapStoresData = gson.toJson(foodMapStores);
		model.addAttribute("foodMapStoresData", foodMapStoresData);
		return "FoodMap";
	}
	
}

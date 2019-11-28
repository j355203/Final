package finalProject.eeit10919.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import finalProject.eeit10904.model.DepartmentBean;
import finalProject.eeit10904.service.DepartmentService;
import finalProject.eeit10919.model.OrderMainBean;
import finalProject.eeit10919.model.StoreBean;
import finalProject.eeit10919.model.WeekStoreBean;
import finalProject.eeit10919.service.OrderListManagePageService;
import finalProject.eeit10919.service.OrderPageService;

@Controller
public class OrderListManagePageController {
	Gson gson = new Gson();
	DepartmentService departmentService;
	OrderPageService orderPageService;
	OrderListManagePageService orderListManagePageService;
	
	@Autowired
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Autowired
	public void setService(OrderPageService orderPageService) {
		this.orderPageService = orderPageService;
	}
	
	@Autowired
	public void setOrderListManagePageService(OrderListManagePageService orderListManagePageService) {
		this.orderListManagePageService = orderListManagePageService;
	}

	@RequestMapping("/ordermanage")
	public String orderManage(Model model, HttpServletRequest request) {
		return "OrderListManagePage";		
	}
	
	@RequestMapping(value = "/ordermanage/today", method=RequestMethod.POST)
	@ResponseBody
	public List<?> orderData() {
		List<?> data;
		data = orderListManagePageService.getAllTodayOrder();
		if(data.size() == 0) {
			List<WeekStoreBean> targetStore = orderPageService.getStoreIdByDate(new Date());
			data = orderPageService.getStoreDataById(targetStore.get(0).getStoreBean().getStoreId());
		}
		return data;		
	}
	
	@RequestMapping(value = "/ordermanage/storeInfo", method=RequestMethod.POST)
	@ResponseBody
	public StoreBean storeInfo() {
		List<WeekStoreBean> targetStore = orderPageService.getStoreIdByDate(new Date());
		List<StoreBean> data = orderPageService.getStoreDataById(targetStore.get(0).getStoreBean().getStoreId());	
		return data.get(0);
	}
	
	@RequestMapping(value = "/ordermanage/depInfo", method=RequestMethod.POST)
	@ResponseBody
	public List<DepartmentBean> depInfo() {
		List<DepartmentBean> depInfo = departmentService.findAll();	
		return depInfo;
	}
	
	@RequestMapping(value = "/ordermanage/status1", method=RequestMethod.POST)
	@ResponseBody
	public String updateOrder1(@RequestParam int id) {
		OrderMainBean targerOrder = orderListManagePageService.getOrderMainByOrderId(id).get(0);
		targerOrder.setOrderStatus(1);
		orderListManagePageService.updateOrderStatus(targerOrder);
		return "200";
	}
	
	@RequestMapping(value = "/ordermanage/status0", method=RequestMethod.POST)
	@ResponseBody
	public String updateOrder0(@RequestParam int id) {
		OrderMainBean targerOrder = orderListManagePageService.getOrderMainByOrderId(id).get(0);
		targerOrder.setOrderStatus(0);
		orderListManagePageService.updateOrderStatus(targerOrder);
		return "200";
	}
	
	@RequestMapping(value = "/ordermanage/liststatus", method=RequestMethod.POST)
	@ResponseBody
	public String updateOrderList(@RequestParam int getOrNotStatus, @RequestParam int id) {
		orderListManagePageService.updateOrderListStatus(getOrNotStatus, id);
		return "200";
	}
}

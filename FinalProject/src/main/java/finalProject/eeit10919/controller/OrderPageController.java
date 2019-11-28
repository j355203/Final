package finalProject.eeit10919.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import finalProject.eeit10904.model.EmployeeBean;
import finalProject.eeit10919.model.MainCourseBean;
import finalProject.eeit10919.model.StoreBean;
import finalProject.eeit10919.model.WeekStoreBean;
import finalProject.eeit10919.service.OrderPageService;

@Controller
@Scope("session")
public class OrderPageController {
	OrderPageService service;
	
	@Autowired
	public void setService(OrderPageService service) {
		this.service = service;
	}
	
	@RequestMapping("/orderpage")
	public String orderPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		List<WeekStoreBean> targetStore = service.getStoreIdByDate(new Date());
		List<StoreBean> store = service.getStoreDataById(targetStore.get(0).getStoreBean().getStoreId());
		model.addAttribute("store", store);
		model.addAttribute("cartData", session.getAttribute("cartData"));
		model.addAttribute("emp", session.getAttribute("emp"));
		session.setAttribute("store", store);
		return "OrderPage";
	}

	@RequestMapping(value = "/orderdata/cart", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public int getOrderData(@RequestBody List<MainCourseBean> cartList, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("cartData", cartList);
//		session.removeAttribute("store");
		return 200;	
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/orderdata/orderList", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public int sendOrderData(@RequestBody List<MainCourseBean> cartList, HttpServletRequest request) {
		HttpSession session = request.getSession();
		service.addOrUpdateOrder(new Date(), (EmployeeBean)session.getAttribute("emp"), cartList, (List<StoreBean>)session.getAttribute("store"));
		session.removeAttribute("cartData");
		return 200;	
	}
}

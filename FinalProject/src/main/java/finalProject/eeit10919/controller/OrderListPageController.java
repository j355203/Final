package finalProject.eeit10919.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import finalProject.eeit10904.model.EmployeeBean;
import finalProject.eeit10919.model.OrderMainBean;
import finalProject.eeit10919.model.PageFormat;
import finalProject.eeit10919.model.SerchInfo;
import finalProject.eeit10919.service.OrderListPageService;

@Controller
@Scope("session")
public class OrderListPageController {

	OrderListPageService service;

	@Autowired
	public void setService(OrderListPageService service) {
		this.service = service;
	}

	@RequestMapping("/orderlist")
	public String storeMap(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		EmployeeBean empData = (EmployeeBean) session.getAttribute("emp");
		int totalRec = service.totalRecCount(empData.getEmpid(), date, 1);
		List<Integer> idList = service.getIdList(empData.getEmpid(), date, 1);
		session.setAttribute("totalRec", totalRec);
		session.setAttribute("idList", idList);
		SerchInfo si = new SerchInfo();
		si.setSerchType(1);
		si.setSerchText(date);
		session.setAttribute("serchInfo", si);
		return "OrderListPage";
	}

	@RequestMapping(value = "/orderlist/chtype", method = RequestMethod.POST)
	@ResponseBody
	public int orderPageSerchType(@RequestParam("serchType") String serchType, @RequestParam("text") String text, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		EmployeeBean empData = (EmployeeBean) session.getAttribute("emp");
		int totalRec = service.totalRecCount(empData.getEmpid(), text, Integer.parseInt(serchType));
		List<Integer> idList = service.getIdList(empData.getEmpid(), text, Integer.parseInt(serchType));
		session.setAttribute("totalRec", totalRec);
		session.setAttribute("idList", idList);
		SerchInfo si = new SerchInfo();
		si.setSerchType(Integer.parseInt(serchType));
		si.setSerchText(text);
		session.setAttribute("serchInfo", si);
		return 200;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/orderlist/detail/page={page}&recperpage={recPerPage}.json")
	public String orderByPage(@PathVariable Integer page, @PathVariable Integer recPerPage, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		PageFormat pageData = service.pageDataWraper((int)session.getAttribute("totalRec"), page, recPerPage, (List<Integer>) session.getAttribute("idList"));
		SerchInfo si = (SerchInfo)session.getAttribute("serchInfo");
		List<OrderMainBean> orders = service.getOrderByPage(((EmployeeBean)session.getAttribute("emp")).getEmpid(), si.getSerchText(), pageData, (int) si.getSerchType());
		model.addAttribute("pageData", pageData);
		model.addAttribute("orders", orders);
		return "OrderListPage";
	}
}

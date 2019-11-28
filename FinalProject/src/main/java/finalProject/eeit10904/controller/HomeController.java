package finalProject.eeit10904.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import finalProject.eeit10904.model.EmployeeBean;
import finalProject.eeit10904.service.EmployeeService;

@Controller
public class HomeController {

	EmployeeService service;

	@Autowired
	public void setService(EmployeeService service) {
		this.service = service;
	}

	@RequestMapping("/")
	public String home() {
		return "index";
	}

	// 登入(Login)
	// 提供登入頁面的表單
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		EmployeeBean emp = new EmployeeBean();
		model.addAttribute("login", emp);
		return "Login";
	}

	// 接收登入的結果並重導向
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") EmployeeBean emp, BindingResult result, Model model,
			HttpServletRequest request, HttpServletResponse response, 
			RedirectAttributes redirectAttributes) {
		boolean judge = service.verify(emp);

		HttpSession session = request.getSession();
		EmployeeBean emp1 = new EmployeeBean();

		if (judge) {
			emp1 = service.findById(emp.getEmpid());

			session.setAttribute("empid", emp1.getEmpid());
			session.setAttribute("emplevel", emp1.getEmplevel());
			session.setAttribute("emp", emp1);
			System.out.println("登入者： " + emp1.getEmpid() + " 權限： " + emp1.getEmplevel());
			redirectAttributes.addFlashAttribute("emp", emp1);
			return "redirect:/";
		} else {
			Map<String, String> errorMsgMap = new HashMap<String, String>();
			errorMsgMap.put("loginError", "登入失敗");
			redirectAttributes.addFlashAttribute("errorMsgMap", errorMsgMap);
			return "redirect:/login";
		}
	}

	// 登入白名單
	@InitBinder
	public void loginWhiteList(WebDataBinder binder) {
		binder.setAllowedFields("empid", "emppassword");
	}
	
	//登出
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}

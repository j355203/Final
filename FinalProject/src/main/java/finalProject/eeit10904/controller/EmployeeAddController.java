package finalProject.eeit10904.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import finalProject.eeit10904.model.DepartmentBean;
import finalProject.eeit10904.model.EmployeeBean;
import finalProject.eeit10904.service.DepartmentService;
import finalProject.eeit10904.service.EmployeeService;

@Controller
public class EmployeeAddController {
	EmployeeService service;
	DepartmentService serviceDep;

	@Autowired
	public void setService(EmployeeService service) {
		this.service = service;
	}

	@Autowired
	public void setServiceDep(DepartmentService serviceDep) {
		this.serviceDep = serviceDep;
	}

	// 新增(Create)
	// 提供新增員工的表單
	@RequestMapping(value = "/addEmp", method = RequestMethod.GET)
	public String getaddEmpForm(Model model) {
		EmployeeBean emp = new EmployeeBean();
		model.addAttribute("addemp", emp);
		return "AddEmpForm";
	}

	// 將部門資訊加入新增員工表單
	@ModelAttribute("depList")
	public Map<Integer, String> getDepList() {
		Map<Integer, String> depMap = new HashMap<>();
		List<DepartmentBean> list = serviceDep.findAll();
		for (DepartmentBean db : list) {
			depMap.put(db.getDepno(), db.getDepname());
		}
		return depMap;
	}

	// 接收新增員工結果並重定向
	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public String addEmpRedirect(@ModelAttribute("addemp") EmployeeBean emp, 
			RedirectAttributes redirectAttributes) {
		if(emp.getEmpname() != null && emp.getDepno() != -1 
				&& emp.getEmponboard() != null) {
			service.add(emp);
			redirectAttributes.addFlashAttribute("emp", emp);
			return "redirect:/addEmpShow";
		}
		return "redirect:/addEmp";
	}

	// 顯示新增員工結果的頁面
	@RequestMapping("/addEmpShow")
	public String addEmpShow(Model model) {
		return "AddEmp";
	}

	// 查詢(Read)
	// 查詢在職全員工的頁面
	@RequestMapping("/findallemps")
	public String list(Model model) {
		List<EmployeeBean> list = service.findAll();
		model.addAttribute("emps", list);
		return "FindAllEmps";
	}

	// 查詢離職全員工的頁面
	@RequestMapping("/findleaveemps")
	public String leavelist(Model model) {
		List<EmployeeBean> list = service.findLeaves();
		model.addAttribute("leaveemps", list);
		return "FindLeaveEmps";
	}
}

package finalProject.eeit10904.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import finalProject.eeit10904.model.DepartmentBean;
import finalProject.eeit10904.model.EmployeeBean;
import finalProject.eeit10904.service.DepartmentService;
import finalProject.eeit10904.service.EmployeeService;

@Controller
public class EmployeeUpdateController {
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

	// 修改(Update)
	// 提供更新人員的表單
	@RequestMapping(value = "/updateEmp/{empid}", method = RequestMethod.GET)
	public String getupdateEmpForm(@PathVariable Integer empid, Model model) {
		EmployeeBean empUpdate = service.findById(empid);
		model.addAttribute("updEmp", empUpdate);
		return "UpdateEmpInfo";
	}

	// 將部門資訊加入更新員工表單
	@ModelAttribute("depList")
	public Map<Integer, String> getDepList() {
		Map<Integer, String> depMap = new HashMap<>();
		List<DepartmentBean> list = serviceDep.findAll();
		for (DepartmentBean db : list) {
			depMap.put(db.getDepno(), db.getDepname());
		}
		return depMap;
	}

	// 接收更新人員結果並重定向
	@RequestMapping(value = "/updateEmp/{empid}", method = RequestMethod.POST)
	public String updateEmpRedirect(@ModelAttribute("updEmp") EmployeeBean empUpdate,
			RedirectAttributes redirectAttributes) {
		service.update(empUpdate);
		redirectAttributes.addFlashAttribute("emp", empUpdate);
		return "redirect:/updateEmpShow";
	}

	// 顯示更新人員結果的頁面
	@RequestMapping("/updateEmpShow")
	public String updateEmp(Model model) {
		return "UpdateEmpShow";
	}

	
	// 刪除(Delete)
	// 提供辦理離職人員的顯示清單(以註記離職方式處理，避免刪除資料)
	@RequestMapping(value = "/leaveEmp/{empid}", method = RequestMethod.GET)
	public String getleaveEmpForm(@PathVariable Integer empid, Model model) {
		EmployeeBean empLeave = service.findById(empid);
		model.addAttribute("leave", empLeave);
		return "LeaveEmpInfo";
	}

	// 接收離職人員結果並導回全部員工
	@RequestMapping(value = "/leaveEmp/{empid}", method = RequestMethod.POST)
	public String leaveEmp(@PathVariable Integer empid, 
			@ModelAttribute("leave") EmployeeBean empLeave, Model model) {
		System.out.println("離職工號" + empid);
		service.leave(empid);
		return "redirect:/findallemps";
	}

	// 回任
	// 提供辦理回任人員的顯示清單(反向處理離職員工的離職註記)
	@RequestMapping(value = "/repatriationEmp/{empid}", method = RequestMethod.GET)
	public String getrepatriationEmpForm(@PathVariable Integer empid, Model model) {
		EmployeeBean empRepatriation = service.findById(empid);
		model.addAttribute("repatriation", empRepatriation);
		return "RepatriationEmpInfo";
	}

	// 接收回任人員結果並導回全部員工
	@RequestMapping(value = "/repatriationEmp/{empid}", method = RequestMethod.POST)
	public String repatriationEmp(@PathVariable Integer empid, 
			@ModelAttribute("repatriation") EmployeeBean empRepatriation, Model model) {
		System.out.println("回任工號" + empid);
		service.repatriation(empid);
		return "redirect:/findallemps";
	}
	
	// 修改密碼(Update Password)
	// 顯示員工個人資料頁
	@RequestMapping(value = "/updpwd/{empid}", method = RequestMethod.GET)
	public String getEmpProfile(@PathVariable Integer empid, Model model) {
		EmployeeBean updpwd = service.findById(empid);
		model.addAttribute("updpwd", updpwd);
		return "Profile";
	}
	
	// 接收更新密碼資訊並回傳員工資料頁
	@RequestMapping(value = "/updpwd/{empid}", method = RequestMethod.POST)
	public String updateEmpPwd(@ModelAttribute("updpwd")EmployeeBean updpwd, 
			RedirectAttributes redirectAttributes) {
		if(service.updatepassword(updpwd)){
			redirectAttributes.addFlashAttribute("updmessage", "您的密碼已更新");
			EmployeeBean emp = service.findById(updpwd.getEmpid());
			redirectAttributes.addFlashAttribute("emp", emp);
			return "redirect:/updpwd/{empid}";
		}
		redirectAttributes.addFlashAttribute("updmessage", "您的新舊密碼相同");
		EmployeeBean emp = service.findById(updpwd.getEmpid());
		redirectAttributes.addFlashAttribute("emp", emp);
		return "redirect:/updpwd/{empid}";
	}

}

package finalProject.eeit10930.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import finalProject.eeit10930.model.LeaveBean;
import finalProject.eeit10930.service.LeaveService;

@Controller
public class UpdateLeaveController {
	LeaveService service;

	@Autowired
	public void setService(LeaveService service) {
		this.service = service;
	}

	// 修改(Update)
	// 提供修改請假的表單
	@RequestMapping(value = "/updateLeave/{leaveid}", method = RequestMethod.GET)
	public String getupdateLeaveForm(@PathVariable Integer leaveid, Model model) {
		LeaveBean lb = service.findbyleaveId(leaveid);
		model.addAttribute("updateLeave", lb);
		return "UpdateLeaveInfo";
	}

	// 員工修改請假
	@RequestMapping(value = "/updateLeave/{leaveid}", method = RequestMethod.POST)
	public String UpdateLeave(@ModelAttribute("updateLeave") LeaveBean lb, RedirectAttributes redirectAttributes) {

		service.updateleave(lb);
		System.out.println(lb.getDayoffstart());
		System.out.println(lb.getDayoffend());
		redirectAttributes.addFlashAttribute("emp", lb);
		return "redirect:/empSelect";

	}
	
	// 將分類資訊加入分類表單
			@ModelAttribute("LeaveMap1")
			public Map<String, String> getLeaveList() {
				Map<String, String> leaveMap1 = new HashMap<>();
				leaveMap1.put("病假", "病假");
				leaveMap1.put("事假", "事假");
				leaveMap1.put("喪假", "喪假");
				leaveMap1.put("補休", "補休");
				leaveMap1.put("特休", "特休");
				leaveMap1.put("年假", "年假");
				return leaveMap1;
			}

}

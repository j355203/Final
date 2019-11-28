package finalProject.eeit10937.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import finalProject.eeit10904.model.EmployeeBean;
import finalProject.eeit10904.service.EmployeeService;
import finalProject.eeit10937.model.RegistrationFormBean;
import finalProject.eeit10937.service.RegistrationFormService;

@Controller
public class RegistrationFormController {
	RegistrationFormService service;

	@Autowired
	public void setService(RegistrationFormService service) {
		this.service = service;
	}

	@Autowired
	EmployeeService empService;

	@RequestMapping("/RegistrationForm")
	public String list(Model model) {
		List<RegistrationFormBean> list = service.getAllRegistrationForm();
		model.addAttribute("RegistrationForm", list);
		return "RegistrationForm";
	}

	@RequestMapping(value = "/searchRegistrationForm", method = RequestMethod.GET)
	public String getDisplayRegistrationFormHTML(Model model) {
		RegistrationFormBean rfb = new RegistrationFormBean();
		model.addAttribute("RegistrationFormBean", rfb);
		return "searchRegistrationForm";
	}

	@RequestMapping("/RegistrationFormOne")
	public String getRegistrationFormById(@RequestParam("formId") Integer formId, Model model) {
		model.addAttribute("RegistrationFormOne", service.getRegistrationFormById(formId));
		return "RegistrationFormOne";
	}

	@RequestMapping(value = "RegistrationFormOne", method = RequestMethod.POST)
	public String displayRegistrationFormHTML(@ModelAttribute("RegistrationFormBean") RegistrationFormBean rfb,
			Model model) {
		RegistrationFormBean rfb1 = service.getRegistrationFormById(rfb.getFormId());
		model.addAttribute("RegistrationForm", rfb1);
		return "RegistrationFormSelect";
	}
//	@RequestMapping("/RegistrationFormA")
//	public String getRegistrationFormById1(@RequestParam("activityId") Integer activityId , Model model) {
//		model.addAttribute("RegistrationFormA",service.getRegistrationFormById(activityId));
//		return "RegistrationFormA";
//	}

	@RequestMapping(value = "/addRegistrationForm/{activityId}", method = RequestMethod.GET)
	public String getAddNewRegistrationForm(@PathVariable Integer activityId, Model model, HttpServletRequest request) {
		RegistrationFormBean rfb = new RegistrationFormBean();
		int empid = (int)request.getSession().getAttribute("empid");
		rfb.setEmpid(empid);
		rfb.setActivityId(activityId);
		boolean test = service.addRegistrationForm(rfb);
		String test2 = "";
		if (test) {
			test2 = "已報名";
		} else {
			test2 = "未報名";
		}
		System.out.println("---------empid: " + empid + ", boolean: " + test);
		model.addAttribute("RegistrationFormBean", rfb);
		model.addAttribute("activityId", activityId);
		model.addAttribute("regis", test2);
		return "addRegistrationForm";
	}

	@RequestMapping(value = "/addRegistrationForm/{activityId}", method = RequestMethod.POST)
	public String processAddNewRegistrationForm(@ModelAttribute("RegistrationFormBean") RegistrationFormBean rfb,
			Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {
		service.addRegistrationForm(rfb);
		List<RegistrationFormBean> list = service.getAllRegistrationForm();
		redirectAttributes.addFlashAttribute("addRegistrationForm", list);
    	service.addRegistrationForm1(rfb);
		return "redirect:/userActivity";
	}

	@RequestMapping(value = "RegistrationFormBean/{empid}", method = RequestMethod.GET)
	public String getURegistrationFormById(@PathVariable Integer empid, Model model) {
		List<RegistrationFormBean> rfb2 = service.getRegistrationFormEid(empid);
		model.addAttribute("RegistrationFormBean1", rfb2);
		return "RegistrationFormSelectU";
	}

	@RequestMapping(value = "RegistrationFormEmp/{empid}", method = RequestMethod.GET)
	public String findById(@PathVariable Integer empid, Model model) {
		EmployeeBean rfb6 = empService.findById(empid);
		model.addAttribute("RegistrationFormEmp", rfb6);
		return "RegistrationFormSelectEmp";
	}

//    @RequestMapping(value="RegistrationFormBean", method=RequestMethod.POST)
//    public String getURegistrationFormById1(@ModelAttribute("RegistrationFormBean1") RegistrationFormBean rfb1 , Model model) {
//    	List<RegistrationFormBean> rfb2 = service.getRegistrationFormEid(rfb1.getEmpid());
//    	System.out.println(rfb1.getEmpid());
//		model.addAttribute("RegistrationForm", rfb2);
//    	return "RegistrationFormSelectU";
//    }
	@RequestMapping("RegistrationFormBeanA")
	public String getURegistrationFormById2(Model model) {
		RegistrationFormBean rfb3 = new RegistrationFormBean();
		model.addAttribute("RegistrationFormBeanA", rfb3);
		return "searchRegistrationFormA";
	}

	@RequestMapping(value = "RegistrationFormBeanA", method = RequestMethod.POST)
	public String getURegistrationFormById2(@ModelAttribute("RegistrationFormBeanA") RegistrationFormBean rfb1,
			Model model) {
		List<RegistrationFormBean> rfb3 = service.getRegistrationFormAid(rfb1.getActivityId());
		model.addAttribute("RegistrationFormA", rfb3);
		return "RegistrationFormSelectA";
	}

	@RequestMapping("/RegistrationFormSelectU/{formId}")
	public String deleteRegistrationForm(@PathVariable Integer formId, Model model, HttpSession session) {
		int empid = (Integer) session.getAttribute("empid");
		RegistrationFormBean rfd = service.getRegistrationFormById(formId);
		service.deleteRegistrationForm(rfd);
		return "redirect:/RegistrationFormBean" + "/" + empid;
	}
}

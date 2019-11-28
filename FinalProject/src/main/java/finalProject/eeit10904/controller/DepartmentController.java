package finalProject.eeit10904.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import finalProject.eeit10904.exception.DepartmentDeleteFoundFKException;
import finalProject.eeit10904.model.DepartmentBean;
import finalProject.eeit10904.service.DepartmentService;

@Controller
public class DepartmentController {
	DepartmentService service;

	@Autowired
	public void setService(DepartmentService service) {
		this.service = service;
	}

	// 新增(Create)
	// 提供新增部門的表單
	@RequestMapping(value = "/addDepname", method = RequestMethod.GET)
	public String getaddDepForm(Model model) {
		DepartmentBean dep = new DepartmentBean();
		model.addAttribute("departmentBean", dep);
		return "AddDepForm";
	}

	// 接收新增部門結果並重定向
	@RequestMapping(value = "/addDepname", method = RequestMethod.POST)
	public String addDepRedirect(@ModelAttribute("departmentBean") DepartmentBean dep,
			RedirectAttributes redirectAttributes) {
		if(dep.getDepname().equals("")) {
			Map<String, String> errorDep = new HashMap<String, String>();
			errorDep.put("message", "輸入部門名稱為空");
			redirectAttributes.addFlashAttribute("errorDep", errorDep);
			return "redirect:addDepname";
		}
		service.add(dep);
		redirectAttributes.addFlashAttribute("dep", dep);
		return "redirect:/addDep";
	}

	// 顯示新增部門結果的頁面
	@RequestMapping("/addDep")
	public String addDep(Model model) {
		return "AddDep";
	}

	// 查詢(Read)
	// 查詢所有部門的頁面
	@RequestMapping("/findalldeps")
	public String list(Model model) {
		List<DepartmentBean> list = service.findAll();
		model.addAttribute("deps", list);
		return "FindAllDeps";
	}

	// 修改(Update)
	// 提供更新部門的表單
	@RequestMapping(value = "/updateDep/{depno}", method = RequestMethod.GET)
	public String getupdateDepForm(@PathVariable Integer depno, Model model) {
		DepartmentBean dep = service.findByNo(depno);
		model.addAttribute("updateDep", dep);
		return "UpdateDepInfo";
	}

	// 接收更新部門結果並重定向
	@RequestMapping(value = "/updateDep/{depno}", method = RequestMethod.POST)
	public String updateDepRedirect(@ModelAttribute("updateDep") DepartmentBean dep,
			RedirectAttributes redirectAttributes) {
		service.update(dep);
		redirectAttributes.addFlashAttribute("dep", dep);
		return "redirect:/updateDep";
	}

	// 顯示更新部門結果的頁面
	@RequestMapping("/updateDep")
	public String updateDep(Model model) {
		return "UpdateDepShow";
	}

	// 刪除(Delete)
	// 刪除部門後導回查詢全部部門
	@RequestMapping("/deleteDep/{depno}")
	public String deleteDep(@PathVariable Integer depno, Model model) {
		service.delete(depno);
		return "redirect:/findalldeps";
	}

	// 自訂例外處理-刪除部門時仍有人在該部門內，導致SQL因有Foreign Key關聯而無法刪除
	@ExceptionHandler({ DepartmentDeleteFoundFKException.class })
	public ModelAndView handleFKError(HttpServletRequest request, 
			DepartmentDeleteFoundFKException exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("depno", exception.getDepno());
		mv.addObject("exception", exception.getMessage());
		mv.setViewName("DepFKError");
		return mv;
	}
}

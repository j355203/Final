package finalProject.eeit10930.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import finalProject.eeit10904.model.EmployeeBean;
import finalProject.eeit10930.model.ClockinBean;
import finalProject.eeit10930.service.ClockinService;
//import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class ClockinController {

	ClockinService service;

	@Autowired
	public void setService(ClockinService service) {
		this.service = service;
	}

	// 上班打卡表單
	@RequestMapping(value = "/clockin", method = RequestMethod.GET)
	public String clockinForm(Model model, HttpServletRequest requset) {
		EmployeeBean emp = (EmployeeBean) requset.getSession().getAttribute("emp");
		ClockinBean cb = new ClockinBean();
		cb.setEmpid(emp.getEmpid());
		model.addAttribute("clockin", cb);
		return "EmpClockin";
	}

	// 上班打卡
	@RequestMapping(value = "/addclockin", method = RequestMethod.POST)
	public String addclockin(@ModelAttribute("addclockin") ClockinBean cb, RedirectAttributes redirectAttributes,
			HttpServletRequest request) {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String createDate = sdFormat.format(date);
		EmployeeBean emp = (EmployeeBean) request.getSession().getAttribute("emp");
		System.out.println("1" + cb.getClockinid());
		System.out.println("2" + cb.getEmpid());
		cb.setClkintime(createDate);
		cb.setEmpid(emp.getEmpid());
		Integer depno = Integer.parseInt(request.getParameter("depno"));
		cb.setDepno(depno);
		request.setAttribute("cb", cb);
		service.addclockin(cb);
		redirectAttributes.addFlashAttribute("cb", cb);
		return "redirect:/clockinView";
	}

	// 上班打卡完成導向打卡頁面
	@RequestMapping("/clockinView")
	public String clockinAfter(Model model) {
		return "EmpClockin";
	}

	// 下班打卡完成導向打卡頁面
	@RequestMapping("/clockoutView")
	public String clockoutAfter(Model model) {
		return "EmpClockin";
	}

	// 依empid修改下班時間
	@RequestMapping(value = "/updateclockout", method = RequestMethod.POST)
	public String updateclockout(@ModelAttribute("updateclockout") ClockinBean cb, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
//		ClockinBean cb1 = (ClockinBean) requset.getSession().getAttribute("emp");
//		cb.setEmpid(cb1.getEmpid());
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String createDate = sdFormat.format(date);
		cb.setClkouttime(createDate);
		System.out.println(cb.getEmpid());
		request.setAttribute("cb", cb);
		service.updateclockout(cb);
		redirectAttributes.addFlashAttribute("cb", cb);
		return "redirect:/clockoutView";
	}

	// 員工查詢打卡紀錄
	@RequestMapping(value = "/empSelectClockin", method = RequestMethod.GET)
	public String EmpSelect(Model model, HttpServletRequest requset) {
		EmployeeBean emp = (EmployeeBean) requset.getSession().getAttribute("emp");
		List<ClockinBean> cb = service.selectclockin(emp.getEmpid());
		model.addAttribute("empSelectClockin", cb);
		return "FindEmpClockin";

	}

	// 提供加班表單
	@RequestMapping(value = "/updateovertime/{clockinid}", method = RequestMethod.GET)
	public String overtimeForm(@PathVariable Integer clockinid, Model model) {
		ClockinBean cb = service.findbyclockinid(clockinid);
		model.addAttribute("updateovertime", cb);
		return "OverTimeInfo";
	}

	// 員工申請加班
	@RequestMapping(value = "/updateovertime/{clockinid}", method = RequestMethod.POST)
	public String Updateovertime(@ModelAttribute("updateovertime") ClockinBean cb,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
		Integer overtime = Integer.parseInt(request.getParameter("overtime"));
		cb.setDepno(overtime);
		String verify = request.getParameter("verify");
		cb.setVerify(verify);
		service.updateovertime(cb);
		redirectAttributes.addFlashAttribute("emp", cb);
		return "redirect:/empSelectClockin";

	}

	// 將加班時數加入加班表單
	@ModelAttribute("OvertimeMap")
	public Map<Integer, Integer> getClockinLeaveList() {
		Map<Integer, Integer> OvertimeMap = new HashMap<Integer, Integer>();
		OvertimeMap.put(1, 1);
		OvertimeMap.put(2, 2);
		OvertimeMap.put(3, 3);
		OvertimeMap.put(4, 4);
		OvertimeMap.put(5, 5);
		OvertimeMap.put(6, 6);
		return OvertimeMap;
	}

	// 提供管理員查詢加班表單
	@RequestMapping(value = "/AdmFindOvertime", method = RequestMethod.GET)
	public String AdmSelectInfo(Model model, HttpServletRequest request) {
		ClockinBean cb = new ClockinBean();
		cb.setDepno(100);
		request.setAttribute("cb", cb);
		model.addAttribute("AdmFindOvertime", cb);
		return "AdmFindOvertimeInfo";
	}

	// 管理員查詢加班bydeptno
	@RequestMapping(value = "/AdmFindOvertime", method = RequestMethod.POST)
	public String AdmSelect(@ModelAttribute("AdmFindOvertime") ClockinBean CBL, Model model,
			RedirectAttributes redirectAttributes) {
		List<ClockinBean> cb = service.findbydepno(CBL.getDepno());
		model.addAttribute("cb", cb);
		redirectAttributes.addFlashAttribute("cb", cb);
		return "redirect:/AdmFindOvertimeView";
	}

	// 管理員查詢請假結果
	@RequestMapping("AdmFindOvertimeView")
	public String AdmSelectView(Model model) {
		return "AdmFindOvertimeView";
	}

	// 管理員更新審核欄位
	@ResponseBody
	@RequestMapping(value = "/UpdateOvertimeVerify/{clockinid}", method = RequestMethod.POST)
	public Map<String, String> UpdateOvertimeVerify(@RequestParam Map<String, String> map,
			@PathVariable int clockinid) {
		Map<String, String> result = new HashMap<String, String>();
		try {

			ClockinBean cb = service.findbyclockinid(clockinid);
			System.out.println("ovo : " + map.get("verify"));// 123
			cb.setVerify((map.get("verify")));
			service.updateverify(cb);
			result.put("returnCode", "0");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("returnCode", "1");
		}

		return result;
	}

	// 管理員查詢加班的部門選單
	@ModelAttribute("CkDepMap")
	public Map<Integer, String> getDepList() {
		Map<Integer, String> depMap = new LinkedHashMap<Integer, String>();
		depMap.put(100, "100:董事長室");
		depMap.put(200, "200:總經理室");
		depMap.put(300, "300:稽核處");
		depMap.put(400, "400:資訊部");
		depMap.put(500, "500:人力資源部");
		depMap.put(600, "600:財務部");
		depMap.put(700, "700:法務部");
		depMap.put(800, "800:管理部");
		depMap.put(900, "900:行銷規劃");
		depMap.put(1000, "1000:專案企劃處");
		return depMap;
	}

}

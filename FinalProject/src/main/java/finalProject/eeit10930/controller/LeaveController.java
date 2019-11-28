package finalProject.eeit10930.controller;

//import java.text.SimpleDateFormat;
//import java.util.Date;
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
import finalProject.eeit10930.model.LeaveBean;
import finalProject.eeit10930.service.LeaveService;

@Controller
public class LeaveController {
	LeaveService service;
	@Autowired
	public void setService(LeaveService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/leave" , method = RequestMethod.GET)
	public String AddNewLeaveForm(Model model) {
		LeaveBean lb = new LeaveBean();
		model.addAttribute("leave",lb);	
		return "EmpLeave";
		
	}
	
	//員工申請請假
	@ResponseBody //不跳轉頁面
	@RequestMapping(value="/saveLeave" , method = RequestMethod.POST)
	//取值放入Map
	public Map<String, String> AddNewLeaveForm(@RequestParam Map<String, String> map,HttpServletRequest requset) {
		Map<String, String> result = new HashMap<String, String>();
		try {
			LeaveBean lb = new LeaveBean();
            System.out.println(map);
			//設定日期格式
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			//欲轉換的日期字串
//			String dayoffstartStr = map.get("dayoffstart");
//			String dayoffendStr = map.get("dayoffend");
			
			//進行轉換
//			Date dayoffstart = sdf.parse(dayoffstartStr);
//			Date dayoffend = sdf.parse(dayoffendStr);
			
//			String EMP_NOStr = map.get("EMP_NObb");
//			int EMP_NO = Integer.parseInt(EMP_NOStr);
//			lb.setEMP_NO(EMP_NO);
//           EmployeeBean  emp = (EmployeeBean) requset.getSession().getAttribute("emp");
           
//            lb.setDeptno(emp.getDepno());
			lb.setEmpid(Integer.parseInt(map.get("EMP_NObb")));
			lb.setEname(map.get("ENAME"));
			lb.setDayoffstart(map.get("dayoffstart"));
			lb.setDayoffend(map.get("dayoffend"));
			lb.setLeavestyle((map.get("leavestyle")));
			lb.setDeptno(Integer.parseInt(map.get("deptno")));
			lb.setVerify((map.get("verify")));
			lb.setImgpath((map.get("imgpath")));
			
			service.addleave(lb);
			result.put("returnCode", "0");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("returnCode", "1");
		}
		return result;
	}
	
	//員工查詢請假
	@RequestMapping(value="/empSelect", method=RequestMethod.GET)
	public  String EmpSelect(Model model, HttpServletRequest requset) {
		//取出登入的empid
		EmployeeBean  emp = (EmployeeBean) requset.getSession().getAttribute("emp");
		System.out.println(emp);
		System.out.println(emp);
		System.out.println(emp);
		System.out.println(emp.getEmpid());
		
		List <LeaveBean> lb = service.queryleave(emp.getEmpid());
		
		//model.addAttribute("emp", requset.getSession().getAttribute("empid"));
		model.addAttribute("empSelectaa",lb);
		return "FindEmpLeave";
	}
	
//	@ResponseBody
	@RequestMapping(value="/deleteLeave/{leaveid}")
	public String DeleteLeave(@PathVariable Integer leaveid, Model model) {
		service.deleteleave(leaveid);
		return"redirect:/empSelect";
	}
	
//	// 修改(Update)
//		// 提供修改請假的表單
//		@RequestMapping(value = "/updateLeave/{leaveid}", method = RequestMethod.GET)
//		public String getupdateLeaveForm(@PathVariable Integer leaveid,Model model) {
//			LeaveBean lb = service.findbyleaveId(leaveid);
//			model.addAttribute("updateEmp", lb);
//			return "UpdateLeaveInfo";
//		}
//		//員工修改請假
//		@RequestMapping(value = "/updateLeave/{leaveid}", method = RequestMethod.POST)
//		public String UpdateLeave(@ModelAttribute("updateLeave") LeaveBean lb,RedirectAttributes redirectAttributes) {
//			 
//			service.updateleave(lb);
//			System.out.println(lb.getDayoffstart());
//			System.out.println(lb.getDayoffend());
//			redirectAttributes.addFlashAttribute("emp", lb);	
//			return "redirect:/empSelect";
//			
//		}
		
//		@RequestMapping(value="/admSelect", method=RequestMethod.GET)
//		public String AdmSelectInfo(Model model, HttpServletRequest requset) {
//			LeaveBean lb = (LeaveBean) requset.getSession().getAttribute("deptno");
//			List <LeaveBean> list = service.findbydeptno(lb.getDeptno());
//			model.addAttribute("admSelect",list);
//			return "AdmFindLeave";
//		}
		//提供管理員查詢請假表單
		@RequestMapping(value="/AdmSelect", method=RequestMethod.GET)
		public String AdmSelectInfo(Model model, HttpServletRequest request) {
			LeaveBean lb = new LeaveBean();
			lb.setDeptno(100);
			request.setAttribute("lb", lb);
			model.addAttribute("AdmSelect", lb);
			return "AdmFindLeaveInfo";
		}
		
		
		//管理員查詢請假bydeptno
		
		@RequestMapping(value="/AdmSelect", method=RequestMethod.POST)
		public String AdmSelect(@ModelAttribute("AdmSelect") LeaveBean LBL, Model model,
				RedirectAttributes redirectAttributes) {
			List <LeaveBean> lb = service.findbydeptno(LBL.getDeptno());
			model.addAttribute("lb",lb);
			redirectAttributes.addFlashAttribute("lb",lb);
			return "redirect:/AdmSelectLeaveView";
//			return "AdmSelectLeaveView";
		}
		//管理員查詢請假結果
		@RequestMapping("AdmSelectLeaveView")
		public String AdmSelectView(Model model) {
			return "AdmSelectLeaveView";
		}
		
		//管理員更新審核欄位
		@ResponseBody
		@RequestMapping(value="/UpdateVerify/{leaveid}", method=RequestMethod.POST)
		public Map<String, String> UpdateVerify(@RequestParam Map<String, String> map ,
				@PathVariable int leaveid) {
			Map<String, String> result = new HashMap<String, String>();
			try {
			
			LeaveBean lb = service.findbyleaveId(leaveid);
			System.out.println("ovo : "+map.get("verify"));//123
			lb.setVerify((map.get("verify")));
			service.updateverify(lb);
			result.put("returnCode", "0");
			}catch (Exception e) {
				e.printStackTrace();
				result.put("returnCode", "1");
			}
			
			return result;
		}
		
		// 將分類資訊加入分類表單
		@ModelAttribute("LeaveMap")
		public Map<String, String> getLeaveList() {
			Map<String, String> leaveMap = new HashMap<String, String>();
			leaveMap.put("病假", "病假");
			leaveMap.put("事假", "事假");
			leaveMap.put("喪假", "喪假");
			leaveMap.put("補休", "補休");
			leaveMap.put("特休", "特休");
			leaveMap.put("年假", "年假");
			return leaveMap;
		}
		@ModelAttribute("DepMap")
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

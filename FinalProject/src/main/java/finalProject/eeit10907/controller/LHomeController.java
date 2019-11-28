package finalProject.eeit10907.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LHomeController {
	
	@RequestMapping("/Learningindex")
	public String Learningindex() {
		return "Learningindex";
	}
	
	@RequestMapping("/sourse")
	public String sourse() {
		return "sourse";
	}
	@RequestMapping("/mycourse")
	public String mycourse() {
		return "mycourse";
	}
	
	
	@RequestMapping("/selectcourse")
	public String selectcourse() {
		return "selectcourse";
	}
	
	@RequestMapping("/title")
	public String title() {
		return "title";
	}
	
	@RequestMapping("/employee")
	public String employee() {
		return "employee";
	}
	@RequestMapping("/opencourse")
	public String opencourse() {
		return "opencourse";
	}
	@RequestMapping("/opensourse")
	public String opensourse() {
		return "opensourse";
	}
	
	@RequestMapping("/opensourse2")//selectcourse的查詢詳細資料
	public String opensourse2() {
		return "opensourse2";
	}
	@RequestMapping("/opencourseall")
	public String opencourseall() {
		return "opencourseall";
	}
	
	@RequestMapping("/updateemployee")
	public String updateemployee() {
		return "updateemployee";
	}
	
	@RequestMapping("/updatecourse")
	public String updatecourse() {
		return "updatecourse";
	}
	@RequestMapping("/updatetitle")
	public String updatetitle() {
		return "updatetitle";
	}
	@RequestMapping("/detailcourse")  //mycourse的查詢詳細資料
	public String detailcourse() {
		return "detailcourse";
	}
	@RequestMapping("/detailcourse2") //opencourseall的查詢詳細資料
	public String detailcourse2() {
		return "detailcourse2";
	}
	@RequestMapping("/detailcourse3")//selectcourse的查詢詳細資料
	public String detailcourse3() {
		return "detailcourse3";
	}
	@RequestMapping("/detailcourse4")//selectcourse的查詢詳細資料
	public String detailcourse4() {
		return "detailcourse4";
	}
	
}

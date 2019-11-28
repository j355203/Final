package finalProject.eeit10907.controller;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import finalProject.eeit10907.service.MycourseService;

import finalProject.eeit10907.service.MycourseService;


//控制器
@Controller
@RequestMapping
public class MycourseController {

	MycourseService service1;

	@Autowired
	public void setService(MycourseService service1) {
		this.service1 = service1;
	}

// 查詢以選課程
	@RequestMapping(value = "/Q1", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String mycourse_Q1(@RequestParam("empid") Integer empid) throws IOException, SQLException {
		String Q1 = service1.mycourse_Q1(empid);
		return Q1;
	}

// 查詢學分
	@RequestMapping(value = "/Q3", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String mycourse_Q3(@RequestParam("empid") Integer empid, Model model) throws IOException, SQLException {
		String Q3 = service1.mycourse_Q3(empid);
		return Q3;
	}

// 取消報名
	@RequestMapping(value = "/D1", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String deleteMycourse( @RequestParam(value = "empid") String empid,
			@RequestParam(value = "CourseID") String CourseID) throws SQLException {


		int[] mycourseD1 = new int[2]; // 建立陣列
		int a1 = Integer.parseInt(empid);
		int a2 = Integer.parseInt(CourseID);
		mycourseD1[0] = a1;
		mycourseD1[1] = a2;

		String D1 = service1.deleteMycourse(mycourseD1);
		return D1;
	}
//查詢課程詳細資料
		@RequestMapping(value = "/Q2", produces = "application/json; charset=utf-8")
		@ResponseBody
		public String mycourse_Q2(@RequestParam("CourseID") String CourseID) throws IOException, SQLException {
			String[] mycourseQ2=new String[1]; 
			String a1 =CourseID;
			mycourseQ2[0] = a1;
			
			String Q2 = service1.mycourse_Q2(mycourseQ2);
			return Q2;
		}
//查詢滿意度
		@RequestMapping(value = "/Q4", produces = "application/json; charset=utf-8")
		@ResponseBody
		public String mycourse_Q4(@RequestParam("empid") String empid,@RequestParam("CourseID") String CourseID) throws IOException, SQLException {
			String[] mycourseD2=new String[2]; //建立陣列
			String a1 =empid;
			String a2 =CourseID;
			System.out.println(a1);
			System.out.println(a2);
			mycourseD2[0] = a1;
			mycourseD2[1] = a2;
			
			String Q4 = service1.mycourse_Q4(mycourseD2);
			return Q4;
		}
		
//新增滿意度
			@RequestMapping(value = "/I1", produces = "application/json; charset=utf-8")
			@ResponseBody
			public String mycourse_I1(@RequestParam("empid") String empid,@RequestParam("CourseID") String CourseID
					,@RequestParam("mysatisfaction_a1") String mysatisfaction_a1
					,@RequestParam("mysatisteacher_a1") String mysatisteacher_a1
					,@RequestParam("mysatiscontent_a1") String mysatiscontent_a1
					,@RequestParam("teacher_Q1") String teacher_Q1
					,@RequestParam("teacher_Q2") String teacher_Q2
					,@RequestParam("content_Q1") String content_Q1
					,@RequestParam("content_Q2") String content_Q2) throws IOException, SQLException {
				String[] mycoursestis=new String[9]; //建立陣列
				String a1 =empid;
				String a2 =CourseID;
				String a3 =mysatisfaction_a1;
				String a4 =mysatisteacher_a1;
				String a5 =mysatiscontent_a1;
				String a6 =teacher_Q1;
				String a7 =teacher_Q2;
				String a8 =content_Q1;
				String a9 =content_Q2;
				mycoursestis[0] = a1;
				mycoursestis[1] = a2;
				mycoursestis[2] = a3;
				mycoursestis[3] = a4;
				mycoursestis[4] = a5;
				mycoursestis[5] = a6;
				mycoursestis[6] = a7;
				mycoursestis[7] = a8;
				mycoursestis[8] = a9;
				
				String I1 = service1.mycourse_I1(mycoursestis);
				return I1;
			}


}
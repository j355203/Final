package finalProject.eeit10907.controller;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import finalProject.eeit10907.service.SelectcourseService;

////控制器
@Controller
@RequestMapping
public class SelectcourseController {
	
	SelectcourseService service;

	@Autowired
	public void setService(SelectcourseService service) {
		this.service = service;
	}
	
	//下拉學門 
	@RequestMapping(value = "/selectcourse/Q1", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String selectcourse_Q1() throws IOException, SQLException {
		
		String Q1 = service.selectcourse_Q1();
		return Q1;

	}
	
	//用學門查 全部課程
		@RequestMapping(value = "/selectcourse/Q2", produces = "application/json; charset=utf-8") 
		@ResponseBody
		public String selectcourse_Q2( @RequestParam(value = "subjectname_q1") String subjectname_q1) throws IOException, SQLException {

			String[] subjectcourseID=new String[1]; // 建立陣列
			String a1 = subjectname_q1;
			subjectcourseID[0] = a1;
			String Q2 = service.selectcourse_Q2(subjectcourseID);
			return Q2;
	
		}
		

	//下拉課程
			@RequestMapping(value = "/selectcourse/Q3", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String selectcourse_Q3( @RequestParam(value = "subjectname_q1") String subjectname_q1) throws IOException, SQLException {

				String[] subjectcourseID=new String[1]; // 建立陣列
				String a1 = subjectname_q1;
				subjectcourseID[0] = a1;
				String Q3 = service.selectcourse_Q3(subjectcourseID);
				return Q3;
		
			}
			
	//課程總攬
			@RequestMapping(value = "/selectcourse/Q4", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String selectcourse_Q4() throws IOException, SQLException {

				String Q4 = service.selectcourse_Q4();
				return Q4;
		
			}

	//用課程查 全部課程
			@RequestMapping(value = "/selectcourse/Q5", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String selectcourse_Q5(@RequestParam(value = "coursename_q1") String coursename_q1) throws IOException, SQLException {
				
				String[] subjectcourseID=new String[1];
				String a1 = coursename_q1;
				subjectcourseID[0] = a1;
				String Q5 = service.selectcourse_Q5(subjectcourseID);
				return Q5;
	
			}
	// 我要報名
			@RequestMapping(value = "/selectcourse/A6", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String selectcourse_A6(@RequestParam(value = "CourseID") String CourseID) throws IOException, SQLException {
				
				String[] mycourseadd=new String[1]; 
				String a1 = CourseID;
				mycourseadd[0] = a1;
				String A6 = service.selectcourse_A6(mycourseadd);
				return A6;

			}
}

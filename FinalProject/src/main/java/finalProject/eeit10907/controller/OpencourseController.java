package finalProject.eeit10907.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import finalProject.eeit10907.service.OpencourseService;

//控制器
@Controller
@RequestMapping
public class OpencourseController {
	OpencourseService service;

	@Autowired
	public void setService(OpencourseService service) {
		this.service = service;
	}
	
	//新增學門
		@RequestMapping(value = "/opencourse/A1", produces = "application/json; charset=utf-8") 
		@ResponseBody
		public String selectcourse_A1(@RequestParam("subjectname_a1") String subjectname_a1,@RequestParam("subjectscore_a1") String subjectscore_a1) throws IOException, SQLException {

			String[] allSubjectValues1 = new String[2]; // 建立陣列
			String a1 = subjectname_a1;
			String a2 = subjectscore_a1;
			allSubjectValues1[0] = a1;
			allSubjectValues1[1] = a2;
			
			System.out.println(a1);
			System.out.println(a2);
			
			String A1 = service.selectcourse_A1(allSubjectValues1);
			return A1;
		}
		
	//新增課程
				@RequestMapping(value = "/opencourse/A2", produces = "application/json; charset=utf-8") 
				@ResponseBody
				public String selectcourse_A2(@RequestParam("subjectname_a2") String subjectname_a2,
												@RequestParam("coursename_a1") String coursename_a1,
												@RequestParam("coursecredits_a1") String coursecredits_a1,
												@RequestParam("starttime_a1") String starttime_a1,
												@RequestParam("endtime_a1") String endtime_a1,
												@RequestParam("courseroom_a1") String courseroom_a1,
												@RequestParam("coursesummary_a1") String coursesummary_a1,
												@RequestParam("signup_a1") String signup_a1) throws IOException, SQLException {

					String[] allSubjectValues2 = new String[9]; // 建立陣列
					String a1 = subjectname_a2;
					String a2 = coursename_a1;
					String a3 = coursecredits_a1;
					String a4 = starttime_a1;
					String a5 = endtime_a1;
					String a6 = courseroom_a1;
					String a7 = coursesummary_a1;
					String a8 = signup_a1;
					allSubjectValues2[7] = a8;
					allSubjectValues2[6] = a7;
					allSubjectValues2[5] = a6;
					allSubjectValues2[4] = a5;
					allSubjectValues2[3] = a4;
					allSubjectValues2[2] = a3;
					allSubjectValues2[1] = a2;
					allSubjectValues2[0] = a1;
					
					String A2 = service.selectcourse_A2(allSubjectValues2);
					return A2;
				}
				
		//下拉查詢學門
			@RequestMapping(value = "/opencourse/Q1", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String selectcourse_Q1()  throws IOException, SQLException {

				
				String Q1 = service.selectcourse_Q1();
				return Q1;
			}
			
	//下拉查詢教室
			@RequestMapping(value = "/opencourse/Q2", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String selectcourse_Q2()  throws IOException, SQLException {

				
				String Q2 = service.selectcourse_Q2();
				return Q2;
			}
	//下拉查詢教室人數
			@RequestMapping(value = "/opencourse/Q3", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String selectcourse_Q3(@RequestParam("courseroom_a1") String courseroom_a1)  throws IOException, SQLException {
				
				String a1 = courseroom_a1;
				
				String Q2 = service.selectcourse_Q3(courseroom_a1);
				return Q2;
			}
}

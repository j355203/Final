package finalProject.eeit10907.controller;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import finalProject.eeit10907.service.OpencourseallService;


@Controller
public class OpencourseallController {
	OpencourseallService service;

	@Autowired
	public void setService(OpencourseallService service) {
		this.service = service;
	}
	
	//下拉查詢學門
	@RequestMapping(value = "/opencourseall/Q1", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String opencourseall_Q1()throws IOException, SQLException {
		
		String Q1 = service.opencourseall_Q1();
		return Q1;
	}
	
	//下拉查詢課程
		@RequestMapping(value = "/opencourseall/Q2", produces = "application/json; charset=utf-8") 
		@ResponseBody
		public String opencourseall_Q2(@RequestParam(value = "subjectname_q3") String subjectname_q3)throws IOException, SQLException {
			String[] subjectID=new String[1]; 
			String a1 =subjectname_q3;
			subjectID[0] =a1 ;
			String Q2 = service.opencourseall_Q2(subjectID);
			return Q2;
		}
		
	//下拉第一個查學門細節
		@RequestMapping(value = "/opencourseall/Q3", produces = "application/json; charset=utf-8") 
		@ResponseBody
		public String opencourseall_Q3(@RequestParam(value = "subjectname_q2") String subjectname_q2)throws IOException, SQLException {
			String[] SubjectID=new String[1]; 
			String a1 =subjectname_q2;
			SubjectID[0] =a1 ;
			String Q3 = service.opencourseall_Q3(SubjectID);
			return Q3;
		}
		
	//學門總攬區
		@RequestMapping(value = "/opencourseall/Q4", produces = "application/json; charset=utf-8") 
		@ResponseBody
		public String opencourseall_Q4()throws IOException, SQLException {

			String Q4 = service.opencourseall_Q4();
			return Q4;
		}
	//下拉第二個學門  秀出課程總攬
			@RequestMapping(value = "/opencourseall/Q5", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String opencourseall_Q5(@RequestParam(value = "subjectname_q3") String subjectname_q3)throws IOException, SQLException {
				String[] SubjectID=new String[1]; 
				String a1 =subjectname_q3;
				SubjectID[0] =a1 ;
				String Q5 = service.opencourseall_Q5(SubjectID);
				return Q5;
			}
	//下拉第一個課程  秀出課程總攬
			@RequestMapping(value = "/opencourseall/Q6", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String opencourseall_Q6(@RequestParam(value = "coursename_q2") String coursename_q2)throws IOException, SQLException {
				String[] courseID=new String[1]; 
				String a1 =coursename_q2;
				courseID[0] =a1 ;
				String Q6 = service.opencourseall_Q6(courseID);
				return Q6;
			}
	//刪除學門
			@RequestMapping(value = "/opencourseall/D1", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String deleteSubject_D1(@RequestParam(value = "SubjectID") String SubjectID)throws IOException, SQLException {
				String[] SubjectIDD1=new String[1]; 
				String a1 =SubjectID;
				SubjectIDD1[0] =a1 ;
				String D1 = service.deleteSubject_D1(SubjectIDD1);
				return D1;
			}
	//刪除課程
			@RequestMapping(value = "/opencourseall/D2", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String deleteSubject_D2(@RequestParam(value = "CourseID") String CourseID)throws IOException, SQLException {
				String[] CourseIDD2=new String[1]; 
				String a1 =CourseID;
				CourseIDD2[0] =a1 ;
				String D2 = service.deleteSubject_D2(CourseIDD2);
				return D2;
			}
	//修改頁面所帶的資料(學門)
			@RequestMapping(value = "/opencourseall/U1", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String updatesubject_U1(@RequestParam(value = "SubjectID") String SubjectID)throws IOException, SQLException {
				String SubjectIU1=""; //建立陣列
				SubjectIU1 = SubjectID;
				
				String U1 = service.updatesubject_U1(SubjectIU1);
				return U1;
			}
	 //修改學門
			@RequestMapping(value = "/opencourseall/U2", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String updatesubject_U2(@RequestParam(value = "subjectname_a3") String subjectname_a3,
					@RequestParam(value = "subjectscore_a1") String subjectscore_a1,
					@RequestParam(value = "subjectID_a1") String subjectID_a1)throws IOException, SQLException {
				
				String a1 =subjectname_a3;
				String a2 =subjectscore_a1;
				String a3 =subjectID_a1;
				String[] SubjectIU2=new String[3]; //建立陣列1
				SubjectIU2[0] =a1;
				SubjectIU2[1] =a2;
				SubjectIU2[2] =a3;
				
				String U2 = service.updatesubject_U2(SubjectIU2);
				return U2;
			}
			
	//修改頁面所帶的資料(課程)
			@RequestMapping(value = "/opencourseall/U3", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String updatecourse_U3(@RequestParam(value = "CourseID") String CourseID)throws IOException, SQLException {
				String CourseIDU3=""; //建立陣列
				CourseIDU3 = CourseID;
				
				String U3 = service.updatecourse_U3(CourseIDU3);
				return U3;
			}
			
			
	//修改課程
			@RequestMapping(value = "/opencourseall/U4", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String updatecourse_U4(@RequestParam(value = "subjectID_a1") String subjectID_a1,
					@RequestParam(value = "courseID_a1") String courseID_a1,
					@RequestParam(value = "coursename_a1") String coursename_a1,
					@RequestParam(value = "coursecredits_a1") String coursecredits_a1,
					@RequestParam(value = "starttime_a1") String starttime_a1,
					@RequestParam(value = "endtime_a1") String endtime_a1,
					@RequestParam(value = "courseroomID_a1") String courseroomID_a1,
					@RequestParam(value = "courseroom_a1") String courseroom_a1,
					@RequestParam(value = "coursesummary_a1") String coursesummary_a1)throws IOException, SQLException {
				
				String a1 =subjectID_a1;
				String a2 =courseID_a1;
				String a3 =coursename_a1;
				String a4 =coursecredits_a1;
				String a5 =starttime_a1;
				String a6 =endtime_a1;
				String a7 =courseroomID_a1;
				String a8 =courseroom_a1;
				String a9 =coursesummary_a1;
				String[] CourseIDU4=new String[9]; //建立陣列1
				CourseIDU4[0] =a1;
				CourseIDU4[1] =a2;
				CourseIDU4[2] =a3;
				CourseIDU4[3] =a4;
				CourseIDU4[4] =a5;
				CourseIDU4[5] =a6;
				CourseIDU4[6] =a7;
				CourseIDU4[7] =a8;
				CourseIDU4[8] =a9;

				
				String U4 = service.updatecourse_U4(CourseIDU4);
				return U4;
			}
	//課程詳細資料
			@RequestMapping(value = "/opencourseall/Q7", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String opencourseall_Q7(@RequestParam(value = "CourseID") String CourseID)throws IOException, SQLException {
				String[] CourseIDQ7=new String[1]; //建立陣列
				String a1 =CourseID;
				CourseIDQ7[0] = a1;
				
				String Q7 = service.opencourseall_Q7(CourseIDQ7);
				return Q7;
			}
	//有選課的人
			@RequestMapping(value = "/opencourseall/Q8", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String opencourseall_Q8(@RequestParam(value = "CourseID") String CourseID)throws IOException, SQLException {
				String[] CourseIDQ8=new String[1]; //建立陣列
				String a1 =CourseID;
				CourseIDQ8[0] = a1;
				
				String Q8 = service.opencourseall_Q8(CourseIDQ8);
				return Q8;
			}
	

	//有選課的人
			@RequestMapping(value = "/opencourseall/Q10", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String opencourseall_Q10()throws IOException, SQLException {
			
				String Q10 = service.opencourseall_Q10();
				return Q10;
			}
			
	//有選課的人
			@RequestMapping(value = "/opencourseall/Q9", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String opencourseall_Q9(@RequestParam(value = "CourseID") String CourseID,@RequestParam(value = "SubjectID") String SubjectID)throws IOException, SQLException {
				String[] CourseIDQ9=new String[2]; //建立陣列
				String a1 =CourseID;
				String a2 =SubjectID;
				CourseIDQ9[0] = a1;
				CourseIDQ9[1] = a2;
				String Q9 = service.opencourseall_Q9(CourseIDQ9);
				return Q9;
			}	
				
}

package finalProject.eeit10907.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import finalProject.eeit10907.service.TitleService;

@Controller
public class TitleController {

	TitleService service;

	@Autowired
	public void setService(TitleService service) {
		this.service = service;
	}
	
	//新增職稱學門
	@RequestMapping(value = "/title/A1", produces = "application/json; charset=utf-8") 
	@ResponseBody
	public String title_A1(@RequestParam(value = "titleno_a1") String titleno_a1,@RequestParam(value = "titlename_a1") 
	String titlename_a1,@RequestParam(value = "subjectt1_a1") String subjectt1_a1,@RequestParam(value = "subjectt2_a1") 
	String subjectt2_a1,@RequestParam(value = "subjectt3_a1") String subjectt3_a1)throws IOException, SQLException {
		
		String[] allTitle1=new String[3]; //建立陣列1
		String a1 =titleno_a1;
		String a2 =titlename_a1;
		String a3 =subjectt1_a1;
		String a4 =subjectt2_a1;
		String a5 =subjectt3_a1;
		allTitle1[2] = a1;
		allTitle1[1] = a2;
		allTitle1[0] = a3+";"+a4+";"+a5;
		
		String A1 = service.title_A1(allTitle1);
		return A1;
	}
	
	//下拉查詢學門
			@RequestMapping(value = "/title/Q1", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String title_Q1()throws IOException, SQLException {
				
				String Q1 = service.title_Q1();
				return Q1;
	}
    //下拉查詢職稱代號
			@RequestMapping(value = "/title/Q2", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String title_Q2()throws IOException, SQLException {
				
				String Q2 = service.title_Q2();
				return Q2;
	}
	//下拉查詢職稱名稱
			@RequestMapping(value = "/title/Q3", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String title_Q3()throws IOException, SQLException {
				
				String Q3 = service.title_Q3();
				return Q3;
	}
	// 職稱代號   送出秀出    職稱代號 總攬
			@RequestMapping(value = "/title/Q4", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String title_Q4(@RequestParam(value = "titleno_q1") String titleno_q1)throws IOException, SQLException {
				
				String[] titlenoID=new String[1]; 
				String a1 =titleno_q1;
				titlenoID[0] = a1;
				String Q4 = service.title_Q4(titlenoID);
				return Q4;
	}		
		
	// 職稱名稱   送出秀出    職稱代號 總攬
			@RequestMapping(value = "/title/Q5", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String title_Q5(@RequestParam(value = "titlename_q1") String titlename_q1)throws IOException, SQLException {
				
				String[] titlenoID=new String[1]; 
				String a1 =titlename_q1;
				titlenoID[0] = a1;
				String Q5 = service.title_Q5(titlenoID);
				return Q5;
	}
	// 總攬區
				@RequestMapping(value = "/title/Q6", produces = "application/json; charset=utf-8") 
				@ResponseBody
				public String title_Q6()throws IOException, SQLException {
					
					String Q6 = service.title_Q6();
					return Q6;
	}
	//刪除職稱學門
				@RequestMapping(value = "/title/D1", produces = "application/json; charset=utf-8") 
				@ResponseBody
				public String title_D1(@RequestParam(value = "TitleID") String TitleID)throws IOException, SQLException {
					
					String[] TitleIDD1=new String[1];
					String a1 =TitleID;
					TitleIDD1[0] = a1;
					String D1 = service.title_D1(TitleIDD1);
					return D1;
					
				}			
	//修改頁面所帶的資料
					@RequestMapping(value = "/title/Q7", produces = "application/json; charset=utf-8") 
					@ResponseBody
					public String updatetitle_Q7(@RequestParam(value = "TitleID") String TitleID)throws IOException, SQLException {
						
						String[] TitleIDQ7=new String[1];
						String a1 =TitleID;
						TitleIDQ7[0] = a1;
						String Q7 = service.updatetitle_Q7(TitleIDQ7);
						return Q7;
					
	}
					
		//修改頁面所帶的資料
					@RequestMapping(value = "/title/U1", produces = "application/json; charset=utf-8") 
					@ResponseBody
					public String updatetitle_U1(@RequestParam(value = "titleno_a1") String titleno_a1,
							@RequestParam(value = "titlename_a1") String titlename_a1,
							@RequestParam(value = "subjectt1_a1") String subjectt1_a1,
							@RequestParam(value = "subjectt2_a1") String subjectt2_a1,
							@RequestParam(value = "subjectt3_a1") String subjectt3_a1,
							@RequestParam(value = "titleID_a1") String titleID_a1)throws IOException, SQLException {
						String[] upTitle=new String[4]; //建立陣列1
						String a1 =titleno_a1;
						String a2 =titlename_a1;
						String a3 =subjectt1_a1;
						String a4 =subjectt2_a1;
						String a5 =subjectt3_a1;
						String a6 =titleID_a1;
					
						upTitle[0] =a1;
						upTitle[1] =a2;
						upTitle[2] =a3+";"+a4+";"+a5;
						upTitle[3] =a6;
						String U1 = service.updatetitle_U1(upTitle);
						return U1;
					
	}	
	
			
}

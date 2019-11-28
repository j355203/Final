package finalProject.eeit10907.controller;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import finalProject.eeit10907.service.EmployeeService;



@Controller
public class LEmployeeController {
	
	EmployeeService service;

	@Autowired
	public void setService(EmployeeService service) {
		this.service = service;
	}
	
	
	//用員編查詢
		@RequestMapping(value = "/employee/Q1", produces = "application/json; charset=utf-8") 
		@ResponseBody
		public String Employee_Q1(@RequestParam(value = "empid") String empid)throws IOException, SQLException {
			
			String[] empidQ1=new String[1]; //建立陣列1
			String a1 =empid;
			empidQ1[0] = a1;

			String Q1 = service.Employee_Q1(empidQ1);
			return Q1;
		}
		
	//用名稱查詢
			@RequestMapping(value = "/employee/Q2", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String Employee_Q2(@RequestParam(value = "empname") String empname)throws IOException, SQLException {
				
				String[] empnameQ2=new String[1]; //建立陣列1
				String a1 =empname;
				empnameQ2[0] = a1;

				String Q2 = service.Employee_Q2(empnameQ2);
				return Q2;
			}
			
			
	//未設定區	
			@RequestMapping(value = "/employee/Q3", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String Employee_Q3()throws IOException, SQLException {
				
				String Q3 = service.Employee_Q3();
				return Q3;
			}
	//修改頁面所帶的資料
			@RequestMapping(value = "/employee/U1", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String Employee_U1(@RequestParam(value = "empid") String empid)throws IOException, SQLException {
				
				String empidU1=""; //建立陣列
				String a1 =empid;
				empidU1 = a1;
		
				String U1 = service.Employee_U1(empidU1);
				return U1;
			}
	//修改 個人資料
			@RequestMapping(value = "/employee/U2", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String Employee_U2(@RequestParam(value = "employeeid_i1") String employeeid_i1,@RequestParam(value = "titleno_i2") String titleno_i2)throws IOException, SQLException {
				

				String[] upemp=new String[2]; //建立陣列1
				String a1 =employeeid_i1;
				String a2 =titleno_i2;
				upemp[0] =a1;
				upemp[1] =a2;
				String U2 = service.Employee_U2(upemp);
				return U2;
			}
	//選課紀錄
			@RequestMapping(value = "/employee/Q4", produces = "application/json; charset=utf-8") 
			@ResponseBody
			public String Employee_Q4(@RequestParam(value = "empid") String empid)throws IOException, SQLException {
				

				String[] empidQ4 = new String[1];
				String a1 = empid;
				System.out.println(a1);
				empidQ4[0] = a1;
				String Q4 = service.Employee_Q4(empidQ4);
				return Q4;
			}
}


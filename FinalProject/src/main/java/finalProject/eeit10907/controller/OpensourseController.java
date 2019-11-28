package finalProject.eeit10907.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import finalProject.eeit10907.service.OpensourseService;

//控制器
@Controller

public class OpensourseController {
	OpensourseService service;

	@Autowired
	public void setService(OpensourseService service) {
		this.service = service;
	}
	
	
	//修改公告一
	@PostMapping(value="/opensourse/U1")
	public String opensourse_U1(@RequestParam("file") MultipartFile file) throws IOException, SQLException{
		MultipartFile a1 =file;
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		Date date = new Date();
		String strDate = sdFormat.format(date);
		String file_name = strDate+"-"+file.getOriginalFilename();

		String url_file = "../photo/"+file_name;
		System.out.print(file_name);
		
		if (!file.getOriginalFilename().isEmpty()) {
			  String A1 = service.opensourse_U1_T(file_name,url_file);
		      BufferedOutputStream outputStream = new BufferedOutputStream(
		            new FileOutputStream(
		                  new File("D:/upFiles",file_name ))); // 上傳檔案位置為D:\
		      outputStream.write(file.getBytes());
		      outputStream.flush();
		      outputStream.close();
		      
		    }else{
			  System.out.print("fail");
		      return "fail";
		    }
		return "{'TFMark':'true','Msg':'upload success !'}";
	}
	
	//上傳公告一的標題 內容
	@RequestMapping(value = "/opensourse/U2", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String opensourse_U2( @RequestParam(value = "bullname") String bullname,@RequestParam(value = "bullsum") String bullsum) throws SQLException {


		String [] bullsU2 = new String[2]; // 建立陣列
		String a1 = bullname;
		String a2 = bullsum;
		bullsU2[0] = a1;
		bullsU2[1] = a2;

		String U2 = service.opensourse_U2_T(bullsU2);
		return U2;
	}
	
	//修改公告二
		@PostMapping(value="/opensourse/U3")
		public String opensourse_U3(@RequestParam("file") MultipartFile file) throws IOException, SQLException{
			MultipartFile a1 =file;
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
			Date date = new Date();
			String strDate = sdFormat.format(date);
			String file_name = strDate+"-"+file.getOriginalFilename();

			String url_file = "../photo/"+file_name;
			System.out.print(file_name);
			
			if (!file.getOriginalFilename().isEmpty()) {
				  String A1 = service.opensourse_U3_T(file_name,url_file);
			      BufferedOutputStream outputStream = new BufferedOutputStream(
			            new FileOutputStream(
			                  new File("D:/upFiles",file_name ))); // 上傳檔案位置為D:\
			      outputStream.write(file.getBytes());
			      outputStream.flush();
			      outputStream.close();
			      
			    }else{
				  System.out.print("fail");
			      return "fail";
			    }
			return "{'TFMark':'true','Msg':'upload success !'}";
		}
		
		//上傳公告二的標題 內容
		@RequestMapping(value = "/opensourse/U4", produces = "application/json; charset=utf-8")
		@ResponseBody
		public String opensourse_U4( @RequestParam(value = "bullname") String bullname,@RequestParam(value = "bullsum") String bullsum) throws SQLException {


			String [] bullsU2 = new String[2]; // 建立陣列
			String a1 = bullname;
			String a2 = bullsum;
			bullsU2[0] = a1;
			bullsU2[1] = a2;

			String U2 = service.opensourse_U4_T(bullsU2);
			return U2;
		}
		
		
		//上傳影片內容
		@RequestMapping(value = "/opensourse/U5", produces = "application/json; charset=utf-8")
		@ResponseBody
		public String opensourse_U5(@RequestParam(value = "check") String check,@RequestParam(value = "moviename") String moviename,
									@RequestParam(value = "moviesum") String moviesum,
									@RequestParam(value = "movieurl") String movieurl) throws SQLException {


			String [] movU5 = new String[4]; // 建立陣列
			movU5[0] = check;
			movU5[1] = moviename;
			movU5[2] = moviesum;
			movU5[3] = movieurl;
			
			System.out.println(movU5[0]);
			System.out.println(movU5[1]);
			System.out.println(movU5[2]);
			System.out.println(movU5[3]);
			
			String U5 = service.opensourse_U5_T(movU5);
			return U5;
		}
				
		

		
		
		
				
				
}

package finalProject.eeit10907.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import finalProject.eeit10907.service.OpensourseService;

//控制器
@Controller

public class Opensourse2Controller {
	OpensourseService service;

	@Autowired
	public void setService(OpensourseService service) {
		this.service = service;
	}
	
	
	
		
		
		//上傳影片內容
		@RequestMapping(value = "/opensourse2/U5", produces = "application/json; charset=utf-8")
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
				
		
		
		
		
		
		//上傳檔案java
		@PostMapping(value="/opensourse2/download1")
		public String opensourse2_download_file(@RequestParam("file") MultipartFile file) throws IOException, SQLException{
			MultipartFile a1 =file;
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
			Date date = new Date();
			String strDate = sdFormat.format(date);
			String file_name = strDate+"-"+file.getOriginalFilename();
			
			String a=file.getOriginalFilename();
			String [] aa=a.split("\\.");
			String file_name_t =aa[0];
			
			String url_file = "../download/"+file_name;
			System.out.print(file_name);
			
			if (!file.getOriginalFilename().isEmpty()) {
				
				  String A1 = service.opensourse_download_file(file_name_t,url_file);
			      BufferedOutputStream outputStream = new BufferedOutputStream(
			            new FileOutputStream(
			                  new File("D:/download",file_name ))); // 上傳檔案位置為D:\
			      outputStream.write(file.getBytes());
			      outputStream.flush();
			      outputStream.close();
			      
			    }else{
				  System.out.print("fail");
			      return "fail";
			    }
			return "{'TFMark':'true','Msg':'upload success !'}";
		}
		
		
		//上傳檔案SQL
		@PostMapping(value="/opensourse2/download2")
		public String opensourse2_download_file2(@RequestParam("file") MultipartFile file) throws IOException, SQLException{
			MultipartFile a1 =file;
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
			Date date = new Date();
			String strDate = sdFormat.format(date);
			String file_name = strDate+"-"+file.getOriginalFilename();
			
			String a=file.getOriginalFilename();
			String [] aa=a.split("\\.");
			String file_name_t =aa[0];
			
			String url_file = "../download/"+file_name;
			System.out.print(file_name);
			
			if (!file.getOriginalFilename().isEmpty()) {
				
				  String A1 = service.opensourse_download_file2(file_name_t,url_file);
			      BufferedOutputStream outputStream = new BufferedOutputStream(
			            new FileOutputStream(
			                  new File("D:/download",file_name ))); // 上傳檔案位置為D:\
			      outputStream.write(file.getBytes());
			      outputStream.flush();
			      outputStream.close();
			      
			    }else{
				  System.out.print("fail");
			      return "fail";
			    }
			return "{'TFMark':'true','Msg':'upload success !'}";
		}
	
		
		
		
		
		
		
				
				
}

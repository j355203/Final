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

import finalProject.eeit10907.service.SourseService;

//控制器
@Controller

public class SourseController {
	SourseService service;

	@Autowired
	public void setService(SourseService service) {
		this.service = service;
	}
	
	//查詢檔案

		@RequestMapping(value = "/sourse/Q1", produces = "application/json; charset=utf-8")
		@ResponseBody
		public String soursefile_Q1( @RequestParam(value = "UpFileID") String UpFileID) throws SQLException, IOException {


			String a1 = UpFileID;
			System.out.print(UpFileID);
			String Q1 = service.soursefile_Q1(a1);
			return Q1;
		}
		
	//查詢影片
		@RequestMapping(value = "/sourse/Q2", produces = "application/json; charset=utf-8")
		@ResponseBody
		public String soursemovie_Q2() throws SQLException, IOException {


			String Q2 = service.soursemovie_Q2();
			return Q2;
		}
		
				
}

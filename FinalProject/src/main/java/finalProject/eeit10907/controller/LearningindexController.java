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

import finalProject.eeit10907.service.LearningindexService;


//控制器
@Controller
@RequestMapping
public class LearningindexController {
	LearningindexService  service;

	@Autowired
	public void setService(LearningindexService service) {
		this.service = service;
	}
	
	//顯示公告一
		@RequestMapping(value="/learningindex/Q1", produces = "application/json; charset=utf-8")
		@ResponseBody
		public String learningindex_Q1() throws IOException, SQLException{
			String Q1 = service.learningindex_Q1();
			return Q1;
		}
		
	//顯示公告二
		@RequestMapping(value="/learningindex/Q2", produces = "application/json; charset=utf-8")
		@ResponseBody
		public String learningindex_Q2() throws IOException, SQLException{
			String Q2 = service.learningindex_Q2();
			return Q2;
		}
	
}

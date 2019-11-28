package finalProject.eeit10907.service.imp;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import finalProject.eeit10907.dao.MycourseDao;
import finalProject.eeit10907.model.CourseBean;
import finalProject.eeit10907.service.MycourseService;

@Service
@Transactional
public class MycourseServiceImp implements MycourseService {
	
	MycourseDao dao;

    
	@Autowired
	public void setDao(MycourseDao dao) {
		this.dao = dao;
	}

	
    
	@Override  //查詢以選課程
	public String mycourse_Q1(int empid) throws IOException, SQLException {
		return dao.mycourse_Q1(empid);
		
	}
	@Override  //查詢課程詳細資料
	public String mycourse_Q2(String[] mycourseQ2) throws IOException, SQLException {
		return dao.mycourse_Q2(mycourseQ2);
	}
	
    
	@Override  //取消報名
	public String deleteMycourse(int[] mycourseD1) throws SQLException {
		return dao.deleteMycourse(mycourseD1);
	}
	
	
	@Override  //查詢學分
	public String mycourse_Q3(int empid) throws IOException, SQLException {
		return dao.mycourse_Q3(empid);
	}
	
	
	
	@Override  //查詢滿意度
	public String mycourse_Q4(String[] mycourseD2) throws IOException, SQLException {
		return dao.mycourse_Q4(mycourseD2);
	}
	
	
	
	@Override  //新增滿意度
	public String mycourse_I1(String[] mycoursestis) throws IOException, SQLException {
		return dao.mycourse_I1(mycoursestis);
	}
	
	
	
	@Override  //查詢課程詳細資料
	public CourseBean mycourse_Q5(int CourseID) throws IOException, SQLException {
		return dao.mycourse_Q5(CourseID);
	}
	
	

	

}
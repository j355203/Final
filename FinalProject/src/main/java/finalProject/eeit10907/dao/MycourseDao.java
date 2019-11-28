package finalProject.eeit10907.dao;

import java.io.IOException;
import java.sql.SQLException;



import finalProject.eeit10907.model.CourseBean;

public interface MycourseDao {

	

	//我的課程
	public String mycourse_Q1(int empid) throws IOException, SQLException; //查詢以選課程
	public String deleteMycourse(int[] mycourseD1) throws SQLException;  //取消報名
	public String mycourse_Q2(String[] mycourseQ2) throws IOException, SQLException; //查詢課程詳細資料
	public String mycourse_Q3(int empid) throws IOException, SQLException; //查詢學分
	public String mycourse_Q4(String[] mycourseD2) throws IOException, SQLException; //查詢滿意度
	public String mycourse_I1(String[] mycoursestis) throws IOException, SQLException; //新增滿意度
	public CourseBean mycourse_Q5(int CourseID) throws IOException, SQLException; //查詢課程詳細資料

	

	
}

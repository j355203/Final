package finalProject.eeit10907.service;

import java.io.IOException;
import java.sql.SQLException;



public interface OpencourseService {
	public String selectcourse_A1(String[] allSubjectValues1) throws  IOException, SQLException; //新增學門
	public String selectcourse_A2(String[] allSubjectValues2) throws  IOException, SQLException; //新增課程
	public String selectcourse_Q1() throws IOException, SQLException; //下拉查詢學門
	public String selectcourse_Q2() throws IOException, SQLException; //下拉查詢教室
	public String selectcourse_Q3(String courseroom_a1) throws IOException, SQLException; //下拉查詢教室人數
//  用 javabean 	public SubjectBean selectcourse_A3(SubjectBean sb) throws  IOException, SQLException; //新增學門
}

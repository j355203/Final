package finalProject.eeit10907.service;

import java.io.IOException;
import java.sql.SQLException;

public interface OpencourseallService {
	public String opencourseall_Q1() throws IOException, SQLException; //下拉查詢學門
	public String opencourseall_Q2(String[] subjectID) throws IOException, SQLException; //下拉查詢課程
	public String opencourseall_Q3(String[] subjectID) throws IOException, SQLException; //下拉第一個查學門細節
	public String opencourseall_Q4() throws IOException, SQLException; //學門總攬
	public String opencourseall_Q5(String[] subjectID) throws IOException, SQLException; //下拉第二個學門  秀出課程總攬
	public String opencourseall_Q6(String[] courseID) throws IOException, SQLException; //下拉第一個課程  秀出課程總攬
	public String deleteSubject_D1(String[] SubjectIDD1) throws IOException, SQLException; //刪除學門
	public String deleteSubject_D2(String[] CourseIDD2) throws IOException, SQLException; //刪除課程
	//--換藥要寫的↓

	public String updatesubject_U1(String SubjectIU1) throws SQLException; //修改頁面所帶的資料(學門)
	public String updatesubject_U2(String[] SubjectIU2) throws SQLException; //修改學門
	public String updatecourse_U3(String CourseIDU3) throws SQLException; //修改頁面所帶的資料(課程)
	public String updatecourse_U4(String[] CourseIDU4) throws SQLException; //修改課程
	public String opencourseall_Q10() throws IOException, SQLException; //課程總攬
	
	public String opencourseall_Q7(String[] CourseIDQ7) throws IOException, SQLException; //課程詳細資料
	public String opencourseall_Q8(String[] CourseIDQ8) throws IOException, SQLException; //有選課的人
	public String opencourseall_Q9(String[] CourseIDQ9) throws IOException, SQLException; //課程總體滿意度

	
	
}

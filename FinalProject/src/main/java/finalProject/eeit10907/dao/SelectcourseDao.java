package finalProject.eeit10907.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface SelectcourseDao {

	public String selectcourse_Q1() throws IOException, SQLException; //下拉學門
	public String selectcourse_Q2(String[] subjectcourseID) throws IOException, SQLException; //用學門查 全部課程
	public String selectcourse_Q3(String[] subjectcourseID) throws IOException, SQLException; //下拉課程
	public String selectcourse_Q4() throws IOException, SQLException; //課程總攬
	public String selectcourse_Q5(String[] subjectcourseID) throws IOException, SQLException; //用課程查 全部課程
	public String selectcourse_A6(String[] mycourseadd) throws IOException, SQLException; // 我要報名

	
}

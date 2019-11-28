package finalProject.eeit10907.service;

import java.io.IOException;
import java.sql.SQLException;

public interface EmployeeService {
	public void updateTitle() throws SQLException; //未使用
	public void deleteTitle() throws SQLException; //未使用
	public String Employee_Q1(String[] empidQ1) throws  IOException, SQLException; //用員編查詢
	public String Employee_Q2(String[] empnameQ2) throws  IOException, SQLException; //用名稱查詢
	public String Employee_Q3() throws  IOException, SQLException; //未設定區
	public String Employee_Q4(String[] empidQ4) throws  IOException, SQLException; //選課紀錄
	public String Employee_U1(String empidU1) throws SQLException; //修改頁面所帶的資料
	public String Employee_U2(String []upemp) throws SQLException; //修改 個人資料
}

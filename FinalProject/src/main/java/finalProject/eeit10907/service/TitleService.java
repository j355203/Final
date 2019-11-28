package finalProject.eeit10907.service;

import java.io.IOException;
import java.sql.SQLException;

public interface TitleService {
	public String title_A1(String[] allTitle1) throws  IOException, SQLException; //新增職稱學門
	public String title_Q1() throws IOException, SQLException; //下拉查詢學門
	public String title_Q2() throws IOException, SQLException; //下拉查詢職稱代號
	public String title_Q3() throws IOException, SQLException; //下拉查詢職稱名稱
	public String title_Q4(String[] titlenoID) throws IOException, SQLException; // 職稱代號   送出秀出    職稱代號 總攬
	public String title_Q5(String[] titlenoID) throws IOException, SQLException; // 職稱名稱   送出秀出    職稱代號 總攬
	public String title_Q6() throws IOException, SQLException; // 學門職稱總攬
	public String title_D1(String[] TitleID) throws SQLException; //刪除職稱學門
	public String updatetitle_Q7(String[] titleIDQ7) throws SQLException; //修改頁面所帶的資料
	public String updatetitle_U1(String[] upTitle) throws SQLException; //修改頁面所帶的資料
}

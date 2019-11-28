package finalProject.eeit10907.service;

import java.io.IOException;
import java.sql.SQLException;

public interface LearningindexService {
	//首頁
	public String learningindex_Q1() throws IOException, SQLException; //查詢公告一
	public String learningindex_Q2() throws IOException, SQLException; //查詢公告二
}

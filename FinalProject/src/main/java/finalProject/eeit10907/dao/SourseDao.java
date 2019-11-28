package finalProject.eeit10907.dao;

import java.io.IOException;
import java.sql.SQLException;

public interface SourseDao {
	//開放資源
		public String soursefile_Q1(String a1) throws IOException, SQLException; //查詢檔案
		public String soursemovie_Q2() throws IOException, SQLException; //查詢影片

}

package finalProject.eeit10907.dao.imp;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalProject.eeit10907.dao.SourseDao;
import net.sf.json.JSONArray;
@Repository
public class SourseDaoImp implements SourseDao {
	 DataSource  dataSource;
	 @Autowired
	 public void setDataSource(DataSource  dataSource) {
		 this.dataSource=dataSource;
	 }
	@Override  //查詢檔案java.sql
	public String soursefile_Q1(String a1) throws IOException, SQLException {

			List<Map> listMap = new ArrayList<Map>();
			try {
				String qryStmt = "SELECT UpFileID,UpFileName,UpFileURL FROM LupFile where UpFileID=?";
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
				stmt.setString(1, a1);
				
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					Map<String, String> map = new HashMap<String, String>();
					String UpFileName = rs.getString("UpFileName");
					String UpFileURL = rs.getString("UpFileURL");
					
					
					map.put("UpFileName", UpFileName);
					map.put("UpFileURL", UpFileURL);
					listMap.add(map);
				}
				
				JSONArray ja2 = JSONArray.fromObject(listMap);
				rs.close();
				stmt.close();
				conn.close();
				return ja2.toString();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return null;
	}
	@Override  	//查詢影片
	public String soursemovie_Q2() throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT * FROM LupMovie";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String UpMovieName = rs.getString("UpMovieName");
				String UpMovieSum = rs.getString("UpMovieSum");
				String UpMovieURL = rs.getString("UpMovieURL");
				map.put("UpMovieName", UpMovieName);
				map.put("UpMovieSum", UpMovieSum);
				map.put("UpMovieURL", UpMovieURL);
				listMap.add(map);
			}
			
			JSONArray ja2 = JSONArray.fromObject(listMap);
			rs.close();
			stmt.close();
			conn.close();
			return ja2.toString();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	


}

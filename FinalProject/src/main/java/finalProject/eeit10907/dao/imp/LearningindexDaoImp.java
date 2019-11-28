package finalProject.eeit10907.dao.imp;

import java.io.IOException;
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

import finalProject.eeit10907.dao.LearningindexDao;
import net.sf.json.JSONArray;


@Repository
public class LearningindexDaoImp implements LearningindexDao {
	
	DataSource  dataSource;
	 @Autowired
	 public void setDataSource(DataSource  dataSource) {
		 this.dataSource=dataSource;
	 }
	 
	 
	 

	@Override
	public String learningindex_Q1() throws IOException, SQLException {
		
		
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT * FROM LupIndex where UpbullID='T1'";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String UpbullID = rs.getString("UpbullID");
				String UpbullName = rs.getString("UpbullName");
				String UpbullSum = rs.getString("UpbullSum");
				String UpbullImg = rs.getString("UpbullImg");
				String UpbullImgUrl = rs.getString("UpbullImgUrl");

				map.put("UpbullID", UpbullID);
				map.put("UpbullName", UpbullName);
				map.put("UpbullSum", UpbullSum);
				map.put("UpbullImg", UpbullImg);
				map.put("UpbullImgUrl", UpbullImgUrl);

				
				
				System.out.println(UpbullID);
				System.out.println(UpbullName);
				System.out.println(UpbullSum);
				System.out.println(UpbullImg);
				System.out.println(UpbullImgUrl);
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



	@Override  //查詢公告二
	public String learningindex_Q2() throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT * FROM LupIndex where UpbullID='T2'";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();
			
			
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String UpbullID = rs.getString("UpbullID");
				String UpbullName = rs.getString("UpbullName");
				String UpbullSum = rs.getString("UpbullSum");
				String UpbullImg = rs.getString("UpbullImg");
				String UpbullImgUrl = rs.getString("UpbullImgUrl");

				map.put("UpbullID", UpbullID);
				map.put("UpbullName", UpbullName);
				map.put("UpbullSum", UpbullSum);
				map.put("UpbullImg", UpbullImg);
				map.put("UpbullImgUrl", UpbullImgUrl);

				
				
				System.out.println(UpbullID);
				System.out.println(UpbullName);
				System.out.println(UpbullSum);
				System.out.println(UpbullImg);
				System.out.println(UpbullImgUrl);
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

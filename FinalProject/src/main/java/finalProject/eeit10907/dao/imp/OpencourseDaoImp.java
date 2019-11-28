package finalProject.eeit10907.dao.imp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import finalProject.eeit10907.dao.OpencourseDao;
import finalProject.eeit10907.model.opencourseBean;
import net.sf.json.JSONArray;



@Repository
public class OpencourseDaoImp implements OpencourseDao {
	DataSource  dataSource;
	 @Autowired
	 public void setDataSource(DataSource  dataSource) {
		 this.dataSource=dataSource;
	 }
	 
	 opencourseBean opencourBean;
	
	 
	 
	 @Override  //新增學門
	public String selectcourse_A1(String[] allSubjectValues1) throws  IOException, SQLException 
	{
	
		try 
		{
			String sqlstr = "insert into  Subject (SubjectName,SubjectScore) values(?,?)";
			Connection conn=dataSource.getConnection();
			PreparedStatement state = conn.prepareStatement(sqlstr);
			state.setString(1, allSubjectValues1[0]);
			state.setString(2, allSubjectValues1[1]);
			state.executeUpdate();
			state.close();
			conn.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	 
	 
	@Override  //新增課程
	public String selectcourse_A2(String[] allSubjectValues2) throws IOException, SQLException {
	
		try 
		{
			
			String qryStmt = "    select Subject.SubjectID,Subject.SubjectName\r\n" + 
					"					 from Subject \r\n" + 
					"					where SubjectID=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, allSubjectValues2[0]);
			System.out.println(allSubjectValues2[0]);
			ResultSet rs = stmt.executeQuery();
			
			String SubjectName="";
			while (rs.next()) {
				SubjectName = rs.getString("SubjectName");
				System.out.println(SubjectName);
			}
			
			
			
			String qryStmt2 = " select Room.RoomID,Room.RoomName\r\n" + 
						      " from Room \r\n" + 
						      " where RoomID=?";
			PreparedStatement stmt2 = conn.prepareStatement(qryStmt2);
			stmt2.setString(1, allSubjectValues2[5]);
			System.out.println(allSubjectValues2[5]);
			ResultSet rs2 = stmt2.executeQuery();
			
			String RoomName="";
			while (rs2.next()) {
				RoomName = rs2.getString("RoomName");
				System.out.println(RoomName);
			}
			rs2.close();
			stmt2.close();
			
			
			String sqlstr = "insert into  Course(SubjectID,SubjectName,CourseName,StartDateTime,"
						  + "EndDateTime,RoomID,RoomName,SignUp,CourseSummary,Credits) values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement state = conn.prepareStatement(sqlstr);
			
			state.setInt(1, Integer.parseInt(allSubjectValues2[0]));//SubjectID
			state.setString(2, SubjectName);//SubjectName
			state.setString(3, allSubjectValues2[1]);//CourseName
			
			

			System.out.println(allSubjectValues2[3]);
			
			String dateString =allSubjectValues2[3];//欲轉換的日期字串
			dateString = dateString.replace('T',' ');

			state.setString(4,dateString);//StartDateTime
			
			String dateString2 =allSubjectValues2[4];//欲轉換的日期字串
			dateString2 = dateString2.replace('T',' ');

			state.setString(5,dateString2 );//EndDateTime
			state.setString(6, allSubjectValues2[5]);//RoomID
			state.setString(7, RoomName);//RoomName
			state.setString(8, allSubjectValues2[7]); //SignUp
			state.setString(9, allSubjectValues2[6]);//CourseSummary
			state.setString(10, allSubjectValues2[2]);//Credits

			
			state.executeUpdate();
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override   //下拉查詢-學門
	public String selectcourse_Q1() throws IOException, SQLException
	{
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT SubjectID,SubjectName FROM Subject";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();

			

			while (rs.next()) 
			{
				Map<String,String> map = new HashMap<String,String>();
				String SubjectID = rs.getString("SubjectID");
			    String SubjectName = rs.getString("SubjectName");
			    map.put("SubjectID", SubjectID);
	            map.put("SubjectName", SubjectName);
	            listMap.add(map);

			}
			JSONArray ja2 = JSONArray.fromObject(listMap);
			System.out.println(ja2.toString());
			rs.close();
			stmt.close();
			conn.close();
			return ja2.toString();
			
		} catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override //教室下拉
	public String selectcourse_Q2() throws IOException, SQLException
	{
		
		
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT RoomID,RoomName,RoomSize FROM Room";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
	
			ResultSet rs = stmt.executeQuery();

		

			while (rs.next()) 
			{
				Map<String,String> map = new HashMap<String,String>();
				String RoomID = rs.getString("RoomID");
			    String RoomName = rs.getString("RoomName");
			    String RoomSize = rs.getString("RoomSize");
			    map.put("RoomID", RoomID);
	            map.put("RoomName", RoomName);
	            map.put("RoomSize", RoomSize);
	            listMap.add(map);

			}
			JSONArray ja2 = JSONArray.fromObject(listMap);
			System.out.println(ja2.toString());
			rs.close();
			stmt.close();
			conn.close();
			return ja2.toString();
			
		} catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return null;
	}


	@Override  //教室下拉人數
	public String selectcourse_Q3(String courseroom_a1) {

		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT RoomID,RoomName,RoomSize FROM Room where RoomID=? ";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, courseroom_a1);
			ResultSet rs = stmt.executeQuery();

		

			while (rs.next()) 
			{
				Map<String,String> map = new HashMap<String,String>();
				String RoomID = rs.getString("RoomID");
			    String RoomName = rs.getString("RoomName");
			    String RoomSize = rs.getString("RoomSize");
			    map.put("RoomID", RoomID);
	            map.put("RoomName", RoomName);
	            map.put("RoomSize", RoomSize);
	            listMap.add(map);

			}
			JSONArray ja2 = JSONArray.fromObject(listMap);
			System.out.println(ja2.toString());
			rs.close();
			stmt.close();
			conn.close();
			return ja2.toString();
			
		} catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return null;
	}
}

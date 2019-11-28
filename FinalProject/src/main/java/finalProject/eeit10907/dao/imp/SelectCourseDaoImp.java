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

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10907.dao.SelectcourseDao;
import net.sf.json.JSONArray;

@Repository
public class SelectCourseDaoImp implements SelectcourseDao {

//	SessionFactory factory;

//	@Autowired
//	public void setFactory(SessionFactory factory) {
//		this.factory = factory;
//	}
	
	 DataSource  dataSource;
	 @Autowired
	 public void setDataSource(DataSource  dataSource) {
		 this.dataSource=dataSource;
	 }
	 

	@Override // 下拉學門
	public String selectcourse_Q1() throws IOException, SQLException {

		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT SubjectID,SubjectName FROM Subject";
			
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();

			String str = "";

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
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

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override // 用學門查 全部課程
	public String selectcourse_Q2(String[] subjectcourseID) throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT Course.SubjectName, Course.SubjectID, Course.CourseID, Course.CourseName, Course.StartDateTime, Course.RoomName ,Course.Credits, Course.SignUp  "
					+ "FROM  Course "  
					+ "where Course.SubjectID= ?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, subjectcourseID[0]);
			System.out.println(subjectcourseID[0]);
			ResultSet rs = stmt.executeQuery();

			String str = "";

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String SubjectID = rs.getString("SubjectID");
				String CourseID = rs.getString("CourseID");
				String SubjectName = rs.getString("SubjectName");
				String CourseName = rs.getString("CourseName");
				String StartDateTime = rs.getString("StartDateTime");
				String RoomName = rs.getString("RoomName");
				String Credits = rs.getString("Credits");
				String SignUp = rs.getString("SignUp");
				
				String qryStmt2 = "  SELECT count(CourseID)as a FROM  MyCourse  where CourseID=? and SubjectID=?";
				
				PreparedStatement stmt2 = conn.prepareStatement(qryStmt2);
				stmt2.setString(1, CourseID);
				stmt2.setString(2, SubjectID);
				ResultSet rs2 = stmt2.executeQuery();
				
				while(rs2.next()) {
					String SignUpT = rs2.getString("a");
					map.put("SignUpT", SignUpT);
				}
				map.put("SubjectID", SubjectID);
				map.put("CourseID", CourseID);
				map.put("SubjectName", SubjectName);
				map.put("CourseName", CourseName);
				map.put("StartDateTime", StartDateTime);
				map.put("RoomName", RoomName);
				map.put("Credits", Credits);
				map.put("SignUp", SignUp);
				listMap.add(map);
				rs2.close();
		        stmt2.close();
			}
			JSONArray ja2 = JSONArray.fromObject(listMap);
			System.out.println(ja2.toString());
			stmt.close();
			rs.close();
			stmt.close();
			conn.close();
			return ja2.toString();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override // 下拉課程
	public String selectcourse_Q3(String[] subjectcourseID) throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "  SELECT Course.SubjectName, Course.SubjectID, Course.CourseID, Course.CourseName, Course.StartDateTime, Course.RoomName ,Course.Credits "
					+ "FROM  Course  "
					+ "where Course.SubjectID= ?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, subjectcourseID[0]);
			System.out.println(subjectcourseID[0]);
			ResultSet rs = stmt.executeQuery();

			String str = "";

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String SubjectID = rs.getString("SubjectID");
				String CourseID = rs.getString("CourseID");
				String SubjectName = rs.getString("SubjectName");
				String CourseName = rs.getString("CourseName");
				String StartDateTime = rs.getString("StartDateTime");
				String RoomName = rs.getString("RoomName");
				String Credits = rs.getString("Credits");
				map.put("SubjectID", SubjectID);
				map.put("CourseID", CourseID);
				map.put("SubjectName", SubjectName);
				map.put("CourseName", CourseName);
				map.put("StartDateTime", StartDateTime);
				map.put("RoomName", RoomName);
				map.put("Credits", Credits);
				listMap.add(map);

			}
			JSONArray ja2 = JSONArray.fromObject(listMap);
			System.out.println(ja2.toString());
			rs.close();
			stmt.close();
			conn.close();
			return ja2.toString();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override // 課程總攬
	public String selectcourse_Q4() throws IOException, SQLException {

		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = " SELECT Course.SubjectName, Course.SubjectID, Course.CourseID, Course.CourseName, Course.StartDateTime, Course.RoomName ,Course.Credits, Course.SignUp "
					+ "FROM  Course  " ;
			Connection conn=dataSource.getConnection();		
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();

			String str = "";

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String SubjectID = rs.getString("SubjectID");
				String CourseID = rs.getString("CourseID");
				String SubjectName = rs.getString("SubjectName");
				String CourseName = rs.getString("CourseName");
				String StartDateTime = rs.getString("StartDateTime");
				String RoomName = rs.getString("RoomName");
				String Credits = rs.getString("Credits");
				String SignUp = rs.getString("SignUp");
				
				String qryStmt2 = "  SELECT count(CourseID)as a FROM  MyCourse  where CourseID=? and SubjectID=?";
				PreparedStatement stmt2 = conn.prepareStatement(qryStmt2);
				stmt2.setString(1, CourseID);
				stmt2.setString(2, SubjectID);
				ResultSet rs2 = stmt2.executeQuery();
				
				while(rs2.next()) {
					String SignUpT = rs2.getString("a");
					map.put("SignUpT", SignUpT);
				}
				
				map.put("SubjectID", SubjectID);
				map.put("CourseID", CourseID);
				map.put("SubjectName", SubjectName);
				map.put("CourseName", CourseName);
				map.put("StartDateTime", StartDateTime);
				map.put("RoomName", RoomName);
				map.put("Credits", Credits);
				map.put("SignUp", SignUp);
				listMap.add(map);
				rs2.close();
		        stmt2.close();
			}
			JSONArray ja2 = JSONArray.fromObject(listMap);
			System.out.println(ja2.toString());
			rs.close();
			stmt.close();
			conn.close();
			return ja2.toString();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override // 用課程查 全部課程
	public String selectcourse_Q5(String[] subjectcourseID) throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT Course.SubjectName, Course.SubjectID, Course.CourseID, Course.CourseName, Course.StartDateTime, Course.RoomName ,Course.Credits, Course.SignUp "
					+ "FROM  Course  "
					+ "where Course.CourseID=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, subjectcourseID[0]);
			System.out.println(subjectcourseID[0]);
			ResultSet rs = stmt.executeQuery();

			String str = "";

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String SubjectID = rs.getString("SubjectID");
				String CourseID = rs.getString("CourseID");
				String SubjectName = rs.getString("SubjectName");
				String CourseName = rs.getString("CourseName");
				String StartDateTime = rs.getString("StartDateTime");
				String RoomName = rs.getString("RoomName");
				String Credits = rs.getString("Credits");
				String SignUp = rs.getString("SignUp");
				String qryStmt2 = "  SELECT count(CourseID)as a FROM  MyCourse  where CourseID=? and SubjectID=?";
				
				PreparedStatement stmt2 = conn.prepareStatement(qryStmt2);
				stmt2.setString(1, CourseID);
				stmt2.setString(2, SubjectID);
				ResultSet rs2 = stmt2.executeQuery();
				
				while(rs2.next()) {
					String SignUpT = rs2.getString("a");
					map.put("SignUpT", SignUpT);
				}
				map.put("SubjectID", SubjectID);
				map.put("CourseID", CourseID);
				map.put("SubjectName", SubjectName);
				map.put("CourseName", CourseName);
				map.put("StartDateTime", StartDateTime);
				map.put("RoomName", RoomName);
				map.put("Credits", Credits);
				map.put("SignUp", SignUp);
				listMap.add(map);
				rs2.close();
		        stmt2.close();
			}
			JSONArray ja2 = JSONArray.fromObject(listMap);
			System.out.println(ja2.toString());
			rs.close();
			stmt.close();
			conn.close();
			return ja2.toString();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override  // 我要報名
	public String selectcourse_A6(String[] mycourseadd) throws IOException, SQLException {

		try {
			String qryStmt = " SELECT Course.SubjectName, Course.SubjectID, Course.CourseID, Course.CourseName, Course.StartDateTime,Course.EndDateTime, Course.RoomID,Course.RoomName, Course.CourseSummary, Course.SignUp ,Course.Credits\r\n"
					+ "  from Course\r\n" 
					+ "  where Course.CourseID=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, mycourseadd[0]);
			ResultSet rs = stmt.executeQuery();

			String str = "";
			String SubjectName= "";
			String SubjectID= "";
			String CourseID= "";
			String CourseName= "";
			String StartDateTime= "";
			String EndDateTime= "";
			String RoomID= "";
			String RoomName= "";
			String CourseSummary= "";
			String SignUp= "";
			String Credits= "";


			while (rs.next()) {
			SubjectName = rs.getString("SubjectName");
			SubjectID = rs.getString("SubjectID");
			CourseID = rs.getString("CourseID");
			CourseName = rs.getString("CourseName");
			StartDateTime = rs.getString("StartDateTime");
			EndDateTime = rs.getString("EndDateTime");
			RoomID = rs.getString("RoomID");
			RoomName = rs.getString("RoomName");
			
			CourseSummary = rs.getString("CourseSummary");
			SignUp = rs.getString("SignUp");
			Credits = rs.getString("Credits");
			}
			String sqlstr = "insert into  MyCourse(empid,CourseID,SubjectID,SubjectName,CourseName,StartDateTime,EndDateTime,RoomID,RoomName,CourseSummary,SignUp,Credits) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement state = conn.prepareStatement(sqlstr);
			state.setString(1, "1001");
			state.setString(2, CourseID);
			state.setString(3, SubjectID);
			state.setString(4, SubjectName);
			state.setString(5, CourseName);
			state.setString(6, StartDateTime);
			state.setString(7, EndDateTime);
			state.setString(8, RoomID);
			state.setString(9, RoomName);
			state.setString(10, CourseSummary);
			state.setString(11, SignUp);
			state.setString(12, Credits);
			state.executeUpdate();
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

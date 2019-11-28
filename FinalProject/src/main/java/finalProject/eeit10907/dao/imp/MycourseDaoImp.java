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
import finalProject.eeit10907.model.CourseBean;
import finalProject.eeit10907.dao.MycourseDao;
import net.sf.json.JSONArray;

@Repository 
public class MycourseDaoImp implements MycourseDao {


//	
////	SessionFactory factory;
//
////	@Autowired
////	public void setFactory(SessionFactory factory) {
////		this.factory = factory;
////	}
//
	
	
	 DataSource  dataSource;
	 @Autowired
	 public void setDataSource(DataSource  dataSource) {
		 this.dataSource=dataSource;
	 }
	 
	
	@SuppressWarnings("rawtypes")
	@Override // 查詢以選課程
	public String mycourse_Q1(int empid) throws IOException, SQLException {

		
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT * FROM MyCourse where empid=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setInt(1, empid);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String empid1 = rs.getString("empid");
				String SubjectID = rs.getString("SubjectID");
				String SubjectName = rs.getString("SubjectName");
				String CourseID = rs.getString("CourseID");
				String CourseName = rs.getString("CourseName");
				String StartDateTime = rs.getString("StartDateTime");
				String RoomName = rs.getString("RoomName");
				String Credits = rs.getString("Credits");

				map.put("empid", empid1);
				map.put("SubjectID", SubjectID);
				map.put("SubjectName", SubjectName);
				map.put("CourseName", CourseName);
				map.put("CourseID", CourseID);
				map.put("StartDateTime", StartDateTime);
				map.put("RoomName", RoomName);
				map.put("Credits", Credits);
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

	@Override // 刪除課程
	public String deleteMycourse(int[] mycourseD1) throws SQLException {
		String qryStmt = "delete from MyCourse where empid=? and CourseID=?";
		Connection conn=dataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement(qryStmt);
		stmt.setInt(1, mycourseD1[0]);
		stmt.setInt(2, mycourseD1[1]);

		stmt.executeUpdate();
		stmt.close();
		conn.close();
		return  null;

	}

	@SuppressWarnings("rawtypes")
	@Override // 課程詳細資料
	public String mycourse_Q2(String[] mycourseQ2) throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			Connection conn=dataSource.getConnection();
			String qryStmt = "SELECT Subject.SubjectName, Course.CourseName, Course.StartDateTime, Course.EndDateTime, Course.EndDateTime,Room.RoomName,Course.Credits,Course.CourseSummary "
					+ "FROM  Course " + "left join Subject " + "on Course.SubjectID=Subject.SubjectID "
					+ "left join Room " + "on Course.RoomID=Room.RoomID " + "where Course.CourseID=?";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, mycourseQ2[0]);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String SubjectName = rs.getString("SubjectName");
				String CourseName = rs.getString("CourseName");
				String StartDateTime = rs.getString("StartDateTime");
				String EndDateTime = rs.getString("EndDateTime");
				String RoomName = rs.getString("RoomName");
				String Credits = rs.getString("Credits");
				String CourseSummary = rs.getString("CourseSummary");

				map.put("SubjectName", SubjectName);
				map.put("CourseName", CourseName);
				map.put("StartDateTime", StartDateTime);
				map.put("EndDateTime", EndDateTime);
				map.put("RoomName", RoomName);
				map.put("Credits", Credits);
				map.put("CourseSummary", CourseSummary);
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

	@SuppressWarnings("rawtypes")
	@Override  //查詢學分
	public String mycourse_Q3(int empid) throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			Connection conn=dataSource.getConnection();
			String qryStmt = "select * from LEmployee where empid=?";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setInt(1, empid);
			
			ResultSet rs = stmt.executeQuery();
			
			String SubjectID ="";
			String SubjectName ="";
			String countstatu="";
			String SubjectScore="";
			while (rs.next()) {
					String PreSubjectID = rs.getString("PreSubjectID");
	
					String[] subject_split = PreSubjectID.split(";");
				    String[] subject_arr = new String[3];
				    int k=0;
				    for (String token:subject_split) {
				    	subject_arr[k] = token;
				    	k++;
			}
				
		    String sql2_qryStmt = "Select * From Subject where SubjectID = ? or SubjectID = ? or  SubjectID =? ";
			PreparedStatement stmt_2 = conn.prepareStatement(sql2_qryStmt);
			stmt_2.setString(1, subject_arr[0]);
			stmt_2.setString(2, subject_arr[1]);
			stmt_2.setString(3, subject_arr[2]);
			ResultSet rs_2 = stmt_2.executeQuery();
			k=0;
	
			while (rs_2.next()) 
				{
					SubjectName = rs_2.getString("SubjectName");
					SubjectScore = rs_2.getString("SubjectScore");
					SubjectID = rs_2.getString("SubjectID");
					System.out.println(SubjectID);
					
					
					
					
					String sql2_qryStmt2 = "   select count(statu)*5 as statu2 from MyCourse where empid=? and  SubjectID =? and statu ='已完成'";
					PreparedStatement stmt_3 = conn.prepareStatement(sql2_qryStmt2);
					stmt_3.setInt(1,empid);
					stmt_3.setString(2,SubjectID);
					ResultSet rs_3 = stmt_3.executeQuery();
					
					while (rs_3.next()){
							countstatu = rs_3.getString("statu2");
							System.out.println(countstatu);
						}
					Map<String, String> map = new HashMap<String, String>();
					map.put("SubjectName", SubjectName);
					map.put("SubjectScore", SubjectScore);
					map.put("countstatu", countstatu);
					listMap.add(map);
					rs_3.close();
			        stmt_3.close();
				}
			 	rs_2.close();
	            stmt_2.close();
			
			
					
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

	@SuppressWarnings("rawtypes")
	@Override  //查詢滿意度
	public String mycourse_Q4(String[] mycourseD2) throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			Connection conn=dataSource.getConnection();
			String qryStmt = "SELECT * FROM MyCourse where empid=?  and CourseID=?";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, mycourseD2[0]);
			stmt.setString(2, mycourseD2[1]);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String empid = rs.getString("empid");
				String CourseID = rs.getString("CourseID");
				String TeacherQ1 = rs.getString("TeacherQ1");
				String TeacherQ2 = rs.getString("TeacherQ2");
				String ContentQ1 = rs.getString("ContentQ1");
				String ContentQ2 = rs.getString("ContentQ2");
				String MySatisContent = rs.getString("MySatisContent");
				String MySatisTeacher = rs.getString("MySatisTeacher");
				String MySatisfaction = rs.getString("MySatisfaction");

				map.put("empid", empid);
				map.put("CourseID", CourseID);
				map.put("TeacherQ1", TeacherQ1);
				map.put("TeacherQ2", TeacherQ2);
				map.put("ContentQ1", ContentQ1);
				map.put("ContentQ2", ContentQ2);
				map.put("MySatisContent", MySatisContent);
				map.put("MySatisTeacher", MySatisTeacher);
				map.put("MySatisfaction", MySatisfaction);
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

	@Override   //新增滿意度
	public String mycourse_I1(String[] mycoursestis) throws IOException, SQLException {
		
		try {
			Connection conn=dataSource.getConnection();
			String sqlstr=" UPDATE Mycourse SET MySatisfaction =?, MySatisTeacher =? ,MySatisContent=?, TeacherQ1=?,TeacherQ2=?,ContentQ1=?,ContentQ2=?,statu=? WHERE empid = ? and CourseID=?";
			PreparedStatement state=conn.prepareStatement(sqlstr);
			state.setString(1,mycoursestis[2]);
			state.setString(2,mycoursestis[3]);
			state.setString(3,mycoursestis[4]);
			state.setString(4,mycoursestis[5]);
			state.setString(5,mycoursestis[6]);
			state.setString(6,mycoursestis[7]);
			state.setString(7,mycoursestis[8]);
			state.setString(8,"已完成");
			state.setString(9,mycoursestis[0]);
			state.setString(10,mycoursestis[1]);
			state.executeUpdate();
			state.close();
			conn.close();
		
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override  //查詢課程詳細資料(享用bean)
	public CourseBean mycourse_Q5(int CourseID) throws IOException, SQLException {
		CourseBean str3=null;
		
		try {
			Connection conn=dataSource.getConnection();
			String qryStmt = "SELECT Subject.SubjectName, Course.CourseName, Course.StartDateTime, Course.EndDateTime, Course.EndDateTime,Room.RoomName,Course.Credits,Course.URL,Course.CourseSummary "
					+ "FROM  Course " + "left join Subject " + "on Course.SubjectID=Subject.SubjectID "
					+ "left join Room " + "on Course.RoomID=Room.RoomID " + "where Course.CourseID=?";
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setInt(1, CourseID);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				str3=new CourseBean();

				str3.setSubjectName(rs.getString("SubjectName"));
				str3.setCourseName( rs.getString("CourseName"));
				str3.setStartDateTime( rs.getDate("StartDateTime"));
				str3.setEndDateTime( rs.getDate("EndDateTime"));
				str3.setRoomName( rs.getString("RoomName"));
				str3.setCredits( rs.getInt("Credits"));
				str3.setURL( rs.getString("URL"));
				str3.setCourseSummary( rs.getString("CourseSummary"));
				
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return str3;
	}
	
	


}

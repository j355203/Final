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

import finalProject.eeit10907.dao.OpencourseallDao;
import net.sf.json.JSONArray;

@Repository
public class OpencourseallDaoImp implements OpencourseallDao {
	

	DataSource  dataSource;
	 @Autowired
	 public void setDataSource(DataSource  dataSource) {
		 this.dataSource=dataSource;
	 }
	
	

	@Override  //查詢學門
	public String opencourseall_Q1() throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT SubjectID,SubjectName FROM Subject";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();

			

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

	@Override  //查詢課程
	public String opencourseall_Q2(String[] subjectID) throws IOException, SQLException {
		
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT CourseID,CourseName FROM Course where SubjectID=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, subjectID[0]);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String CourseID = rs.getString("CourseID");
				String CourseName = rs.getString("CourseName");
				map.put("CourseID", CourseID);
				map.put("CourseName", CourseName);
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

	@Override  //查詢學門細節
	public String opencourseall_Q3(String[] subjectID) throws IOException, SQLException {
	
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT * FROM Subject where SubjectID=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, subjectID[0]);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String SubjectID = rs.getString("SubjectID");
				String SubjectName = rs.getString("SubjectName");
				String SubjectScore = rs.getString("SubjectScore");
				map.put("SubjectID", SubjectID);
				map.put("SubjectName", SubjectName);
				map.put("SubjectScore", SubjectScore);
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

	@Override  //第一個學門總攬
	public String opencourseall_Q4() throws IOException, SQLException {
		
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT * FROM Subject";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();

			

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String SubjectID = rs.getString("SubjectID");
				String SubjectName = rs.getString("SubjectName");
				String SubjectScore = rs.getString("SubjectScore");
				map.put("SubjectID", SubjectID);
				map.put("SubjectName", SubjectName);
				map.put("SubjectScore", SubjectScore);
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

	
	
	
	@Override //下拉第二個學門  秀出課程總攬
	public String opencourseall_Q5(String[] subjectID) throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT Course.SubjectName, Course.SubjectID, Course.CourseID, Course.CourseName, Course.SignUp \r\n" + 
							 "	FROM  Course\r\n" + 
							 "	where Course.SubjectID=?";
					
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, subjectID[0]);
			System.out.println(subjectID[0]);
			ResultSet rs = stmt.executeQuery();

			

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String SubjectID = rs.getString("SubjectID");
				String CourseID = rs.getString("CourseID");
				String SubjectName = rs.getString("SubjectName");
				String CourseName = rs.getString("CourseName");
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
	@Override //查詢課程總攬
	public String opencourseall_Q10() throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT Course.SubjectName, Course.SubjectID, Course.CourseID, Course.CourseName, Course.SignUp \r\n" + 
					"FROM  Course";
					
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);

			ResultSet rs = stmt.executeQuery();

			

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String SubjectID = rs.getString("SubjectID");
				String CourseID = rs.getString("CourseID");
				String SubjectName = rs.getString("SubjectName");
				String CourseName = rs.getString("CourseName");
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
	
	
	@Override //下拉第一個課程  秀出課程總攬
	public String opencourseall_Q6(String[] courseID) throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = " SELECT Course.SubjectID,Course.SubjectName,Course.CourseName,Course.CourseID, Course.SignUp \r\n" + 
					"					 FROM  Course\r\n" + 
					"					  where Course.CourseID=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, courseID[0]);
			System.out.println(courseID[0]);
			ResultSet rs = stmt.executeQuery();

			

			while (rs.next()) {
				
				
				Map<String, String> map = new HashMap<String, String>();
				String SubjectID = rs.getString("SubjectID");
				String CourseID = rs.getString("CourseID");		
				String SubjectName = rs.getString("SubjectName");
				String CourseName = rs.getString("CourseName");
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

	@Override  //刪除學門
	public String deleteSubject_D1(String[] SubjectIDD1) throws IOException, SQLException {
		
		String qryStmt="delete from Subject where SubjectID=?";
		Connection conn=dataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement(qryStmt);
		stmt.setString(1, SubjectIDD1[0]);
		stmt.executeUpdate();
		stmt.close();
		conn.close();
		return null;
	}

	@Override  //刪除課程
	public String deleteSubject_D2(String[] CourseIDD2) throws IOException, SQLException {
		
		String qryStmt="delete from Course where CourseID=?";
		Connection conn=dataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement(qryStmt);
		stmt.setString(1, CourseIDD2[0]);
		stmt.executeUpdate();
		stmt.close();
		conn.close();
		return null;
	}

	@Override  //課程詳細資料
	public String opencourseall_Q7(String[] CourseIDQ7) throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = " SELECT Course.SubjectName, Course.CourseName, Course.StartDateTime, Course.EndDateTime, Course.EndDateTime,Course.RoomName,Course.Credits,Course.CourseSummary\r\n" + 
					"	 FROM  Course \r\n" + 
					"	where Course.CourseID=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, CourseIDQ7[0]);
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

	@Override  //有選課的人
	public String opencourseall_Q8(String[] CourseIDQ8) throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = " SELECT MyCourse.empid,LEmployee.empname,MyCourse.MySatisfaction,MyCourse.MySatisTeacher,MyCourse.MySatisContent,MyCourse.TeacherQ1,MyCourse.TeacherQ2,MyCourse.ContentQ1,MyCourse.ContentQ2\r\n" + 
					"		FROM  MyCourse\r\n" + 
					"		left join LEmployee \r\n" + 
					"		on MyCourse.empid=LEmployee.empid\r\n" + 
					"		where MyCourse.CourseID=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, CourseIDQ8[0]);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String empid = rs.getString("empid");
				String empname = rs.getString("empname");
				String MySatisfaction = rs.getString("MySatisfaction");
				String MySatisTeacher = rs.getString("MySatisTeacher");
				String MySatisContent = rs.getString("MySatisContent");
				String TeacherQ1 = rs.getString("TeacherQ1");
				String TeacherQ2 = rs.getString("TeacherQ2");
				String ContentQ1 = rs.getString("ContentQ1");
				String ContentQ2 = rs.getString("ContentQ2");
				map.put("empid", empid);
				map.put("empname", empname);
				map.put("MySatisfaction", MySatisfaction);
				map.put("MySatisTeacher", MySatisTeacher);
				map.put("MySatisContent", MySatisContent);
				map.put("TeacherQ1", TeacherQ1);
				map.put("TeacherQ2", TeacherQ2);
				map.put("ContentQ1", ContentQ1);
				map.put("ContentQ2", ContentQ2);
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

	@Override  //修改頁面所帶的資料(學門)
	public String updatesubject_U1(String SubjectIU1) throws SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT * FROM Subject where SubjectID =?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, SubjectIU1);
			System.out.println(SubjectIU1);
			ResultSet rs = stmt.executeQuery();

			

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();

				String SubjectID = rs.getString("SubjectID");
				String SubjectName = rs.getString("SubjectName");
				String SubjectScore = rs.getString("SubjectScore");
	
				map.put("SubjectID", SubjectID);
				map.put("SubjectName", SubjectName);
				map.put("SubjectScore", SubjectScore);

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

	@Override  //修改學門
	public String updatesubject_U2(String[] SubjectIU2) throws SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "UPDATE Subject SET SubjectScore = ?  where SubjectID = ?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, SubjectIU2[1]);
			stmt.setString(2, SubjectIU2[0]);
		    stmt.executeUpdate();
		    System.out.println("success");
		    stmt.close();
			conn.close();
			return "success";

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override  //修改頁面所帶的資料(課程)
	public String updatecourse_U3(String CourseIDU3) throws SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "  SELECT Subject.SubjectName, Subject.SubjectID, Course.CourseID, Course.CourseName, Course.StartDateTime,Course.EndDateTime, Course.RoomID,Room.RoomName, Course.CourseSummary, Course.SignUp, Course.Satisfaction ,Course.Credits\r\n" + 
					"  from Course\r\n" + 
					"  left join Subject\r\n" + 
					"  on Course.SubjectID=Subject.SubjectID\r\n" + 
					"  left join Room\r\n" + 
					"  on Course.RoomID=Room.RoomID\r\n" + 
					" where Course.CourseID=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, CourseIDU3);
			System.out.println(CourseIDU3);
			ResultSet rs = stmt.executeQuery();

			

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();

				String SubjectID = rs.getString("SubjectID");
				String SubjectName = rs.getString("SubjectName");
				String CourseID1 = rs.getString("CourseID");
				String CourseName = rs.getString("CourseName");
				String StartDateTime = rs.getString("StartDateTime");
				String EndDateTime = rs.getString("EndDateTime");
				String RoomID = rs.getString("RoomID");
				String RoomName = rs.getString("RoomName");
	
				String CourseSummary = rs.getString("CourseSummary");
				String SignUp = rs.getString("SignUp");
				String Satisfaction = rs.getString("Satisfaction");
				String Credits = rs.getString("Credits");
				map.put("SubjectID", SubjectID);
				map.put("SubjectName", SubjectName);
				map.put("CourseID1", CourseID1);
				map.put("CourseName", CourseName);
				map.put("StartDateTime", StartDateTime);
				map.put("SubjectName", SubjectName);
				map.put("EndDateTime", EndDateTime);
				map.put("RoomID", RoomID);
				map.put("RoomName", RoomName);
	
				map.put("CourseSummary", CourseSummary);
				map.put("SignUp", SignUp);
				map.put("Satisfaction", Satisfaction);
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

	@Override  // 修改課程
	public String updatecourse_U4(String[] CourseIDU4) throws SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "UPDATE Course SET SubjectID = ?,CourseName = ?,StartDateTime = ?,EndDateTime = ?,RoomID = ?,RoomName=?,CourseSummary = ?,Credits = ? where CourseID = ?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, CourseIDU4[0]);//SubjectID
			stmt.setString(2, CourseIDU4[2]);//CourseName
			stmt.setString(3, CourseIDU4[4]);//StartDateTime
			stmt.setString(4, CourseIDU4[5]);//EndDateTime
			stmt.setString(5, CourseIDU4[6]);//RoomID
			stmt.setString(6, CourseIDU4[7]);//RoomName
			stmt.setString(7, CourseIDU4[8]);//CourseSummary 
			stmt.setString(8, CourseIDU4[3]);//Credits
			stmt.setString(9, CourseIDU4[1]);//CourseID

			
		    stmt.executeUpdate();
		    System.out.println("success");
		    
		    stmt.close();
			conn.close();
			return "success";

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	@Override  //課程總體滿意度
	public String opencourseall_Q9(String[] CourseIDQ9) throws IOException, SQLException {
		
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "select round(AVG(MySatisfaction),1) as MySatisfaction,round(AVG(MySatisTeacher),1) as MySatisTeacher,round(AVG(MySatisContent),1) as MySatisContent,\r\n" + 
					"					round(AVG(TeacherQ1),1) as TeacherQ1 ,round(AVG(TeacherQ2),1) as TeacherQ2,round(AVG(ContentQ1),1) as ContentQ1,round(AVG(ContentQ2),1)  as ContentQ2\r\n" + 
					"					from MyCourse where SubjectID=? and CourseID=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, CourseIDQ9[1]);//SubjectID
			stmt.setString(2, CourseIDQ9[0]);//CourseID
			ResultSet rs = stmt.executeQuery();

		    
			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();

				String MySatisfaction = rs.getString("MySatisfaction");
				String MySatisTeacher = rs.getString("MySatisTeacher");
				String MySatisContent = rs.getString("MySatisContent");
				String TeacherQ1 = rs.getString("TeacherQ1");
				String TeacherQ2 = rs.getString("TeacherQ2");
				String ContentQ1 = rs.getString("ContentQ1");
				String ContentQ2 = rs.getString("ContentQ2");

				map.put("MySatisfaction", MySatisfaction);
				map.put("MySatisTeacher", MySatisTeacher);
				map.put("MySatisContent", MySatisContent);
				map.put("TeacherQ1", TeacherQ1);
				map.put("TeacherQ2", TeacherQ2);
				map.put("ContentQ1", ContentQ1);
				map.put("ContentQ2", ContentQ2);
	
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




}

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

import finalProject.eeit10907.dao.EmployeeDao;
import net.sf.json.JSONArray;

@Repository
public class EmployeeDaoImp implements EmployeeDao {

	
	DataSource  dataSource;
	 @Autowired
	 public void setDataSource(DataSource  dataSource) {
		 this.dataSource=dataSource;
	 }
	 
	 


	@SuppressWarnings("rawtypes")
	@Override //用員編查詢
	public String Employee_Q1(String[] empidQ1) throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "  SELECT LEmployee.empid,LEmployee.empname,Title.TitleNO,Title.TitleName,LEmployee.PreSubjectID\r\n" + 
					"				FROM  LEmployee\r\n" + 
					"				left join Title \r\n" + 
					"				on LEmployee.TitleID=Title.TitleID\r\n" + 
					"				where LEmployee.empid=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			
			stmt.setString(1, empidQ1[0]);
			System.out.println(empidQ1[0]);
			ResultSet rs = stmt.executeQuery();

			
			String PreSubject_Name = "";
			while (rs.next()) 
			{
				Map<String,String> map = new HashMap<String,String>();
				String empid1 = rs.getString("empid");
			    String empname = rs.getString("empname");
			    String TitleNO = rs.getString("TitleNO");
			    String TitleName = rs.getString("TitleName");
			    String PreSubjectID = rs.getString("PreSubjectID");
			    
			    
			    String[] subject_split = PreSubjectID.split(";");
			    String[] subject_arr = new String[3];
			    int k=0;
			    for (String token:subject_split) {
			    	subject_arr[k] = token;
			    	System.out.println(subject_arr[k]);
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
						if(k==2) {
							PreSubject_Name = PreSubject_Name + rs_2.getString("SubjectName");
							break;
						}
						PreSubject_Name = PreSubject_Name + rs_2.getString("SubjectName")+"、";
						k++;
				    	System.out.println(PreSubject_Name);
					}
			    
			    
			    map.put("empid", empid1);
	            map.put("empname", empname);
	            map.put("TitleNO", TitleNO);
	            map.put("TitleName", TitleName);
	            map.put("PreSubjectID", PreSubjectID);
	            map.put("PreSubject_Name", PreSubject_Name);
	            listMap.add(map);
	            rs_2.close();
	            stmt_2.close();

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
	@Override //用名稱查詢
	public String Employee_Q2(String[] empnameQ2) throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = " SELECT LEmployee.empid,LEmployee.empname,Title.TitleNO,Title.TitleName,LEmployee.PreSubjectID\r\n" + 
					"				FROM  LEmployee\r\n" + 
					"				left join Title \r\n" + 
					"				on LEmployee.TitleID=Title.TitleID\r\n" + 
					"				where LEmployee.empname=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, empnameQ2[0]);
			System.out.println(empnameQ2[0]);
			ResultSet rs = stmt.executeQuery();

			
			String PreSubject_Name = "";

			while (rs.next()) 
			{
				Map<String,String> map = new HashMap<String,String>();
				String empid = rs.getString("empid");
			    String empname1 = rs.getString("empname");
			    String TitleNO = rs.getString("TitleNO");
			    String TitleName = rs.getString("TitleName");
			    String PreSubjectID = rs.getString("PreSubjectID");
			    //select subject 
			    String[] subject_split = PreSubjectID.split(";");
			    String[] subject_arr = new String[3];
			    int k=0;
			    for (String token:subject_split) {
			    	subject_arr[k] = token;
			    	System.out.println(subject_arr[k]);
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
						if(k==2) {
							PreSubject_Name = PreSubject_Name + rs_2.getString("SubjectName");
							break;
						}
						PreSubject_Name = PreSubject_Name + rs_2.getString("SubjectName")+"、";
						k++;
				    	System.out.println(PreSubject_Name);
					}
			    
					
					
			    map.put("empid", empid);
	            map.put("empname", empname1);
	            map.put("TitleNO", TitleNO);
	            map.put("TitleName", TitleName);
	            map.put("PreSubjectID", PreSubjectID);
	            map.put("PreSubject_Name", PreSubject_Name);
	            listMap.add(map);
	            rs_2.close();
	            stmt_2.close();
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
	@Override  //未設定區
	public String Employee_Q3() throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "SELECT LEmployee.empid,LEmployee.empname,Title.TitleNO,Title.TitleName,LEmployee.PreSubjectID\r\n" + 
					"FROM  LEmployee\r\n" + 
					"left join Title \r\n" + 
					"on LEmployee.TitleID=Title.TitleID\r\n" + 
					"where PreSubjectID=''";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			ResultSet rs = stmt.executeQuery();

			

			while (rs.next()) 
			{
				Map<String,String> map = new HashMap<String,String>();
				String empid = rs.getString("empid");
			    String empname = rs.getString("empname");
			    String TitleNO = rs.getString("TitleNO");
			    String TitleName = rs.getString("TitleName");
			    String PreSubjectID = rs.getString("PreSubjectID");
			    map.put("empid", empid);
	            map.put("empname", empname);
	            map.put("TitleNO", TitleNO);
	            map.put("TitleName", TitleName);
	            map.put("PreSubjectID", PreSubjectID);
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
	@Override  //選課紀錄
	public String Employee_Q4(String[] empidQ4) throws IOException, SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "  SELECT SubjectName, CourseName,Credits,"
					+ "(case when MySatisfaction is null  then '-' else MySatisfaction end)as MySatisfaction,"
					+ "(case when MySatisTeacher is null  then '-' else MySatisTeacher end)as MySatisTeacher,"
					+ "(case when MySatisContent is null  then '-' else MySatisContent end)as MySatisContent,"
					+ "(case when TeacherQ1 is null  then '-' else TeacherQ1 end)as TeacherQ1,"
					+ "(case when TeacherQ2 is null  then '-' else TeacherQ2 end)as TeacherQ2,"
					+ "(case when ContentQ1 is null  then '-' else ContentQ1 end)as ContentQ1,"
					+ "(case when ContentQ2 is null  then '-' else ContentQ2 end)as ContentQ2,"
					+ "(case when statu is null  then '-' else statu end)as statu\r\n" + 
					"				FROM  MyCourse\r\n" + 
					"				where MyCourse.empid=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, empidQ4[0]);
			System.out.println(empidQ4[0]);
			ResultSet rs = stmt.executeQuery();

			

			while (rs.next()) 
			{
				Map<String,String> map = new HashMap<String,String>();
				String SubjectName = rs.getString("SubjectName");
			    String CourseName = rs.getString("CourseName");
			    String Credits = rs.getString("Credits");
			    String MySatisfaction = rs.getString("MySatisfaction");
			    String MySatisTeacher = rs.getString("MySatisTeacher");
			    String MySatisContent = rs.getString("MySatisContent");
			    String TeacherQ1 = rs.getString("TeacherQ1");
			    String TeacherQ2 = rs.getString("TeacherQ2");
			    String ContentQ1 = rs.getString("ContentQ1");
			    String ContentQ2 = rs.getString("ContentQ2");
			    
			    String statu = rs.getString("statu");


			    
			    
			    map.put("SubjectName", SubjectName);
	            map.put("CourseName", CourseName);
	            map.put("Credits", Credits);
	            map.put("MySatisfaction", MySatisfaction);
	            map.put("MySatisTeacher", MySatisTeacher);
	            map.put("MySatisContent", MySatisContent);
	            map.put("TeacherQ1", TeacherQ1);
	            map.put("TeacherQ2", TeacherQ2);
	            map.put("ContentQ1", ContentQ1);
	            map.put("ContentQ2", ContentQ2);
	            map.put("statu", statu);
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
	@Override  //修改頁面所帶的資料
	public String Employee_U1(String empidU1) throws SQLException {
		List<Map> listMap = new ArrayList<Map>();
		try {
			String qryStmt = "select LEmployee.empid,LEmployee.empname,LEmployee.TitleID,Title.TitleNO,LEmployee.PreSubjectID\r\n" + 
					"  from LEmployee\r\n" + 
					"  left join Title\r\n" + 
					"  on LEmployee.TitleID=Title.TitleID\r\n" + 
					"  where empid=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, empidU1);
			System.out.println(empidU1);
			ResultSet rs = stmt.executeQuery();

			

			while (rs.next()) {
				Map<String, String> map = new HashMap<String, String>();
				String empid1= rs.getString("empid");
				String empname = rs.getString("empname");
				String TitleID = rs.getString("TitleID");
				String TitleNO = rs.getString("TitleNO");
				String PreSubjectID = rs.getString("PreSubjectID");
				map.put("empid", empid1);
				map.put("empname", empname);
				map.put("TitleID", TitleID);
				map.put("TitleNO", TitleNO);
				map.put("PreSubjectID", PreSubjectID);

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



	@SuppressWarnings({ "rawtypes", "unused" })
	@Override  //修改 個人資料
	public String Employee_U2(String[] upemp) throws SQLException {
		List<Map> listMap = new ArrayList<Map>();
		
		
		try {
			String qryStmt = " select Title.PreTitleSubject\r\n" + 
					"  from Title\r\n" + 
					"  where TitleID=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, upemp[1]);
			System.out.println(upemp[1]);
			ResultSet rs = stmt.executeQuery();
			
			String PreTitleSubject="";
			while (rs.next()) {
			PreTitleSubject = rs.getString("PreTitleSubject");
			System.out.println(PreTitleSubject);
			}
			
			String qryStmt2 = "UPDATE LEmployee SET TitleID = ? ,PreSubjectID = ?  where empid = ?";
			PreparedStatement stmt2 = conn.prepareStatement(qryStmt2);
			stmt2.setString(1, upemp[1]);
			stmt2.setString(2, PreTitleSubject);
			stmt2.setString(3, upemp[0]);
		
		    stmt2.executeUpdate();
		    System.out.println("success");
		    rs.close();
		    stmt.close();
			conn.close();
			return "success";

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}



}

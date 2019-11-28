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

import finalProject.eeit10907.dao.TitleDao;
import net.sf.json.JSONArray;
@Repository
public class TitleDaoImp implements TitleDao {

	

		DataSource  dataSource;
		 @Autowired
		 public void setDataSource(DataSource  dataSource) {
			 this.dataSource=dataSource;
		 }


		@Override  //新增職稱學門
		public String title_A1(String[] allTitle1) throws IOException, SQLException {
			try 
			{
				String sqlstr = "insert into  Title (TitleNO,TitleName,PreTitleSubject) values(?,?,?)";
				Connection conn=dataSource.getConnection();
				PreparedStatement state = conn.prepareStatement(sqlstr);
				state.setString(1, allTitle1[2]);
				state.setString(2, allTitle1[1]);
				state.setString(3, allTitle1[0]);
				state.executeUpdate();
				state.close();
				conn.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return null;
		}
		
		
		@Override  //刪除職稱學門
		public String title_D1(String[] TitleID) throws SQLException {
			
			String qryStmt="delete from Title where  TitleID=?";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, TitleID[0]);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			return null;

		}

		
		
		
	//------------------下拉--------------------------------	
		@Override // 查學門下拉
		public String title_Q1() throws IOException, SQLException {
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
				rs.close();
				stmt.close();
				conn.close();

				return ja2.toString();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return null;
		}

		@Override // 查職稱代號下拉
		public String title_Q2() throws IOException, SQLException {
			List<Map> listMap = new ArrayList<Map>();
			try {
				String qryStmt = "SELECT TitleID,TitleNO FROM Title";
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
				ResultSet rs = stmt.executeQuery();

			

				while (rs.next()) {
					Map<String, String> map = new HashMap<String, String>();
					String TitleID = rs.getString("TitleID");
					String TitleNO = rs.getString("TitleNO");
					map.put("TitleID", TitleID);
					map.put("TitleNO", TitleNO);
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

		@Override // 查職稱代號下拉
		public String title_Q3() throws IOException, SQLException {
			List<Map> listMap = new ArrayList<Map>();
			try {
				String qryStmt = "SELECT TitleID,TitleName FROM Title";
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
				ResultSet rs = stmt.executeQuery();

				

				while (rs.next()) {
					Map<String, String> map = new HashMap<String, String>();
					String TitleID = rs.getString("TitleID");
					String TitleName = rs.getString("TitleName");
					map.put("TitleID", TitleID);
					map.put("TitleName", TitleName);
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


		@Override  // 職稱代號   送出秀出    職稱代號 總攬
		public String title_Q4(String[] titlenoID) throws IOException, SQLException {
			List<Map> listMap = new ArrayList<Map>();
			try {
				String qryStmt = "select * from Title where TitleID=?";
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
				stmt.setString(1, titlenoID[0]);
				
				ResultSet rs = stmt.executeQuery();

				
				
				String PreSubject_Name = "";
				while (rs.next()) {
					Map<String, String> map = new HashMap<String, String>();
					String TitleID = rs.getString("TitleID");
					String TitleNO = rs.getString("TitleNO");
					String TitleName = rs.getString("TitleName");
					String PreSubjectID = rs.getString("PreTitleSubject");
					
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
						
						
					map.put("TitleID", TitleID);
					map.put("TitleNO", TitleNO);
					map.put("TitleName", TitleName);
					map.put("PreSubjectID", PreSubjectID);
		            map.put("PreSubject_Name", PreSubject_Name);

					listMap.add(map);
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


		@Override  // 職稱名稱   送出秀出    職稱代號 總攬
		public String title_Q5(String[] titlenoID) throws IOException, SQLException {
			
			List<Map> listMap = new ArrayList<Map>();
			try {
				String qryStmt = "select * from Title where TitleID=?";
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
				stmt.setString(1, titlenoID[0]);
				
				ResultSet rs = stmt.executeQuery();

				
			
				String PreSubject_Name = "";
				while (rs.next()) {
					Map<String, String> map = new HashMap<String, String>();
					String TitleID = rs.getString("TitleID");
					String TitleNO = rs.getString("TitleNO");
					String TitleName = rs.getString("TitleName");
					String PreSubjectID = rs.getString("PreTitleSubject");
					
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
						
						
					map.put("TitleID", TitleID);
					map.put("TitleNO", TitleNO);
					map.put("TitleName", TitleName);
					map.put("PreSubjectID", PreSubjectID);
		            map.put("PreSubject_Name", PreSubject_Name);

					listMap.add(map);
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




		@Override  //總攬區
		public String title_Q6() throws IOException, SQLException {
			List<Map> listMap = new ArrayList<Map>();
			try {
				String qryStmt = "select * from Title";
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
				ResultSet rs = stmt.executeQuery();
			
				
				String PreSubject_Name = "";
				while (rs.next()) {
					PreSubject_Name = "";
					Map<String, String> map = new HashMap<String, String>();
					String TitleID = rs.getString("TitleID");
					String TitleNO = rs.getString("TitleNO");
					String TitleName = rs.getString("TitleName");
					String PreSubjectID = rs.getString("PreTitleSubject");
					
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
						
						
					map.put("TitleID", TitleID);
					map.put("TitleNO", TitleNO);
					map.put("TitleName", TitleName);
					map.put("PreSubjectID", PreSubjectID);
		            map.put("PreSubject_Name", PreSubject_Name);

					listMap.add(map);
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


		@Override //修改頁面所帶的資料
		public String updatetitle_Q7(String[]TitleIDQ7) throws SQLException {
			List<Map> listMap = new ArrayList<Map>();
			try {
				String qryStmt = "SELECT * FROM Title where TitleID = ?";
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
				stmt.setString(1, TitleIDQ7[0]);
				
				ResultSet rs = stmt.executeQuery();

				

				while (rs.next()) {
					Map<String, String> map = new HashMap<String, String>();
					String TitleID1= rs.getString("TitleID");
					String TitleNO = rs.getString("TitleNO");
					String TitleName = rs.getString("TitleName");
					String PreTitleSubject = rs.getString("PreTitleSubject");
					map.put("TitleID", TitleID1);
					map.put("TitleNO", TitleNO);
					map.put("TitleName", TitleName);
					map.put("PreTitleSubject", PreTitleSubject);

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
		
		
		@SuppressWarnings("rawtypes")
		@Override //修改資料
		public String updatetitle_U1(String[] upTitle) throws SQLException {
			List<Map> listMap = new ArrayList<Map>();
			try {
				String qryStmt = "UPDATE Title SET TitleNO = ? , TitleName=? ,PreTitleSubject = ?  where TitleID = ?";
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
				stmt.setString(1, upTitle[0]);
				stmt.setString(2, upTitle[1]);
				stmt.setString(3, upTitle[2]);
				stmt.setString(4, upTitle[3]);
			    stmt.executeUpdate();
			    
				
				stmt.close();
				conn.close();
				System.out.println("success");
				return "success";
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return null;
		}

}

package finalProject.eeit10907.dao.imp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import java.util.Date; 
import java.text.SimpleDateFormat;


import finalProject.eeit10907.dao.OpensourseDao;


@Repository
public class OpensourseDaoImp implements OpensourseDao {
	
	
	DataSource  dataSource;
	 @Autowired
	 public void setDataSource(DataSource  dataSource) {
		 this.dataSource=dataSource;
	 }

	 
	 @Override  //公告一檔案
	 public String opensourse_U1_T(String UpbullImg,String UpbullImgUrl) throws SQLException {
		try {
			String qryStmt = "UPDATE LupIndex SET UpbullImg=?,UpbullImgUrl=? where UpbullID ='T1' ";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, UpbullImg);
			stmt.setString(2, UpbullImgUrl);
			
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
	 
	 
	@Override  //上船公告一的標題 內容
	public String opensourse_U2_T(String[] bullsU2) throws SQLException {
		try {
			String qryStmt = "UPDATE LupIndex SET UpbullName=?,UpbullSum=? where UpbullID ='T1' ";
			Connection conn=dataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(qryStmt);
			stmt.setString(1, bullsU2[0]);
			stmt.setString(2, bullsU2[1]);
			System.out.println(bullsU2[0]);
			System.out.println(bullsU2[1]);

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
	
	@Override  //公告二檔案
	 public String opensourse_U3_T(String UpbullImg,String UpbullImgUrl) throws SQLException {
			try {
				String qryStmt = "UPDATE LupIndex SET UpbullImg=?,UpbullImgUrl=? where UpbullID ='T2' ";
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
				stmt.setString(1, UpbullImg);
				stmt.setString(2, UpbullImgUrl);


				
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
		 
	
		@Override  //上船公告二的標題 內容
		public String opensourse_U4_T(String[] bullsU2) throws SQLException {
			try {
				String qryStmt = "UPDATE LupIndex SET UpbullName=?,UpbullSum=? where UpbullID ='T2' ";
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
				stmt.setString(1, bullsU2[0]);
				stmt.setString(2, bullsU2[1]);
				System.out.println(bullsU2[0]);
				System.out.println(bullsU2[1]);

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
		
		@Override //上傳影片
		public String opensourse_U5_T(String[] movU5) throws SQLException {
			
			String UpMovieID=movU5[0];


			try {
				
				if(UpMovieID .equalsIgnoreCase("1")) {
					
					String qryStmt = "UPDATE LupMovie SET UpMovieName=?,UpMovieSum=? ,UpMovieURL=? where UpMovieID ='M1' ";
					Connection conn=dataSource.getConnection();
					PreparedStatement stmt = conn.prepareStatement(qryStmt);
					stmt.setString(1, movU5[1]);
					stmt.setString(2, movU5[2]);
					stmt.setString(3, movU5[3]);
					System.out.println(movU5[1]);
					System.out.println(movU5[2]);
					System.out.println(movU5[3]);
					
				    stmt.executeUpdate();
				    System.out.println("success");
				    stmt.close();
					conn.close();
					
					
				}else if(UpMovieID .equalsIgnoreCase("2")){
					
					String qryStmt = "UPDATE LupMovie SET UpMovieName=?,UpMovieSum=? ,UpMovieURL=? where UpMovieID ='M2' ";
					Connection conn=dataSource.getConnection();
					PreparedStatement stmt = conn.prepareStatement(qryStmt);
					stmt.setString(1, movU5[1]);
					stmt.setString(2, movU5[2]);
					stmt.setString(3, movU5[3]);
					System.out.println(movU5[1]);
					System.out.println(movU5[2]);
					System.out.println(movU5[3]);
					
				    stmt.executeUpdate();
				    System.out.println("success");
				    stmt.close();
					conn.close();
					
					
				}else if(UpMovieID .equalsIgnoreCase("3")){
					
					String qryStmt = "UPDATE LupMovie SET UpMovieName=?,UpMovieSum=? ,UpMovieURL=? where UpMovieID ='M3' ";
					Connection conn=dataSource.getConnection();
					PreparedStatement stmt = conn.prepareStatement(qryStmt);
					stmt.setString(1, movU5[1]);
					stmt.setString(2, movU5[2]);
					stmt.setString(3, movU5[3]);
					System.out.println(movU5[1]);
					System.out.println(movU5[2]);
					System.out.println(movU5[3]);
					
				    stmt.executeUpdate();
				    System.out.println("success");
				    stmt.close();
					conn.close();
					
					
				}else if(UpMovieID .equalsIgnoreCase("4")){
					
					String qryStmt = "UPDATE LupMovie SET UpMovieName=?,UpMovieSum=? ,UpMovieURL=? where UpMovieID ='M4' ";
					Connection conn=dataSource.getConnection();
					PreparedStatement stmt = conn.prepareStatement(qryStmt);
					stmt.setString(1, movU5[1]);
					stmt.setString(2, movU5[2]);
					stmt.setString(3, movU5[3]);
					System.out.println(movU5[1]);
					System.out.println(movU5[2]);
					System.out.println(movU5[3]);
					
				    stmt.executeUpdate();
				    System.out.println("success");
				    stmt.close();
					conn.close();
					
					
				}else {
					
					 System.out.println("xxxxxxxxxxxxxxxxxxxxxx");
				}
		
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return null;
		}


		
		
		@Override  //上傳檔案java
		public String opensourse_download_file(String file_name_t,String url_file) throws SQLException {
			try {
				String qryStmt = "  insert into LupFile (UpFileName, UpFileURL , UpFileID) values(?,?,'D1')" ;
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
				stmt.setString(1, file_name_t);
				stmt.setString(2, url_file);


				
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


		@Override //上傳檔案SQL
		public String opensourse_download_file2(String file_name_t, String url_file) throws SQLException {
			try {
				String qryStmt = "  insert into LupFile (UpFileName, UpFileURL , UpFileID) values(?,?,'D2')" ;
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(qryStmt);
				stmt.setString(1, file_name_t);
				stmt.setString(2, url_file);


				
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


		
		
		
		
		
		
		
		
		
		
		





}

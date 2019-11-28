package finalProject.eeit10907.service;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.multipart.MultipartFile;

public interface OpensourseService {
	//開放資源

	
	public String opensourse_U1_T(String UpbullImg,String UpbullImgUrl) throws SQLException;//修改公告一
	public String opensourse_U2_T(String [] bullsU2) throws SQLException;//上船公告一的標題 內容
	public String opensourse_U3_T(String UpbullImg,String UpbullImgUrl) throws SQLException;//修改公告一
	public String opensourse_U4_T(String [] bullsU2) throws SQLException;//上船公告一的標題 內容
	public String opensourse_U5_T(String [] movU5) throws SQLException;//上傳影片
	
	public String opensourse_download_file(String file_name_t,String url_file) throws SQLException;//上傳影片
	public String opensourse_download_file2(String file_name_t,String url_file) throws SQLException;//上傳影片
	
}

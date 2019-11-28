package finalProject.eeit10907.service.imp;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import finalProject.eeit10907.dao.OpensourseDao;
import finalProject.eeit10907.service.OpensourseService;


@Service
@Transactional
public class OpensourseServiceImp implements OpensourseService {
	
	OpensourseDao dao;
	
	
	
	@Autowired
	public void setDao2(OpensourseDao dao2) {
		this.dao = dao2;
	}

	@Override //修改公告一檔案
	public String opensourse_U1_T(String UpbullImg,String UpbullImgUrl) throws SQLException {
		return dao.opensourse_U1_T(UpbullImg,UpbullImgUrl);
	}
	
	@Override //上船公告一的標題 內容
	public String opensourse_U2_T(String[] bullsU2) throws SQLException {
		return dao.opensourse_U2_T(bullsU2);
	}
	
	
	@Override //修改公告二檔案
	public String opensourse_U3_T(String UpbullImg, String UpbullImgUrl) throws SQLException {
		return dao.opensourse_U3_T(UpbullImg,UpbullImgUrl);
	}

	@Override //上船公告二的標題 內容
	public String opensourse_U4_T(String[] bullsU2) throws SQLException {
		return dao.opensourse_U4_T(bullsU2);
	}
	@Override //影片上傳
	public String opensourse_U5_T(String[] movU5) throws SQLException {
		return dao.opensourse_U5_T(movU5);
	}
	
	
	
	@Override //上傳檔案一
	public String opensourse_download_file(String file_name_t,String url_file) throws SQLException {
		return dao.opensourse_download_file(file_name_t,url_file);
	}
	


	@Override
	public String opensourse_download_file2(String file_name_t, String url_file) throws SQLException {
		return dao.opensourse_download_file2(file_name_t,url_file);
	}








}

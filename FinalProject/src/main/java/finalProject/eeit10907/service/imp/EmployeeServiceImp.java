package finalProject.eeit10907.service.imp;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import finalProject.eeit10907.dao.EmployeeDao;
import finalProject.eeit10907.service.EmployeeService;


@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService {
	
	
	EmployeeDao dao;
	@Autowired
	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}
	
	
	
	
	@Override
	public void updateTitle() throws SQLException {
//		return dao.updateTitle();

	}

	@Override
	public void deleteTitle() throws SQLException {
//		return dao.deleteTitle();

	}

	@Override //用員編查詢
	public String Employee_Q1(String[] empidQ1) throws IOException, SQLException {
		return dao.Employee_Q1(empidQ1);
	}
 
	@Override   //用名稱查詢
	public String Employee_Q2(String[] empnameQ2) throws IOException, SQLException {
		return dao.Employee_Q2(empnameQ2);
	}

	@Override  //未設定區
	public String Employee_Q3() throws IOException, SQLException {
		return dao.Employee_Q3();
	}

	@Override  //選課紀錄
	public String Employee_Q4(String[] empidQ4) throws IOException, SQLException {
		return dao.Employee_Q4(empidQ4);
	}


	@Override  //修改頁面所帶的資料
	public String Employee_U1(String empidU1) throws SQLException {
		return dao.Employee_U1(empidU1);
	}

	@Override //修改 個人資料
	public String Employee_U2(String[] upemp) throws SQLException {
		return dao.Employee_U2(upemp);
	}

}

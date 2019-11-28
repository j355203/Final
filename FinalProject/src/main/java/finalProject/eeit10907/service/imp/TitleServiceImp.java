package finalProject.eeit10907.service.imp;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10907.dao.TitleDao;
import finalProject.eeit10907.service.TitleService;
@Service
@Transactional
public class TitleServiceImp implements TitleService {

	TitleDao dao;
	@Autowired
	public void setDao(TitleDao dao) {
		this.dao = dao;
	}
	
	
	
	@Override
	public String title_A1(String[] allTitle1) throws IOException, SQLException {
		return dao.title_A1(allTitle1);
		
		

	}
	@Override
	public String title_Q1() throws IOException, SQLException {
		return dao.title_Q1();
	}

	@Override
	public String title_Q2() throws IOException, SQLException {
		return dao.title_Q2();
	}

	@Override
	public String title_Q3() throws IOException, SQLException {
		return dao.title_Q3();
	}

	@Override
	public String title_Q4(String[] titlenoID) throws IOException, SQLException {
		return dao.title_Q4(titlenoID);
	}

	@Override
	public String title_Q5(String[] titlenoID) throws IOException, SQLException {
		return dao.title_Q5(titlenoID);
	}

	@Override
	public String title_Q6() throws IOException, SQLException {
		return dao.title_Q6();
	}

	@Override
	public String title_D1(String[] TitleID) throws SQLException {
		return dao.title_D1(TitleID);
	}

	@Override
	public String updatetitle_Q7(String[] titleIDQ7) throws SQLException {
		return dao.updatetitle_Q7(titleIDQ7);
	}

	@Override
	public String updatetitle_U1(String[] upTitle) throws SQLException {
		return dao.updatetitle_U1(upTitle);
	}

}

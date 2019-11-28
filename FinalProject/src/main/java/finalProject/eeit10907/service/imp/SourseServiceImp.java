package finalProject.eeit10907.service.imp;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10907.dao.MycourseDao;
import finalProject.eeit10907.dao.SourseDao;
import finalProject.eeit10907.service.SourseService;
@Service
@Transactional
public class SourseServiceImp implements SourseService {
	SourseDao dao;

    
	@Autowired
	public void setDao(SourseDao dao) {
		this.dao = dao;
	}
	@Override
	public String soursefile_Q1(String a1) throws IOException, SQLException {
		return dao.soursefile_Q1(a1);
	}
	@Override
	public String soursemovie_Q2() throws IOException, SQLException {
		return dao.soursemovie_Q2();
	}


}

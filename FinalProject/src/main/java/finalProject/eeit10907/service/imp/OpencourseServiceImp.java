package finalProject.eeit10907.service.imp;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10907.dao.OpencourseDao;
import finalProject.eeit10907.service.OpencourseService;


@Service
@Transactional
public class OpencourseServiceImp implements OpencourseService {
	OpencourseDao dao;
	
	@Autowired
	public void setDao(OpencourseDao dao) {
		this.dao = dao;
	}
	
	
	
	
	@Override
	public String selectcourse_A1(String[] allSubjectValues1) throws IOException, SQLException {
		return dao.selectcourse_A1(allSubjectValues1);
	}

	@Override
	public String selectcourse_A2(String[] allSubjectValues2) throws IOException, SQLException {
		return dao.selectcourse_A2(allSubjectValues2);
	}

	@Override
	public String selectcourse_Q1() throws IOException, SQLException {
		return dao.selectcourse_Q1();
	}

	@Override
	public String selectcourse_Q2() throws IOException, SQLException {
		return dao.selectcourse_Q2();
	}
	@Override
	public String selectcourse_Q3(String courseroom_a1 ) throws IOException, SQLException {
		return dao.selectcourse_Q3(courseroom_a1);
	}

}

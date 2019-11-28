package finalProject.eeit10907.service.imp;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10907.dao.LearningindexDao;
import finalProject.eeit10907.dao.MycourseDao;
import finalProject.eeit10907.dao.SelectcourseDao;
import finalProject.eeit10907.service.LearningindexService;
@Service
@Transactional
public class LearningindexServiceImp implements LearningindexService {
	LearningindexDao dao;

    
	@Autowired
	public void setDao(LearningindexDao dao) {
		this.dao = dao;
	}
	@Override  //顯示公告一
	public String learningindex_Q1() throws IOException, SQLException {
		return dao.learningindex_Q1();
	}

	
	
	@Override  //顯示公告二
	public String learningindex_Q2() throws IOException, SQLException {
		return dao.learningindex_Q2();
	}

}

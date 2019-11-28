package finalProject.eeit10907.service.imp;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10907.dao.SelectcourseDao;
import finalProject.eeit10907.service.SelectcourseService;
@Service
@Transactional
public class SelectcourseServiceImp implements SelectcourseService {
	
	
	SelectcourseDao dao2;
	@Autowired
	public void setDao2(SelectcourseDao dao2) {
		this.dao2 = dao2;
	}
	//選課系統-----------------------------
		@Override
		public String selectcourse_Q1() throws IOException, SQLException {
			return dao2.selectcourse_Q1();
		}

		@Override
		public String selectcourse_Q2(String[] subjectcourseID) throws IOException, SQLException {
			return dao2.selectcourse_Q2(subjectcourseID);
		}

		@Override
		public String selectcourse_Q3(String[] subjectcourseID) throws IOException, SQLException {
			return dao2.selectcourse_Q3(subjectcourseID);
		}

		@Override
		public String selectcourse_Q4() throws IOException, SQLException {
			return dao2.selectcourse_Q4();
		}

		@Override
		public String selectcourse_Q5(String[] subjectcourseID) throws IOException, SQLException {
			return dao2.selectcourse_Q5(subjectcourseID);
		}

		@Override
		public String selectcourse_A6(String[] mycourseadd) throws IOException, SQLException {
			return dao2.selectcourse_A6(mycourseadd);
		}

}

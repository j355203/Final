package finalProject.eeit10907.service.imp;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10907.dao.OpencourseallDao;
import finalProject.eeit10907.service.OpencourseallService;


@Service
@Transactional
public class OpencourseallServiceImp implements OpencourseallService {
	
	
	OpencourseallDao dao;
	@Autowired
	public void setDao(OpencourseallDao dao) {
		this.dao = dao;
	}
	
	
	
	@Override
	public String opencourseall_Q1() throws IOException, SQLException {
		return dao.opencourseall_Q1();
	}

	@Override
	public String opencourseall_Q2(String[] subjectID) throws IOException, SQLException {
		return dao.opencourseall_Q2(subjectID);
	}

	@Override
	public String opencourseall_Q3(String[] subjectID) throws IOException, SQLException {
		return dao.opencourseall_Q3(subjectID);
	}

	@Override
	public String opencourseall_Q4() throws IOException, SQLException {
		return dao.opencourseall_Q4();
	}

	@Override
	public String opencourseall_Q5(String[] subjectID) throws IOException, SQLException {
		return dao.opencourseall_Q5(subjectID);
	}

	@Override
	public String opencourseall_Q6(String[] courseID) throws IOException, SQLException {
		return dao.opencourseall_Q6(courseID);
	}

	@Override
	public String deleteSubject_D1(String[] SubjectIDD1) throws IOException, SQLException {
		return dao.deleteSubject_D1(SubjectIDD1);
	}

	@Override
	public String deleteSubject_D2(String[] CourseIDD2) throws IOException, SQLException {
		return dao.deleteSubject_D2(CourseIDD2);
	}

	@Override
	public String opencourseall_Q7(String[] CourseIDQ7) throws IOException, SQLException {
		return dao.opencourseall_Q7(CourseIDQ7);
	}

	@Override
	public String opencourseall_Q8(String[] CourseIDQ8) throws IOException, SQLException {
		return dao.opencourseall_Q8(CourseIDQ8);
	}

	@Override
	public String updatesubject_U1(String SubjectIU1) throws SQLException {
		return dao.updatesubject_U1(SubjectIU1);
	}

	@Override
	public String updatesubject_U2(String[] SubjectIU2) throws SQLException {
		return dao.updatesubject_U2(SubjectIU2);
	}

	@Override
	public String updatecourse_U3(String CourseIDU3) throws SQLException {
		return dao.updatecourse_U3(CourseIDU3);
	}

	@Override
	public String updatecourse_U4(String[] CourseIDU4) throws SQLException {
		return dao.updatecourse_U4(CourseIDU4);
	}

	@Override
	public String opencourseall_Q10() throws IOException, SQLException {
		return dao.opencourseall_Q10();
	}

	@Override
	public String opencourseall_Q9(String[] CourseIDQ9) throws IOException, SQLException {
		return dao.opencourseall_Q9(CourseIDQ9);
	}




}

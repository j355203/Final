package finalProject.eeit10937.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import finalProject.eeit10937.dao.RegistrationFormDao;
import finalProject.eeit10937.model.RegistrationFormBean;
import finalProject.eeit10937.service.RegistrationFormService;

@Service
public class RegistrationFormServiceImpl implements RegistrationFormService{
	RegistrationFormDao dao;

	@Autowired
	public void setDao(RegistrationFormDao dao) {
		this.dao = dao;
	}

	@Transactional
	@Override
	public List<RegistrationFormBean> getAllRegistrationForm() {
         return dao.getAllRegistrationForm();
	}
	
	@Transactional
	@Override
	public RegistrationFormBean getRegistrationFormById(int formId) {
		return dao.getRegistrationFormById(formId);
	}
	@Transactional
	@Override
	public boolean addRegistrationForm(RegistrationFormBean RegistrationForm) {
		return dao.addRegistrationForm(RegistrationForm);
	}
	
	@Transactional
	@Override
	public void addRegistrationForm1(RegistrationFormBean addRegistrationForm) {
		dao.addRegistrationForm1(addRegistrationForm);
	}
	
	@Transactional
	@Override
	public RegistrationFormBean getURegistrationFormById(int activityId) {
		return dao.getURegistrationFormById(activityId);
	}
	@Transactional
	@Override
	public List<RegistrationFormBean> getRegistrationFormEid(Integer empid) {
		return dao.getRegistrationFormEid(empid);
	}
	
	@Transactional
	@Override
	public List<RegistrationFormBean> getRegistrationFormAid(Integer activityId) {
		return dao.getRegistrationFormAid(activityId);
	}
	@Transactional
	@Override
	public void deleteRegistrationForm(RegistrationFormBean RegistrationFormDel) {
		dao.deleteRegistrationForm(RegistrationFormDel);
		
	}

	
	
}




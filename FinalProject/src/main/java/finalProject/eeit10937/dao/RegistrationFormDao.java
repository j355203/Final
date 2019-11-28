package finalProject.eeit10937.dao;

import java.util.List;

import finalProject.eeit10937.model.RegistrationFormBean;

public interface RegistrationFormDao {
	List<RegistrationFormBean> getAllRegistrationForm();
	
	public RegistrationFormBean getRegistrationFormById(int formId);
	
	boolean addRegistrationForm(RegistrationFormBean RegistrationForm);
	
	void addRegistrationForm1(RegistrationFormBean RegistrationForm);
	
	public RegistrationFormBean getURegistrationFormById(int activityId);
	
	List<RegistrationFormBean> getRegistrationFormEid(Integer empid);
	
	List<RegistrationFormBean> getRegistrationFormAid(Integer activityId);
	
	void deleteRegistrationForm(RegistrationFormBean RegistrationFormDel);
	
}

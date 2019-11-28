package finalProject.eeit10937.service;

import java.util.List;

import finalProject.eeit10937.model.RegistrationFormBean;

public interface RegistrationFormService {
     List<RegistrationFormBean> getAllRegistrationForm();
     
     public RegistrationFormBean getRegistrationFormById(int formId);
     
     boolean addRegistrationForm(RegistrationFormBean addRegistrationForm);
     
     void addRegistrationForm1(RegistrationFormBean addRegistrationForm);
     
     public RegistrationFormBean getURegistrationFormById(int activityId);
     
     List<RegistrationFormBean> getRegistrationFormEid(Integer empid);
     
     List<RegistrationFormBean> getRegistrationFormAid(Integer activityId);
     
     void deleteRegistrationForm(RegistrationFormBean RegistrationFormDel);
     
}

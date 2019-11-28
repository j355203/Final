package finalProject.eeit10937.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import finalProject.eeit10937.dao.RegistrationFormDao;
import finalProject.eeit10937.model.RegistrationFormBean;

@Repository
public class RegistrationFormDaoImpl implements RegistrationFormDao {
	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RegistrationFormBean> getAllRegistrationForm() {
		String hql = "From RegistrationFormBean";
		Session session = null;
		List<RegistrationFormBean> list = new ArrayList<>();
		session = factory.getCurrentSession();
		list = session.createQuery(hql).getResultList();
		return list;

	}

	@Override
	public RegistrationFormBean getRegistrationFormById(int formId) {
		Session session = factory.getCurrentSession();
		RegistrationFormBean rfb = session.get(RegistrationFormBean.class, formId);
		return rfb;
	}

	@Override
	public boolean addRegistrationForm(RegistrationFormBean RegistrationForm) {
		String hql = "FROM RegistrationFormBean  WHERE empid=?0 AND activityId = ?1";
		Session session = factory.getCurrentSession();
		 RegistrationFormBean query = session.createQuery(hql,RegistrationFormBean.class)
		.setParameter(0,RegistrationForm.getEmpid())
		.setParameter(1,RegistrationForm.getActivityId()).uniqueResult();
		if (query == null) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public void addRegistrationForm1(RegistrationFormBean RegistrationForm) {
		Session session = factory.getCurrentSession();
		session.save(RegistrationForm);
	}

	@Override
	public RegistrationFormBean getURegistrationFormById(int activityId) {
		Session session = factory.getCurrentSession();
		RegistrationFormBean rfb1 = session.get(RegistrationFormBean.class, activityId);
		System.out.println(rfb1);
		System.out.println(rfb1.getActivityId());
		System.out.println(rfb1.getFormId());
		System.out.println(rfb1.getEmpname());
		System.out.println(rfb1.getDepno());
		System.out.println(rfb1.getEmpid());
		return rfb1;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RegistrationFormBean> getRegistrationFormEid(Integer empid) {
		String hql = "From RegistrationFormBean where empid=?0";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, empid);
		List<RegistrationFormBean> list = query.getResultList();
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RegistrationFormBean> getRegistrationFormAid(Integer activityId) {
		String hql = "From RegistrationFormBean where activityId=?0";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, activityId);
		List<RegistrationFormBean> list = query.getResultList();
		return list;
	}

	@Override
	public void deleteRegistrationForm(RegistrationFormBean RegistrationFormDel) {
		Session session = factory.getCurrentSession();
		session.delete(RegistrationFormDel);
	}

}

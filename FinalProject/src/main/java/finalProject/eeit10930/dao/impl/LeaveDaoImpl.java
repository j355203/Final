package finalProject.eeit10930.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalProject.eeit10930.dao.LeaveDao;
import finalProject.eeit10930.model.LeaveBean;

@Repository
public class LeaveDaoImpl implements LeaveDao{
	
	private SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void addleave(LeaveBean lb) {
		Session session = factory.getCurrentSession();
//		LeaveBean lb1 = new LeaveBean();
//		lb1.setVerify("未通過");
//		session.save(lb1);
		session.save(lb);
		
	}

	@Override
	public LeaveBean updateleave(LeaveBean lb) {
		LeaveBean result =factory.getCurrentSession().get(LeaveBean.class, lb.getLeaveid());
				
		if(result !=null) {
			result.setDayoffstart(lb.getDayoffstart());
			result.setDayoffend(lb.getDayoffend());
			result.setLeavestyle(lb.getLeavestyle());
			result.setDeptno(lb.getDeptno());
		}		
		return null;
	}

	@Override
	public void deleteleave(Integer leaveid) {
		LeaveBean leavebean = (LeaveBean)factory.getCurrentSession().get(LeaveBean.class, leaveid);	
		 factory.getCurrentSession().delete(leavebean);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LeaveBean> queryleave(Integer empid) {
		
		Query<LeaveBean> query = factory.getCurrentSession().createQuery("FROM LeaveBean WHERE empid= :no order by leaveid desc");
		query.setParameter("no", empid);
		List<LeaveBean> list = (List<LeaveBean>) query.list();
		return list;
		
	}

	@Override
	public LeaveBean findbyleaveId(Integer leaveid) {	
		return factory.getCurrentSession().get(LeaveBean.class, leaveid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LeaveBean> findbydeptno(Integer deptno) {	
		Query<LeaveBean> query = factory.getCurrentSession().createQuery("FROM LeaveBean WHERE deptno= :no order by leaveid desc");
		query.setParameter("no", deptno);
		List<LeaveBean> list = (List<LeaveBean>) query.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void updateverify(LeaveBean lb) {
//		LeaveBean result =factory.getCurrentSession().get(LeaveBean.class, lb.getVerify());		
//		if(result !=null) {
//			result.setVerify(lb.getVerify());
//		}
		Session session = factory.getCurrentSession();
		session.update(lb);
	}


}

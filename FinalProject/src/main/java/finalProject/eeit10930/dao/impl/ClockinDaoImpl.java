package finalProject.eeit10930.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalProject.eeit10930.dao.ClockinDao;
import finalProject.eeit10930.model.ClockinBean;
import finalProject.eeit10930.model.LeaveBean;

@Repository
public class ClockinDaoImpl implements ClockinDao{

	private SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void addclockin(ClockinBean cb) {
		Session session = factory.getCurrentSession();
		session.save(cb);	
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void updateclockout(ClockinBean cb) {
		System.out.println(cb.getEmpid());
		String hql = "select max(cb.clockinid) from ClockinBean cb where cb.empid = :empid";
		Session session = factory.getCurrentSession();
		List target = session.createQuery(hql).setParameter("empid", cb.getEmpid()).getResultList();
		String hql2 = "from ClockinBean where empid=:empid AND clockinid=:clockinid";
		System.out.println((int)(target.get(0)));
		List<ClockinBean> newCb = session.createQuery(hql2).setParameter("empid", cb.getEmpid()).setParameter("clockinid", (int)(target.get(0))).getResultList();
		ClockinBean targetCb = newCb.get(0);
		targetCb.setClkouttime(cb.getClkouttime());
		factory.getCurrentSession().update(targetCb);
		

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClockinBean> selectclockin(Integer empid) {
		
		Query<ClockinBean> query = factory.getCurrentSession().createQuery("FROM ClockinBean WHERE empid= :no order by clockinid desc");
		query.setParameter("no", empid);
		List<ClockinBean> list = (List<ClockinBean>) query.list();
		return list;
	}
	
	@Override
	public ClockinBean findbyempid(Integer empid) {
		return factory.getCurrentSession().get(ClockinBean.class, empid);
	}

	@Override
	public ClockinBean findbyclockinid(Integer clockinid) {
		return factory.getCurrentSession().get(ClockinBean.class, clockinid);
	}
	//管理員查詢加班
	@SuppressWarnings("unchecked")
	@Override
	public List<ClockinBean> findbydepno(Integer depno) {
		Query<ClockinBean> query = factory.getCurrentSession().createQuery("FROM ClockinBean WHERE depno= :no order by clockinid desc");
		query.setParameter("no", depno);
		List<ClockinBean> list = (List<ClockinBean>) query.list();
		return list;
	
	}

	@Override
	public ClockinBean updateovertime(ClockinBean cb) {
		ClockinBean result = factory.getCurrentSession().get(ClockinBean.class,cb.getClockinid());
		if(result!=null) {
			result.setOvertime(cb.getOvertime());
			result.setVerify(cb.getVerify());
		}
		return null;
	}

	@Override
	public void updateverify(ClockinBean cb) {
		Session session = factory.getCurrentSession();
		session.update(cb);
		
	}

}

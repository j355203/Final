package finalProject.eeit10904.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalProject.eeit10904.dao.IDepartmentDao;
import finalProject.eeit10904.exception.DepartmentDeleteFoundFKException;
import finalProject.eeit10904.model.DepartmentBean;
import finalProject.eeit10904.model.EmployeeBean;

@Repository
public class DepartmentDaoImpl implements IDepartmentDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public Integer add(DepartmentBean dep) {
		@SuppressWarnings("unchecked")
		Query<DepartmentBean> query = factory.getCurrentSession()
				.createQuery("FROM DepartmentBean WHERE depname like :depname");
		query.setParameter("depname", dep.getDepname());
		try {
			DepartmentBean result = (DepartmentBean) query.getSingleResult();
			return result.getDepno();
		} catch (NoResultException e) {
			Integer depno = (Integer) this.factory.getCurrentSession().save(dep);
			System.out.println("部門新增成功，部門編號為： " + depno);
			return depno;
		}
	}

	@Override
	public DepartmentBean update(DepartmentBean dep) {
		DepartmentBean result = (DepartmentBean) factory.getCurrentSession().get(DepartmentBean.class, dep.getDepno());
		if (result != null) {
			System.out.println("正在更新之部門No為： " + result.getDepno());
			result.setDepname(dep.getDepname());
			return result;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean delete(Integer depno) {
		Query<EmployeeBean> query = factory.getCurrentSession().
				createQuery("FROM EmployeeBean WHERE depno like :depno");
		query.setParameter("depno", depno);
		List<EmployeeBean> result = query.getResultList();//不應有值
		System.out.println("要刪除的" + depno + "內有" + result.size() + "位員工");
		
		DepartmentBean dep = factory.getCurrentSession().get(DepartmentBean.class, depno);

		if (result.size() != 0) {//如果有值則丟出例外
			throw new DepartmentDeleteFoundFKException("還有" + result.size() + "位員工在" 
				+ dep.getDepno() + "-" + dep.getDepname() + "部門內，請先刪除部門內所屬員工", depno);
		}else {//如果沒值代表不會發生FK條件約束而無法刪除，繼續處理
			if (dep != null) {
				factory.getCurrentSession().delete(dep);
			}
		}
		return true;
	}

	@Override
	public DepartmentBean findByNo(Integer depno) {
		return factory.getCurrentSession().get(DepartmentBean.class, depno);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DepartmentBean> findAll() {
		String hql = "FROM DepartmentBean";
		Session session = factory.getCurrentSession();
		List<DepartmentBean> list = session.createQuery(hql).getResultList();
		return list;
	}
}

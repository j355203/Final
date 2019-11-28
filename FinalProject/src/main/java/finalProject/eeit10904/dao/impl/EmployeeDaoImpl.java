package finalProject.eeit10904.dao.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import finalProject.eeit10904.dao.IEmployeeDao;
import finalProject.eeit10904.model.DepartmentBean;
import finalProject.eeit10904.model.EmployeeBean;
import finalProject.eeit10904.utils.CipherUtils;
import finalProject.eeit10904.utils.CsvUtils;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	private SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	// 登入驗證
	@Override
	public boolean verify(EmployeeBean emp) {
		Session session = factory.getCurrentSession();
		String hql = "FROM EmployeeBean WHERE empid =?0 AND emppassword =?1 AND empleave =0";
		boolean check = false;

		String key = "EEIT09JASONHSIEH";
		String EncodePassword_AES = CipherUtils.encryptString(key, emp.getEmppassword());
		EmployeeBean employee = (EmployeeBean) session.createQuery(hql).setParameter(0, emp.getEmpid())
				.setParameter(1, EncodePassword_AES).uniqueResult();
		if (employee != null) {
			System.out.println(employee.getEmpname() + "驗證登入成功");
			check = true;
		}

		return check;
	}

	// 新增員工
	@Override
	public Integer add(EmployeeBean emp) {
		Session session = factory.getCurrentSession();

		DepartmentBean dep = getDepByNo(emp.getDepno());
		emp.setDepBean(dep);

		String key = "EEIT09JASONHSIEH";
		String EncodePassword_AES = CipherUtils.encryptString(key, "Eeit!109");
		emp.setEmppassword(EncodePassword_AES);

		Integer empID = (Integer) session.save(emp);
		System.out.println("empID:" + empID);
		return empID;
	}

	// 取得PkFk
	@Override
	public DepartmentBean getDepByNo(Integer depno) {
		DepartmentBean dep = null;
		Session session = factory.getCurrentSession();
		dep = session.get(DepartmentBean.class, depno);
		return dep;
	}

	// 更新員工
	@Override
	public EmployeeBean update(EmployeeBean emp) {
		EmployeeBean result = (EmployeeBean) factory.getCurrentSession().get(EmployeeBean.class, emp.getEmpid());
		if (result != null) {
			System.out.println("正在更新之員工ID為: " + result.getEmpid());
			result.setEmpname(emp.getEmpname());
			result.setEmpgender(emp.getEmpgender());
			result.setEmpbirth(emp.getEmpbirth());
			result.setDepno(emp.getDepno());
			result.setEmptitle(emp.getEmptitle());
			result.setEmplevel(emp.getEmplevel());
			result.setEmpphone(emp.getEmpphone());
			result.setEmpaddress(emp.getEmpaddress());
			result.setEmponboard(emp.getEmponboard());
			result.setEmppassword(result.getEmppassword());
			return result;
		}
		return null;
	}

	// 更新員工密碼
	@SuppressWarnings("rawtypes")
	@Override
	public boolean updatepassword(EmployeeBean emp) {
		Session session = factory.getCurrentSession();
		EmployeeBean result = session.get(EmployeeBean.class, emp.getEmpid());
		String key = "EEIT09JASONHSIEH";
		if (result != null) {
			String oldpassword = CipherUtils.decryptString(key, result.getEmppassword());
			if (!oldpassword.equals(emp.getEmppassword())) {
				System.out.println("辦理員工" + result.getEmpname() + "密碼變更，輸入新密碼為： " + emp.getEmppassword());
				String hql = "UPDATE EmployeeBean SET emppassword =?0 WHERE empid =?1";
				String EncodePassword_AES = CipherUtils.encryptString(key, emp.getEmppassword());
				Query query = session.createQuery(hql);
				query.setParameter(0, EncodePassword_AES);
				query.setParameter(1, emp.getEmpid());
				query.executeUpdate();
				return true;
			} else {
				System.out.println("新舊密碼相同");
				return false;
			}
		}
		System.out.println("沒有這個員工");
		return false;
	}

	// 員工離職
	@SuppressWarnings("rawtypes")
	@Override
	public EmployeeBean leave(Integer empid) {
		Session session = factory.getCurrentSession();
		EmployeeBean result = session.get(EmployeeBean.class, empid);
		if (result != null) {
			System.out.println("辦理員工 " + result.getEmpname() + "之離職手續");
			String hql = "UPDATE EmployeeBean SET empleave = 1 WHERE empid =?0";
			Query query = session.createQuery(hql);
			query.setParameter(0, result.getEmpid());
			query.executeUpdate();
			return result;
		} else {
			return null;
		}
	}

	// 員工回任
	@SuppressWarnings("rawtypes")
	@Override
	public EmployeeBean repatriation(Integer empid) {
		Session session = factory.getCurrentSession();
		EmployeeBean result = session.get(EmployeeBean.class, empid);
		if (result != null) {
			System.out.println("辦理員工 " + result.getEmpname() + "之回任手續");
			String hql = "UPDATE EmployeeBean SET empleave = 0 WHERE empid =?0";
			Query query = session.createQuery(hql);
			query.setParameter(0, result.getEmpid());
			query.executeUpdate();
			return result;
		}
		return null;
	}

	// 查詢一筆員工
	@Override
	public EmployeeBean findById(Integer empid) {
		return factory.getCurrentSession().get(EmployeeBean.class, empid);
	}

	// 查詢全部在職員工
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeBean> findAll() {
		String hql = "FROM EmployeeBean WHERE empleave = 0";
		Session session = factory.getCurrentSession();
		List<EmployeeBean> list = session.createQuery(hql).getResultList();
		return list;
	}

	// 查詢全部離職員工
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeBean> findLeaves() {
		String hql = "FROM EmployeeBean WHERE empleave = 1";
		Session session = factory.getCurrentSession();
		List<EmployeeBean> list = session.createQuery(hql).getResultList();
		return list;
	}

	// 輸出成csv
	@Override
	public byte[] exportUsersToCsv(List<EmployeeBean> emps) {
		List<LinkedHashMap<String, Object>> exportData = new ArrayList<>(emps.size());
		for (EmployeeBean emp : emps) {
			LinkedHashMap<String, Object> rowData = new LinkedHashMap<>();
			rowData.put("1", emp.getEmpid());
			rowData.put("2", emp.getEmpname());
			rowData.put("3", emp.getEmpgender());
			rowData.put("4", emp.getEmpbirth());
			rowData.put("5", emp.getDepBean().getDepno());
			rowData.put("6", emp.getEmptitle());
			rowData.put("7", emp.getEmplevel());
			rowData.put("8", emp.getEmpphone());
			rowData.put("9", emp.getEmpaddress());
			rowData.put("10", emp.getEmponboard());
			exportData.add(rowData);
		}
		LinkedHashMap<String, String> header = new LinkedHashMap<>();
		header.put("1", "員工代號");
		header.put("2", "員工姓名");
		header.put("3", "員工性別");
		header.put("4", "員工生日");
		header.put("5", "部門編號");
		header.put("6", "員工職稱");
		header.put("7", "員工權限");
		header.put("8", "員工電話");
		header.put("9", "居住地址");
		header.put("10", "到職日期");
		return CsvUtils.exportCSV(header, exportData);
	}
}

package finalProject.eeit10930.service;

import java.util.List;

import finalProject.eeit10930.model.ClockinBean;

public interface ClockinService {
	void addclockin(ClockinBean cb); 	
	void updateclockout(ClockinBean cb); 
	List<ClockinBean> selectclockin(Integer empid); 
	ClockinBean findbyempid(Integer empid);
	ClockinBean findbyclockinid(Integer clockinid);
	List<ClockinBean> findbydepno(Integer depno);
	ClockinBean updateovertime(ClockinBean cb);
	void updateverify (ClockinBean cb);
}

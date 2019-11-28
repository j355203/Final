package finalProject.eeit10930.dao;

import java.util.List;

import finalProject.eeit10930.model.ClockinBean;
import finalProject.eeit10930.model.LeaveBean;

public interface ClockinDao {
	void addclockin(ClockinBean cb); //上班打卡	
	void updateclockout(ClockinBean cb); //下班打卡
	List<ClockinBean> selectclockin(Integer empid); //員工查詢打卡紀錄	
	ClockinBean findbyempid(Integer empid); //依員工編號查詢打卡紀錄
	ClockinBean findbyclockinid(Integer clockinid);
	List<ClockinBean> findbydepno(Integer depno);//管理員查詢部門請假
	ClockinBean updateovertime(ClockinBean cb);//員工申請加班
	void updateverify (ClockinBean cb);//管理員修改審核欄位
	
	
}

package finalProject.eeit10919.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import finalProject.eeit10919.model.PageFormat;
import finalProject.eeit10919.model.StoreBean;
import finalProject.eeit10919.service.OrderListPageService;
import finalProject.eeit10919.service.OrderPageService;
import finalProject.eeit10919.service.StoreManagePageService;

@Controller
public class StoreManagePageController {
	Gson gson = new Gson();
	StoreManagePageService storeManagePageService;
	OrderListPageService orderListPageService;
	OrderPageService orderPageService;

	@Autowired
	public void setStoreManagePageService(StoreManagePageService storeManagePageService) {
		this.storeManagePageService = storeManagePageService;
	}

	@Autowired
	public void setOrderListPageService(OrderListPageService orderListPageService) {
		this.orderListPageService = orderListPageService;
	}

	@Autowired
	public void setOrderPageService(OrderPageService orderPageService) {
		this.orderPageService = orderPageService;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/storemanage")
	public String storeManage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		int totalRec = storeManagePageService.getAllStoreNumber();
		List<Integer> idList = storeManagePageService.getAllStoreId();
		session.setAttribute("totalRec", totalRec);
		session.setAttribute("idList", idList);
		String pageInfo = gson.toJson(orderListPageService.pageDataWraper((int) session.getAttribute("totalRec"), 1, 10,
				(List<Integer>) session.getAttribute("idList")));
		model.addAttribute("pageInfo", pageInfo);
		return "StoreManagePage";
	}

	@RequestMapping(value = "/storemanage/updatestore", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public int storeEdit(@RequestBody StoreBean storeData, Model model, HttpServletRequest request) {
		storeManagePageService.updateStoreData(storeData);
		return 200;
	}

	@RequestMapping(value = "/storemanage/addstore", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public int storeAdd(@ModelAttribute StoreBean storeData, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		List<StoreBean> storesData = new ArrayList<StoreBean>();
		storeData.setStoreImg("/images2/eeit10919/" + storeData.getStoreName() + "/"  + storeData.getStoreName() + ".png");
		storesData.add(storeData);
		session.setAttribute("store", storesData);
		storeManagePageService.addStore(storeData);
		return 200;
	}

	//寫入圖片到指定資料夾
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/storemanage/updateimg", method = RequestMethod.POST)
	@ResponseBody
	public int updateStoreImg(@ModelAttribute MultipartFile img, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		StoreBean storeData = ((List<StoreBean>) session.getAttribute("store")).get(0);
		int lastPattern = storeData.getStoreImg().lastIndexOf("/");
		String fileName = storeData.getStoreImg().substring(lastPattern + 1, storeData.getStoreImg().length());
		if (img != null) {
			storeManagePageService.writeImgToFolder(img, storeData.getStoreName(), fileName);
		}
		return 0;
	}

	//將資料根據頁碼包裝器分頁
	@SuppressWarnings("unchecked")
	@RequestMapping("/storemanage/store/page={page}&recperpage={recPerPage}.json")
	public String getAllStoreData(@PathVariable Integer page, @PathVariable Integer recPerPage, Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		PageFormat pageInfo = orderListPageService.pageDataWraper((int) session.getAttribute("totalRec"), page,
				recPerPage, (List<Integer>) session.getAttribute("idList"));
		List<StoreBean> storeData = storeManagePageService.getAllStoreDataByPage(pageInfo);
		model.addAttribute("storeData", storeData);
		model.addAttribute("pageInfo", pageInfo);
		return "StoreManagePage";
	}

	//當前端頁面即將訪問特定店家時先把店家相關資訊放到session中
	@RequestMapping("/storemanage/store/store={storeId}.json")
	@ResponseBody
	public List<StoreBean> getTargetStoreData(@PathVariable Integer storeId, Model model, HttpServletRequest request) {
		List<StoreBean> targetStoreData = orderPageService.getStoreDataByIdWithOutRandom(storeId);
		HttpSession session = request.getSession(false);
		session.setAttribute("store", targetStoreData);
		return targetStoreData;
	}
}

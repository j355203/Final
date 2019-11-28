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

import finalProject.eeit10919.model.MainCourseBean;
import finalProject.eeit10919.model.PageFormat;
import finalProject.eeit10919.model.StoreBean;
import finalProject.eeit10919.service.MainCourseManagePageService;
import finalProject.eeit10919.service.OrderListPageService;
import finalProject.eeit10919.service.StoreManagePageService;

@Controller
public class MainCourseManagePageController {
	Gson gson = new Gson();
	OrderListPageService orderListPageService;
	StoreManagePageService storeManagePageService;
	MainCourseManagePageService mainCourseManagePageService;

	@Autowired
	public void setOrderListPageService(OrderListPageService orderListPageService) {
		this.orderListPageService = orderListPageService;
	}

	@Autowired
	public void setStoreManagePageService(StoreManagePageService storeManagePageService) {
		this.storeManagePageService = storeManagePageService;
	}

	@Autowired
	public void setMainCourseManagePageService(MainCourseManagePageService mainCourseManagePageService) {
		this.mainCourseManagePageService = mainCourseManagePageService;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/mainCourse")
	public String mainCoursePage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		int id = ((List<StoreBean>) session.getAttribute("store")).get(0).getStoreId();
		String storeImg = ((List<StoreBean>) session.getAttribute("store")).get(0).getStoreImg();
		String storeName = ((List<StoreBean>) session.getAttribute("store")).get(0).getStoreName();
		System.out.println("id : " + id);
		int totalRec = mainCourseManagePageService.getMainCourseNumberByStoreId(id);
		List<Integer> idList = mainCourseManagePageService.getMainCourseIdByStoreId(id);
		session.setAttribute("totalRec", totalRec);
		session.setAttribute("idList", idList);
		String pageInfo = gson.toJson(orderListPageService.pageDataWraper((int) session.getAttribute("totalRec"), 1, 10,
				(List<Integer>) session.getAttribute("idList")));
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("storeImg", gson.toJson(storeImg));
		model.addAttribute("storeName", gson.toJson(storeName));
		return "MainCourseManagePage";
	}

	@RequestMapping(value = "/mainCourse/update", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public int mainCourseEdit(@RequestBody MainCourseBean mainCourse, Model model) {
		mainCourseManagePageService.updateMainCourse(mainCourse);
		return 200;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/mainCourse/add", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public int storeAdd(@ModelAttribute MainCourseBean mainCourse, Model model, HttpServletRequest request) {
		System.out.println(mainCourse);
		HttpSession session = request.getSession(false);
		StoreBean storeInfo = ((List<StoreBean>)session.getAttribute("store")).get(0);
		mainCourse.setStoreBean(storeInfo);
		mainCourse.setProductImg("/images2/eeit10919/" + storeInfo.getStoreName() + "/"  + mainCourse.getProductName() + ".png");
		List<MainCourseBean> mainCourseList = new ArrayList<MainCourseBean>();
		mainCourseList.add(mainCourse);
		session.setAttribute("mainCourseList", mainCourseList);
		mainCourseManagePageService.addMainCourse(mainCourse);
		return 200;
	}

	// 寫入圖片到指定資料夾
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/mainCourse/updateimg", method = RequestMethod.POST)
	@ResponseBody
	public int updateStoreImg(@ModelAttribute MultipartFile img, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		MainCourseBean mainCoursData = ((List<MainCourseBean>) session.getAttribute("mainCourseList")).get(0);
		int lastPattern = mainCoursData.getProductImg().lastIndexOf("/");
		String fileName = mainCoursData.getProductImg().substring(lastPattern + 1,
				mainCoursData.getProductImg().length());
		String dirFullName = mainCoursData.getProductImg().substring(0, lastPattern);
		int dirLastPattern = dirFullName.lastIndexOf("/");
		String dirName = dirFullName.substring(dirLastPattern + 1,
				dirFullName.length());
		System.out.println(fileName);
		System.out.println(dirName);
		if (img != null) {
			storeManagePageService.writeImgToFolder(img, dirName, fileName);
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/mainCourse/page={page}&recperpage={recPerPage}.json")
	public String getAllStoreData(@PathVariable Integer page, @PathVariable Integer recPerPage, Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		int id = ((List<StoreBean>) session.getAttribute("store")).get(0).getStoreId();
		PageFormat pageInfo = orderListPageService.pageDataWraper((int) session.getAttribute("totalRec"), page,
				recPerPage, (List<Integer>) session.getAttribute("idList"));
		List<MainCourseBean> mainCourseList = mainCourseManagePageService.getAllMainCourseByStoreIdAndPage(id,
				pageInfo);
		model.addAttribute("mainCourseList", mainCourseList);
		model.addAttribute("pageInfo", pageInfo);
		return "MainCourseManagePage";
	}

	// 當前端頁面即將訪問特定店家時先把店家相關資訊放到session中
	@RequestMapping("/mainCourse/mainCourse={productId}.json")
	@ResponseBody
	public List<MainCourseBean> getTargetStoreData(@PathVariable Integer productId, Model model, HttpServletRequest request) {
		List<MainCourseBean> mainCoursData = mainCourseManagePageService.getMainCourseByProductId(productId);
		HttpSession session = request.getSession(false);
		session.setAttribute("mainCourseList", mainCoursData);
		return mainCoursData;
	}

}

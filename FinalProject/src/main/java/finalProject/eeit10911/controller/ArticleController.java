package finalProject.eeit10911.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import finalProject.eeit10904.model.EmployeeBean;
import finalProject.eeit10904.service.EmployeeService;
import finalProject.eeit10911.model.Article;
import finalProject.eeit10911.model.Reply;
import finalProject.eeit10911.service.ArticleService;
import finalProject.eeit10911.service.ReplyService;

@Controller
public class ArticleController {
	ArticleService service1;

	@Autowired
	public void setService(ArticleService service1) {
		this.service1 = service1;
	}

	ReplyService service2;

	@Autowired
	public void setService(ReplyService service2) {
		this.service2 = service2;
	}

	EmployeeService service3;

	@Autowired
	public void setService(EmployeeService service3) {
		this.service3 = service3;
	}

	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}

	// 查詢(Select)
	// 檢視全文章(不含違規)
	@RequestMapping("/SelectAllArticle")
	public String selectAllArticle(Model model) {
		List<Article> AB = service1.selectPass();
		model.addAttribute("AB", AB);
		return "SelectAllArticle";
	}

	// 檢視分類文章(提供查詢分類表單)
	@RequestMapping(value = "/SelectArticleByClass", method = RequestMethod.GET)
	public String SelectArticleByClassForm(Model model, HttpServletRequest request) {
		Article AB = new Article();
		AB.setArticleClass("公告");
		request.setAttribute("AB", AB);
		model.addAttribute("SelectArticleByClass", AB);
		return "SelectArticleByClass";
	}

	// 檢視分類文章(傳送查詢結果)
	@RequestMapping(value = "/SelectArticleByClass", method = RequestMethod.POST)
	public String SelectArticleByClass(@ModelAttribute("SelectArticleByClass") Article ABL, Model model,
			RedirectAttributes redirectAttributes) {
		List<Article> AB = service1.selectByArticleClass(ABL.getArticleClass());
		model.addAttribute("AB", AB);
		redirectAttributes.addFlashAttribute("AB", AB);
		return "redirect:/SelectArticleByClassView";
	}

	// 顯示檢視分類文章結果的頁面
	@RequestMapping("/SelectArticleByClassView")
	public String selectArticleByClassView(Model model) {
		return "SelectAllArticle";
	}

	// 檢視全文章(後台)
	@RequestMapping("/SelectAll-admin")
	public String selectAllArticleAdmin(Model model) {
		List<Article> AB = service1.selectAll();
		model.addAttribute("AB", AB);
		return "SelectAll-admin";
	}

	// 檢視被檢舉文章(後台)
	@RequestMapping("/SelectReport-admin")
	public String selectAllRreportedArticleAdmin(Model model) {
		List<Article> AB = service1.reportedArticle();
		model.addAttribute("AB", AB);
		return "SelectReport-admin";
	}

	// 檢視檢舉通過文章(後台)
	@RequestMapping("/SelectExamined-admin")
	public String selectAllExaminedArticleAdmin(Model model) {
		List<Article> AB = service1.examinedArticle();
		model.addAttribute("AB", AB);
		return "SelectExamined-admin";
	}

	// 檢視檢舉未通過文章(後台)
	@RequestMapping("/SelectToBeDeleted-admin")
	public String selectAllToBeDeletedArticleAdmin(Model model) {
		List<Article> AB = service1.toBeDeletedArticle();
		model.addAttribute("AB", AB);
		return "SelectToBeDeleted-admin";
	}

	// 檢視單筆文章(前端使用者)
	@RequestMapping("/SelectArticle")
	public String selectArticle(@RequestParam("articleId") Integer articleId, Model model) {
		model.addAttribute("AB", service1.findByArticleID(articleId));
		model.addAttribute("RBL", service2.selectReplyByArticleID(articleId));
		model.addAttribute("emp", service3.findById(service1.findByArticleID(articleId).getEmpId()));
		return "SelectArticle";
	}

	// 檢視單筆文章(後台)
	@RequestMapping("/SelectArticle-admin")
	public String selectArticleAdmin(@RequestParam("articleId") Integer articleId, Model model) {
		model.addAttribute("AB", service1.findByArticleID(articleId));
		model.addAttribute("RBL", service2.selectReplyByArticleID(articleId));
		model.addAttribute("emp", service3.findById(service1.findByArticleID(articleId).getEmpId()));
		return "SelectArticle-admin";
	}

	// 檢視單筆被檢舉文章(後台)
	@RequestMapping("/SelectArticleReport-admin")
	public String selectRreportedArticleAdmin(@RequestParam("articleId") Integer articleId, Model model) {
		model.addAttribute("AB", service1.findByArticleID(articleId));
		model.addAttribute("RBL", service2.selectReplyByArticleID(articleId));
		model.addAttribute("emp", service3.findById(service1.findByArticleID(articleId).getEmpId()));
		return "SelectArticleReport-admin";
	}

	// 檢視單筆檢舉通過文章(後台)
	@RequestMapping("/SelectArticleExamined-admin")
	public String selectExaminedArticleAdmin(@RequestParam("articleId") Integer articleId, Model model) {
		model.addAttribute("AB", service1.findByArticleID(articleId));
		model.addAttribute("RBL", service2.selectReplyByArticleID(articleId));
		model.addAttribute("emp", service3.findById(service1.findByArticleID(articleId).getEmpId()));
		return "SelectArticleExamined-admin";
	}

	// 檢視單筆檢舉未通過文章(後台)
	@RequestMapping("/SelectArticleToBeDeleted-admin")
	public String selectToBeDeletedArticleAdmin(@RequestParam("articleId") Integer articleId, Model model) {
		model.addAttribute("AB", service1.findByArticleID(articleId));
		model.addAttribute("RBL", service2.selectReplyByArticleID(articleId));
		model.addAttribute("emp", service3.findById(service1.findByArticleID(articleId).getEmpId()));
		return "SelectArticleToBeDeleted-admin";
	}

	// 新增(Create)
	// 提供新增文章的表單
	@RequestMapping(value = "/InsertArticle", method = RequestMethod.GET)
	public String insertArticle(Model model, HttpServletRequest request) {
		Article AB = new Article();
		EmployeeBean emp = (EmployeeBean) request.getSession().getAttribute("emp");
		AB.setArticleClass("公告");
		AB.setEmpId(emp.getEmpid());
		request.setAttribute("AB", AB);
		model.addAttribute("InsertArticle", AB);
		return "InsertArticle";
	}

	// 接收新增文章結果並重定向
	@RequestMapping(value = "/InsertArticle", method = RequestMethod.POST)
	public String insertArticleRedirect(@ModelAttribute("InsertArticle") Article AB,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
		String articleContent = request.getParameter("articleContent");
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String createDate = sdFormat.format(date);
		AB.setArticleContent(articleContent);
		AB.setCreateDate(createDate);
		request.setAttribute("AB", AB);
		service1.insert(AB);
		redirectAttributes.addFlashAttribute("AB", AB);
		return "redirect:/InsertArticleView";
	}

	// 顯示新增文章結果的頁面
	@RequestMapping("/InsertArticleView")
	public String insertArticleView(Model model) {
		return "SelectArticle";
	}

	// 修改(Update)
	// 提供更新文章的表單
	@RequestMapping(value = "/UpdateArticle/{articleId}", method = RequestMethod.GET)
	public String updateArticle(@PathVariable Integer articleId, Model model) {
		Article AB = service1.findByArticleID(articleId);
		model.addAttribute("AB", AB);
		return "UpdateArticle";
	}

	// 接收更新文章結果並重定向
	@RequestMapping(value = "/UpdateArticle/{articleId}", method = RequestMethod.POST)
	public String updateArticleRedirect(@ModelAttribute("UpdateArticle") Article AB,
			RedirectAttributes redirectAttributes, HttpServletRequest request) {
//		String articleContent = request.getParameter("articleContent").replaceAll("\n", "<br>");
		String articleContent = request.getParameter("articleContent");
		AB.setArticleContent(articleContent);
		request.setAttribute("AB", AB);
		service1.update(AB);
		List<Reply> RBL = service2.selectReplyByArticleID(AB.getArticleId());
		request.setAttribute("RBL", RBL);
		redirectAttributes.addFlashAttribute("AB", AB);
		redirectAttributes.addFlashAttribute("RBL", RBL);
		return "redirect:/UpdateArticleView";
	}

	// 顯示更新文章結果的頁面
	@RequestMapping("/UpdateArticleView")
	public String updateArticleView(Model model) {
		return "SelectArticle";
	}

	// 刪除(Delete)
	// 刪除後直接導向總覽
	@RequestMapping(value = "/DeleteArticle/{articleId}")
	public String deleteArticle(@PathVariable Integer articleId, Model model) {
		service2.deleteFromArticleId(articleId);
		service1.delete(articleId);
		return "redirect:/SelectAllArticle";
	}

	// 檢舉(Report)
	// 一般使用者檢舉
	@RequestMapping(value = "/ReportButton", method = RequestMethod.POST)
	public String ReportButton(@ModelAttribute("reportSpace") Article AB, RedirectAttributes redirectAttributes) {
		AB.setReportStatus(1);
		service1.report(AB);
		redirectAttributes.addFlashAttribute("AB", AB);
		return "redirect:/SelectArticle";
	}

	// 後台檢舉審核通過
	@RequestMapping(value = "/ReportButtonPass", method = RequestMethod.POST)
	public String ReportButtonPass(@ModelAttribute("reportSpace") Article AB, RedirectAttributes redirectAttributes) {
		AB.setReportStatus(2);
		service1.report(AB);
		redirectAttributes.addFlashAttribute("AB", AB);
		return "redirect:/SelectArticleReport-admin";
	}

	// 後台檢舉審核未通過
	@RequestMapping(value = "/ReportButtonUnPass", method = RequestMethod.POST)
	public String ReportButtonUnPass(@ModelAttribute("reportSpace") Article AB, RedirectAttributes redirectAttributes) {
		AB.setReportStatus(3);
		service1.report(AB);
		redirectAttributes.addFlashAttribute("AB", AB);
		return "redirect:/SelectArticleReport-admin";
	}

	// 將分類資訊加入分類表單
	@ModelAttribute("classMap")
	public Map<String, String> getClassList() {
		Map<String, String> classMap = new HashMap<String, String>();
		classMap.put("公告", "公告");
		classMap.put("心得", "心得");
		classMap.put("問題", "問題");
		classMap.put("討論", "討論");
		classMap.put("部門", "部門");
		classMap.put("主管", "主管");
		classMap.put("閒聊", "閒聊");
		classMap.put("其他", "其他");
		return classMap;
	}
}

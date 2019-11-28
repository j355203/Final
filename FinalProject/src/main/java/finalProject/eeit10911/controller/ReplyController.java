package finalProject.eeit10911.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
public class ReplyController {
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

	// 新增(Create)
	// 提供新增回覆的表單
	@RequestMapping(value = "/InsertReply/{articleId}", method = RequestMethod.GET)
	public String insertReply(@PathVariable Integer articleId, Model model, HttpServletRequest request) {
		EmployeeBean emp = (EmployeeBean) request.getSession().getAttribute("emp");
		Article AB = service1.findByArticleID(articleId);
		Reply RBL = new Reply();
		RBL.setEmpId(emp.getEmpid());
		RBL.setEmpName(emp.getEmpname());
		model.addAttribute("AB", AB);
		model.addAttribute("RBL", RBL);
		return "InsertReply";
	}

	// 接收新增回覆結果並重定向
	@RequestMapping(value = "/InsertReply/{articleId}", method = RequestMethod.POST)
	public String insertArticleRedirect(@ModelAttribute("InsertReply") Reply RB, RedirectAttributes redirectAttributes,
			HttpServletRequest request) {
		String replyContent = request.getParameter("replyContent");
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String replyDate = sdFormat.format(date);
		RB.setReplyContent(replyContent);
		RB.setReplyDate(replyDate);
		Article AB = new Article();
		request.setAttribute("RB", RB);
		service2.insert(RB);
		AB.setTopic(service1.findByArticleID(RB.getArticleId()).getTopic());
		redirectAttributes.addFlashAttribute("RB", RB);
		redirectAttributes.addFlashAttribute("AB", AB);
		return "redirect:/InsertReplyView";
	}

	// 顯示新增回覆結果的頁面
	@RequestMapping("/InsertReplyView")
	public String insertArticleView(Model model) {
		return "SelectReply";
	}

	// 檢視單筆回覆(前端使用者)
	@RequestMapping("/SelectReply")
	public String selectArticle(@RequestParam("replyId") Integer replyId, Model model) {
		model.addAttribute("RBL", service2.selectReplyByArticleID(replyId));
		return "SelectReply";
	}

	// 刪除(Delete)
	// 刪除後直接導向總覽
	@RequestMapping(value = "/DeleteReply/{replyId}")
	public String deleteArticle(@PathVariable Integer replyId, Model model) {
		service2.delete(replyId);
		return "redirect:/SelectAllArticle";
	}

	// 修改(Update)
	// 提供更新回覆的表單
	@RequestMapping(value = "/UpdateReply/{replyId}", method = RequestMethod.GET)
	public String updateArticle(@PathVariable Integer replyId, Model model) {
		Reply RB = service2.findByReplyID(replyId);
		Article AB = new Article();
		AB.setTopic(service1.findByArticleID(service2.findByReplyID(replyId).getArticleId()).getTopic());
		model.addAttribute("AB", AB);
		model.addAttribute("RB", RB);
		return "UpdateReply";
	}

	// 接收更新回覆結果並重定向
	@RequestMapping(value = "/UpdateReply/{replyId}", method = RequestMethod.POST)
	public String updateArticleRedirect(@ModelAttribute("UpdateReply") Reply RB, RedirectAttributes redirectAttributes,
			HttpServletRequest request) {
		String replyContent = request.getParameter("replyContent");
		RB.setReplyContent(replyContent);
		request.setAttribute("RB", RB);
		Article AB = new Article();
		service2.update(RB);
		request.setAttribute("RB", RB);
		AB.setTopic(service1.findByArticleID(RB.getArticleId()).getTopic());
		redirectAttributes.addFlashAttribute("RB", RB);
		redirectAttributes.addFlashAttribute("AB", AB);
		return "redirect:/UpdateReplyView";
	}

	// 顯示更新回覆結果的頁面
	@RequestMapping("/UpdateReplyView")
	public String updateArticleView(Model model) {
		return "SelectReply";
	}
}

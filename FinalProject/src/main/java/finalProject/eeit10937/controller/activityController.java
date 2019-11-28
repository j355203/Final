package finalProject.eeit10937.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import finalProject.eeit10937.model.activityBean;
import finalProject.eeit10937.service.ActivityService;

@Controller
public class activityController {
	ActivityService service;

	@Autowired
	public void setService(ActivityService service) {
		this.service = service;
	}

	@RequestMapping(value = "activity", method = RequestMethod.GET)
	public String list(Model model) {
		List<activityBean> list = service.getAllActivity();
		model.addAttribute("activitys", list);
		return "activity";

	}

	@RequestMapping("/update/activityStatus")
	public String updateActivityStatus(Model model) {
		service.updateAllActivityStatus();
		return "redirect:/activity";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getDisplayActivityHTML(Model model) {
		activityBean ab = new activityBean();
		model.addAttribute("activityBean", ab);
		return "search";

	}


	@RequestMapping("/activity1")
	public String getActivityById(@RequestParam("activityId") Integer activityId, Model model) {
		model.addAttribute("activity1", service.getActivityById(activityId));
		return "activity1";

	}

	@RequestMapping(value = "activity", method = RequestMethod.POST)
	public String displayActivityHTML(@ModelAttribute("activityBean") activityBean ab, Model model) {
		activityBean ab1 = service.getActivityById(ab.getActivityId());
		model.addAttribute("activity", ab1);
		return "activitySelect";
	}

	@RequestMapping(value = "addActivity", method = RequestMethod.GET)
	public String getAddNewActivityForm(Model model) {
		activityBean ab = new activityBean();
		model.addAttribute("activityBean", ab);
		return "addActivity";
	}

	@RequestMapping(value = "addActivity", method = RequestMethod.POST)
	public String processAddNewActivityForm(@ModelAttribute("activityBean") activityBean ab) {
		MultipartFile activityImage = ab.getActivityImage();
		String originalFilename = activityImage.getOriginalFilename();
		ab.setFileName(originalFilename);
		if (activityImage != null && !activityImage.isEmpty()) {
			try {
				byte[] b = activityImage.getBytes();
				Blob blob = new SerialBlob(b);
				ab.setCoverImage(blob);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		}
		service.addActivity(ab);
		return "redirect:/activity";
	}

	ServletContext context;

	@Autowired
	public void setContext(ServletContext context) {
		this.context = context;
	}



	@RequestMapping(value = "/getPicture/{activityId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPicture(HttpServletResponse resp, @PathVariable Integer activityId) {
		String filePath = "/resources/images/NoImage.jpg";
		byte[] media = null;
		HttpHeaders headers = new HttpHeaders();
		String filename = "";
		int len = 0;
		activityBean bean = service.getActivityById(activityId);
		if (bean != null) {
			Blob blob = bean.getCoverImage();
			filename = bean.getFileName();
			if (blob != null) {
				try {
					len = (int) blob.length();
					media = blob.getBytes(1, len); // blob.getBytes(1, len): 是 1 開頭。Jdbc相關的類別都是1 開頭。
				} catch (SQLException e) {
					throw new RuntimeException("activityController的getPicture()發生SQLException: " + e.getMessage());
				}
			} else {
				media = toByteArray(filePath);
				filename = filePath;
			}
		} else {
			media = toByteArray(filePath);
			filename = filePath;
		}
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		String mimeType = context.getMimeType(filename);
		MediaType mediaType = MediaType.valueOf(mimeType);
		System.out.println("mediaType =" + mediaType);
		headers.setContentType(mediaType);
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
		return responseEntity;
	}

	private byte[] toByteArray(String filepath) {
		byte[] b = null;
		String realPath = context.getRealPath(filepath);
		try {
			File file = new File(realPath);
			long size = file.length();
			b = new byte[(int) size];
			InputStream fis = context.getResourceAsStream(filepath);
			fis.read(b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return b;
	}

	@RequestMapping(value = "/modifyActivity/{id}", method = RequestMethod.GET)
	public String modifyActivityData2(@PathVariable Integer id, Model model) {
		activityBean bean = service.getActivityById(id);
		model.addAttribute("updActivity", bean);
		return "EditActivityForm";
	}

	@RequestMapping(value = "/modifyActivity/{id}", method = RequestMethod.POST)
	public String modifyActivityForm(@ModelAttribute("updActivity") activityBean ab, Model model) {
		MultipartFile activityImage = ab.getActivityImage();
		String originalFilename = activityImage.getOriginalFilename();
		ab.setFileName(originalFilename);
		if (activityImage != null && !activityImage.isEmpty()) {
			service.updateActivity(ab);
			try {
				byte[] b = activityImage.getBytes();
				Blob blob = new SerialBlob(b);
				ab.setCoverImage(blob);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
			}
		} else {
			service.updateActivityNoImage(ab);
		}
		return "redirect:/activity";
	}

	@RequestMapping("/userActivity")
	public String list1(Model model1) {
		List<activityBean> list1 = service.getUserActivity();
		model1.addAttribute("userActivity", list1);
		return "userActivity";
	}

}

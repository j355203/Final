package finalProject.eeit10904.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import finalProject.eeit10904.model.EmployeeBean;
import finalProject.eeit10904.service.EmployeeService;

@Controller
public class EmployeeCSVController {

	EmployeeService service;

	@Autowired
	public void setService(EmployeeService service) {
		this.service = service;
	}

	@RequestMapping(value = "/uploadCsv", method = RequestMethod.POST)
	public String uploadCsvFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		if (!file.isEmpty()) {
			String targetPath = "D:\\";
			String fileName = targetPath + file.getOriginalFilename();
			File f = new File(fileName);
			file.transferTo(f);

			try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
				String data;
				Integer lineNo = 0;
				while ((data = br.readLine()) != null) {
					lineNo++;

					if (lineNo == 1) {
						continue;
					}
					String[] values = data.split(",");
					EmployeeBean emp = new EmployeeBean();
					emp.setEmpname(values[0]);
					emp.setEmpgender(values[1]);
					emp.setEmpbirth(values[2]);
					emp.setDepno(Integer.parseInt(values[3]));
					emp.setEmptitle(values[4]);
					emp.setEmplevel(Integer.parseInt(values[5]));
					emp.setEmpphone(values[6]);
					emp.setEmpaddress(values[7]);
					emp.setEmponboard(values[8]);
					service.add(emp);
				}
			} catch (IOException e) {
				System.err.println("無法讀取，請重新選擇");
			}
			f.delete();
		}
		return "redirect:/findallemps";
	}

	@RequestMapping(value = "/downloadCsv", method = RequestMethod.GET)
	public void exportCsv(HttpServletResponse response, HttpServletRequest request) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		List<EmployeeBean> emps = service.findAll();
		String fileName = "員工資料表.csv";
		fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
		response.setHeader("Content-Disposition",
				"attachment; filename=\"" + fileName + "\"; filename*=utf-8''" + fileName);
		FileCopyUtils.copy(service.exportUsersToCsv(emps), response.getOutputStream());
	}
}

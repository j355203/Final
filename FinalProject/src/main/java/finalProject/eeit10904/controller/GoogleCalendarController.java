package finalProject.eeit10904.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoogleCalendarController {

	@RequestMapping("/calendar")
	public String getCalendar() {
		return "GoogleCalendar";
	}
}

package kr.or.comma.timeline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimelineController {
	
	@GetMapping("")
	public String timelineForm() {
		
		return "main/timelineList";
	}
	
	
	
}

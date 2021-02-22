package kr.or.comma.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/home.jsp")
	public String main() {
		return "home";
	}
	
}

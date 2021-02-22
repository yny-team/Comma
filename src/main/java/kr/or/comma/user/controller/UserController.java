package kr.or.comma.user.controller;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@RequestMapping("/home.jsp")
	public String main() {
		return "home";
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/login")
	public String loginForm() {
		
		logger.info("signin..............");
		
		return "user/login";
>>>>>>> 064e24c735026085758ffaadba3797e18d0e6c34
	}
	
}

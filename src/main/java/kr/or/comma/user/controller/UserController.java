package kr.or.comma.user.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.comma.user.svc.UserService;
import kr.or.comma.user.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public String loginForm() {
		
		log.info("login..............");
		
		return "user/login";
	}
	
	@GetMapping("/signup")
	public String registMemberForm(@ModelAttribute UserVO userVO) {
		
		log.info("signup.............");
		
		return "user/signup";
	}
	
	/*
	 * 회원가입
	 * @Param UserVO userVO
	 * @Return "redirect:/user/signup" OR "redirect:/user/login"
	 */
	@PostMapping("/signup")
	public String registMember(@ModelAttribute @Valid UserVO userVO, BindingResult bindingResult,
			RedirectAttributes rttr) throws Exception {
		
		String resultAddr = "redirect:/user/signup";
		
		// Server Input Form Validation 검사
		if(bindingResult.hasErrors()) {
			
			return "/user/signup";
		}
		
		int registSuccessCount = userService.registUser(userVO);
		
		if(registSuccessCount <= 0) {
			rttr.addFlashAttribute("registMsg", "fail");
			return resultAddr;
			
		} 
		
		rttr.addFlashAttribute("registMsg", "success");
		resultAddr = "redirect:/user/login";
		
		return resultAddr;
		
	}	
	
	@ResponseBody
	@PostMapping("/idCheck")
	public String idCheck(@RequestParam("userId") String userId) throws Exception {
		
		int idCheckCount = userService.getUserIdExistsCount(userId);

		return Integer.toString(idCheckCount);
	}
	
	@ResponseBody
	@PostMapping("/emailCheck")
	public String emailCheck(@RequestParam("userEmail") String userEmail) throws Exception {
		
		int emailCheckCount = userService.getUserEmailExistsCount(userEmail);
		
		return Integer.toString(emailCheckCount);
	}	
	
}

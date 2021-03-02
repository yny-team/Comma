package kr.or.comma.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@Controller
public class CommonExceptionController {
	
	private static final Logger log = LoggerFactory.getLogger(CommonExceptionController.class);

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleNoHandlerFound(NoHandlerFoundException ex) {
		
		// 404
		log.info("NoHandlerFoundException = > " + ex);
		
		return "error404";
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException e) {
		
		// 400
		log.info("MethodArgumentTypeMismatchException = > " + e);
		
		return "error404";
	}	
	
	@ExceptionHandler(NotFoundException.class)
	public String handleNotFound(NotFoundException e) {
			
		log.info("NotFoundException : {}", e);
		
		return "redirect:/";
	}
	
	
	
}

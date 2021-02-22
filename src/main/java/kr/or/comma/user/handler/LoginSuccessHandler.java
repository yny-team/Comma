package kr.or.comma.user.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	private String defaultUrl;
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	private RedirectStrategy redirectStatgy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
				
		
		resultRedirectStrategy(request, response, authentication);
		
		clearAuthenticationAttributes(request);
		
	}

	protected void resultRedirectStrategy(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		SavedRequest savedRequest = requestCache.getRequest(request, response);
				
		if(savedRequest != null) {
			String targetUrl = savedRequest.getRedirectUrl();
			redirectStatgy.sendRedirect(request, response, targetUrl);
		} else {
			redirectStatgy.sendRedirect(request, response, defaultUrl);
		}
		
	}
	
	private void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session == null) return;
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);		 
	}

	public String getDefaultUrl() {
		return defaultUrl;
	}

	public void setDefaultUrl(String defaultUrl) {
		this.defaultUrl = defaultUrl;
	}
}

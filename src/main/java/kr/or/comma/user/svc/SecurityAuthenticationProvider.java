package kr.or.comma.user.svc;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import kr.or.comma.user.vo.UserVO;

public class SecurityAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityAuthenticationProvider.class);
	
	@Autowired
	private SecurityUserDetailService securityUserDetailService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@SuppressWarnings("unchecked")
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String userId = (String) authentication.getPrincipal();
		String userPassword = (String) authentication.getCredentials();
		
		UserVO user = (UserVO) securityUserDetailService.loadUserByUsername(userId);

		if(!passwordEncoder.matches(userPassword, user.getPassword())) {
			logger.info("matchPassword :::::::: false!");
			throw new BadCredentialsException(userId);
		}
		
		if(!user.isEnabled()) {
			logger.info("AuthenticationProvider :: isEnablesd 걸림 == 계정 비활성화");
			throw new BadCredentialsException(userId);
		}
		
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) user.getAuthorities();
		
		UserVO userPrincipal = new UserVO(user.getUserNo(), user.getUserId(), user.getUserNames());
		
		logger.info("matchPassword :::::::: true!");
		return new UsernamePasswordAuthenticationToken(userPrincipal, null, authorities);
	}
	
	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
}

package kr.or.comma.user.svc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.or.comma.user.vo.UserVO;

public class SecurityUserDetailService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityUserDetailService.class);

	@Autowired
	private SecurityUserService securityUserService;
	
	@Override
		public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
			logger.info("loadUserByUsername ::::::: 2");
		
			UserVO user = securityUserService.getUserById(userId);
			logger.info("user : " + user);
			
			if(user == null) {
				logger.info("no user :::::::: AuthenticationProvider");
				throw new UsernameNotFoundException(userId);
			}
			return user;
		}	
}

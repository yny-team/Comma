package kr.or.comma.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.comma.user.svc.SecurityUserService;
import kr.or.comma.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class SecurityUserServiceImplTest {
	
	private static final Logger log = LoggerFactory.getLogger(SecurityUserServiceImplTest.class);
	
	@Autowired
	private SecurityUserService securityUserService;
	
	@Test
	public void getMembers() {
		
		UserVO user = securityUserService.getUserById("dgd03023");
		
		log.info("user : " + user);
		
	}
	
	
}

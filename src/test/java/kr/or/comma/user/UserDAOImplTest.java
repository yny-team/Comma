package kr.or.comma.user;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.comma.user.dao.UserDAO;
import kr.or.comma.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class UserDAOImplTest {	
	
	private static final Logger log = LoggerFactory.getLogger(UserDAOImplTest.class);

	@Autowired
	private UserDAO userDAO;
	
//	@Test
	public void testJoin(){
		
		UserVO userVO = new UserVO();
		userVO.setUserId("test01");
		userVO.setUserEmail("test01@naver.com");
		userVO.setUserNames("test01");
		userVO.setUserPassword("test01");
		
		userDAO.insertUser(userVO);
	}
	
}

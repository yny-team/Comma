package kr.or.comma.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml", 
								"file:src/main/webapp/WEB-INF/spring/**/security-context.xml",
								"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class UserControllerTest {

	private static final Logger log = LoggerFactory.getLogger(UserControllerTest.class);

	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void user_회원가입_유효성검증() throws Exception {
			
		log.info("user_회원가입_유효성검증 : " + mockMvc.perform(MockMvcRequestBuilders.post("/user/signup"))
				.andReturn()
				.getModelAndView().getModelMap());
		
		
	}
	
}

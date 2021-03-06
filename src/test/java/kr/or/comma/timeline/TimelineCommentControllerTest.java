package kr.or.comma.timeline;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import kr.or.comma.timeline.vo.TimelineCommentVO;
import kr.or.comma.user.vo.UserVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml", 
								"file:src/main/webapp/WEB-INF/spring/**/security-context.xml",
								"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class TimelineCommentControllerTest {

	private static final Logger log = LoggerFactory.getLogger(TimelineCommentControllerTest.class);

	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
//	@Test
	@WithMockUser(username = "test01", roles="USER")
	public void testList() throws Exception {
		
		int timeNo = 28;
		
		mockMvc.perform(get("/comments/" + timeNo)).andExpect(status().is(200));
		
	}
	
	@Test
	@WithMockUser(username = "test01", roles="USER")
	public void testNewComment() throws Exception{
		
		TimelineCommentVO timelineCommentVO = new TimelineCommentVO();
		timelineCommentVO.setUserNo(4);
		timelineCommentVO.setTimeNo(28);
		timelineCommentVO.setTimeCommContent("test");
		
		String jsonStr = new Gson().toJson(timelineCommentVO);
		
		log.info("jsonStr : {}", jsonStr);
		
		mockMvc.perform(post("/comment/new").with(csrf())
				.contentType("application/json")
				.content(jsonStr))
				.andExpect(status().is(200)
				);
		
		
	}
	
	
	
}

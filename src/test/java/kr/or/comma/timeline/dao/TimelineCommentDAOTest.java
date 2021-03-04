package kr.or.comma.timeline.dao;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.or.comma.timeline.vo.TimelineCommentVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml", 
								"file:src/main/webapp/WEB-INF/spring/**/security-context.xml",
								"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class TimelineCommentDAOTest {
	
	private static final Logger log = LoggerFactory.getLogger(TimelineCommentDAOTest.class);

	@Autowired
	private TimelineCommentDAO timelineCommentDAO;
	
	@Test
	public void testTimelineCommentDAO() {
		
		log.info("timelineCommentDAO : {}", timelineCommentDAO);
	}
	
	@Test
	public void testInsertTimelineComment() {
		
		IntStream.rangeClosed(1, 10).forEach(i -> {
			
			TimelineCommentVO comment = new TimelineCommentVO();
			comment.setTimeNo(28);
			comment.setUserNo(4);
			comment.setTimeCommContent("댓글 테스트");
			
			timelineCommentDAO.insertTimelineComment(comment);
		});
	}

	@Test
	public void testSelectTimelineCommentOneByTimeNo() {
		
		TimelineCommentVO comment = timelineCommentDAO.selectTimelineCommentOneByTimeCommNo(25);
		
		log.info("comment : {}", comment);
		
	}
	
	@Test
	public void testDeleteTimelineComment() {
		
		timelineCommentDAO.deleteTimelineComment(25);
		
	}
	
//	@Test
	public void testUpdateTimelineComment() {
		
		int targetTimeCommNo = 30;
		
		TimelineCommentVO comment = 
				timelineCommentDAO.selectTimelineCommentOneByTimeCommNo(targetTimeCommNo);
		
		comment.setTimeCommContent("댓글 수정 테스트");
		
		int updateSuccessCount = timelineCommentDAO.updateTimelineComment(comment);
		
		log.info("UPDATE COUNT : {}", updateSuccessCount);
	}
	
	@Test
	public void testSelectTimelineCommentListAll() {
		
		List<TimelineCommentVO> comments = timelineCommentDAO.selectTimelineCommentListAll(28);
		
		comments.forEach(comment -> log.info("Comment : {}", comment));
		
	}
	
}

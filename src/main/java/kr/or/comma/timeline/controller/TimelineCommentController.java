package kr.or.comma.timeline.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.comma.timeline.svc.TimelineCommentService;
import kr.or.comma.timeline.vo.TimelineCommentVO;


@RestController
@RequestMapping("/comment")
public class TimelineCommentController {
	
	private static final Logger log = LoggerFactory.getLogger(TimelineCommentController.class);

	@Autowired
	private TimelineCommentService timelineCommentService;
	
	@GetMapping(value = "/list/{timeNo}",
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<TimelineCommentVO>> list(@PathVariable("timeNo") int timeNo){
		
		log.info("timeline comment list timeNo : {}", timeNo);
	
		return new ResponseEntity<>(timelineCommentService.getTimelineCommentListAll(timeNo),
				HttpStatus.OK);
		
	}
	
	
	@PostMapping(value = "/new",
			consumes = "application/json",
			produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> registTimelineComment(@RequestBody TimelineCommentVO timelineCommentVO){
		
		log.info("timeline comment regist : {}", timelineCommentVO);
		
		int insertCount = timelineCommentService.registTimelineComment(timelineCommentVO);
		
		log.info("Comment INSERT COUNT : {}", insertCount);
		
		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK)
								: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value = "/{timeCommNo}",
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE
			})
	public ResponseEntity<TimelineCommentVO> detailTimelineComment(@PathVariable("timeCommNo") int timeCommNo){
		
		return new ResponseEntity<>(
				timelineCommentService.getTimelineCommentOneByTimeCommNo(timeCommNo),
				HttpStatus.OK);
	}
	
	@DeleteMapping("/{timeCommNo}")
	public ResponseEntity<String> removeTimelineComment(@PathVariable("timeCommNo") int timeCommNo){
		
		log.info("timeline comment remove : {}", timeCommNo);
		
		return timelineCommentService.removeTimelineComment(timeCommNo) == 1 
				? new ResponseEntity<>("success", HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH},
			value = "/{timeCommNo}",
			consumes = "application/json",
			produces = { MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modifyTimelineComment(@RequestBody TimelineCommentVO timelineCommentVO,
			@PathVariable("timeCommNo") int timeCommNo){
		
		log.info("timeline comment timeCommNo[{}] modify : {}", timeCommNo, timelineCommentVO);

		timelineCommentVO.setTimeCommNo(timeCommNo);
		
		return timelineCommentService.modifyTimelineComment(timelineCommentVO) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

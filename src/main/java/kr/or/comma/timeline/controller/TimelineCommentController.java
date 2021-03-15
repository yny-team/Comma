package kr.or.comma.timeline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.comma.timeline.svc.TimelineCommentService;
import kr.or.comma.timeline.vo.TimelineCommentDTO;
import kr.or.comma.timeline.vo.TimelineCommentVO;


@RestController
public class TimelineCommentController {
	
	private static final Logger log = LoggerFactory.getLogger(TimelineCommentController.class);

	@Autowired
	private TimelineCommentService timelineCommentService;
	
	/*
	 * 타임라인 댓글 리스트 조회
	 * @Param int timeNo
	 * @Return ResponseEntity<TimelineCommentDTO> => commentCount, commentList
	 */
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/comments/{timeNo}",
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<TimelineCommentDTO> list(@PathVariable("timeNo") int timeNo){
		
		log.info("timeline comment list timeNo : {}", timeNo);
	
		return new ResponseEntity<>(timelineCommentService.getTimelineCommentListAll(timeNo),
				HttpStatus.OK);
		
	}
	
	/*
	 * 타임라인 댓글 등록
	 * @Param TimelineCommentVO timelineCommentVO
	 * @Return ResponseEntity<String> => "댓글 등록을 성공했습니다.", ERROR
	 */
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value = "/comment/new",
			consumes = "application/json",
			produces = "text/plain;charset=utf8")
	public ResponseEntity<String> registTimelineComment(@RequestBody TimelineCommentVO timelineCommentVO){
		
		log.info("timeline comment regist : {}", timelineCommentVO);
		
		int insertCount = timelineCommentService.registTimelineComment(timelineCommentVO);
		
		log.info("Comment INSERT COUNT : {}", insertCount);
		
		return insertCount == 1 ? new ResponseEntity<>("댓글 등록을 성공했습니다.", HttpStatus.OK)
								: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping(value = "/comment/{timeCommNo}",
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE
			})
	public ResponseEntity<TimelineCommentVO> detailTimelineComment(@PathVariable("timeCommNo") int timeCommNo){
		
		return new ResponseEntity<>(
				timelineCommentService.getTimelineCommentOneByTimeCommNo(timeCommNo),
				HttpStatus.OK);
	}

	
	/*
	 * 타임라인 댓글 삭제
	 * @Param TimelineCommentVO timelineCommentVO, int timeCommNo
	 * @Return ResponseEntity<String> => "댓글 삭제를 성공했습니다.", ERROR
	 */
	@PreAuthorize("(( isAuthenticated()) and ( principal.userNo == #timelineCommentVO.userNo ))")
	@DeleteMapping(value = "/comment/{timeCommNo}",
			produces="text/plain;charset=utf8")
	public ResponseEntity<String> removeTimelineComment(@RequestBody TimelineCommentVO timelineCommentVO, 
												@PathVariable("timeCommNo") int timeCommNo
														){
		
		log.info("timeline comment remove : {}", timeCommNo);
		
		return timelineCommentService.removeTimelineComment(timeCommNo) == 1 
				? new ResponseEntity<>("댓글 삭제를 성공했습니다.", HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PreAuthorize("(( isAuthenticated()) and ( principal.userNo == #timelineCommentVO.userNo ))")
	@RequestMapping(method = RequestMethod.PUT,
			value = "/comment/{timeCommNo}",
			consumes = "application/json",
			produces = "text/plain;charset=utf8")
	public ResponseEntity<String> modifyTimelineComment(@RequestBody TimelineCommentVO timelineCommentVO,
			@PathVariable("timeCommNo") int timeCommNo){
		
		log.info("timeline comment timeCommNo[{}] modify : {}", timeCommNo, timelineCommentVO);

		timelineCommentVO.setTimeCommNo(timeCommNo);
		
		return timelineCommentService.modifyTimelineComment(timelineCommentVO) == 1
				? new ResponseEntity<>("댓글 수정을 성공했습니다.", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

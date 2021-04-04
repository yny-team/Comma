package kr.or.comma.timeline.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.comma.timeline.svc.TimelineLikeService;
import kr.or.comma.timeline.vo.TimelineLikeCheckDTO;
import kr.or.comma.timeline.vo.TimelineLikeCountDTO;
import kr.or.comma.timeline.vo.TimelineLikeDTO;
import kr.or.comma.timeline.vo.TimelineLikeVO;
import kr.or.comma.user.vo.UserVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class TimelineLikeController {
	
	private static final Logger log = LoggerFactory.getLogger(TimelineLikeController.class);
	
	@Autowired
	private TimelineLikeService timelineLikeService;
	
	/*
	 * 타임라인 좋아요 리스트
	 * @Param String jsonData
	 * @Return Map<String, Object> timelineMap 
	 */
	@PostMapping(value = "/likes")
	@ResponseBody
	public Map<String, Object> listLikeView(@RequestParam String jsonData) throws Exception {
		
		log.info(jsonData);
		
		UserVO user = (UserVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int userNo = user.getUserNo();
		
		Map<String, Object> timelineMap = new HashMap<String, Object>();
		List<Object> timelineNumberList = getTimelineNumberList(jsonData);
		
		List<TimelineLikeCountDTO> timelineLikeCountList = new ArrayList<>();
		
		for (int i = 0; i < timelineNumberList.size(); i++) {
			int timeNo = Integer.parseInt(timelineNumberList.get(i).toString());
			int timeLikeCount = timelineLikeService.getTimelineLikeCountByTimeNo(timeNo);
			
			TimelineLikeCountDTO timelineLikeCountDTO = new TimelineLikeCountDTO();
			timelineLikeCountDTO.setTimeNo(timeNo);
			timelineLikeCountDTO.setTimeLikeCount(timeLikeCount);
			timelineLikeCountList.add(timelineLikeCountDTO);
		}
		
		log.info("timelineLikeCountList : " + timelineLikeCountList);
		
		List<TimelineLikeCheckDTO> TimelineLikeCheckList = new ArrayList<>();
		
		for (int i = 0; i < timelineNumberList.size(); i++) {
			int timeNo = Integer.parseInt(timelineNumberList.get(i).toString());
			boolean timeLineLikeDuplicateCheck = false;
			
			if(timelineLikeService.getTimeLikeCountByTimeNoAndUserNo(timeNo, userNo) == 1) {
				timeLineLikeDuplicateCheck = true;
			} 
			
			TimelineLikeCheckDTO timelineLikeCheckDTO = new TimelineLikeCheckDTO();
			timelineLikeCheckDTO.setTimeNo(timeNo);
			timelineLikeCheckDTO.setTimeLikeDuplicateCheck(timeLineLikeDuplicateCheck);
			TimelineLikeCheckList.add(timelineLikeCheckDTO);
		}
		
		log.info("TimelineLikeCheckList : " + TimelineLikeCheckList);
		
		timelineMap.put("timelineLikeCountList", timelineLikeCountList);
		timelineMap.put("TimelineLikeCheckList", TimelineLikeCheckList);
		
		return timelineMap;
		
	}
	
	private List<Object> getTimelineNumberList(String jsonData) {

		JSONArray array = JSONArray.fromObject(jsonData);
		log.info("JSONArray : " + array);
		
		List<Map<String, Object>> resendList = new ArrayList<Map<String, Object>>();
		
		for (int i = 0; i < array.size(); i++) {
			JSONObject obj = (JSONObject)array.get(i);
			Map<String, Object> resendMap = new HashMap<String, Object>();
			
			resendMap.put("timeNo", obj.get("timeNo"));
			
			resendList.add(resendMap);
		}
		
		log.info("resendList : " + resendList);
		
		List<Object> timeNoList = new ArrayList<Object>();
		
		for (int i = 0; i < resendList.size(); i++) {
			String str = resendList.get(i).toString();
			String restr = str.replaceAll("[^0-9]", "");
			timeNoList.add(restr);
		}
		
		log.info("timeNoList : " + timeNoList);
		
		return timeNoList;
	}

	/*
	 * 타임라인 좋아요 등록
	 * @Param TimelineLikeVO timelineLikeVO, int timeNo
	 * @Return ResponseEntity<TimelineLikeDTO> => timeLikeMessage, timeLikeCount;
	 */
	@PreAuthorize("(( isAuthenticated() ) and ( principal.userNo == #userNo ))")
	@PostMapping(value = "/like/{timeNo}",
			consumes = "application/json",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE
			})
	public ResponseEntity<TimelineLikeDTO> like(@RequestBody TimelineLikeVO timelineLikeVO, 
									   @PathVariable("timeNo") int timeNo) {
		
		log.info("user {} => timeline like Post => timeNo {}", timelineLikeVO.getUserNo(), timeNo);
		
		timelineLikeVO.setTimeNo(timeNo);
		
		int insertCount = timelineLikeService.registTimelineLikeBytimeNoAndUserNo(timelineLikeVO);
		// 0 : INSERT, 1 : DELETE
		int label = 0;
		
		return insertCount == 1 
				      ? new ResponseEntity<>(
							timelineLikeService.getTimelineLikeMessageAndTimeLikeCount(timeNo, label)
						,HttpStatus.OK)
					  : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/*
	 * 타임라인 좋아요 취소
	 * @Param TimelineLikeVO timelineLikeVO, int timeNo
	 * @Return ResponseEntity<TimelineLikeDTO> => timeLikeMessage, timeLikeCount;
	 */
	@PreAuthorize("(( isAuthenticated() ) and ( principal.userNo == #userNo ))")
	@DeleteMapping(value = "/like/{timeNo}",
			consumes = "application/json",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE
			})
	public ResponseEntity<TimelineLikeDTO> unlike(@RequestBody TimelineLikeVO timelineLikeVO,
										 @PathVariable("timeNo") int timeNo) {
		
		log.info("user {} => timeline like Delete => timeNo {}", timelineLikeVO.getUserNo(), timeNo);

		timelineLikeVO.setTimeNo(timeNo);
		
		int removeCount = timelineLikeService.removeTimelineLikeBytimeNoAndUserNo(timelineLikeVO);
		// 0 : INSERT, 1 : DELETE
		int label = 1;
		
		return removeCount == 1 ? new ResponseEntity<>(timelineLikeService.getTimelineLikeMessageAndTimeLikeCount(timeNo, label), HttpStatus.OK)
								: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}

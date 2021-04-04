package kr.or.comma.timeline.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.comma.common.vo.ImageOrFileVO;
import kr.or.comma.timeline.svc.TimelineFileService;
import kr.or.comma.timeline.svc.TimelineLikeService;
import kr.or.comma.timeline.svc.TimelineService;
import kr.or.comma.timeline.vo.TimelineLikeVO;
import kr.or.comma.timeline.vo.TimelineVO;
import kr.or.comma.timeline.vo.TimelineWithImageVO;

@Controller
public class TimelineController {
	
	private static final Logger log = LoggerFactory.getLogger(TimelineController.class);

	@Autowired
	private TimelineService timelineService;
	
	@Autowired
	private TimelineFileService timelineFileService;
	
	@Autowired
	private TimelineLikeService timelineLikeService;
	
	/*
	 * 타임라인 리스트  
	 */
	@GetMapping("")
	public String Index(Model model) {
		
		log.info("timeline main get :::: ");
		
		List<TimelineVO> timelineList = timelineService.getTimelineListAll();
		List<ImageOrFileVO> timelineFileList = timelineFileService.getTimelineFileListAll();
		List<TimelineLikeVO> timelineLikeList = timelineLikeService.getTimelineLikeListAll();
		
		model.addAttribute("timelineList", timelineList);
		model.addAttribute("timelineFileList", timelineFileList);
		model.addAttribute("timelineLikeList", timelineLikeList);
		
		return "main/timelineList";
	}
	
	
	/*
	 * 타임라인 상세보기
	 * @Param int timeNo
	 */ 
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/detail")
	public String detailPage(@RequestParam("timeNo") int timeNo, Model model) {
				
		log.info("timeline detail get :::: {}", timeNo);

		TimelineVO timelineVO = timelineService.getTimelineOneByTimeNo(timeNo);
		List<ImageOrFileVO> timelineFileList = timelineFileService.getTimelineOneFileByTimeNo(timeNo);
		
		if(timelineVO == null) {
			throw new NotFoundException("타임라인이 존재하지 않습니다.");
		}
		
		model.addAttribute("timelineVO", timelineVO);
		model.addAttribute("timelineFileList", timelineFileList);
		
		return "main/timelineDetail";
	}	
	
	/*
	 * 타임라인 등록 폼
	 * @Param TimelineVO timelineVO
	 */ 
	@PAuthorize("isAuthenticated()")
	@GetMapping("/regist")
	public String registTimelineForm(@ModelAttribute TimelineVO timelineVO) {
		
		log.info("timeline regist get :::: {}", timelineVO);
		
		return "main/timelineRegistForm";
	}
	
	/*
	 * 타임라인 등록
	 * @Param TimelineVO timelinVO
	 */ 
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/regist")
	public String registTimeline(@ModelAttribute @Valid TimelineVO timelineVO, BindingResult bindingResult,
			RedirectAttributes rttr) {
		
		log.info("timeline regist post :::: {}", timelineVO);
		
		if(bindingResult.hasErrors()) {
			return "main/timelineRegistForm";
		}

		String registSuccess = timelineService.registTimeline(timelineVO);
		
		rttr.addFlashAttribute("registMessage", registSuccess);
		
		return "redirect:/";
	}
	
	/*
	 * 타임라인 수정 폼
	 * @Param int timeNo, int userNo
	 */ 
	@PreAuthorize("(( isAuthenticated() ) and ( principal.userNo == #userNo ))")
	@GetMapping("/modify")
	public String modifyTimelineForm(@RequestParam("timeNo") int timeNo, @RequestParam("userNo") int userNo,
		 Model model, RedirectAttributes rttr)   {
		
		log.info("userNo : {} => timeline modify get :::: {}",userNo, timeNo);
		
		TimelineVO timelineVO = timelineService.getTimelineOneByTimeNo(timeNo);
		List<ImageOrFileVO> timelineFileList = timelineFileService.getTimelineOneFileByTimeNo(timeNo);

		String resultAddress = "main/timelineModifyForm";
		
		if(timelineVO == null) {
			throw new NotFoundException("타임라인이 존재하지 않습니다.");
		} 
		
		// PostMapping("/modify")에서 @Valid TimelineVO가 bindResult에서 걸리면 
		// RedirectAttributes에 timelineVO 유효성 검증 결과와 기존에 입력한 TimelinVO를 addFlashAttribute
		// 저장하기에 (!model.containsAttributes("timelineVO"))는 timelineVO가 model에 존재하지 않는 경우라면
		// 일반적으로 GET /modify에 접근하는것이기에 model에 timelineVO, timelineFileList를 저장한다.
		if(!model.containsAttribute("timelineVO")) {
			model.addAttribute("timelineVO", timelineVO);	
		 	model.addAttribute("timelineFileList", timelineFileList);
		}
		
		return resultAddress;
	}
	
	/*
	 * 타임라인 수정
	 * @Param TimelineVO timelineVO
	 */ 
	@PreAuthorize("(( isAuthenticated() ) and ( principal.userNo == #timelineVO.userNo ))")
	@PostMapping("/modify")					 
	public String modifyTimeline(@ModelAttribute @Valid TimelineVO timelineVO, BindingResult bindingResult,
			 RedirectAttributes rttr) {
	
		log.info("userNo : {} => timeline modify post :::: {}",timelineVO.getUserNo(), timelineVO.getTimeNo());

		String resultAddress = "redirect:/modify?timeNo=" + timelineVO.getTimeNo() + "&"
				+ "userNo=" + timelineVO.getUserNo();
	
		if(bindingResult.hasErrors()) {
			rttr.addFlashAttribute("org.springframework.validation.BindingResult.timelineVO", bindingResult);
			rttr.addFlashAttribute("timelineVO", timelineVO);
			
			return resultAddress;	
		}
		
		String modifySuccess = timelineService.modifyTimeline(timelineVO);
		
		rttr.addFlashAttribute("modifyMessage", modifySuccess);
		
		return resultAddress;
	}
	
	/*
	 * 타임라인 삭제 
	 * @Param int timeNo, userNo
	 */
	@PreAuthorize("(( isAuthenticated() ) and ( principal.userNo == #userNo ))")
	@PostMapping("/remove")
	public String removeTimeline(int timeNo, int userNo, RedirectAttributes rttr) throws Exception {
		
		log.info("userNo : {} => timeline remove post :::: {}",timeNo, userNo);

		String reultAddress = "redirect:/";
		String removeSuccess = timelineService.removeTimeline(timeNo);
					
		rttr.addFlashAttribute("removeMessage", removeSuccess);
		
		return reultAddress;
	
	}

	
}

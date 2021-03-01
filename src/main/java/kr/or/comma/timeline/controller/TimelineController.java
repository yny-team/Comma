package kr.or.comma.timeline.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.comma.common.vo.ImageOrFileVO;
import kr.or.comma.timeline.svc.TimelineService;
import kr.or.comma.timeline.vo.TimelineVO;

@Controller
public class TimelineController {
	
	private static final Logger log = LoggerFactory.getLogger(TimelineController.class);

	@Autowired
	private TimelineService timelineService;
	
	@GetMapping("")
	public String timelineForm(Model model) {
		
		log.info("timeline main get :::: ");
		
		List<TimelineVO> timelineList = timelineService.getTimelineListAll();
		List<ImageOrFileVO> timelineFileList = timelineService.getTimelineFileListAll();
		
		model.addAttribute("timelineList", timelineList);
		model.addAttribute("timelineFileList", timelineFileList);
		
		return "main/timelineList";
	}
	
	@GetMapping("/regist")
	public String timelineRegistForm(@ModelAttribute TimelineVO timelineVO) {
		
		log.info("timeline regist get :::: {}", timelineVO);
		
		return "main/timelineRegistForm";
	}
	
	@PostMapping("/regist")
	public String timelineRegist(@ModelAttribute @Valid TimelineVO timelineVO, BindingResult bindingResult,
			RedirectAttributes rttr) {
		
		log.info("timeline regist post :::: {}", timelineVO);
		
		if(bindingResult.hasErrors()) {
			return "main/timelineRegistForm";
		}

		String registSuccess = timelineService.registTimeline(timelineVO);
		
		rttr.addFlashAttribute("registMessage", registSuccess);
		
		return "redirect:/";
	}
	
	@GetMapping("/detail")
	public String timelineDetailPage(@RequestParam("timeNo") int timeNo, Model model) {
				
		log.info("timeline detail get :::: {}", timeNo);

		TimelineVO timelineVO = timelineService.getTimelineOneByTimeNo(timeNo);
		List<ImageOrFileVO> timelineFileList = timelineService.getTimelineOneFileByTimeNo(timeNo);
		
		model.addAttribute("timelineVO", timelineVO);
		model.addAttribute("timelineFileList", timelineFileList);
		
		return "main/timelineDetail";
	}
	
	
	
	
	
	
}

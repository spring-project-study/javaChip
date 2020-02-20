package org.javachip.controller;


import org.javachip.domain.Criteria;
import org.javachip.domain.PageDTO;
import org.javachip.service.ProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.javachip.domain.MultipleChoiceVO;
import org.javachip.domain.ProblemVO;
import org.javachip.domain.ShortAnswerVO;
import org.javachip.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

@Controller
@Log4j
@RequestMapping(path = "/problem")	
public class ProblemController {

	@Autowired
	ProblemService problemService;

	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		model.addAttribute("list", problemService.getListWithPaging(cri));
		int total = problemService.getTotal(cri);
		log.info(cri);
		log.info("total:" + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}

	@GetMapping
	public ModelAndView problemGet() {
		ModelAndView mv = new ModelAndView("problem/register");
		return mv;
	}
	
	@PostMapping(value = "/multiplechoice", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> multipleProblemPost(@RequestBody Map<String, Object> dto) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		ProblemVO problem_vo = objectMapper.convertValue(dto.get("problem_vo"), ProblemVO.class);
		List<MultipleChoiceVO> choice_vo_list = objectMapper.convertValue(dto.get("choice_vo_list"),
				TypeFactory.defaultInstance().constructCollectionType(List.class, MultipleChoiceVO.class));
		
		problem_vo = problemService.registerMultipleChoice(problem_vo, choice_vo_list);	
		if(problem_vo != null) {
			return Collections.singletonMap("result", "success");
		}
		else {
			return Collections.singletonMap("result", "fail");
		}	
	}
	
	@PostMapping(value = "/shortanswer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> shortAnswerPost(@RequestBody Map<String, Object> dto){
		ObjectMapper objectMapper = new ObjectMapper();
		ProblemVO problem_vo = objectMapper.convertValue(dto.get("problem_vo"), ProblemVO.class);
		List<ShortAnswerVO> short_answer_list = objectMapper.convertValue(dto.get("answer_vo_list"),
				TypeFactory.defaultInstance().constructCollectionType(List.class, ShortAnswerVO.class));
		
		problem_vo = problemService.registerShortAnswer(problem_vo, short_answer_list);	
		if(problem_vo != null) {
			return Collections.singletonMap("result", "success");
		}
		else {
			return Collections.singletonMap("result", "fail");
		}	
	}
}

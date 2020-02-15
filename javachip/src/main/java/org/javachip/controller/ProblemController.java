package org.javachip.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.javachip.domain.MultipleChoiceVO;
import org.javachip.domain.ProblemVO;
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

@RestController
@RequestMapping(path = "/problem")	
public class ProblemController {

	@Autowired
	ProblemService problemService;

	@GetMapping
	public ModelAndView problemGet() {
		ModelAndView mv = new ModelAndView("problem/register");
		return mv;
	}
	
	@GetMapping("/multiplechoice")
	public ModelAndView multipleProblemGet() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	
	@PostMapping(value = "/multiplechoice", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> multipleProblemPost(@RequestBody Map<String, Object> dto)
			throws IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		ProblemVO problem_vo = objectMapper.convertValue(dto.get("problem_vo"), ProblemVO.class);
		// 일단 따라함
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

}

package org.javachip.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.javachip.domain.MultipleChoiceVO;
import org.javachip.domain.ProblemVO;
import org.javachip.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
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
	
//	@PostMapping("/multiplechoice")
//	public ModelAndView multipleProblemPost(HttpServletResponse response, @RequestBody Map<String, Object> dto)
//			throws IOException {
//		ModelAndView mv = new ModelAndView("home");
//		ObjectMapper objectMapper = new ObjectMapper();
//		ProblemVO problem_vo = objectMapper.convertValue(dto.get("problem_vo"), ProblemVO.class);
//		// 일단 따라함
//		List<MultipleChoiceVO> choice_vo_list = objectMapper.convertValue(dto.get("choice_vo_list"),
//				TypeFactory.defaultInstance().constructCollectionType(List.class, MultipleChoiceVO.class));
//		
//		problem_vo = problemService.registerMultipleChoice(problem_vo, choice_vo_list);
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8;");
//		PrintWriter out = response.getWriter();
////		
//		if(problem_vo != null) {
//			out.print("<script>alert('등록 성공 !');location.href='/problem/list';</script>");
//			out.flush();
////			return Collections.singletonMap("result", "success");
//		}
//		else {
//			out.print("<script>");
//			out.print("alert('등록 실패! 잠시 후 다시 시도하세요.');");
//			out.print("</script>");
//			out.flush();
////			out.close();
////			return Collections.singletonMap("result", "fail");
//		}	
//		return mv;
//	}
	
/*
	@PostMapping("/multiplechoice")
	public void multipleProblemPost(HttpServletResponse response, @RequestBody Map<String, Object> dto)
			throws IOException {
		ModelAndView mv = new ModelAndView("home");
		ObjectMapper objectMapper = new ObjectMapper();
		ProblemVO problem_vo = objectMapper.convertValue(dto.get("problem_vo"), ProblemVO.class);
		// 일단 따라함
		List<MultipleChoiceVO> choice_vo_list = objectMapper.convertValue(dto.get("choice_vo_list"),
				TypeFactory.defaultInstance().constructCollectionType(List.class, MultipleChoiceVO.class));
		
		problem_vo = problemService.registerMultipleChoice(problem_vo, choice_vo_list);
//		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8;");
		PrintWriter out = response.getWriter();
//		
		if(problem_vo != null) {
			out.print("alert('aa !');");
			out.print("location.href='/problem/list';");
			out.flush();
//			return Collections.singletonMap("result", "success");
		}
		else {
			out.print("alert('등록 실패! 잠시 후 다시 시도하세요.');");
			out.flush();
//			out.close();
//			return Collections.singletonMap("result", "fail");
		}	
	}
	*/
	
	
}

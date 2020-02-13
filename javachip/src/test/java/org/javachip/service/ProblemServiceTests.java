package org.javachip.service;

import java.util.ArrayList;
import java.util.List;

import org.javachip.domain.MultipleChoiceVO;
import org.javachip.domain.ProblemVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.javachip.config.RootConfig.class} )
@Log4j	
public class ProblemServiceTests {
	
	@Autowired
	ProblemService problemService;
		
	//@Test
	public void getTest() {
		System.out.println(problemService.get(1L));
	}
	
	@Test
	public void registerTest() {
		ProblemVO vo = new ProblemVO();
		vo.setProblem_content("내용입니다.");
		vo.setProblem_title("제목입니다.");
		vo.setProblem_type("m");
		vo.setUser_id("user00");
		vo.setUser_name("유저00");
		List<MultipleChoiceVO> list = new ArrayList<>();
		for(int i=1; i<=3; ++i) {
			MultipleChoiceVO cvo = new MultipleChoiceVO();
			cvo.setChoice_content("보기" + i);
			if(i%2==1) cvo.setChk_answer(true);
			list.add(cvo);
		}
		
		ProblemVO ret = problemService.registerMultipleChoice(vo,list);
		System.out.println("!!!this" + ret);
	}
}

package org.javachip.service;

import java.util.ArrayList;
import java.util.List;

import org.javachip.domain.MultipleChoiceVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.javachip.config.RootConfig.class} )
@Log4j	
public class MultipleChoiceServiceTests {

	@Autowired
	MultipleChoiceService service;
	
	@Test
	public void registerListTest() {
		List<MultipleChoiceVO> list = new ArrayList<>();
		MultipleChoiceVO vo = new MultipleChoiceVO();
		vo.setProblem_id(2);
		vo.setChk_answer(true);
		vo.setChoice_content("보기1");
		list.add(vo);
		vo.setProblem_id(-1);
		vo.setChk_answer(false);
		vo.setChoice_content("보기2");
		list.add(vo);
		
	}
}

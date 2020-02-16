package org.javachip.mapper;

import org.javachip.domain.MultipleChoiceVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.javachip.config.RootConfig.class} )
@Log4j
public class MultipleChoiceTests {
	
	@Autowired
	MultipleChoiceMapper mapper;
	
	@Test
	public void insertTest() {
		MultipleChoiceVO vo = new MultipleChoiceVO();
		vo.setChk_answer(true);
		vo.setChoice_content("�����Դϴ�.");
		
		System.out.println("genkey" + vo.getChoice_id());
	}
}

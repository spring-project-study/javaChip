package org.javachip.mapper;

import org.javachip.domain.ProblemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import lombok.extern.log4j.Log4j;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.javachip.config.RootConfig.class} )
@Log4j	
public class ProblemMapperTests {
	
	@Autowired
	ProblemMapper mapper;
	
	//@Test
	public void insertTest() {
		ProblemVO vo = new ProblemVO();
		
		mapper.insert(vo);
	}
	
	//@Test
	public void getTest() {
		System.out.println(mapper.select(1));
	}
}









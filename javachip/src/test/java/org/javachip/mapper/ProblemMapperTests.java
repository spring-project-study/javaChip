package org.javachip.mapper;

import org.javachip.domain.ProblemVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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









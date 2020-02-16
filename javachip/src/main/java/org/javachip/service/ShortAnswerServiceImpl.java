package org.javachip.service;

import java.util.List;

import org.javachip.domain.ShortAnswerVO;
import org.javachip.mapper.ShortAnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShortAnswerServiceImpl implements ShortAnswerService{
	
	@Autowired
	ShortAnswerMapper shortAnswerMapper;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void registerListWithProblemId(List<ShortAnswerVO> list, long problem_id) {
		try {
			for(ShortAnswerVO vo : list) {
				vo.setProblem_id(problem_id);
				shortAnswerMapper.insert(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

}

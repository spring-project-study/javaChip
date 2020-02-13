package org.javachip.service;

import java.util.List;

import org.javachip.domain.MultipleChoiceVO;
import org.javachip.mapper.MultipleChoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MultipleChoiceServiceImpl implements MultipleChoiceService{
	
	@Autowired
	MultipleChoiceMapper multipleChocieMapper;

	@Override
	//@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	@Transactional(propagation = Propagation.REQUIRED)
	public void registerListWithProblemId(List<MultipleChoiceVO> list, long problem_id) {
		try {
			for(MultipleChoiceVO vo : list) {
				vo.setProblem_id(problem_id);
				multipleChocieMapper.insert(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

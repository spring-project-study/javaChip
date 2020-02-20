package org.javachip.service;

import java.util.List;

import org.javachip.domain.Criteria;
import org.javachip.domain.ProblemVO;
import org.javachip.mapper.ProblemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.javachip.domain.MultipleChoiceVO;
import org.javachip.domain.ProblemVO;
import org.javachip.domain.ShortAnswerVO;
import org.javachip.mapper.ProblemMapper;
import org.javachip.mapper.ShortAnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProblemServiceImpl implements ProblemService{

	@Autowired
	ProblemMapper problemMapper;
	@Autowired
	MultipleChoiceService multipleChoiceService;
	@Autowired
	ShortAnswerService shortAnswerService;

	@Override
	public List<ProblemVO> getListWithPaging(Criteria cri) {
		// TODO Auto-generated method stub
		cri.setStartNum((cri.getPageNum() - 1) * cri.getAmount());
		cri.setEndNum(cri.getStartNum() + cri.getAmount() - 1);

		return problemMapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return problemMapper.getTotalCount(cri);
	}

	@Override
	public ProblemVO get(Long problem_id) {
		return problemMapper.get(problem_id);
	}

	@Override
	public boolean remove(Long problem_id) {
		return problemMapper.delete(problem_id) > 0 ? true : false;
	}
	
	@Override
	public boolean modify(ProblemVO vo) {
		return problemMapper.update(vo) > 0 ? true : false;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public ProblemVO registerMultipleChoice(ProblemVO problem_vo, List<MultipleChoiceVO> choice_vo_list) {
		try{
			problemMapper.insert(problem_vo);
			multipleChoiceService.registerListWithProblemId(choice_vo_list, problem_vo.getProblem_id());
			return problem_vo;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor={Exception.class})
	public ProblemVO registerShortAnswer(ProblemVO problem_vo, List<ShortAnswerVO> short_answer_list) {
		try{
			problemMapper.insert(problem_vo);
			shortAnswerService.registerListWithProblemId(short_answer_list, problem_vo.getProblem_id());
			return problem_vo;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

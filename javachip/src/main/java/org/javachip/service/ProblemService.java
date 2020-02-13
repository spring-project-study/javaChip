package org.javachip.service;

import java.util.List;

import org.javachip.domain.MultipleChoiceVO;
import org.javachip.domain.ProblemVO;
import org.javachip.domain.ShortAnswerVO;

public interface ProblemService {
	public ProblemVO get(Long problem_id);
	public boolean remove(Long problem_id);
	public ProblemVO registerMultipleChoice(ProblemVO problem_vo, List<MultipleChoiceVO> choice_vo_list);
	public ProblemVO registerShortAnswer(ProblemVO problem_vo, List<ShortAnswerVO> short_answer_vo);
	public boolean modify(ProblemVO vo);
	
}

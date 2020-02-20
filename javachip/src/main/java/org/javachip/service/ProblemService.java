package org.javachip.service;

import java.util.List;
import org.javachip.domain.MultipleChoiceVO;
import org.javachip.domain.ProblemVO;
import org.javachip.domain.ShortAnswerVO;
import org.javachip.domain.Criteria;
import org.javachip.domain.ProblemVO;

public interface ProblemService {

	public List<ProblemVO> getListWithPaging(Criteria cri);
	public int getTotal(Criteria cri);
	public ProblemVO get(Long problem_id);
	public boolean remove(Long problem_id);
	public ProblemVO registerMultipleChoice(ProblemVO problem_vo, List<MultipleChoiceVO> choice_vo_list);
	public ProblemVO registerShortAnswer(ProblemVO problem_vo, List<ShortAnswerVO> short_answer_list);
	public boolean modify(ProblemVO vo);
}

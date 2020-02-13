package org.javachip.service;

import java.util.List;

import org.javachip.domain.MultipleChoiceVO;

public interface MultipleChoiceService {
	public void registerListWithProblemId(List<MultipleChoiceVO> list, long problem_id);
}

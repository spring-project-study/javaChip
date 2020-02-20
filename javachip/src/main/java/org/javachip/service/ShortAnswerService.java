package org.javachip.service;

import java.util.List;

import org.javachip.domain.ShortAnswerVO;

public interface ShortAnswerService {
	public void registerListWithProblemId(List<ShortAnswerVO> list, long problem_id);
}

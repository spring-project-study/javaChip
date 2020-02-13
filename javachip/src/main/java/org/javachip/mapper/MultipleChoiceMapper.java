package org.javachip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.javachip.domain.MultipleChoiceVO;

public interface MultipleChoiceMapper {
	public int insert(MultipleChoiceVO vo);
	public MultipleChoiceVO select(long choice_id);
	public List<MultipleChoiceVO> selectByPid(long problem_id);
}

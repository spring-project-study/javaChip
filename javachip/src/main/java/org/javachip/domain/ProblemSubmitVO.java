package org.javachip.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ProblemSubmitVO {
	private long submit_id;
	private String user_id;
	private long problem_id;
	private boolean state;
	private Date submit_date;
}

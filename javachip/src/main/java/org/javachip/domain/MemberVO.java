package org.javachip.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String user_id;
	private String user_pw;
	private String user_name;
	private Date reg_date;
	private Date recent_login_date;
}

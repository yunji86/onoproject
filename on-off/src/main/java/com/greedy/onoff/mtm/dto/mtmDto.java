package com.greedy.onoff.mtm.dto;

import java.sql.Date;

import com.greedy.onoff.classes.dto.ClassesDto;
import com.greedy.onoff.member.dto.MemberDto;

import lombok.Data;

@Data
public class mtmDto {
	
	 	private Long mtmCode;
	    private Date mtmDate;
	    private String mtmTitle;
	    private String mtmDescription;
	    private MemberDto member;
	    private ClassesDto classes;
	    private Long mtmrefer;
	    private Long answerCode;
	    private String mtmdelete;

}
package com.greedy.onoff.acc.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greedy.onoff.acc.dto.AccDto;
import com.greedy.onoff.acc.service.AccService;
import com.greedy.onoff.common.ResponseDto;
import com.greedy.onoff.common.paging.Pagenation;
import com.greedy.onoff.common.paging.PagingButtonInfo;
import com.greedy.onoff.common.paging.ResponseDtoWithPaging;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ono/acc")
public class AccController {
	
	private final AccService accService;
	
	public AccController(AccService accService) {
		this.accService = accService;
	}
	
	/* 수납 내역 조회 */
	@GetMapping("/acc-management")
	public ResponseEntity<ResponseDto> selectAccListForAdmin(@RequestParam(name="page", defaultValue = "1") int page){
		
		Page<AccDto> accDtoList = accService.selectAccListForAdmin(page);
		PagingButtonInfo pageInfo = Pagenation.getPagingButtonInfo(accDtoList);
		
		ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
		responseDtoWithPaging.setPageInfo(pageInfo);
		responseDtoWithPaging.setData(accDtoList.getContent());
		
		return ResponseEntity.ok().body(new ResponseDto(HttpStatus.OK, "수납 조회 성공!", responseDtoWithPaging));
	}

}
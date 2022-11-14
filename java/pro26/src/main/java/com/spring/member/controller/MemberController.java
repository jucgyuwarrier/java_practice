package com.spring.member.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.member.vo.MemberVO;

public interface MemberController {

	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response)
			 throws Exception;
	public ModelAndView addMember(@ModelAttribute("info") MemberVO memberVO, HttpServletRequest request, HttpServletResponse response) 
			throws Exception;
	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response)
	throws Exception;
//@ModelAttribute하려면 보내는곳이 getter setter을 가지고 있고 빈이 생성된 클래스여야 함	
}

package com.spring.pro27.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.pro27.HomeController;
import com.spring.pro27.member.service.MemberService;
import com.spring.pro27.member.vo.MemberVO;



@Controller("memberController")
public class MemberControllerImpl implements MemberController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;

	@Override
	@RequestMapping(value = "/member/listMembers.do", method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//String viewName = getViewName(request);
		String viewName = (String)request.getAttribute("viewName");
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/addMember.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}

	@Override
	@RequestMapping(value = "/member/removeMember.do", method = RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}

	@RequestMapping(value = {"/member/loginForm.do", "/member/memberForm.do" }, method = RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//String viewName = getViewName(request); // request.setAttribute("키",값)으로 request에 값이 넣어져 있음으로 request를 매개변수로 함
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}



	 @Override
	  @RequestMapping(value = "/member/login.do", method = RequestMethod.POST)
	  public ModelAndView login(@ModelAttribute("member") MemberVO member,
			  //RedirectAttributes 객체생성해서 로그인 실패시 처리할 로직을 만듬
			RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception{ 
	  ModelAndView mav = new ModelAndView(); 
	  memberVO = memberService.login(member); 
	  if(memberVO != null) { HttpSession session = request.getSession(); 
	  session.setAttribute("member", memberVO);
	  session.setAttribute("isLogOn", true);
	  mav.setViewName("redirect:/member/listMembers.do"); }else {
	  rAttr.addAttribute("result","loginFailed");
	  mav.setViewName("redirect:/member/loginForm.do"); } return mav; } //실패시 로그인창으로 다시 리 다이렉트
	  
	  @Override
	  
	  @RequestMapping(value = "/member/logout.do",method = RequestMethod.GET)
	  public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)throws Exception{ 
		  HttpSession session = request.getSession();
	  session.removeAttribute("member"); session.removeAttribute("isLogOn");
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("redirect:/member/listMembers.do"); return mav; }
	  //로그아웃시 세션에 저장된 로그인 정보와 회원정보를 삭제
	  
	  @RequestMapping(value = "/member/*Form.do", method = RequestMethod.GET)
	  private ModelAndView form(@RequestParam(value= "result", required=false)
	  String result, HttpServletRequest request, HttpServletResponse response)throws Exception{ 
	  /*String viewName = getViewName(request); ViewNameInterceptor 클래스에서 다 해줘서 컨트롤러에서 넣을 필요가 없음
	    
	   */
	  String viewName =(String)request.getAttribute("viewName"); 
	  ModelAndView mav = new ModelAndView(); 
	  mav.addObject("result",result); 
	  mav.setViewName(viewName);
	  return mav;
	  }
	 

	  	
		/* 뷰이름 반환하는 getViewName 메서드를 interceptor 클래스에서 대신함으로 컨트롤러마다 getViewName메서드를 넣지 않아도 됨   
		 * private String getViewName(HttpServletRequest request) throws Exception {
		 * String contextPath = request.getContextPath(); String uri = (String)
		 * request.getAttribute("javax.servlet.include.request_uri"); if (uri == null ||
		 * uri.trim().equals("")) { uri = request.getRequestURI(); }
		 * 
		 * // http://localhost:8090/member/listMember.do로 요청시 int begin = 0; if
		 * (!((contextPath == null) || ("".equals(contextPath)))) { begin =
		 * contextPath.length(); // 전체 요청명의 길이를 구함 } int end; if (uri.indexOf(";") !=
		 * -1) { end = uri.indexOf(";"); } else if (uri.indexOf("?") != -1) { end =
		 * uri.indexOf("?");
		 * 
		 * } else { end = uri.length(); }
		 * 
		 * // http://localhost:8090/member/listMember.do로 요청시 먼저 '.do'를 제거한다. //
		 * http://localhost:8090/member/listMember 를 구한 후 , // 다시
		 * http://localhost:8090/member/listMember에서 역순으로 첫번째 // '/'위치를 구한 후, 그 뒤의
		 * listMember를 구한다. String viewName = uri.substring(begin, end); if
		 * (viewName.indexOf(".") != -1) { viewName = viewName.substring(0,
		 * viewName.lastIndexOf(".")); // 요청명에서 역순으로 최초 '.'의 위치를 구한 후, '.do'앞에까지의 문자열을
		 * 구함 } if (viewName.lastIndexOf("/") != -1) { viewName =
		 * viewName.substring(viewName.lastIndexOf("/", 3), viewName.length()); // 요청명에서
		 * 역순으로 최초 '/'의 위치를 구한 후 , '/' 다음부터의 문자열을 구함 } return viewName; }
		 */

}

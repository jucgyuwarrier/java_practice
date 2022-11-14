/*package sec02.ex01;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/member/*")
public class MemberController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO2 memberDAO2;
	
	public void init() throws ServletException {
		memberDAO2 = new MemberDAO2();
		System.out.println("init 메서드 호출");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo(); //URL에서 요청명을 가져옵니다.
		System.out.println("action:" + action);
		
		if(action == null || action.equals("/listMembers.do")) 
			{
			List membersList = memberDAO2.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test02/listMembers.jsp"; 
			} else if (action.equals("/addMember.do"))
			{
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");
				String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO2.addMember(memberVO);
			nextPage = "/member/listMembers.do";
			} else if (action.equals("/memberForm.do"))
			{
				nextPage = "/test02/memberForm.jsp";
		} else {
			List<MemberVO> membersList = memberDAO2.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test02/listMembers.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
		//서블릿 내에서 여러 처리를 요청하고 넘기는 클래스
	}
}
*/
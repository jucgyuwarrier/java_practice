package sec02.ex02;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/member/*")
public class MemberController3 extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	MemberDAO3 memberDAO3;

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		memberDAO3 = new MemberDAO3();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		
		if (action == null || action.equals("/listMembers.do")) 
		{
			List membersList = memberDAO3.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test03/listMembers.jsp"; 
		}  else if (action.equals("/memberForm.do"))
		{
			nextPage = "/test03/memberForm.jsp";
		}
		else if (action.equals("/addMember.do"))
		{
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
		MemberVO memberVO = new MemberVO(id, pwd, name, email);
		memberDAO3.addMember(memberVO);
		nextPage = "/member/listMembers.jsp";
		}
		else if (action.equals("/modMemberForm.do"))
		{
			String id = request.getParameter("id");
		MemberVO memInfo = memberDAO3.findMember(id);
		request.setAttribute("memInfo", memInfo);
		nextPage = "/test03/modMemberForm.jsp";
		} else if (action.equals("/modMember.do"))
		{
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO3.modMember(memberVO);
			request.setAttribute("msg", "modified"); //회원 목록창에서 수정작업 완료 메세지를 전달
			nextPage = "/member/listMembers.do";
		} else if (action.equals("/delMember.do"))
		{
			String id = request.getParameter("id");
			memberDAO3.delMember(id);
			request.setAttribute("msg", "deleted");
			nextPage = "/member/listMembers.do";
		} else 
		{ 
			List membersList = memberDAO3.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test03/listMembers.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}

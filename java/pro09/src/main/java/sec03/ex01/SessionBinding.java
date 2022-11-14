package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bindinglogin1")
public class SessionBinding extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doHandle(request, response);
	}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	 doHandle(request, response);
}


private void doHandle(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out = response.getWriter();
	HttpSession session = request.getSession();
	String user_id = request.getParameter("user_id");
	String user_pw =  request.getParameter("user_pw");
	if(session.isNew()) {
		if(user_id.length() != 0) {
			session.setAttribute("user_id", user_id); //setAttribute("객체 name", 객체)
			out.println("<a href = 'bindinglogin1'>로그인 상태 확인</a>"); //
		}else {
			out.print("<a href = 'bindinglogin.html'>다시 로그인 하세요</a>");
			session.invalidate();
		}
	} else {
		user_id = (String)session.getAttribute("user_id"); // 가져온 아이디 정보를 String형 객체로 변환
		if(user_id != null && user_id.length() != 0) {
			out.print("안녕하세요 " + user_id + "님");
		} else {
			out.print("<a href = 'bindinglogin.html'>다시 로그인 하세요</a>");
			session.invalidate();
		}
	}
}
}

package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class SessionTest extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//HttpSession 클래스 객체 생성후 = request.getSession(), 호출하고 없으면 새로 생성하는 메서드 
		out.println("세션 아이디: " +session.getId()+"<br>"); //getId() 생성된 세션객체의 id를 가져옴
		out.println("최초 세션 생성 시각 : " + new Date(session.getCreationTime()) + "<br>");
		out.println("최근 세션 접근 시각 : " + new Date(session.getLastAccessedTime())+"<br>");
		out.println("최근 세션 유효 시간 : " + session.getMaxInactiveInterval()+"<br>");
		if(session.isNew()) { //isNew() 최초 생성된 세션인지 판별
			out.print("새 세션이 만들어졌습니다.");
		}
	}
}

package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {

	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//setContentType()을 이용해 응답할 데이터 종류가 HTML임을 설정합니다.
		PrintWriter out = response.getWriter();
		//HttpServletResponse 객체의 getWriter()를 이용해 출력 스트림 PrintWriter 객체를 받아옴.
		
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		String data = "<html>";
		data += "<body>"; //브라우저로 출력할 데이터를 문자열로 연결해서 HTML태그로 만듭니다.
		data += "아이디 : " + id;
		data += "<br>";
		data += "패스워드 : " + pw;
		data += "<html>";
		data += "</body>";
		
		out.print(data);
		
	}
}

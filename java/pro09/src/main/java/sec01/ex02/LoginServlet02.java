package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet02
 */
@WebServlet("/nosessionlogin")
public class LoginServlet02 extends HttpServlet {


	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address=request.getParameter("user_address");
		
		String user_email=request.getParameter("user_email");
		String user_hp=request.getParameter("user_hp");
		
		String data="안녕하세요!<br>로그인하셨습니다.<br><br>";
			data+="<html><body>";
			data+="아이디 : "+user_id;
			data+="<br>";
			data+="패스워드 : "+user_pw;
			data+="<br>";
			data+="주소 : "+user_address;
			data+="<br>";
			data+="email : "+user_email;
			data+="<br>";
			data+="휴대전화 : "+user_hp;
			data+="<br>";
			out.print(data);
			
			user_address=URLEncoder.encode(user_address,"utf-8");
			out.print("<a href='/pro09/second02?user_id="+user_id+"&user_pw="+user_pw+"&user_address="+user_address+"'> 두 번째 서블릿으로 보내기 </a>");
			//주소를 적어줘서 get방식으로 받을 수 있음
			data="</body></html>";
			out.print(data);
	}

}

package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet0401
 */
@WebServlet("/second0401")
public class SecondServlet0401 extends HttpServlet {
	

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String address=(String)request.getAttribute("address");
		out.println("<html><body>");
		out.println("주소:" +address);
		out.println("<br>");
		out.println("redirect를 이용한 바인딩 실습입니다.");
		out.println("</body></html>");
		/* first0401의 request, response 객체와 second의 request, response는 별개의 객체임
		 *  redirect방식으로는 바인딩한 데이터를 다른 서블릿으로 전송할 수 없음 dispatch로 보내야함*/
		}

}

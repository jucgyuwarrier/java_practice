package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/JsonServlet2")
public class JsonServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		JSONObject totalObject = new JSONObject();
		JSONArray membersArray = new JSONArray();
		JSONObject memberInfo = new JSONObject();
		memberInfo.put("name", "북북스");
		memberInfo.put("age", "28");
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "북북스님");
		membersArray.add(memberInfo);
		
		memberInfo = new JSONObject();
		memberInfo.put("name", "규규스");
		memberInfo.put("age", "29");
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "규규스님");
		membersArray.add(memberInfo);
		
		totalObject.put("members", membersArray);
		
		String jsonInfo = totalObject.toJSONString();
		System.out.println(jsonInfo);
		writer.print(jsonInfo);
	}
}

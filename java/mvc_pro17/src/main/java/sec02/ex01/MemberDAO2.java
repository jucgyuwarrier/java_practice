/*package sec02.ex01;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO2 {
private Connection con;
private PreparedStatement pstmt;
private DataSource dataFactory;

public MemberDAO2() {
	
	try {
		Context ctx = new InitialContext();
		Context envContext = (Context)ctx.lookup("java:/comp/env");
		dataFactory = (DataSource) envContext.lookup("jdbc/servletex");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

public List listMembers() {
	List membersList = new ArrayList();
	try { 
	con = dataFactory.getConnection();
	String query = "select * from t_member order by joinDate desc";
	System.out.println(query);
	pstmt = con.prepareStatement(query);
	ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String email = rs.getString("email");
			Date joinDate = rs.getDate("joinDate");
			MemberVO memberVO = new MemberVO(id, pwd, name, email, joinDate);
			membersList.add(memberVO);
		}
	rs.close();
	pstmt.close();
	con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	} 
	return membersList;
}
public void addMember(MemberVO m) {
	try {
		con = dataFactory.getConnection();
		String id = m.getid();
		String pwd = m.getpwd();
		String name = m.getname();
		String email = m.getemail();
		String query = "INSERT INTO t_member(id, pwd, name, email)" + "VALUES(?,?,?,?)";
		System.out.println(query);
		
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(3, name);
		pstmt.setString(4, email);
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	} catch (SQLException e)
	{
		e.printStackTrace();
	}
}
}
*/
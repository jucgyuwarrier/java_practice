	package sec01.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
private Connection con; //커넥션 참조변수 생성
private PreparedStatement pstmt; // 쿼리문을 매개변수로 받는 참조변수 생성
private DataSource dataFactory;
// Connection Pool Connection을 사용하게해주는 dataSource 참조변수 생성

public MemberDAO() {
	
	try {
		Context ctx = new InitialContext(); 
		// Connection Pool에서 Datasource(Connection)을 사용하기 위한 JNDI 서버 객체 생성 후 ctx에 전달
		Context envContext = (Context)ctx.lookup("java:/comp/env");
		dataFactory = (DataSource) envContext.lookup("jdbc/servletex");
		//web.xml에 설정한 res-ref-name 중 일치하는 데이터베이스
	} catch (Exception e) {
		e.printStackTrace();
	}
}
//
public List listMembers() 
{
	List membersList = new ArrayList();
	try
	{
		con = dataFactory.getConnection();
		String query = "select * from t_member order by joinDate desc";
		System.out.println(query);
		pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{
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
	} catch (SQLException e)
	{
		e.printStackTrace();
	}
	return membersList;
}
public void addMember(MemberVO m)
{
	try 
	{
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

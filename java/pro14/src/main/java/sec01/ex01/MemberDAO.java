package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class MemberDAO {
private Connection con;
private PreparedStatement pstmt;
private DataSource dataFactory;

public MemberDAO() {}
public List listMembers() {
	List list = new ArrayList();
	try {
		con=dataFactory.getConnection();
		String query = "select * from t_member order by joinDate desc";
		System.out.println("prepareSatement: " + query);
		pstmt = con.prepareStatement(query); //셀렉트 구문을 처리할 수 있게 환경설정을함
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			String email =rs.getString("email");
			Date joinDate = rs.getDate("joinDate");
			MemberBean vo = new MemberBean();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setEmail(email);
			vo.setJoinDate(joinDate);
			list.add(vo);
		}//각각 회원정보를 맴버빈객체로 만들어 각각 리스트에 추가한후 리턴한걸 membersList 객체에 넣음 ex) 4명일시 0123 
		rs.close();
		pstmt.close();
		con.close();
	} catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
public void addMember(MemberBean memberBean)
{//회원가입시 넣은 자료의 값을 DB에 저장하는 역할을 함
try
{
	Connection con = dataFactory.getConnection();
	String id = memberBean.getId();
	String pwd = memberBean.getPwd();
	String name = memberBean.getName();
	String email = memberBean.getEmail();
	String query = "insert into t_member"; //DB에 있는 t_member에 저장
	query += "(id,pwd,name,email)";
	query += "values(?,?,?,?)"; //세팅
	System.out.println("prepareStatement: "+ query);
	pstmt = con.prepareStatement(query);
	pstmt.setString(1, id);
	pstmt.setString(2, pwd);
	pstmt.setString(3, name);
	pstmt.setString(4, email);
	pstmt.executeUpdate();
	pstmt.close(); //실행시키고 나서는 닫아줌
} catch (Exception e) {}
}
}
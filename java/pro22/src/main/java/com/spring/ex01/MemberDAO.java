/* package com.spring.ex01;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MemberDAO {
	
	private static SqlSessionFactory sqlMapper=null;
	public static SqlSessionFactory getInstance() {
		if(sqlMapper==null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				System.out.println("resource :" + resource);
//MemberDAO의 각 메서드 호출 시 src/mybatis/SqlMapConfig.xml에서 설정정보를 읽은후 데이터베이스와의 연동을 준비합니다.
				Reader reader = Resources.getResourceAsReader(resource);
				System.out.println("reader :" + reader);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
// 마이비티스를 이용하는 sqlMapper객체를 가져옵니다.

				reader.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("1.sqlMapper: " + sqlMapper);
		return sqlMapper;
	}
	
	public List<MemberVO> selectAllMemberList() {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		System.out.println("2.session: " + session);
		List<MemberVO> memlist=null;
		memlist=session.selectList("mapper.member.selectAllMemberList");
		return memlist;
		//memlist의 값이 호출했던 서블릿의 dao.selectAllMemberList()메서드 위치로 반환
	}
	
}
*/
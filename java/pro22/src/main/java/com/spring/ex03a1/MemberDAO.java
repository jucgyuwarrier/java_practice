/*
package com.spring.ex03a1;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.ex03.MemberVO;

public class MemberDAO {
	public static SqlSessionFactory sqlMapper=null; //sql세션펙토리형 sqlmapper객체 생성
	
	private static SqlSessionFactory getInstance() {
		if(sqlMapper==null) {
			try { 
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return sqlMapper;
	}
	
	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.selectAllMemberList");
		return memlist;
	}
	
	public MemberVO selectMemberById(String id) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		MemberVO memberVO = (MemberVO)session.selectOne("mapper.member.selectMemberById", id);
		return memberVO;
	}
	
	public List<MemberVO> selectMemberByPwd(int pwd) {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> membersList = null;
		membersList = session.selectList("mapper.member.selectMemberByPwd", pwd);
		//SqlSession클래스의 내장 메서드 select문을 실행후 여러 레코드로 List화 시킴 
		return membersList;
	}
}
*/
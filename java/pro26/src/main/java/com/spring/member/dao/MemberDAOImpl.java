package com.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.spring.member.vo.MemberVO;

@Repository("memberDAO") //id가 memberDAO인 빈을 자동 주입함
public class MemberDAOImpl implements MemberDAO {
	@Autowired //XML설정파일에서 생성한 id가 sqlSession인 빈을 자동 주입합니다.
	private SqlSession sqlSession;
	
	@Override
	public List selectAllMemberList() throws DataAccessException {
		
		List<MemberVO> membersList = null;
		membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
		//membersList의 값이 호출했던 서블릿의 dao.selectAllMemberList()메서드 위치로 반환
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
		
	}

}
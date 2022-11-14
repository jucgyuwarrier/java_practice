package com.spring.pro27.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.pro27.member.dao.MemberDAO;
import com.spring.pro27.member.vo.MemberVO;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED) 
//트랜잭션 직접 객체를 만들 필요 없이 선언만으로도 관리를 용이하게 해줌
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public List listMembers() throws DataAccessException{
		List membersList = null;
		membersList = memberDAO.selectAllMemberList();
		return membersList;
	}
	
	@Override
	public int addMember(MemberVO member) throws DataAccessException{
		return memberDAO.insertMember(member);
	}
	
	@Override
	public int removeMember(String id) throws DataAccessException{
		return memberDAO.deleteMember(id);
	}
	
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception{
		return memberDAO.loginById(memberVO);
	}

}

package com.spring.ex03;

public class MemberServiceImpl implements MemberService {
private MemberDAO memberDAO;

public void setMemberDAO(MemberDAO memberDAO)
{//<property 태그라 setter로 저장
	this.memberDAO = memberDAO;
}

@Override
public void listMembers()
{
	memberDAO.listMembers();
}
}

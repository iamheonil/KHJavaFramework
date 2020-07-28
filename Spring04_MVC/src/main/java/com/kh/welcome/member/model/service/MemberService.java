package com.kh.welcome.member.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.welcome.member.model.dao.MemberDao;
import com.kh.welcome.member.model.vo.Member;

@Service
// @Service : @Controller 나 @Repository 와 다르게
// Bean 으로 등록시켜주는 기능 외에는 별 기능이 없다
// @Component 와 동일하나 가독성을 위해 @Service 어노테이션을 사용한다
public class MemberService {

	@Autowired
	MemberDao memberDao;
	
	public int insertMember(Member member) {
		
		return memberDao.insertMember(member);
		
	}
	
	public Member selectMember(Map<String, Object> commandMap) {
		
		return memberDao.selectMember(commandMap);
		
	}
	
	public int updateMember(Member member) {
		
		return memberDao.updateMember(member);
		
	}
	
}

package com.kh.welcome.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.welcome.member.model.vo.Member;

@Repository
// @Repository - 해당 클래스를 Dao 역할을 하는 Bean 으로 등록한다
// SqlException 을 DataAccessException 으로 전환한다
public class MemberDao {
	
	
	@Autowired
	SqlSessionTemplate session;
	
	public int insertMember(Member member) {
		
		// MEMBER.insertMember : Mapper 의 NameSpace 이름 . 태그의 id 속성값
		
		return session.insert("MEMBER.insertMember", member);
	}
	
	public Member selectMember(Map<String, Object> commandMap) {
		return session.selectOne("MEMBER.selectMember", commandMap);
	}
	
	public int updateMember(Member member) {
		
		return session.update("MEMBER.updateMember", member);
		
	}

}

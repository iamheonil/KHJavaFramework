package com.kh.welcome.member.model.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.welcome.member.model.vo.Member;

@Repository
//@Repository 어노테이션
//해당 클래스를 Dao 역할을 하는 Bean으로 등록
//SqlException을 DataAccessException으로 전환해준다.
public class MemberDao {

	@Autowired
	SqlSessionTemplate session;
	
	//select 쿼리 1.결과가 하나인 경우
	//				selectOne(네임스페이스.태그id, 매핑시킬 객체)
	//			 2.결과가 여러개인 경우
	//				selectList(네임스페이스.태그id, 매핑시킬 객체)
	//insert 쿼리  sqlSessionTemplate.insert(네임스페이스.태그id,매핑시킬 객체)
	//update 쿼리  sqlSessionTemplate.update(네임스페이스.태그id,매핑시킬 객체)
	//delete 쿼리	 sqlSessionTemplate.delete(네임스페이스.태그id,매핑시킬 객체)
	//매핑 시킬 객체가 필요하지 않다면 두번째 매개변수를 생략
	public int insertMember(Member member) {
		System.out.println("dao >>>>>>>> : " + member);
		return session.insert("MEMBER.insertMember", member);
	}

	public Member selectMember(
			Map<String,Object> commandMap) {
		
		return session.selectOne("MEMBER.selectMember",commandMap);
	}
	
	public int updateMember(Member member) {
		return session.update("MEMBER.updateMember", member);
	}
	
	public int updateMemberToLeave(String userId) {
		return session.update("MEMBER.leaveMember", userId);
	}
	
	public int selectId(String userId) {
		return session.selectOne("MEMBER.selectId",userId);
	}
	
	
	
	
	
	
	
	
	
	
}

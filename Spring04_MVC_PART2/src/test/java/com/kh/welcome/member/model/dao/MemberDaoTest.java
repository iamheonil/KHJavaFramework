package com.kh.welcome.member.model.dao;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.welcome.member.model.vo.Member;

@WebAppConfiguration
// 프로젝트의 web.xml 이 아니라 테스트를 위해 자동으로 생성되는 가상의 web.xml 을 사용하겠다는 의미

@RunWith(SpringJUnit4ClassRunner.class)
// jUnit 프레임워크의 테스트 실행방법을 변경할 때 지정
// SpringJUnit4ClassRunner.class - 테스트를 진행할 때 사용할 ApplicationContext 를 만들고 관리한다

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
// 자동으로 생성되는 applicationContext 의 설정파일 위치를 지정한다

public class MemberDaoTest {

	// SpringJUnit4ClassRunner 를 사용해서 만든 applicationContext 로 부터 의존성 주입을 받는다
	
	@Autowired
	MemberDao memberDao;
	
	@Test
	public void test1() {
		
		assertThat(memberDao, is(notNullValue()));
		
	}
	
	@Test // 데이터베이스에 존재하는 특정 회원을 조회하는 테스트 케이스 
	// 예상값과 결과로 반환되는 Member 객체의 userId 값이 일치하는 지 확인
	// equalsTo() 메소드 사용
	public void test2() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", "anjdi");
		
		Member member = memberDao.selectMember(map);
		
		// assertThat
		assertThat(member.getUserId(), equalTo(map.get("id")));
		
	}
	
	@Test
	public void test3() {
		
		Map<String, Object> testMap = new HashMap();
		
		testMap.put("id", "tjfkqthrdp");
		
		Member member = memberDao.selectMember(testMap);
		
		assertThat(member, is(nullValue()));
	}
	
}

package com.kh.welcome.member.model.service;

import java.util.Map;

import com.kh.welcome.member.model.vo.Member;

public interface MemberService {

	public int insertMember(Member member);

	public Member selectMember(Map<String, Object> commandMap);

	public int updateMember(Member member);

	public int updateMemberToLeave(String userId);

	public int selectId(String userId);

	public void mailSending(Member member, String urlPath);

	public void mailSendingToLeave(Member member);

}

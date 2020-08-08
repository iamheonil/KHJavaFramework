package com.kh.welcome.member.model.service;

import java.util.Map;

import javax.activation.CommandMap;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.welcome.member.model.dao.MemberDao;
import com.kh.welcome.member.model.vo.Member;

import common.exception.MailException;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	// 회원가입 메소드
	public int insertMember(Member member) {

		// 사용자가 입력한 password
		String password = member.getPassword();
		String springPassword = "";

		// password 암호화 작업 - 매번 다른 방식으로 암호화가 진행된다
		springPassword = passwordEncoder.encode(password);

		System.out.println(springPassword);

		member.setPassword(springPassword);

		return memberDao.insertMember(member);
	}

	// 로그인 메소드
	public Member selectMember(Map<String, Object> commandMap) {

		// 사용자가 입력한 비밀번호
		String password = (String) commandMap.get("pw");

		// DB에 저장되어있는 사용자 정보
		Member member = memberDao.selectMember(commandMap);

		// 사용자가 입력한 비밀번호와 DB 의 사용자 정보가 일치한다면 -> 트루가 반환된다면
		if (passwordEncoder.matches(password, member.getPassword())) {
			return member;
		} else {
			return null;
		}

	}

	// 회원정보 수정 메소드
	public int updateMember(Member member) {

		String password = member.getPassword();
		String springPassword = "";

		springPassword = passwordEncoder.encode(password);
		member.setPassword(springPassword);

		return memberDao.updateMember(member);
	}

	public int updateMemberToLeave(String userId) {
		return memberDao.updateMemberToLeave(userId);
	}

	public int selectId(String userId) {
		return memberDao.selectId(userId);
	}

	public void mailSending(Member member, String urlPath) {

		String setfrom = "azimemory@naver.com";
		String tomail = member.getEmail();
		String title = "회원가입을 환영합니다.";
		String htmlBody = "<form " + "action='http://" + urlPath + "/member/joinimple.do'" + " method='post'>"
				+ "<h3>회원가입을 환영합니다</h3>" + "<input type='hidden' value='" + member.getUserId() + "' name='userId'>"
				+ "<input type='hidden' value='" + member.getPassword() + "' name='password'>"
				+ "<input type='hidden' value='" + member.getTell() + "' name='tell'>" + "<input type='hidden' value='"
				+ member.getEmail() + "' name='email'>" + "<button type='submit'>전송하기</button></form>";

		mailSender.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws MessagingException {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				// 보내는 이
				message.setFrom(setfrom);
				// 받는 이
				message.setTo(tomail);
				// 메일 제목
				message.setSubject(title);
				// 메일 내용
				// 두번째 boolean값은 html 여부 (true : html , false : text)
				message.setText(htmlBody, true);
			};

		});
	}

	public void mailSendingToLeave(Member member) throws MailException { 

		String setfrom = "azimemory@naver.com";
		String tomail = member.getEmail();
		String title = "안녕히 가세요.";
		String htmlBody = "<h1>안녕히 가세요.</h1>";

		try {
			
			// int testNum = 10 / 0;
			
			mailSender.send(new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws MessagingException {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					// 보내는 이
					message.setFrom(setfrom);
					// 받는 이
					message.setTo(tomail);
					// 메일 제목
					message.setSubject(title);
					// 메일 내용
					// 두번째 boolean값은 html 여부 (true : html , false : text)
					message.setText(htmlBody, true);
				};
			});

		} catch (Exception e) {
			e.printStackTrace();
			throw new MailException("M_ERROR_01");
		}
	}

}

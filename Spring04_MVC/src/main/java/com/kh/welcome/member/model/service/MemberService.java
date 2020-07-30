package com.kh.welcome.member.model.service;

import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
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

	@Autowired
	JavaMailSender mailSender;

	public int insertMember(Member member) {

		return memberDao.insertMember(member);

	}

	public Member selectMember(Map<String, Object> commandMap) {

		return memberDao.selectMember(commandMap);

	}

	public int updateMember(Member member) {

		return memberDao.updateMember(member);

	}

	public int deleteMember(Member member) {

		return memberDao.deleteMember(member);

	}

	public int selectId(String userId) {

		return memberDao.idCheck(userId);

	}

	public void mailSending(Member member, String urlPath) {
		mailSender.send(new MimeMessagePreparator() {

			String setFrom = "kimhi__@naver.com";
			String tomail = member.getEmail();
			String title = "회원가입 확인 메일입니다";
			String htmlBody = "<form action='http://"+ urlPath + "/member/joinimple.do'" + " method='post'>" + "<h3>회원가입을 환영합니다</h3>"
			+ "<input type='hidden' value='" + member.getUserId() + "' name='userId'>" 
			+ "<input type='hidden' value='" + member.getPassword() + "' name='password'>"
			+ "<input type='hidden' value='" + member.getTell() + "' name='tell'>"
			+ "<input type='hidden' value='" + member.getEmail() + "' name='email'>"
			+ "<button type='submit'>전송하기</button> </form>";
			
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");

				// 보내는 사람
				message.setFrom(setFrom);

				// 받는 사람
				message.setTo(tomail);

				// 메일 제목
				message.setSubject(title);

				// 메일 내용 (true - html, false - text)
				message.setText(htmlBody, true);
			}
		});
	}

}

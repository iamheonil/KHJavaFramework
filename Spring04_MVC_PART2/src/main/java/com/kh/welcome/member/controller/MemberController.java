package com.kh.welcome.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.welcome.member.model.service.MemberService;
import com.kh.welcome.member.model.vo.Member;

import common.exception.MailException;

//MemberController를 bean으로 등록

//Controller
//1. 사용자의 요청을 받아
//   어플리케이션에 알맞은 형태로 데이터를 파싱
//   적절한 Service의 메서드를 호출
//   Service로 부터 받은 결과값을 사용자에게 반환
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	public MemberService memberService;

	/*
	 * @RequestMapping(value="/member/login.do") //해당 메서드를 어떤 url에 매핑 시킬 지 설정
	 * //value 속성을 사용해서 url 지정할 수 있다. //void : 요청이 온 url과 같은 경로의 jsp를 호출 public void
	 * logIn() { System.out.println("로그인 메서드 호출되었습니다."); }
	 */

	// @RequestMapping("/login.do")
	// RequestMapping에서 사용할 속성이 value밖에 없으면
	// value 생략할 수 있다.
	// class에 적용 : 모든 메서드에 적용되는 url경로 앞에 붙을 경로를 지정
	// ModelAndView 객체의 setViewName 메서드의 파라미터로
	// 원하는 jsp경로를 입력해 jsp를 호출 할 수 있다.
	/*
	 * public ModelAndView logIn() { ModelAndView mav = new ModelAndView();
	 * mav.setViewName("member/login"); System.out.println("로그인 메서드 호출되었습니다.");
	 * return mav; }
	 */

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	// @RequestMapping의 method 속성에 http method를 지정할 수 있다.
	// 반환형이 String이라면 String의 값으로 jsp를 찾는다.
	public String login() {
		System.out.println("login 메서드 호출");
		return "/member/login";
	}

	@RequestMapping("join.do")
	public void join() {
	}

	@RequestMapping("/joinimple.do")
	public ModelAndView joinImpl(@ModelAttribute Member member, HttpServletRequest request) {

		// ContextPath경로값을 받아온다.
		String root = request.getContextPath();
		ModelAndView mav = new ModelAndView();

		int res = memberService.insertMember(member);
		if (res > 0) {
			mav.addObject("alertMsg", "회원가입에 성공하였습니다.");
			mav.addObject("url", root + "/member/login.do");
			mav.setViewName("/common/result");
		} else {
			mav.addObject("alertMsg", "회원가입에 실패하였습니다.");
			mav.addObject("url", root + "/member/join.do");
			mav.setViewName("/common/result");
		}

		return mav;
	}

	@RequestMapping("/loginimple.do")
	public ModelAndView loginInmpl(@RequestParam Map<String, Object> commandMap, HttpSession session,
			HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		Member res = memberService.selectMember(commandMap);
		if (res != null) {
			session.setAttribute("logInInfo", res);
			mav.addObject("alertMsg", "로그인에 성공했습니다.");
			mav.addObject("url", request.getContextPath() + "/member/mypage.do");
		} else {
			mav.addObject("alertMsg", "로그인에 실패했습니다.");
			mav.addObject("url", request.getContextPath() + "/member/login.do");
		}

		mav.setViewName("common/result");
		return mav;
	}

	@RequestMapping("/mypage.do")
	public void mypage() {
	}

	@RequestMapping("/modify.do")
	public String modify(
			// @ModelAttribute 어노테이션은 생략 가능
			Member member, HttpSession session
			// ModelAndView에서 값을 저장하는 Model객체
			// view 경로를 지정하는 것은 return하는 String에 지정한다.
			, Model model) {

		Member sessionMember = (Member) session.getAttribute("logInInfo");
		member.setUserId(sessionMember.getUserId());

		int res = memberService.updateMember(member);

		// 회원 수정에 성공했다면
		if (res > 0) {
			// Model.addAttribute(K,V)
			// : view에 전달할 데이터를 추가하는 메서드
			model.addAttribute("alertMsg", "회원정보 수정에 성공했습니다.");
			model.addAttribute("url", "mypage.do");
			sessionMember.setPassword(member.getPassword());
			sessionMember.setEmail(member.getEmail());
			sessionMember.setTell(member.getTell());
		} else {
			model.addAttribute("alertMsg", "회원정보 수정에 실패했습니다.");
			model.addAttribute("url", "mypage.do");
		}

		return "common/result";
	}

	@RequestMapping("/leave.do")
	public String memberLeave(HttpSession session, Model model) throws MailException {

		Member member = (Member) session.getAttribute("logInInfo");
		int res = memberService.updateMemberToLeave(member.getUserId());

		if (res > 0) {
			model.addAttribute("alertMsg", "회원탈퇴하셨습니다.");
			model.addAttribute("url", "login.do");
			memberService.mailSendingToLeave(member);
			session.removeAttribute("logInInfo");
		} else {
			model.addAttribute("alertMsg", "에러가 발생하였습니다.");
			model.addAttribute("url", "login.do");
		}

		return "common/result";
	}

	@RequestMapping("/idcheck.do")
	@ResponseBody
	// 메소드에 @ResponseBody 어노테이션을 지정하면
	// 메서드에서 리턴하는 값을 viewResolver를 거쳐서 출력하지 않고
	// Http Response Body에 직접 쓰게 된다.
	public String idCheck(String userId) {
		System.out.println(userId);
		System.out.println("idCheck메서드가 호출되었습니다.");

		int res = memberService.selectId(userId);
		if (res > 0) {
			return userId;
		} else {
			return "";
		}
	}

	@RequestMapping("joinemailcheck.do")
	public ModelAndView joinEmailCheck(Member member, HttpServletRequest request) throws MailException {

		ModelAndView mav = new ModelAndView();
		String urlPath = request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

//		int testNum = 10 / 0;

//		System.out.println(testNum);
		memberService.mailSending(member, urlPath);

		mav.addObject("alertMsg", "이메일로 확인 메일이 발송 되었습니다.");
		mav.addObject("url", "login.do");
		mav.setViewName("common/result");

		return mav;
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {

		session.removeAttribute("logInInfo");

		return "redirect:login.do";

	}

}

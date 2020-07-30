package com.kh.welcome.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.welcome.member.model.service.MemberService;
import com.kh.welcome.member.model.vo.Member;

@Controller
//Controller 어노테이션으로 해당 객체를 WebApplicationContext에 등록
// Controller 어노테이션을 등록함으로써 @RequestParam, @RequestMapping
// 같은 Controller를 위한 어노테이션을 사용할 수 있다.
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	/*
	 * @RequestMapping(value="/member/join.do") //해당 메서드를 어떤 url에 매핑 시킬 지 설정 //value
	 * 속성에 url을 지정할 수 있다. 단 지정할 속성이 value밖에 없다면 생략 가능하다. public void join() { //void
	 * : 컨트롤러에서 return type이 void라면 요청온 url과 동일한 // jsp를 찾아서 사용자에게 보내준다. }
	 */

	/*
	 * @RequestMapping("/join.do") //RequestMapping을 class에 적용하면 해당 클래스의 모든 메서드에
	 * 적용되는 //url을 지정하 실 수 있습니다. 이 url은 메서드에 붙는 url의 앞 경로를 의미합니다. public String
	 * join() { //String이 반환형이면 String으로 반환되는 문자열이 jsp의 경로가 된다. return
	 * "/member/join"; }
	 */

	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	// 만약 method 속성을 작성하지 않으면 get, post 둘 다 허용한다.
	// value에 url, method 속성에 허가할 http method 방식 지정
	public ModelAndView join() {
		// ModelAndView : model 객체에 값을 담고
		// viewName을 보내고 싶은 jsp의 경로로 지정
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/join");
		return mav;
	}

	@RequestMapping("/login.do")
	public void login() {
	}

	@RequestMapping("/joinimple.do")
	public ModelAndView joinImpl(@ModelAttribute Member member, HttpServletRequest req) {
		// @RequestParam : Http요청 파라미터를 컨트롤러 메서드의 파라미터로 전달 받을 때 사용
		// 타입을 자동으로 변환해준다.(ex. String -> int) 변경이 불가능한 경우
		// 400 responce code 응답

		// 스프링 컨트롤러 매개변수 매핑 Case
		// 메서드 매개변수와 HTML 태그의 Name값이 같은 경우
		// VO의 필드변수명과 HTML 태그의 Name값이 같은 경우(@ModelAttribute)
		// 메서드 매개변수에 Map을 지정한 경우
		// > HTML 태그의 Name값이 Map의 Key 값으로 저장
		// > 단 @RequestParam 어노테이션이 명시적으로 지정되어있어야 한다.

		// required : 필수 파라미터 여부 지정(default값은 true)
		// defaultValue : 필수 파라미터가 없을 경우 기본값으로 지정할 값을 설정
		// html 태그의 name 속성명과 컨트롤러의 파라미터 변수명을 일치시켜서 매핑
		// HttpServletRequest,
		// HttpServletResponce
		// HttpSession 를 매개변수로 지정할 경우
		// DispatcherServlet이 컨트롤러를 호출 할 때 해당 객체를 전달해준다.

		// @RequestParam Map<String,Object> commandMap
		String root = req.getContextPath();

		ModelAndView mav = new ModelAndView();

		int res = memberService.insertMember(member);

		if (res > 0) {
			mav.addObject("alertMsg", "회원가입 성공!");
			mav.addObject("url", root + "/member/login.do");
			mav.setViewName("common/result");
		} else {
			mav.addObject("alertMsg", "회원가입에 실패하였습니다.");
			mav.addObject("url", root + "/member/join.do");
			mav.setViewName("common/result");
		}
		return mav;
	}

	@RequestMapping("/loginimple.do")
	public ModelAndView loginImpl(@RequestParam Map<String, Object> commandMap, HttpSession session,
			HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();

		Member res = memberService.selectMember(commandMap);

		if (res != null) {
			session.setAttribute("loginInfo", res);
			mav.addObject("alertMsg", "로그인 하이");
			mav.addObject("url", "/member/mypage.do");
			mav.setViewName("common/result");
		} else {
			mav.addObject("alertMsg", "로그인 실패");
			mav.addObject("url", "/member/login.do");
			mav.setViewName("common/result");
		}

		return mav;
	}

	@RequestMapping("/mypage.do")
	public void myPage() {

	}

	@RequestMapping("/modify.do")
	public ModelAndView update(@ModelAttribute Member member, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		int res = memberService.updateMember(member);

		HttpSession session = req.getSession();

		// select 쿼리
		// 1. 결과가 하나인 경우 -> selectOne
		// 2. 결과가 여러개인 경우 -> selectList

		// insert 쿼리 sqlSessionTemplate.insert(namespace.tagId, Mapping Object)
		// update 쿼리 sqlSessionTemplate.update()
		// delete 쿼리 sqlSessionTemplate.delete()

		if (res > 0) {
			mav.addObject("alertMsg", "수정 성공!");
			mav.addObject("url", "/member/mypage.do");
			session.setAttribute("loginInfo", member);
			mav.setViewName("common/result");
		} else {
			mav.addObject("alertMsg", "수정 실패하였습니다.");
			mav.addObject("url", "/member/mypage.do");
			mav.setViewName("common/result");
		}

		return mav;

	}

	@RequestMapping("/delete.do")
	public ModelAndView delete(@ModelAttribute Member member, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();

		int res = memberService.deleteMember(member);

		if (res > 0) {
			mav.addObject("alertMsg", "삭제 성공!");
			mav.addObject("url", "/member/login.do");
			mav.setViewName("common/result");
		} else {
			mav.addObject("alertMsg", "삭제 실패하였습니다.");
			mav.addObject("url", "/member/mypage.do");
			mav.setViewName("common/result");
		}

		return mav;

	}

	@RequestMapping("/idcheck.do")
	@ResponseBody
	// 메소드에서 @ResponseBody 어노테이션을 지정하면 메소드에서 리턴하는 값을 viewResolver 를 거쳐서
	// 출력하지 않고 Http Response Body 에 직접 쓴다
	public String idCheck(String userId) {

		System.out.println("확인하는 아이디 : " + userId);

		int res = memberService.selectId(userId);

		// 아이디가 있다면 유저아이디를 다시 보내줌
		if (res > 0) {
			return userId;
		} else {
			return "";
		}

	}

	@RequestMapping("joinemailcheck.do")
	public ModelAndView joinEmailCheck(Member member, HttpServletRequest req) {
		
		ModelAndView mav = new ModelAndView();
		
		String urlPath = req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
		
		memberService.mailSending(member, urlPath);
		
		mav.addObject("alertMsg", "이메일을 확인해보셔");
		mav.addObject("url", "login.do");
		mav.setViewName("common/result");
		
		return mav;
	}
	
}

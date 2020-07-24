package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// Controller Annotation 으로 해당 객체를 WebApplicationContext 에 등록,
// @RequestParam, @RequestMapping 을 사용할 수 있다
public class MemberController {

	@RequestMapping("/member/join.do")	
	public void join() {
		
	}
	
}

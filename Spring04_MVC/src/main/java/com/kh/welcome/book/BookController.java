package com.kh.welcome.book;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	@RequestMapping("jacksoncore.do")
	public String kakaoBook(@RequestBody Map<String, Object> kakaoBook) {
		// @RequestBody - HTTP Request Message 의 body 부분에 들어있는 데이터를 그대로 전달 해준다
		// Request header 에 Content-Type 을 application/json 으로 지정하면 해당 json 를 자바의 객체로 변환한다
		
//		System.out.println(kakaoBook);	
		
		List<Map<String, Object>> jsonData = (List<Map<String, Object>>)kakaoBook.get("documents");
		
		for(Map<String, Object> m : jsonData) {
			System.out.println("작가명 : " + m.get("authors"));
			System.out.println("요약 : " + m.get("contents"));
		}
		
		return "member/join";
		
	}
	
}

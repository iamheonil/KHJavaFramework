package com.kh.welcome.book;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	@RequestMapping("jacksoncore.do")
	public String kakaoBook(
		//@RequestBody 
		//HTTP Request Message의 body부분에 들어있는 데이터를
		//그대로 전달 해준다.
		//request header에 Content-type을 application/json
		//으로 지정하면 해당 json을 자바의 객체로 변환하여 넣어준다.
		@RequestBody
		Map<String,Object> kakaoBook) {
		
		List<Map<String,Object>> jsonData 
		= (List<Map<String,Object>>)kakaoBook.get("documents");
		
		for(Map<String,Object> m : jsonData) {
			System.out.println(m.get("authors"));
			System.out.println(m.get("contents"));
		}
		
		return "member/join";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

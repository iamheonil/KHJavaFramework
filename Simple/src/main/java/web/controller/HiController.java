package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HiController {

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public void method() {
		
		System.out.println("Hello World");
		
	}
	
}

package web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Dept;
import web.service.DeptService;

@Controller
public class DeptController {
	
	// 로그 남기게 해주는 
	private Logger logger = LoggerFactory.getLogger(DeptController.class);
	
	// AutoWired 서비스쪽 
	@Autowired
	private DeptService deptService;

	@RequestMapping(value="/dept/list", method=RequestMethod.GET)
	public void deptlist(Model model) {
		
//		System.out.println("dept/list");
		
		logger.info("/dept/list");
		
		List<Dept> list = deptService.getList();
		
		// 모델 값 전달
		model.addAttribute("list", list);
		
		
	}
}

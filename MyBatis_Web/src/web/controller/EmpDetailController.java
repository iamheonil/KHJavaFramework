package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Emp;
import web.service.EmpService;
import web.service.EmpServiceImpl;

/**
 * Servlet implementation class EmpDetailController
 */
@WebServlet("/emp/detail")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpService empService = new EmpServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("BreakPoint Test");
		
		// 조회할 이름 얻어오고 변환하여 Emp 에 세팅
		String stringNo = req.getParameter("ename");
		Emp empString = new Emp();
		empString.setEname(stringNo);
		
		// 상세결과 조회
		Emp detail = empService.selectEname(empString); 
		
		// 결과 뷰쪽으로 보내주기
		req.setAttribute("detail", detail);
		
		// System.out.println(detail);
		
		// 뷰 포워드
		req.getRequestDispatcher("/WEB-INF/views/emp/detail.jsp").forward(req, resp);
	
	}
	
}

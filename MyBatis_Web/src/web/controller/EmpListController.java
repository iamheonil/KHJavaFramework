package web.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/emp/list")
public class EmpListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpService empService = new EmpServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/emp/list [GET]");
		
		// 사원 전체 조회 - EmpService 사용
		List<Emp> list = empService.getList();
		
		for(Emp emp : list) {
			System.out.println(emp);
		}
		
		// 조회된 결과(List<Emp>)를 Request 컨텍스트 영역에 추가 - Model 에 전달
		req.setAttribute("list", list);
		
		// View 지정 및 Forward - JSP 사용
		req.getRequestDispatcher("/WEB-INF/views/emp/list.jsp").forward(req, resp);
	
	}
}

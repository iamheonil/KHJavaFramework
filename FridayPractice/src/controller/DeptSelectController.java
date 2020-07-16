package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDao;
import dao.DeptDaoImpl;
import dto.Dept;

/**
 * Servlet implementation class DeptSelectController
 */
@WebServlet("/dept/select")
public class DeptSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptDao deptDao = new DeptDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// System.out.println("ㅎㅇ");
		
		Dept dept = new Dept();
		
		String param = req.getParameter("deptno");
		int parseDeptno = 0;
		
		if(param != "" && !"".equals(param)) {
			parseDeptno = Integer.parseInt(param);
		}
		
		dept.setDeptno(parseDeptno);
		
		// System.out.println(parseDeptno);
		
		Dept res = deptDao.selectInfo(parseDeptno);
		
		req.setAttribute("select", res);
		
		req.getRequestDispatcher("/WEB-INF/views/select.jsp").forward(req, resp);
		
		
	}

}

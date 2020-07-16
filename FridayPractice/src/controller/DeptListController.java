package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDao;
import dao.DeptDaoImpl;
import dto.Dept;

/**
 * Servlet implementation class DeptListController
 */
@WebServlet("/dept/list")
public class DeptListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptDao deptDao = new DeptDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Dept> list = deptDao.selectAll();

		System.out.println(list);
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
		
		
		
	}

}

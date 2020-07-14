package dept.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import dept.dao.DeptDaoImpl;
import dept.dto.Dept;

/**
 * Servlet implementation class DeptSelectController
 */
@WebServlet("/dept/select")
public class DeptSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptDao deptDao = new DeptDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("hi");

		String param = req.getParameter("deptno");

		int deptNo = 0;

		if (param != null && !"".equals("param")) {
			deptNo = Integer.parseInt(param);
		}

		Dept dept = new Dept();

		dept.setDeptno(deptNo);

		Dept result = deptDao.selectOne(deptNo);

		req.setAttribute("result", result);

		req.getRequestDispatcher("/WEB-INF/views/dept/select.jsp").forward(req, resp);

	}

}

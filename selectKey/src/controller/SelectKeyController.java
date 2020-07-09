package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.SelectKeyDao;
import dto.SelectKey;
import mybatis.MyBatisConnectionFactory;
import service.SelectKeyService;
import service.SelectKeyServiceImpl;

/**
 * Servlet implementation class SelectKeyController
 */
@WebServlet("/mybatis/selectKey")
public class SelectKeyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectKeyService myService = new SelectKeyServiceImpl();
	private SqlSessionFactory factory = MyBatisConnectionFactory.getsqlSessionFactory();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("pw"));
		
		// myService.insert(req);
		
		SqlSession sqlSession = factory.openSession(true);
		
		SelectKeyDao selectKeyDao = sqlSession.getMapper(SelectKeyDao.class);
		
		SelectKey selectKey = new SelectKey();
		
		selectKey.setId(req.getParameter("id"));
		selectKey.setPw(req.getParameter("pw"));
		
		selectKeyDao.insertMember(selectKey);
		
		req.setAttribute("selectKey", selectKey);
		
		req.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(req, resp);
		
	}

}

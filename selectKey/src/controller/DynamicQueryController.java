package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.DynamicQueryDao;
import dto.SelectKey;
import mybatis.MyBatisConnectionFactory;

/**
 * Servlet implementation class DynamicQueryController
 */
@WebServlet("/dynamic/query")
public class DynamicQueryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 마이바티스 연결 객체
	private SqlSessionFactory factory = MyBatisConnectionFactory.getsqlSessionFactory();
	
	// 마이바티스 수행 객체
	private SqlSession sqlSession;
	
	// DAO 객체
	private DynamicQueryDao dynamicQueryDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		sqlSession = factory.openSession(true);
		dynamicQueryDao = sqlSession.getMapper(DynamicQueryDao.class);
		
		
		List<HashMap<String, Object>> list = dynamicQueryDao.select();
		
		List res2 = dynamicQueryDao.select2("dpdzz");
		System.out.println(res2);
		
		SelectKey selectKey = new SelectKey();
		selectKey.setId("good");
		selectKey.setPw(null);
		
		List res3 = dynamicQueryDao.select3(selectKey);
		System.out.println(res3);
		
		for(Object object : list) {
			System.out.println(object);
		}
		
		req.setAttribute("jspList", list);
		req.getRequestDispatcher("/WEB-INF/views/query.jsp").forward(req, resp);
	}
	
}

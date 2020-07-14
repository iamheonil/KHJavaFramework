package web.controller;

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

import mybatis.MyBatisConnectionFactory;
import web.dao.DynamicQueryDao;
import web.dto.Emp;

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
		
		
//		List<HashMap<String, Object>> list = dynamicQueryDao.select();
//		
//		List res2 = dynamicQueryDao.select2("dpdzz");
//		System.out.println(res2);
//		
//		SelectKey selectKey = new SelectKey();
//		selectKey.setId("good");
//		selectKey.setPw(null);
//		
//		List res3 = dynamicQueryDao.select3(selectKey);
//		System.out.println(res3);
//		
//		for(Object object : list) {
//			System.out.println(object);
//		}
//		
//		req.setAttribute("jspList", list);
		
		// -------------------------------
		
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("category", "id");
//		map.put("keyword", "dpdzz");
//		
//		List<SelectKey> res4 = dynamicQueryDao.select4(map);
//		
//		System.out.println(res4);
//		
//		System.out.println("--");
//		
//		map.put("category", "pw");
//		map.put("keyword", "good");
//		
//		List<SelectKey> res5 = dynamicQueryDao.select4(map);
//		
//		System.out.println(res5);
		
		// -------------------------------
		
		
//		req.getRequestDispatcher("/WEB-INF/views/query.jsp").forward(req, resp);
		
		req.getRequestDispatcher("/WEB-INF/views/queryCheckbox.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		sqlSession = factory.openSession(true);
		dynamicQueryDao = sqlSession.getMapper(DynamicQueryDao.class);
		
		// 전달 파라미터가 하나일 때만 사용 가능하다
//		String data = req.getParameter("deptno");
//		System.out.println(data);
		
		String dataArr[] = req.getParameterValues("deptno");
		
		for(int i = 0; i < dataArr.length; i++) {
			System.out.println(dataArr[i]);
		}
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("dataArr", dataArr);
		
		List<Emp> list = dynamicQueryDao.selectCheckbox(map);
		
		for (Emp emp : list) {
			System.out.println(emp);
		}
	
		sqlSession.clearCache();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/resultCheckbox.jsp").forward(req, resp);
		
		
	}
	
}

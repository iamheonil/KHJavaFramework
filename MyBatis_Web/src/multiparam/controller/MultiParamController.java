package multiparam.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import multiparam.dao.MultiParamDao;
import mybatis.MyBatisConnectionFactory;
import web.dao.DynamicQueryDao;
import web.dto.Emp;

/**
 * Servlet implementation class MultiParamController
 */
@WebServlet("/multi/param")
public class MultiParamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 마이바티스 연결 객체
	private SqlSessionFactory factory = MyBatisConnectionFactory.getsqlSessionFactory();

	// 마이바티스 수행 객체
	private SqlSession sqlSession;

	private MultiParamDao multiParamDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		sqlSession = factory.openSession(true);
		multiParamDao = sqlSession.getMapper(MultiParamDao.class);

		// System.out.println("/multi/param [get]");

		// DTO 를 이용한 파라미터 전달
//		Emp emp = new Emp();
//		emp.setEmpno(8999);
//		emp.setEname("KIM");
//		emp.setJob("AAA");
//
//		multiParamDao.insert(emp);

		// 여러개의 파라미터 전달
		// multiParamDao.insert2(8996, "PARK", null);

		// HashMap 을 사용하여 파라미터 전달
		HashMap<String, Object> hashMap = new HashMap<>();
		
		hashMap.put("empno", 8995);
		hashMap.put("ename", "Lee");
		hashMap.put("job", "Traveler");
		
		multiParamDao.insert3(hashMap);
		

	}

}

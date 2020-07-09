package service;

import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.SelectKeyDao;
import dto.SelectKey;
import mybatis.MyBatisConnectionFactory;

public class SelectKeyServiceImpl implements SelectKeyService {
	
	private SelectKeyDao memberDao;

	// 마이바티스 연결 객체 생성
	private SqlSessionFactory factory = MyBatisConnectionFactory.getsqlSessionFactory();

	@Override
	public void insert(HttpServletRequest req) {

		// 마이바티스 SQL 수행 객체
		SqlSession sqlSession = factory.openSession();

		// 매퍼를 이용한 DAO 연결
		memberDao = sqlSession.getMapper(SelectKeyDao.class);

		SelectKey selectKey = new SelectKey();
		
		selectKey.setId(req.getParameter("id"));
		selectKey.setPw(req.getParameter("pw"));
		
		// System.out.println(member);
		
		memberDao.insertMember(selectKey);

	}

}

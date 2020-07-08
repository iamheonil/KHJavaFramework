package web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MyBatisConnectionFactory;
import web.dao.EmpDao;
import web.dto.Emp;

public class EmpServiceImpl implements EmpService {

	// 마이바티스 연결 객체 생성
	private SqlSessionFactory factory = MyBatisConnectionFactory.getsqlSessionFactory();

	// DAO 객체
	private EmpDao empDao;

	@Override
	public List<Emp> getList() {

		// 마이바티스 SQL 수행 객체
		SqlSession sqlSession = factory.openSession();

		// 매퍼를 이용한 DAO 연결
		empDao = sqlSession.getMapper(EmpDao.class);

		// 전체 리스트 조회
		List<Emp> list = empDao.selectAll();

//		sqlSession.commit();
//		sqlSession.rollback();

//		sqlSession.close();

		return list;
	}

	@Override
	public Emp selectEname(Emp ename) {

		// 마이바티스 SQL 수행 객체
		SqlSession sqlSession = factory.openSession();

		// 매퍼를 이용한 DAO 연결
		empDao = sqlSession.getMapper(EmpDao.class);
		
		Emp detail = empDao.selectDetail(ename);

		return detail;
	}

}

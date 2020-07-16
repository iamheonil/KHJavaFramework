package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Dept;
import mybatis.MyBatisConnectionFactory;

public class DeptDaoImpl implements DeptDao {

	private SqlSessionFactory factory = MyBatisConnectionFactory.getsqlSessionFactory();
	private String namespace = "dao.DeptDao.";

	@Override
	public List<Dept> selectAll() {

		SqlSession sqlSession = factory.openSession();
		
		List<Dept> deptList = sqlSession.selectList(namespace + "selectAll");
		
		sqlSession.close();
		
		return deptList;
	}

	@Override
	public Dept selectInfo(int parseDeptno) {
		SqlSession sqlSession = factory.openSession();
		Dept dept = sqlSession.selectOne(namespace + "selectInfo", parseDeptno);
		
		sqlSession.close();
		
		System.out.println(dept);
		return dept;
	}

}

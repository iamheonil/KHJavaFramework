package dept.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dept.dto.Dept;
import mybatis.MyBatisConnectionFactory;

public class DeptDaoImpl implements DeptDao {

	// 마이바티스 객체 생성
	private SqlSessionFactory factory = MyBatisConnectionFactory.getsqlSessionFactory();

	private String namespace = "dept.dao.DeptDao.";

	@Override
	public List<Dept> selectAll() {

		// 마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();

		List<Dept> deptList = sqlSession.selectList(namespace + "selectAll");

		sqlSession.close();

		return deptList;
	}

	@Override
	public Dept selectOne(int deptNo) {

		SqlSession sqlSession = factory.openSession();

		Dept result = sqlSession.selectOne(namespace + "selectOne", deptNo);

		sqlSession.close();

		System.out.println(result);

		return result;
	}

	@Override
	public void insert(Dept dept) {
		
		SqlSession sqlSession = factory.openSession(true);

		// sqlSession.insert, update, delete 는 영향받은 행 수를 반환한다
		sqlSession.insert(namespace + "insert", dept);
		
		System.out.println(dept);
		
		sqlSession.commit();

	}

}

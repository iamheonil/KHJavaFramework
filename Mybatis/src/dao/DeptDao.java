package dao;

import java.util.List;

import dto.Dept;

public interface DeptDao {

	// 부서번호를 이용한 부서정보 조회
	public Dept selectByDeptno(int deptno);
	
	// 전체 부서를 조회한다
	public List<Dept> selectAll();
	
	// 부서명을 입력하여 조회한다
	public Dept selectByDname(String str);
	
	// 입력되어 있는 부서명을 통해 조회한다
	public Dept selectByDept(Dept data);
	
	// 부서정보를 삽입한다.
	public void insert(Dept InsertDept);
	
}

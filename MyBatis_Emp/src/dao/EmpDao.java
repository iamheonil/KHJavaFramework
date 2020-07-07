package dao;

import java.util.List;

import dto.Emp;

public interface EmpDao {

		// Emp 테이블의 전체를 출력한다.
		public List<Emp> selectAll();
		
		// Emp 테이블에 정보를 삽입한다.
		public void insertEmp(Emp emp);
		
		// Emp 테이블에서 EmpNo 으로 사원을 특정하여 출력한다.
		public Emp selectByEmpNo(Emp selectEmp);
		
		// Emp 테이블에서 EmpNo 으로 사원을 특정하여 삭제한다.
		public void deleteEmp(Emp deleteEmp);

}

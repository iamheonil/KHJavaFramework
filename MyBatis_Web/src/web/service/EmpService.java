package web.service;

import java.util.List;

import web.dto.Emp;

public interface EmpService {

	// Emp 테이블 전체 조회
	public List<Emp> getList();
	
	// Emp No 을 조회하여 상세 출력
	public Emp selectEname(Emp ename);
	
}

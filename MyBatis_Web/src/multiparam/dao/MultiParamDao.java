package multiparam.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import web.dto.Emp;

public interface MultiParamDao {

	// DTO 전달 받아 마이바티스 이용
	public void insert(Emp emp);
	
	// 여러개의 인자로 매개변수 전달
	public void insert2(@Param("e1") int empno, @Param("e2") String ename, @Param("e3") String job);
	
	public void insert3(HashMap<String, Object> hashMap);
	
}

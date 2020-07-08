package web.dao;

import java.util.List;

import web.dto.Emp;

public interface EmpDao {

	public List<Emp> selectAll();
	
	public Emp selectDetail(Emp ename);

}

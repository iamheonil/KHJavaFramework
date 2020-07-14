package dept.dao;

import java.util.List;

import dept.dto.Dept;

public interface DeptDao {
	
	public List<Dept> selectAll();
	
	public Dept selectOne(int deptNo);

	public void insert(Dept dept);
	

}

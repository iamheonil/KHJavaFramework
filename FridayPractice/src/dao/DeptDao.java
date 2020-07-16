package dao;

import java.util.List;

import dto.Dept;

public interface DeptDao {

	public List<Dept> selectAll();

	public Dept selectInfo(int parseDeptno);

}

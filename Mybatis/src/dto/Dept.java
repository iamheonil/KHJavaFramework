package dto;

public class Dept {

	private int deptno;
	private String dname;
	private String loc;

	@Override
	public String toString() {
		return "Dept [부서번호=" + deptno + ", 부서이름=" + dname + ", 지역=" + loc + "]";
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}

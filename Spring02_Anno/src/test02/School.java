package test02;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class School {

//	@Autowired
//	@Qualifier("lee")
	
	
	@Resource(name = "hong")
	private Student kim;
	private int grade;

	public School() {
	}

	public School(Student kim, int grade) {
		super();
		this.kim = kim;
		this.grade = grade;
	}

	public Student getKim() {
		return kim;
	}

	public void setKim(Student kim) {
		this.kim = kim;
	}
	
	public void thisKim(Student kim) {
		this.kim = kim;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "School [kim=" + kim + ", grade=" + grade + "]";
	}

}

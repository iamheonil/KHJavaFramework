package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.EmpDao;
import dto.Emp;
import mybatis.MyBatisConnectionFactory;

public class EmpEx {
	public static void main(String[] args) {

		// 마이바티스 수행 객체를 생성한다.
		SqlSession sqlSession;

		// DB 접속 및 SqlSession 생성 팩토리 객체를 생성한다.
		SqlSessionFactory factory = MyBatisConnectionFactory.getsqlSessionFactory();

		// SQL 수행 객체 생성
		sqlSession = factory.openSession();

		// =- =- =- =- =- =- =- =- =- =- =- =- =- =- =-

		// 마이바티스의 매퍼와 자바프로그램의 DAO 인터페이스 매핑(연결)
		EmpDao empDao = sqlSession.getMapper(EmpDao.class);

		// =- =- =- =- =- =- =- =- =- =- =- =- =- =- =-

		Scanner sc = new Scanner(System.in);

		List<Emp> list = empDao.selectAll();

		for (Emp emp : list) {
			System.out.println(emp);
		}
		
		System.out.println("=- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =-");
		System.out.println("회원정보 삽입해보기");
		Emp insertEmp = new Emp();
		
		System.out.print("사원번호 입력 : ");
		insertEmp.setEmpno(sc.nextInt());

		sc.nextLine();
		
		System.out.print("이름 입력 : ");
		insertEmp.setEname(sc.nextLine());
		
		System.out.print("직업 입력 : ");
		insertEmp.setJob(sc.nextLine());
		
		System.out.print("사수번호 입력 : ");
		insertEmp.setMgr(sc.nextInt());
		
		sc.nextLine();
		
		System.out.print("입사일 입력 (yyyy-MM-dd) : ");
		String input = sc.nextLine();
		
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		Date hiredate = null;
		
		try {
			hiredate = form.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		insertEmp.setHiredate(hiredate);
		
		System.out.print("월급 입력 : ");
		insertEmp.setSal(sc.nextInt());
		
		sc.nextLine();
		
		System.out.print("보너스 입력 : ");
		insertEmp.setComm(sc.nextInt());
		
		sc.nextLine();
		
		System.out.print("부서번호 입력 : ");
		insertEmp.setDeptno(sc.nextInt());
		
		System.out.println(insertEmp);
		empDao.insertEmp(insertEmp);
		
		sqlSession.commit();
		System.out.println("커밋완료");
		
		System.out.println("=- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =-");
		System.out.println("사원번호를 입력받아 정보를 출력");
		System.out.print("사원 번호를 입력하세요 : ");
		Emp selectNo = new Emp();
		selectNo.setEmpno(sc.nextInt());
		
		Emp res = empDao.selectByEmpNo(selectNo);
		System.out.println(res);
		
		System.out.println("=- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =-");
		System.out.println("사원번호를 입력받아 정보를 삭제");
		System.out.print("사원 번호를 입력하세요 : ");
		Emp deleteNo = new Emp();
		deleteNo.setEmpno(sc.nextInt());
		
		empDao.deleteEmp(deleteNo);
		System.out.println(deleteNo + " 는 삭제 성공 수고링");
		
		System.out.println("=- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =- =-");
		
		sqlSession.commit();
		System.out.println("커밋이 완료 되었습니다.");
		
	} // Main End
} // Class End

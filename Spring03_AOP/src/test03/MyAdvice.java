package test03;

import org.aspectj.lang.JoinPoint;

public class MyAdvice {

	public void before(JoinPoint join) {
		
		// JoinPoint 타겟객체에 대한 정보를 담고 있다
		// Spring AOP 를 사용하기 위해서 반드시 매개변수로 넣어줘야하는 객체이다 
		
		// 클래스명 출력
		System.out.println(join.getTarget().getClass());

		// 메소드명 출력
		System.out.println(join.getSignature().getName());
		
		// 대상 객체 메서드의 정보
		System.out.println(join);
		
		// 메소드 매개변수
		System.out.println(join.getArgs());
		
		System.out.println("출석 카드를 찍는다");
	}
	
	public void after(JoinPoint join) {
		System.out.println("집에 간다 제발");
	}
	
}

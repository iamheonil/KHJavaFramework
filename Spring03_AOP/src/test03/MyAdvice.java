package test03;

import org.aspectj.lang.JoinPoint;

public class MyAdvice {

	public void test(JoinPoint join) {
		System.out.println(join.getTarget().getClass());
		System.out.println(join.getSignature().getName());
		System.out.println("출석 카드를 찍는다");
	}
	
	public void after(JoinPoint join) {
		System.out.println("집에 간다 제발");
	}
	
}

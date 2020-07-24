package test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// 해당 클래스가 Aspect 역할을 하게끔 만들어주는 어노테이션
@Aspect
public class MyAspect {
	
	// 정상흐름 : @Before -> @After -> @AfterReturning
	// 예외 발생 시 @After -> @AfterThrowing

	// target 객체를 호출하기전에 before 어노테이션이 실행된다
	@Before("execution(public * * (..))")
	public void before(JoinPoint join) {

		System.out.println("출석카드를 찍는다");

	}

	// target 객체를 반환한 뒤에 실행되는 메소드
	@AfterThrowing("execution(public * * (..))")
	public void throwing(JoinPoint join) {
		System.out.println("쉬는 날 이었다");
	}

	// Before, AfterThrowing, After 와는 달리 어노테이션에 pointcut 과 결과를 반환받을
	// 변수명 두가지를 지정해줘야 한다 pointcut, returning
	@AfterReturning(pointcut = "execution(public * *(..))", returning = "returnVal")
	public void returning(JoinPoint join, Object returnVal) {

		System.out.println(returnVal + " 공부하는 날이었다 ");

	}

	// 타겟 객체의 메소드를 실행하고, 결과값을 반환하기 직전에 실행
	// return 값을 가지고 오지 않는다
	@After("execution(public * * (..))")
	public void after(JoinPoint join) {
		System.out.println("집으로");
	}

}

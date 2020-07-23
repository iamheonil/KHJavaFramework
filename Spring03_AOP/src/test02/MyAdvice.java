package test02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Object target = null;
		
		System.out.println("출석카드");

		try {
			
			// target 객체의 메소드 실행
			target = invocation.proceed();
			
		} catch (Exception e) {
			System.out.println("쉬는 날이었다");
		} finally {
			System.out.println("렛츠고 홈");
		}
		
		return target;
	}

}

package common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAop {

	@Before("execution(* com.kh.welcome..*.*(..))")
	public void before(JoinPoint join) {
		
		Logger logger = LoggerFactory.getLogger(join.getTarget().toString());
		logger.info("------------------------");

		// 메소드 명 출력
		logger.info("method : " + join.getSignature().getName());
		
		// Object[] 에 매개변수들을 담는다
		Object[] args = join.getArgs();
		
		if(args != null) {
			logger.info("- - 매개변수 - -");
			for(Object arg : args) {
				logger.info(arg.toString());
			}
		}
		
	}
	
}

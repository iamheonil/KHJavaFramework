package test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
	public static void main(String[] args) {

		// ApplicationContext 가 생성되는 시점에 ApplicationContext.xml 을 참조하도록 생성자의 매개변수에 xml
		// 파일의 경로를 입력
		// ApplicationContext 는 생성됨과 동시에 xml 파일에서 설정한 일 (객체생성, 의존성 주입 등) 을 처리한다
		ApplicationContext factory = new ClassPathXmlApplicationContext("test02/applicationContext.xml");

		
		// ApplicationContext 로 부터 해당 아이디를 가진 Bean 객체를 반환받는다
		Address lee = (Address) factory.getBean("lee");

		System.out.println(lee);

		Address hong = (Address) factory.getBean("hong");

		System.out.println(hong);

	}
}

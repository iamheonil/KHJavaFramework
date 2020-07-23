package test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("test04/ApplicationContext.xml");
		
		// factory.getBean 의 두번째 매개변수에 원하는 클래스 객체를 넣어주면 원하는 타입으로 객체를 반환받을 수 있다 
		BeanTest beanTest = factory.getBean("beanTest", BeanTest.class);
	}
	
}

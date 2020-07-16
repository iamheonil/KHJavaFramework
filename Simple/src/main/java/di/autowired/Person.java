package di.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Person {

	public static void main(String[] args) {

		// 스프링 어플리케이션 컨텍스트 객체
		ApplicationContext context = null;

		// Spring Bean Configuration XML 파일을 이용하여 등록된 스프링 Bean 들의 정보를 읽어
		// 스프링 어플리케이션 컨텍스트를 생성한다
		context = new FileSystemXmlApplicationContext("/src/main/java/di/autowired/di.xml");
		
		Car car = (Car) context.getBean("car");
		
		System.out.println(car.getInfo());

	}

}

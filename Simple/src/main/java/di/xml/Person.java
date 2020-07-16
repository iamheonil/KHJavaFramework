package di.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import di.tire.Tire;

public class Person {
	public static void main(String[] args) {

		// 스프링 어플리케이션 컨텍스트 객체
		ApplicationContext context = null;
		
		// Spring Bean Configuration XML 파일을 이용하여 등록된 스프링 Bean 들의 정보를 읽어
		// 스프링 어플리케이션 컨텍스트를 생성한다
		context = new FileSystemXmlApplicationContext(
				"/src/main/java/di/xml/di.xml");
		
		// Car 객체 DI
		Car car = (Car) context.getBean("car");

		// tire 멤버필드 DI
//		car.setTire((Tire) context.getBean("gTire"));
		car.setTire((Tire) context.getBean("sTire"));
		
		System.out.println(car.getInfo());
		
		System.out.println("----------------------");
		
		Car c1 = (Car) context.getBean("car");
		c1.setTire((Tire) context.getBean("gTire"));
		System.out.println(c1.getInfo());
		
		Car c2 = (Car) context.getBean("car");
		c2.setTire((Tire) context.getBean("sTire"));
		System.out.println(c2.getInfo());
		
		System.out.println("----------------------");
		
		System.out.println(c1.getInfo());
		System.out.println(c2.getInfo());
	
	}
}

package test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {

//		Develop man = new MyAdvice();
//		Develop woman = new WomanProxy();

		ApplicationContext factory = new ClassPathXmlApplicationContext("test02/applicationContext.xml");

		Develop woman = (Develop) factory.getBean("woman");
		Develop man = (Develop) factory.getBean("man");
		
		System.out.println("여학생 입장");
		woman.classWork();
		
		System.out.println("남학생 입장");
		man.classWork();

	}

}

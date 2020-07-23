package test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("test02/applicationContext.xml");
		
		System.out.println(factory.getBean("mySchool"));
		
	}

}

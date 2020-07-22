package test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("test03/applicationContext.xml");
		
		AbstractTest today = (AbstractTest) factory.getBean("factorybean");
		
		System.out.println(today.dayInfo());
	
	}

}

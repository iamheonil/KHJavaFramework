package test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("test01/applicationContext.xml");
	
		System.out.println(factory.getBean("myNickName"));
		
	}

}

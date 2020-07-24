package com.edu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.entity.Rectangle;
import com.edu.entity.Triangle;

public class Run {
	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("com/edu/main/applicationContext.xml");
		
		Triangle setTr = new Triangle();
		Rectangle setRc = new Rectangle();
		
		Figure triangle = (Figure) factory.getBean("triangle");
		Figure rectangle = (Figure) factory.getBean("rectangle");
		
		setTr.setTitle("삼각형");
		setTr.setHeight(3);
		setTr.setWidth(5);
		
		triangle.viewSize();
		System.out.println();
		
		setRc.setTitle("사각형");
		setRc.setHeight(3);
		setRc.setWidth(5);

		System.out.println();
		
		rectangle.viewSize();
		
		System.out.println("\n");
//		setTr.viewSize();
//		setRc.viewSize();
		
	
	}
}

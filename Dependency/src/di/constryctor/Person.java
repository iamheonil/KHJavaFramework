package di.constryctor;

import di.tire.SilverTire;

public class Person {
	public static void main(String[] args) {

		Car car = new Car(new SilverTire());
		
		System.out.println(car.getTire());
		
	}
}

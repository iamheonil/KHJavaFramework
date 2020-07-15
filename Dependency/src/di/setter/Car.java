package di.setter;

import di.tire.GoldTire;
import di.tire.SilverTire;
import di.tire.Tire;

public class Car {

	private Tire tire;

	public Car() {

		// 의존성 발생지점
		// tire = new GoldTire();
		// tire = new SilverTire();

	}

	public void setTire(Tire tire) {

		// 의존성 발생지점
		this.tire = tire;

	}

	public String getTire() {

		return tire.getProduct() + "장착!!";

	}

}

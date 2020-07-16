package di.autowired;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import di.tire.Tire;

public class Car {

	@Qualifier("gTire")
	// @Autowired
	// @Resource
	@Inject
	private Tire tire;

	public String getInfo() {
		return tire.getProduct() + " 장착 했습니다!";
	}

	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		this.tire = tire;
	}
	
}

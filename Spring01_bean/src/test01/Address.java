package test01;

public class Address {

	private String name;
	private String addr;
	private String phone;

	public Address() {

	}

	public Address(String name, String addr, String phone) {
		super();
		this.name = name;
		this.addr = addr;
		this.phone = phone;
		
		System.out.println("Address 생성자 호출");
	}

	@Override
	public String toString() {
		return "Address [name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println(name + " 입력 됐습니다.");
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
		System.out.println(addr + " 입력 됐습니다.");
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println(phone + " 입력 됐습니다.");
	}

}

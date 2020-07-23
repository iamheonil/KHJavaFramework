package test01.proxy;

public class Run {

	public static void main(String[] args) {
		
		Develop man = new ManProxy();
		Develop woman = new WomanProxy();
		
		System.out.println("여학생 입장");
		woman.classWork();
		System.out.println("남학생 입장");
		man.classWork();
		
	}
	
}

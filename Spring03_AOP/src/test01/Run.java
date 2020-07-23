package test01;

public class Run {

	public static void main(String[] args) {
		
		Man man = new Man();
		Woman woman = new Woman();
		
		System.out.println("여학생 입장");
		woman.classWork();
		System.out.println("남학생 입장");
		man.classWork();
		
	}
	
}

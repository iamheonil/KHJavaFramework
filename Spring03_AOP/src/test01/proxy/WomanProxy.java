package test01.proxy;

public class WomanProxy implements Develop {

	@Override
	public void classWork() {
		
		System.out.println("출석카드");

		try {
			new Woman().classWork();
			// int error = 20/0;
		} catch (Exception e) {
			System.out.println("쉬는 날이었다");
		} finally {
			System.out.println("렛츠고 홈");
		}
	}

}

package test01;

public class Woman {

	public void classWork() {
		System.out.println("출석카드");

		try {
			System.out.println("콤푸타를 켜서 오라크를 켠다");
			int error = 20/0;
		} catch (Exception e) {
			System.out.println("쉬는 날이었다");
		} finally {
			System.out.println("렛츠고 홈");
		}
	}

}

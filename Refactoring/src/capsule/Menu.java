package capsule;

import java.util.Scanner;

public class Menu {

	// 스케너 객체 생성
	Scanner sc = new Scanner(System.in);

	private Accounting accounting;
	private Sales sales;

	// 사용자가 판매할 커피의 갯수를 결정할 수 있다
	private Coffee[] coffeeArr;

	public Menu() {

		accounting = new Accounting();
		System.out.println("잔고를 입력하세요 : ");
		// 사용자에게 잔고 입력받아서 accounting 객체에 세팅
		accounting.setBalance(sc.nextInt());

		// 생성자로 의존성 주입
		sales = new Sales(accounting);

		System.out.println("=========================");
		System.out.println("커피 종류의 가짓수를 입력하세요 : ");

		// 사용자가 지정한 커피 종류의 수 만큼 커피 배열의 칸을 만듬
		coffeeArr = new Coffee[sc.nextInt()];

		System.out.println("=========================");

		// 커피 객체를 생성해서 커피 객체배열에 추가
		for (int i = 0; i < coffeeArr.length; i++) {
			Coffee coffee = new Coffee(accounting);
			int no = i + 1;

			System.out.println(no + "번째 커피의 이름을 등록하세요 : ");
			coffee.setName(sc.next());

			System.out.println(no + "번째 커피의 판매가를 등록하세요 : ");
			coffee.setSalesPrice(sc.nextInt());

			System.out.println(no + "번째 커피의 매입가를 등록하세요 : ");
			coffee.setPerchacePrice(sc.nextInt());

			System.out.println(no + "번째 커피의 재고를 등록하세요 : ");
			coffee.setStock(sc.nextInt());

			System.out.println(no + "번째 커피의 안전재고를 등록하세요 : ");
			coffee.setSafetyStock(sc.nextInt());

			System.out.println("=====================");
			coffeeArr[i] = coffee;

		}

	}

	public void showIndex() {
		do {
			System.out.println("\n========메뉴=======");
			System.out.println("메뉴 (0)");
			System.out.println("현황 (1)");
			System.out.println("종료 (2)");
			System.out.println("환불 (3)");
			System.out.println("반품 (4)");
			System.out.println("입력 : ");
			int inputMenu = sc.nextInt();

			switch (inputMenu) {
			case 0:
				showMenu();
				break;
			case 1:
				showStats();
				break;
			case 2:
				System.out.println("프로그램 종료");
				return;
			case 3:
				refund();
				break;
			default:
				System.out.println("잘못된 번호를 입력하였습니다");
			}

		} while (true);

	}

	private void showMenu() {

		System.out.println("\n****** 음료 메뉴");
		for (int i = 0; i < coffeeArr.length; i++) {
			System.out.println(coffeeArr[i].getName() + "(" + i + ")");
		}

		showSales();

	}
	
	private void refund() {
		
		System.out.println("환불 절차를 진행합니다");
		
		
	}

	private void showSales() {
		System.out.println("\n * 판매할 커피의 코드를 입력하세요 :");
		int inputType = sc.nextInt();
		System.out.println("* 주문량을 입력하세요 : ");
		int ordercnt = sc.nextInt();

		int payPrice = sales.sellProduct(coffeeArr[inputType], ordercnt);
		if (payPrice > 0) {
			System.out.println("\n 제품명 :" + coffeeArr[inputType].getName() + "\n 판매가 :"
					+ coffeeArr[inputType].getSalesPrice() + "\n 구매 개수 :" + ordercnt + "\n 결제금액 :" + payPrice
					+ "\n 남은 재고 :" + coffeeArr[inputType].getStock());
		} else {
			System.out.println(" * 주문이 취소 되었습니다");
		}
	}

	private void showStats() {
		System.out.println("/n===============");
		// 모든 커피들의 재고와 판매량을 출력
		for (Coffee coffee : coffeeArr) {
			System.out.printf("%10s 재고 : %d | 판매량 : %d \n ", coffee.getName(), coffee.getStock(),
					coffee.getSalesCount());
		}

		System.out.println("* 재고 : " + accounting.getBalance() + "매출 :" + accounting.getSalesPrice() + "| 지출 :"
				+ accounting.getExpences());
	}

}

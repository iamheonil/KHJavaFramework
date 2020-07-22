package refactoring_01;

import java.util.Scanner;

public class Refactoring_01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("잔고를 등록하세요 : ");
		int balance = sc.nextInt(); // 잔고
		int expences = 0; // 지출
		int salesPrice = 0; // 매출

		System.out.println("=============================");

		System.out.print("아메리카노 판매가를 등록하세요 : ");
		int americanoPrice = sc.nextInt();
		System.out.print("아메리카노 원가를 등록하세요 : ");
		int americanoCost = sc.nextInt();
		System.out.print("아메리카노 재고를 등록하세요 : ");
		int americanoStock = sc.nextInt();
		System.out.print("아메리카노 안전재고를 등록하세요 : ");
		int americanoSaftyStock = sc.nextInt();
		int americanoSalesCount = 0;

		System.out.println("=============================");

		System.out.print("라떼 판매가를 등록하세요 : ");
		int lattePrice = sc.nextInt();
		System.out.print("라떼 원가를 등록하세요 : ");
		int latteCost = sc.nextInt();
		System.out.print("라떼 재고를 등록하세요 : ");
		int latteStock = sc.nextInt();
		System.out.print("라떼 안전재고를 등록하세요 : ");
		int latteSaftyStock = sc.nextInt();
		int latteSalesCount = 0;

		System.out.println("=============================");

		System.out.print("모카 판매가를 등록하세요 : ");
		int mocaPrice = sc.nextInt();
		System.out.print("모카 원가를 등록하세요 : ");
		int mocaCost = sc.nextInt();
		System.out.print("모카 재고를 등록하세요 : ");
		int mocaStock = sc.nextInt();
		System.out.print("모카 안전재고를 등록하세요 : ");
		int mocaSaftyStock = sc.nextInt();
		int mocaSalesCount = 0;

		do {
			System.out.println("\n======Menu=====");
			System.out.println("메뉴(1)  ");
			System.out.println("현황(2)  ");
			System.out.println("종료(3)  ");
			System.out.print("입력 : ");
			int inputMenu = sc.nextInt();

			if (inputMenu == 1) {

				System.out.println("\n ******* 음료 메뉴");
				System.out.println("아메리카노(1)");
				System.out.println("라떼(2)");
				System.out.println("모카(3)");
				System.out.print("\n * 판매한 커피의 코드를 입력하세요:");
				int inputType = sc.nextInt();

				System.out.print("\n * 주문량을 입력하세요:");
				int orderCnt = sc.nextInt();

				if (inputType == 1) {
					if (orderCnt <= americanoStock) {
						americanoStock = americanoStock - orderCnt;
						balance += americanoPrice * orderCnt;
						salesPrice += americanoPrice * orderCnt;
						americanoSalesCount += orderCnt;
						System.out.println("\n * 판매가 완료되었습니다.");
						System.out.println("제품명 : 아메리카노" + " \n 판매가 : " + americanoPrice + " \n 구매 갯수 : " + orderCnt
								+ " \n 결재금액 : " + americanoPrice * orderCnt + " \n 남은 재고 : " + americanoStock);
					} else {
						int needMoney = orderCnt * americanoCost;
						if (needMoney <= balance) {
							System.out.println(" * 재고를 " + orderCnt + "개 추가합니다.");
							balance -= americanoPrice * orderCnt;
							balance += americanoPrice * orderCnt;
							salesPrice += americanoPrice * orderCnt;
							americanoSalesCount += orderCnt;
							expences += americanoCost * orderCnt;
							System.out.println("\n  * 판매가 완료되었습니다.");
							System.out.println("제품명 : 아메리카노" + " \n 판매가 : " + americanoPrice + " \n 구매 갯수 : " + orderCnt
									+ " \n 결재금액 : " + americanoPrice * orderCnt + " \n 남은 재고 : " + americanoStock);
						} else {
							System.out.println(" * 잔고가 부족해 재고를 추가하지 못 했습니다.");
							System.out.println("\n * 주문이 취소되었습니다.");
						}
					}

					if (americanoStock < americanoSaftyStock) {
						int needCnt = americanoSaftyStock * 2;
						int needMoney = americanoSaftyStock * 2 * americanoCost;
						if (needMoney < balance) {
							System.out.println(" * 안전재고가 부족해 안전재고를 추가합니다.");
							americanoStock += needCnt;
							balance -= needMoney;
							expences += needCnt * americanoCost;
							System.out.println("아메리카노 재고 : " + americanoStock);
						}
					}
				} else if (inputType == 2) {
					if (orderCnt <= latteStock) {
						latteStock = latteStock - orderCnt;
						balance += lattePrice * orderCnt;
						salesPrice += lattePrice * orderCnt;
						latteSalesCount += orderCnt;
						System.out.println("\n * 판매가 완료되었습니다.");
						System.out.println("제품명 : 라떼" + " \n 판매가 : " + lattePrice + " \n 구매 갯수 : " + orderCnt
								+ " \n 결재금액 : " + lattePrice * orderCnt + " \n 남은 재고 : " + latteStock);
					} else {
						int needMoney = orderCnt * latteCost;

						if (needMoney <= balance) {
							System.out.println(" * 재고를 " + orderCnt + "개 추가합니다.");
							latteStock = latteSaftyStock * 2;
							balance -= americanoPrice * orderCnt;
							balance += lattePrice * orderCnt;
							salesPrice += lattePrice * orderCnt;
							latteSalesCount += orderCnt;
							expences += latteCost * orderCnt;
							System.out.println("\n * 판매가 완료되었습니다.");
							System.out.println("제품명 : 라떼" + " \n 판매가 : " + lattePrice + " \n 구매 갯수 : " + orderCnt
									+ " \n 결재금액 : " + lattePrice * orderCnt + " \n 남은 재고 : " + latteStock);
						} else {
							System.out.println(" * 잔고가 부족해 재고를 추가하지 못 했습니다.");
							System.out.println("\n * 주문이 취소되었습니다.");
						}
					}

					if (latteStock < latteSaftyStock) {
						int needCnt = latteSaftyStock * 2;
						int needMoney = needCnt * latteCost;

						if (needMoney < balance) {
							System.out.println(" * 안전재고가 부족해 안전재고를 추가합니다.");
							latteStock += needCnt;
							expences += latteCost * needCnt;
							balance -= needMoney;
							System.out.println("라때 재고 : " + latteStock);
						}
					}
				} else if (inputType == 3) {
					if (orderCnt <= mocaStock) {
						mocaStock = mocaStock - orderCnt;
						balance += mocaPrice * orderCnt;
						salesPrice += mocaPrice * orderCnt;
						mocaSalesCount += orderCnt;
						System.out.println("\n * 판매가 완료되었습니다.");
						System.out.println("제품명 : 모카" + " \n 판매가 : " + mocaPrice + " \n 구매 갯수 : " + orderCnt
								+ " \n 결재금액 : " + mocaPrice * orderCnt + " \n 남은 재고 : " + mocaStock);
					} else {
						int needMoney = orderCnt * mocaCost;
						if (needMoney <= balance) {
							System.out.println(" * 재고를 " + orderCnt + "개 추가합니다.");
							mocaStock = mocaSaftyStock * 2;
							balance -= americanoPrice * orderCnt;
							balance += mocaPrice * orderCnt;
							salesPrice += mocaPrice * orderCnt;
							expences += mocaCost * orderCnt;
							mocaSalesCount += orderCnt;
							System.out.println("\n * 판매가 완료되었습니다.");
							System.out.println("제품명 : 모카" + " \n 판매가 : " + mocaPrice + " \n 구매 갯수 : " + orderCnt
									+ " \n 결재금액 : " + mocaPrice * orderCnt + " \n 남은 재고 : " + mocaStock);
						} else {
							System.out.println(" * 잔고가 부족해 재고를 추가하지 못 했습니다.");
							System.out.println("\n 주문이 취소되었습니다.");
						}
					}

					if (mocaStock < mocaSaftyStock) {
						int needCnt = latteSaftyStock * 2;
						int needMoney = needCnt * mocaCost;
						if (needMoney < balance) {
							System.out.println(" * 안전재고가 부족해 안전재고를 추가합니다.");
							mocaStock += needCnt;
							balance -= needMoney;
							expences += mocaCost * needCnt;
							System.out.println("모카 재고 : " + mocaStock);
						}
					}
				} else {
					System.out.println(" * 잘못 입력하셨습니다.");
				}
			} else if (inputMenu == 2) {
				System.out.println("\n아메리카노 재고 : " + americanoStock + " | 판매량 : " + americanoSalesCount);
				System.out.println("       라떼 재고 : " + latteStock + " | 판매량 : " + latteSalesCount);
				System.out.println("       모카 재고 : " + mocaStock + " | 판매량 : " + mocaSalesCount);
				System.out.println(" 잔고 : " + balance + " | 매출 : " + salesPrice + " | 지출 : " + expences);
			} else if (inputMenu == 3) {
				System.out.println(" * 프로그램을 종료합니다.");
				return;
			} else {
				System.out.println(" * 잘못된 번호를 입력하였습니다.");
			}

		} while (true);
	}
}

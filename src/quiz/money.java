package quiz;

import java.util.Scanner;

public class money {
	
	public static void main(String[] args) {
		// 금액 단위 5만원 1만원 5천원 1천원
		Scanner sc = new Scanner(System.in); // sc는 입력값 이다
		int value = sc.nextInt(); // nextint sc.옆에 숫자값을 가져온다
		int a = 50000;
		int b = 10000;
		int c = 5000;
		int d = 1000;
		
		int remain = 0; //나머지
		
		int a1 = value / a ;
		remain = value % a ;
		
		int a2 = remain / b;
		remain = remain % b;
		
		int a3 = remain / c;
		remain = remain % c;
		
		int a4 = remain / d;
		remain = remain % d;
		
		int a5 = remain ;
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		System.out.println(a5);
		
		

		
		
//		
////		% //나머지 구하는 법
//		/ // 해 찾기
//				
		// 대단위 금액 사용 
				// 5만원 사용 가격 보다 크면 안됨
				// 1만원 사용
				// 5천원 사용
				// 1천원 사용
	}
	
	
	
}


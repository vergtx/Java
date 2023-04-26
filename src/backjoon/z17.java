package backjoon;

import java.util.Scanner;

public class z17 {
	
	
	public static void main(String[] args) {
		// 윤년은 4의 배수 이면서 100의 배수가 아닐때
		// 또는 400의 배수 일떄 
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = 0 ;

		
				
		if  ((a % 4 == 0 && a % 100 != 0)||a % 400 == 0 ) {
			b = 1 ;			
			} else b = 0;
		System.out.println(b);

	}
	

}

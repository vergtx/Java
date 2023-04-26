package backjoon;

import java.util.Scanner;

public class z11 {
	
	public static void main(String[] args) {
	
		
	
	Scanner sc = new Scanner(System.in);
	
	int A = sc.nextInt() ;
	int B = sc.nextInt() ;

	
	int T = B % 10; // 세 번째 자리 숫자
    int S = (B / 10) % 10; // 두 번째 자리 숫자
    int F = B / 100; // 첫 번째 자리 숫자
	
	
	
	
	System.out.println(A*T);
	System.out.println(A*S);
	System.out.println(A*F);
	System.out.println(A*B);


	
	}
 

}

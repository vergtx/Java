package a백준_조건문;

import java.util.Scanner;

public class z19 {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
				
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int t = A * 60 + B + C ;
		
		A = t / 60;
		B = t % 60;
		
		if (A >= 24) {
			A = A-24;
		}
		
		
		
		System.out.println(A +" "+ B);
		
	}

}

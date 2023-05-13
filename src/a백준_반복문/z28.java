package a백준_반복문;

import java.util.Scanner;

public class z28 {
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
							
			for (int i=0 ; i<n; i++ ) { //0 ~ 4까지 5번
				for (int y=0 ; y<=i ; y++) {
					System.out.print("*");
				}
				
				System.out.println();
			}
		}
		
	}
	
		
}
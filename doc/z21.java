package backjoon;

import java.util.Scanner;

public class z21 {
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int z = 0; 
						
			if (a == b && b == c) {
				z = 10000 + a * 1000;
			} else if (a == b || a == c ) {
				z = 1000 + a * 100;
			} else if(b == c) {
				z= 1000+ b * 100;
			}
			else {
				z = Math.max(Math.max(a,b),c) * 100;
			}
			
			System.out.println(z);
		}
	}
	
}

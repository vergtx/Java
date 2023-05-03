package backjoon;

import java.util.Scanner;

public class z23 {
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			
			for (int i = 0 ; i < N ; i++) {
				
				int A = sc.nextInt();
				int B = sc.nextInt();
				System.out.println(A+B);
				
			}
		}
		
		
	}
	

}

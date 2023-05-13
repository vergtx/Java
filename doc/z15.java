package backjoon;

import java.util.Scanner;

public class z15 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt() ;
		int b = sc.nextInt() ;
		String c = null ;
		
		if (a > b) {
			c = ">";
		} else if (a < b) { 
			c = "<";
		} else if (a == b) { 
			c = "==";
			
		}
		
		System.out.println(c);
	}

}

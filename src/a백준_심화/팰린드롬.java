package a백준_심화;

import java.util.Scanner;

public class 팰린드롬 {
	
	private static String reverseString(String str) {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder(str);

		return sb.reverse().toString();
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		String reversed_str = reverseString(str);
		
		if (str.equals(reversed_str)) {
			System.out.println(1);
		} else System.out.println(0);
	
	}

}

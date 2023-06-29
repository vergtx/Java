package a백준_문자열;

import java.util.Scanner;

public class 숫자의합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input_number = sc.nextLine();

		String[] numS = input_number.split(" ");
		String num1 = numS[0];
		String num2 = numS[1];

		//System.out.println(numS[0]);
		//System.out.println(numS[1]);

		String reversed_num1 = reverseString(num1);
		String reversed_num2 = reverseString(num2);

		numS[0] = reversed_num1;
		numS[1] = reversed_num2;

		//System.out.println(numS[0]);
		//System.out.println(numS[1]);
		
		int int_num1 = Integer.parseInt(reversed_num1);
		int int_num2 = Integer.parseInt(reversed_num2);
		
		int max_numS = Math.max(int_num1, int_num2);
		
		System.out.println(max_numS);
		
	}

	private static String reverseString(String s) {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder(s);

		return sb.reverse().toString();
	}

}

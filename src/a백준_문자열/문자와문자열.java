package a백준_문자열;

import java.util.Scanner;

public class 문자와문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		int K = sc.nextInt();

		// System.out.println(str);

		// System.out.println(K);

		char alphabet = str.charAt(K - 1);

		System.out.println(alphabet);

	}
}

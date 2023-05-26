package 자료구조5장_재귀알고리즘;

import java.util.Scanner;

public class Factorial2 {
	static int factorial(int n) {
		 if (n > 0) {
		        System.out.println("factorial(" + n + ")");
		        int result = n * factorial(n - 1);
		        System.out.println("return " + n + " * factorial(" + (n - 1) + ") = " + result);
		        return result;
		    } else {
		        System.out.println("factorial(" + n + ") = 1");
		        return 1;
		    }
		}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("정수를입력하세요: ");

		int x = sc.nextInt();
		int result = factorial(x);
		System.out.println(x + "의 팩토리얼은 " + result + "입니다.");

	}

}

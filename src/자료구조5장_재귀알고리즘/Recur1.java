package 자료구조5장_재귀알고리즘;

import java.util.Scanner;

public class Recur1 {

	//재귀함수
	static void recur(int n) {
		if (n>0) {
			recur(n-1);
			System.out.println(n);
			recur(n-2);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요: " );
		int x = sc.nextInt();
		
		recur(x);
	
	}
}

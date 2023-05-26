package 자료구조5장_재귀알고리즘;

import java.util.Scanner;

public class RecurX1 {

	//재귀함수
	static void recur(int n) {
		while (n>0) {
		//if (n>0) {   ---- 제거 1번쨰 while 이용
			System.out.println("recur(" + n + "-1);"); // ---- 제거 2번쨰 stack 이용
			recur(n-1);
			System.out.println(n);
			System.out.println("recur(" + n + "-2);");
			//recur(n-2);  ---- 제거 1번쨰 while 이용
			n=n-2;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요: " );
		int x = sc.nextInt();
		
		recur(x);
	
	}
}

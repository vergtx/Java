

import java.util.Scanner;

public class Main {
	
	 public static void reverseBaskets(int[] baskets, int start, int end) {
	        while (start < end) {
	            int temp = baskets[start];
	            baskets[start] = baskets[end];
	            baskets[end] = temp;

	            start++;
	            end--;
	        }
	    }

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int N = sc.nextInt();  // 바구니의 개수
	        int M = sc.nextInt();  // 뒤집는 작업의 횟수

	        int[] baskets = new int[N];
	        for (int i = 0; i < N; i++) {
	            baskets[i] = i + 1;  // 초기 바구니 상태 설정
	        }

	        for (int i = 0; i < M; i++) {
	            int start = sc.nextInt();  // 뒤집기 시작하는 위치
	            int end = sc.nextInt();    // 뒤집기 끝나는 위치

	            reverseBaskets(baskets, start - 1, end - 1);  // 바구니 뒤집기
	        }

	        for (int i = 0; i < N; i++) {
	            System.out.print(baskets[i] + " ");  // 뒤집힌 바구니 출력
	        }
	    }

}


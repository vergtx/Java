package a백준_일차원배열;

import java.util.Scanner;

public class 바구니_뒤집기 {
	
	 public static void reverseBaskets(int[] baskets, int start, int end) {
	        while (start < end) { // 바꿀때 언제 까지 바꿀것인가
	            int temp = baskets[start]; //swap 알고리즘
	            baskets[start] = baskets[end];
	            baskets[end] = temp;

	            start++;
	            end--;
	        }
	    }
	 
		/*
		  그러니까 start 위치값이 1 이고 end 위치값이 5이면 한번 바꾸기를 할때 1과 5만 바꾸는 것이 아니라 1과 5, 2와 4 이렇게
		  두번 바꾼다는 이야기임
		 */

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int N = sc.nextInt();  // 바구니의 개수
	        int M = sc.nextInt();  // 뒤집는 작업의 횟수

	        int[] baskets = new int[N];
	        for (int i = 0; i < N; i++) {
	            baskets[i] = i + 1;  // 초기 바구니 상태 설정 
	            //baskets[0]에는 1이, i가 1일 때 baskets[1]에는 2가 대입되는 식
	            // 배열의 인덱스는 0부터 시작하며, baskets[0]은 첫 번째 바구니를 나타냅니다. 
	            //따라서 바구니 번호와 배열 인덱스 간에 1씩 차이가 나기 때문에 i + 1 연산을 통해 바구니 번호를 설정
	            
	        }

	        for (int i = 0; i < M; i++) {
	            int start = sc.nextInt();  // 뒤집기 시작하는 위치
	            int end = sc.nextInt();    // 뒤집기 끝나는 위치

	            reverseBaskets(baskets, start - 1, end - 1);  // 바구니 뒤집기
	            //배열의 인덱스와 바구니 번호 간의 차이를 보정하기 위해 사용
	            //start와 end는 바구니 번호를 나타내는 변수입
	            //배열의 인덱스는 0부터 시작하므로, 바구니 번호와 배열 인덱스 간의 차이를 보정하기 위해 -1을 적용
	        }

	        for (int i = 0; i < N; i++) {
	            System.out.print(baskets[i] + " ");  // 뒤집힌 바구니 출력
	        }
	    }

}


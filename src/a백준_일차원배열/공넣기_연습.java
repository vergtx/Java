package a백준_일차원배열;

import java.util.Scanner;

public class 공넣기_연습 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [] arr = new int[N];
		int M = sc.nextInt();
		
		for (int i = 0; i < M; i++) {
			int I = sc.nextInt();
			int Y = sc.nextInt();
			int K = sc.nextInt();
			
			for(int z = I-1; z < Y; z++) {
				arr[z] = K;
			}
			
		}
		for (int x = 0; x < N ; x++) {
			System.out.print(arr[x] + " ");
		}
    }
}
/*
 * //위 입력을 기반으로 코드가 실행되면, arr 배열은 초기에 [0, 0, 0, 0, 0]으로 시작하며, 다음과 같이 변경됩니다:
 * 첫 번째 연산: arr[0]부터 arr[2]까지의 값이 2로 변경됩니다. 결과: [2, 2, 2, 0, 0] 두 번째 연산:
 * arr[1]부터 arr[3]까지의 값이 5로 변경됩니다. 결과: [2, 5, 5, 5, 0] 세 번째 연산: arr[2]부터
 * arr[4]까지의 값이 1로 변경됩니다. 결과: [2, 5, 1, 1, 1] 따라서 위 입력에 대한 출력은 2 5 1 1 1이 됩니다.
 */
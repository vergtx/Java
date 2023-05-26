package a백준_일차원배열;

import java.util.Scanner;

public class 공넣기 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 배열의 크기 입력
        int[] arr = new int[N]; // arr 배열은 크기가 N인 정수 배열
        int M = sc.nextInt(); //연산의 개수 M

        for(int i = 0; i < M; i++) { // M번 반복하면서 연산을 수행한다.
            int I = sc.nextInt(); //구간의 시작
            int J = sc.nextInt(); //구간의 끝
            int K = sc.nextInt(); // 구간의 시작 부터 끝 까지 입력할 값

            for(int j = I - 1; j < J; j++) {
                arr[j] = K; // 인덱스를 순회하면서 arr 배열의 값을 K로 바꿈
            }
        }
        for(int k = 0; k < arr.length; k++) { //arr 배열의 모든 요소를 공백을 사이에 두고 출력합니다.
            System.out.print(arr[k] + " ");
        }
    }
}
/*
 * //위 입력을 기반으로 코드가 실행되면, arr 배열은 초기에 [0, 0, 0, 0, 0]으로 시작하며, 다음과 같이 변경됩니다:
 * 첫 번째 연산: arr[0]부터 arr[2]까지의 값이 2로 변경됩니다. 결과: [2, 2, 2, 0, 0] 두 번째 연산:
 * arr[1]부터 arr[3]까지의 값이 5로 변경됩니다. 결과: [2, 5, 5, 5, 0] 세 번째 연산: arr[2]부터
 * arr[4]까지의 값이 1로 변경됩니다. 결과: [2, 5, 1, 1, 1] 따라서 위 입력에 대한 출력은 2 5 1 1 1이 됩니다.
 */
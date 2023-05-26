import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 공의 개수
		int m = sc.nextInt(); // 작업 횟수

		int[] arr = new int[n + 1]; // 공의 위치를 저장하는 배열

		// 초기 공의 위치 설정
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		
//		// 바꾸기전 배열 출력
//		for (int i = 1; i <= n; i++) {
//			System.out.print( arr[i] + " ");
//		} System.out.println(" \n ");

		// 공 위치 바꾸기 작업 수행
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt(); // 공의 위치 a
			int b = sc.nextInt(); // 공의 위치 b

			// a와 b를 m번 바꿈
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}

		// 최종 공의 위치 출력
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
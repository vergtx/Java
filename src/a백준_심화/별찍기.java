package a백준_심화;

import java.util.Scanner;

public class 별찍기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String a = "*";
		String b = " ";

		for (int i = 1; i <= n; i++) {
			for (int z = n - i; z > 0; z--) {
				System.out.print(b);
			}
			for (int j = 0; j < 2 * i - 1; j++) { // j의 값은 0부터 시작하여 2 * i - 1보다 작을 때까지 반복문이 실행
				// 첫 번째 줄에서 (i가 1일 때) 2 * i - 1은 1이 됩니다. 따라서 두 번째 반복문에서 j는 0부터 시작하며, j가 1보다 작은
				// 동안(즉, 한 번 반복) 별을 출력합니다. /
				System.out.print(a);
			}

			System.out.println();
		}

		for (int i = n-1; i >= 1; i--) {
			for (int z = n - i; z > 0; z--) {
				System.out.print(b);
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print(a);
			}
			System.out.println();
		}
	}
}

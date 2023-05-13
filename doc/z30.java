package backjoon;

import java.util.Scanner;

public class z30 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) { // 0,1,2,3,4 ---- 4줄 반복
			for (int j = n - i - 1; j > 0; j--) { // 전체 삼각형의 높이 n에서 i+1을 뺀 값만큼 빈 칸을 출력합니다
				System.out.print(" ");
			}
			for (int k = 0; k < i + 1; k++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}

	}

}
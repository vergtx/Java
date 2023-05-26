package a백준_일차원배열;

import java.util.Scanner;

public class 바구니_뒤집기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int m = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 1; i <= n; i++) {
			arr[i] = i; 

		
		}

		for (int z = 1; z <= m; z++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			while (a < b) {
				int temp = arr[b];
				arr[b] = arr[a];
				arr[a] = temp;
				a++;
				b--;
			}
		}
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

}


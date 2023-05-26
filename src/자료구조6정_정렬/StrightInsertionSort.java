package 자료구조6정_정렬;

import java.util.Random;

class StrightInsertionSort {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void StrightInsertionSort(int[] a, int n) {
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			int j;
			int temp = a[i];
			for (j = i; j > 0 && a[j - 1] > temp; j--) { // 비교해서

				a[j] = a[j - 1];
				count++; // 빈자리 만들고
			}
			a[j] = temp; // 집어 넣고
		}
		System.out.println("비교 횟수 = " + count);
	}

	public static void main(String[] args) {
		

		Random rand = new Random();

		
		System.out.print("난수생성 완료");
		System.out.print("\n ");
		int nx = 100;
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			x[i] = rand.nextInt(100);
			// System.out.print("난수출력" + i +" ");

		}

		StrightInsertionSort(x, nx); // 배열 x를 단순교환정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
	}
}

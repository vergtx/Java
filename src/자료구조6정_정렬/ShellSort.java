package 자료구조6정_정렬;

import java.util.Random;

class ShellSort {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void ShellSort(int[] a, int n) {
		int count = 0;
		for (int h = n / 2; h > 0; h /= 2)
			for (int i = h; i < n; i++) {
				int j;
				int temp = a[i];
				for (j = i - h; j >= 0 && a[j] > temp; j -= h) {
					a[j + h] = a[j];
					count++;
				}

				a[j + h] = temp;
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

		ShellSort(x, nx); // 배열 x를 단순교환정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
	}
}

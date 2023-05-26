package 자료구조6정_정렬;

import java.util.Random;

class SelectionSort {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	static void SelectionSort(int [] a, int n) {
		int count = 0;
		for (int i = 0 ; i < n-1 ; i++) {
			int min = i ;
			for (int j = i + 1 ; j < n ; j++) {
				count ++;
				if (a[j] < a [min])
					min = j;
			}
			swap (a, i , min) ;
		}
		System.out.println("비교횟수 = " + count);
	}



	public static void main(String[] args) {
		// Scanner stdIn = new Scanner(System.in);

		Random rand = new Random();

		
		System.out.print("난수생성 완료");
		System.out.print("\n ");
		int nx = 100;
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			x[i] = rand.nextInt(100);
			// System.out.print("난수출력" + i +" ");

		}

		SelectionSort(x, nx); // 배열 x를 단순교환정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
	}
}

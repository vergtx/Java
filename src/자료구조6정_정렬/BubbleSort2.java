package 자료구조6정_정렬;

import java.util.Random;

class BubbleSort2 {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 버블 정렬 ---//
	static void bubbleSort(int[] a, int n) { // if문 몇번 도는 지 보려고 sysout넣음 :성능고려 목적
		int count = 0;
		for (int i = 0; i < n - 1; i++) { // 100번돔
			int exchange = 0;
			for (int j = n - 1; j > i; j--) { // 100부터 작아짐
				count++; 
				if (a[j - 1] > a[j]) {// 여기가 버블 비교
					swap(a, j - 1, j);
					exchange++;
				}
			}
			if (exchange == 0)	break;
			
			
		}System.out.print("비교횟수 = " + count);
	}

	public static void main(String[] args) {
		// Scanner stdIn = new Scanner(System.in);

		Random rand = new Random();

		System.out.println("버블 정렬(버전 1)");
		System.out.print("난수생성");
		System.out.print("\n ");
		int nx = 100;
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			x[i] = rand.nextInt(100);
			// System.out.print("난수출력" + i +" ");

		}

		bubbleSort(x, nx); // 배열 x를 단순교환정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
	}
}

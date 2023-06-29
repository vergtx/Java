package 자료구조6정_정렬;


import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);

	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 10;

	public Heap(int sz) { // 생성자 만들고
		MaxSize = sz;
		n = 0;
		heap = new int [MaxSize + 1];
	}

	public void display() { // 만들고
		int i;
		for (i = 1; i <= n; i++)
			System.out.print("  (" + i + ", " + heap[i] + ") ");
		System.out.println();
	}

	@Override
	public void Insert(int x) { // 만들어야함
		int i;
		if (n == MaxSize) {
			HeapFull();
			return;
		}
		n++;
		for (i = n; i >= 1;) { // 여기 부터 인서트 알리즘 새 값을 인서트 후 비교해서 자리 찾는 알고리즘
			if (i == 1)
				break;	 //	1. 1번 at root로 고정
			if (x <= heap[i / 2]) //	2. 새로운 요소 x가 부모 "heap[i / 2] 위치의 값" 보다 작은 값이기 때문에 이미 힙의 성질을 만족 더이상 비교 필요 없음.
				break; /////////////////////////////////////////////////////////////////////////////// 자바에서 generic array 사용 안됨
			// move from parent to i
			heap[i] = heap[i / 2]; //	 3. x가 부모 노드보다 큰 경우 heap[i/2]를 현재 위치 heap[i]로 이동시킵니다. 이는 x를 현재 위치로 올림
			i /= 2;		// 인댁스 위치 i를 i / 2로 갱신
		}
		heap[i] = x; //반복문을 빠져나온 후에는 새로운 인덱스 위치 heap[i]에 x를 삽입

	}

	@Override
	public int DeleteMax() {// 만들어야함
		int i, j;
		if (n == 0) {
			HeapEmpty();
			Element elm = new Element(0);
			return -1;
		}
		int x = heap[1];
		int k = heap[n];
		n--;

		for (i = 1, j = 2; j <= n;) {
			if (j < n)
				if (heap[j] < heap[j + 1])
					j++;
			// j points to the larger child
			if (k >= heap[j])
				break;
			heap[i] = heap[j];
			i = j;
			j *= 2;
		}
		heap[i] = k;
		return x;
	}

	private int[] heap;
	private int n; // current size of MaxHeap
	private int MaxSize; // Maximum allowable size of MaxHeap

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}
public class heap_정렬_test {
	
	public static void main(String[] args) {
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
	    final int count = 100;
	    int[] x = new int[count+1];
	    int []sorted = new int[count];

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1:
			     for (int i = 0; i < count; i++) {
			         x[i] = (int)(Math.random() * 130);
						heap.Insert(x[i]);
			     }
				break;
			case 2:
				heap.display();
				break;
			case 3: // 루프 돌려서 하나씩 빼내는것
				for (int i = 1; i <= count; i++)
					sorted[i-1] = heap.DeleteMax();
				for(int num: sorted)
					System.out.print(" " + num);
				System.out.println();
				break;

			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}

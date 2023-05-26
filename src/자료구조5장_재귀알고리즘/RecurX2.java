package 자료구조5장_재귀알고리즘;

import java.util.Scanner;

import 자료구조4장_스택과큐.IntStack.EmptyIntStackException;
import 자료구조4장_스택과큐.IntStack.OverflowIntStackException;


public class RecurX2 {
	
	class IntStack {
		private int[] stk; // 스택용 배열
		private int capacity; // 스택의 크기
		private int ptr; // 스택 포인터

		public class EmptyIntStackException extends RuntimeException { // 실핸ㅇ시 예외 스택이 비어 있음
			public EmptyIntStackException() {
			}
		}

		public class OverflowIntStackException extends RuntimeException {
			public OverflowIntStackException() {
			}
		}

		// 생성자 만등어야 함.
		public IntStack(int maxlen) {
			ptr = 0;
			capacity = maxlen;
			try {
				stk = new int[capacity]; // 스택 배열을 생성
			} catch (OutOfMemoryError e) { // 생성할 수 없을때
				capacity = 0;
			}
		}

		public int push(int x) throws OverflowIntStackException {
			if (ptr >= capacity)
				throw new OverflowIntStackException();
			stk[ptr++] = x ;
			return 1;
		}

		public int pop() throws EmptyIntStackException {
			if (ptr <= 0)
				throw new EmptyIntStackException();
			return stk[--ptr];

		}

		public int peek() throws OverflowIntStackException {
			if (ptr <= 0)
				throw new EmptyIntStackException();
			return stk[ptr - 1];
		}

		public void Clear() {
			ptr = 0;
		}

		public int indexOf(int x) {
			for (int i = ptr - 1; i >= 0; i--) // 꼭대기 부터 선형검색
				if (stk[i] == x)
					return i;
			return -1;

		}

		public boolean isEmpty() {
			return ptr <= 0;
		}

	//재귀함수
	static void recur(int n) {
		
		IntStack s = new IntStack(n);
		
		while (true) {
			if (n > 0) {   
				System.out.println("recur(" + n + "-1);"); // ---- 제거 2번쨰 stack 이용
				try { 
					s.push(n);
				} catch (OverflowIntStackException e ) {
					System.out.println("스택이 가득 찼습니다.");
				}
				n= n-1;
				continue;
			}
			if (s.isEmpty() !=true) {
				n=s.pop();
				System.out.println(n);
				n=n-2;
				continue;
			}
			break;
			//System.out.println(n);
			//System.out.println("recur(" + n + "-2);");
			//recur(n-2);  ---- 제거 1번쨰 while 이용
			//n=n-2;
		}
	}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요: " );
		int x = sc.nextInt();
		
		recur(x);
	
	}
}

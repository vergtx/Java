package 자료구조4장_스택과큐;

import java.util.Scanner;

//int형 고정 길이 스택

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

	// 꼭대기 부터 출력
	public void dump() {
		if (isEmpty()) {
			System.out.println("Stack이 비었습니다.");
		} else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}

}

public class 스택정수_test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(4); // 최대 64 개를 푸시할 수 있는 스택

		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			// System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");

			int menu = sc.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {

			case 1: // 푸시
				System.out.print("데이터: ");
				x = sc.nextInt();
				try {
					s.push(x);
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;

			case 2: // 팝
				try {
					x = s.pop();
					System.out.println("팝한 데이터는 " + x + "입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 3: // 피크
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}
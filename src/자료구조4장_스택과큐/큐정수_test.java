package 자료구조4장_스택과큐;

import java.util.Scanner;

//int형 고정 길이 큐

class Queue {
	private int[] que; //
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; // 현재 데이터 개수 // 배열이 비어 있는지 가득 찾는비 구분하기 위하여 이변수 필요
	
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {
		}
	}

	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
		}
	}

	public Queue(int maxlen) { // maxlen 일반적으로 최대크기 최대길이를 나타낼때 사용됨.
		num = front = rear = 0;
		capacity = maxlen;
		try {
			que = new int[capacity];
		} catch (OutOfMemoryError e) {
			capacity = 0;        
		}  // capacity를 큐의 최대 크기로 해석하고, 배열 생성에 실패한 경우 큐의 동작을 막음
	}
	
	public int enque(int x) throws OverflowIntQueueException {
		if (num >= capacity)
			throw new OverflowIntQueueException();
		que[rear++] = x;
		num++;
		if (rear == capacity)
			rear = 0;
		return x;
	}
	
	public int deque() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		int x = que[front++];
		num--;
		if (front == capacity)
			front = 0;
		return x;
	}
	// 큐에서 데이터 피크는 front 임
	public int peek() throws EmptyIntQueueException {
		if (num <= 0) 
			throw new EmptyIntQueueException();
		return que[front];
	}
	
	public void clear() { // 초기화
		num = front = rear = 0 ;
	}
	
	public int indexOf(int x) { //indexOf는 검색값의 배열 위치 찾음
		for (int i = 0 ; i < num ; i++) {
			int idx = (i + front) % capacity ; // 이 계산은 주로 원형 큐와 같이 순환 구조를 가진 자료구조에서 사용
			if (que[idx] == x)
				return idx;
		} return -1;
	}
	/*
	  i는 반복문에서 현재 순회하고 있는 인덱스를 나타내며,
	  front는 큐의 시작 위치를 나타냅니다. (i + front)는 현재 인덱스가
	  시작 위치를 기준으로 얼마나 떨어져 있는지를 나타내는 값
	  % capacity 연산을 수행하여 배열의 크기로 나눈 나머지를 계산하는 것 배열의 순환을 구현하는 핵심.
	  배열의 순환을 처리하면서 요소에 접근할 수 있습니다. 이 연산은 배열의 크기를 초과하지 않으면서 순환 구조를 구현하는 효과를 갖습니다.
	 */
	
	public void dump() { // 리어순으로 출력하는 메소드
		if (num < 0 )
			System.out.println("큐가 비어 있습니다.");
		else {
			for (int i =0 ; i < num ; i++) {
				System.out.println(que[(i+front) % capacity] + " "); // 쿠 배열을 출력
			System.out.println();
			}
		}
	}
}

//int형 고정 길이 큐의 사용 예
public class 큐정수_test {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Queue s = new Queue(4); // 최대 64개를 인큐할 수 있는 큐

		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			//System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1: // 인큐
				System.out.print("데이터: ");
				x = stdIn.nextInt();
				try {
					s.enque(x);
				} catch (Queue.OverflowIntQueueException e) {
					System.out.println("큐가 가득 찼습니다.");
				}
				break;

			case 2: // 디큐
				try {
					x = s.deque();
					System.out.println("디큐한 데이터는 " + x + "입니다.");
				} catch (Queue.EmptyIntQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");
				} catch (Queue.EmptyIntQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}
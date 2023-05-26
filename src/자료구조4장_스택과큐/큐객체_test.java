package 자료구조4장_스택과큐;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import 자료구조4장_스택과큐.Queue.EmptyIntQueueException;
import 자료구조4장_스택과큐.Queue.OverflowIntQueueException;

//int형 고정 길이 큐
class objectQueue {
    private List<Point> que; // ArrayList로 변경
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; // 현재 데이터 개수
	
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException () {}
	}
	
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
		}
	}
	
	public objectQueue(int maxlen) { // maxlen 일반적으로 최대크기 최대길이를 나타낼때 사용됨.
		num = front = rear = 0;
		capacity = maxlen;
		try {
			que = new ArrayList<Point> (); //큐 배열을 생성 Arraylist<Integer>()
		} catch (OutOfMemoryError e) {
			capacity = 0;        
		}  // capacity를 큐의 최대 크기로 해석하고, 배열 생성에 실패한 경우 큐의 동작을 막음
	}
	
	public Point enque(Point x) throws OverflowIntQueueException {
		if (num >= capacity)
			throw new OverflowIntQueueException();
		num++;
		que.add(x);
		rear++;
		if (rear == capacity)
			rear = 0;
		return x;
	}
	
	
	public Point deque() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		num--;
		Point x = que.remove(front);
		front++; // 빼고나서 front 위치 이동 하기 때문에 remove 이후에 입력
		if (front == capacity)
			front = 0;
		return x;
	}
	
	public Point peek() throws EmptyIntQueueException {
		if (num <= 0) 
			throw new EmptyIntQueueException();
		return que.get(front);
	}
	
	public void clear() { // 초기화
		num = front = rear = 0 ;
	}
	
	public int indexOf(Integer x) { //indexOf는 검색값의 배열 위치 찾음
		for (int i = 0 ; i < num ; i++) {
			int idx = (i + front) % capacity ; // 이 계산은 주로 원형 큐와 같이 순환 구조를 가진 자료구조에서 사용
			if (que.get(i).equals(x))
				return idx;
		} return -1;
	}

	public void dump() { // 리어순으로 출력하는 메소드
		if (num < 0)
			System.out.println("큐가 비어 있습니다.");
		else {
			for (int i = 0; i < num; i++) {
				System.out.println(que.get((i + front) % capacity) + " "); // 쿠 배열을 출력
			}
			System.out.println();

		}
	}

}


//int형 고정 길이 큐의 사용 예
public class 큐객체_test {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		objectQueue s = new objectQueue(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point p = null;
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
				rndx = random.nextInt() % 20;
				rndy = random.nextInt() % 20;
				p = new Point(rndx,rndy);
				try {
					s.enque(p); // add
					System.out.println("인큐한 데이터: " + p);
				} catch(objectQueue.OverflowIntQueueException e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = s.deque(); //remove
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (objectQueue.EmptyIntQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = s.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (objectQueue.EmptyIntQueueException e) {
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
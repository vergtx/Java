package 자료구조4장_스택과큐;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import 자료구조4장_스택과큐.objectStack.EmptyIntStackException;
import 자료구조4장_스택과큐.objectStack.OverflowIntStackException;

class objectStack {
	private List<Point> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // ptr 을 여기서는 top으로 정의 /
						// 스택 포인터 스택의 맨 꼭대기 정수 생성자 들고 오면 려기 필드 이름에 맞게 바꾸어야 한다.//
						// objectstack에 Arraylist<point>() 로 바꿔줘야함

	public class EmptyIntStackException extends RuntimeException { // 실핸ㅇ시 예외 스택이 비어 있음
		public EmptyIntStackException() {
		}
	}

	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	// 생성자 만등어야 함.
	public objectStack(int maxlen) {
		top = 0;
		capacity = maxlen;
		try {
			data = new ArrayList<Point>(); // 스택 배열을 생성 Arraylist<point>()
		} catch (OutOfMemoryError e) { // 생성할 수 없을때
			capacity = 0;
		}
	}

	public int push(Point x) throws OverflowIntStackException {
		if (top >= capacity)
			throw new OverflowIntStackException();
		top++;
		data.add(x);
		return 1;

	}

	public Point pop() throws EmptyIntStackException {
		if (top <= 0)
			throw new EmptyIntStackException();

		Point P = data.remove(top - 1);
		top--;
		return P;

	}

	public Point peek() throws OverflowIntStackException {
		if (top <= 0)
			throw new EmptyIntStackException();

		return data.get(top - 1);

	}

	public void Clear() {
		top = 0;
	}

	public int indexOf(Point x) {
		for (int i = top - 1; i >= 0; i--) // 꼭대기 부터 선형검색
			if (data.get(i).equals(x))
				return i;
		return -1;

	}

	public boolean isEmpty() {
		return top <= 0;
	}

	// 꼭대기 부터 출력
	public void dump() {
		if (isEmpty()) {
			System.out.println("Stack이 비었습니다.");
		} else {
			for (int i = 0; i < top; i++)
				System.out.print(data.get(i) + " ");
			System.out.println();
		}
	}

}

class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";

	}

	@Override
	public boolean equals(Object p) { // Object 가져오는 값 point p 와 Object point p 는 달라서 override 하려면 파라메타 Object point p
										// 로 받아야 한다
		Point px = (Point) p;
		// if (this.x == px.x && this.y == px.y)
		if (this.x == ((Point) p).x && this.y == ((Point) p).y)
			return true;
		else
			return false;
	}

}

public class 스택객체_test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		objectStack s = new objectStack(8); // 최대 8 개를 push할 수 있는 stack
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point p;
		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			// System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)push　(2)pop　(3)peek　(4)dump　(0)종료: ");

			int menu = sc.nextInt();
			if (menu == 0)
				break;

			switch (menu) {
			case 1: // 푸시
				System.out.print("난수 좌표가 입력되었습니다.");
				rndx = random.nextInt() % 20;
				rndy = random.nextInt() % 20;
				p = new Point(rndx, rndy);
				try {
					s.push(p);
				} catch (OverflowIntStackException e) {
					System.out.println("stack이 가득찼있습니다.");
				}
				break;

			case 2: // 팝
				try {
					p = s.pop();
					System.out.println("pop한 데이터는 " + p + "입니다.");
				} catch (EmptyIntStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = s.peek();
					System.out.println("peek한 데이터는 " + p + "입니다.");
				} catch (EmptyIntStackException e) {
					System.out.println("stack이 비어있습니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}
package 자료구조6정_정렬;
// 퀵 정렬(비재귀 버전)

import java.util.ArrayList;
import java.util.List;
import java.util.Random;




class Stack {
	private List<Point> data; // 스택용 배열
	private int capacity; // 스택의 크기
	private int top; // ptr 을 여기서는 top으로 정의 /
						// 스택 포인터 스택의 맨 꼭대기 정수 생성자 들고 오면 려기 필드 이름에 맞게 바꾸어야 한다.//
						// Stack에 Arraylist<point>() 로 바꿔줘야함

	public class EmptyIntStackException extends RuntimeException { // 실핸ㅇ시 예외 스택이 비어 있음
		public EmptyIntStackException() {
		}
	}

	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	// 생성자 만등어야 함.
	public Stack(int maxlen) {
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
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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


class QuickSort2 {
    //--- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
    }

    //--- 퀵 정렬(비재귀 버전)---//
    static void QuickSort2(int[] a, int left, int right) {
	
    	Stack st = new Stack(right - left +1);
    	Point p = new Point (left, right);
		    	try {
					st.push(p);
				} catch (자료구조6정_정렬.Stack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
        while (st.isEmpty() != true) {

	
			try {
				p = st.pop();
				System.out.println("팝한 데이터는 " + p + "입니다.");
			} catch (자료구조6정_정렬.Stack.EmptyIntStackException e) {
				System.out.println("스택이 비어있습니다.");
			}
        
        	int pl = left = p.getX();
            int pr = right  = p.getY();        // 왼쪽 커서
            								// 오른쪽 커서
            int x = a[(left + right) / 2];        // 피벗은 가운데 요소

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            if (left < pr) {
            	p = new Point (left, pr);
            	st.push(p);
			            }
            if (pl < right) {
            	p = new Point (pl, right);
            	st.push(p);
				           }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("퀵 정렬");
        System.out.print("요솟수: ");
        int nx = 100;
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			x[i] = rand.nextInt(100);
			
		}
        QuickSort2(x, 0, nx - 1);            // 배열 x를 퀵정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]=" + x[i]);
    }
}

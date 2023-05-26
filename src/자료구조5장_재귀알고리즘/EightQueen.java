
package 자료구조5장_재귀알고리즘;
//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp

//N Queen problem / backtracking

//각 열에 1개의 퀸을 배치하는 조합을 재귀를 사용하여 나열한다.

import java.util.ArrayList;
import java.util.List;

class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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

class Stack3 {
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
	public Stack3(int maxlen) {
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

//----------------------------------------------------------------------------

public class EightQueen {
	static final int numberQeens = 8;

	public static void SolveQueen(int[][] d) {
		int count = 0;
		int ix = 0, iy = 0;

		Stack3 st = new Stack3(10); // 객체 stack 스택3이라고 한것은 앞의 스택과 충돌일어나서 3붙임 // 퀸을 저장하는 역할
		Point p = new Point(ix, iy);

		d[ix][iy] = 1; // 체스판의 "int ix = 0, iy = 0; (0, 0)" 위치에 퀸을 배치 //d[ix][iy] 값을 1로설정
		count++; // 체스판 퀸 숫자 ++

		st.push(p); // 퀸자표 p >> (0,0)=1 를 st스택에 push 하여 저장

		while (count < numberQeens) {
			ix++; // 퀸의 숫자가 numberQeens보다 작깨 까지 한줄씩 내려감
			int cy = 0; // 매 줄 첫째 인덱스 부터 검사 하도록 (x,0) y값 초기화

			while (ix < numberQeens) {
				cy = NextMove(d, ix, cy);

				if (cy != -1) {

					Point px = new Point(ix, cy);

					st.push(px);
					st.dump(); // 스택이 다 차면 dump됨
					d[ix][cy] = 1; // 수정된 부분: 해당 위치에 퀸 배치
					count++;
					break;
				}
				
				else { 	//cy가 -1인 경우, 즉 배치 가능한 위치를 찾지 못한 경우 다음 작업을 수행
					p = st.pop(); //  가장 최근에 저장된 퀸의 위치를 pop
					ix = p.getX(); //ix와 cy 값을 이전에 저장된 px 객체의 좌표로 업데이트. 다음 열로 이동하기 위한 작업
					cy = p.getY(); // 다음 열로 이동
					d[ix][cy] = 0; // 이전에 퀸을 배치한 위치를 초기화합니다.
					count--; // 팝하고 나서 -1 해줌
					cy++; //cy 값을 1 증가시켜 다음 열로 이동합니다.
				}
			}

		}//st에는 가능한 퀸의 배치 상태가 저장 // d에는 퀸의 배치 여부

	}

	public static boolean checkRow(int[][] d, int crow) { 
		// 배열명 d 에서 crow 에 queen 놓을 수 있느냐 ?
		for (int j = 0; j < numberQeens; j++) {
			if (d[crow][j] == 1) //crow는 주어진 배열 d의 특정 행을 의미
				return false; //crow는 특정 행을 나타냄, checkRow 메서드를 호출할 때마다 다른 행의 검사를 수행
		}
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) {
		for (int i = 0; i < numberQeens; i++) {
			if (d[i][ccol] == 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkDiagSW(int[][] d, int x, int y) { // x++, y-- or x--, y++ where 0<= x,y <= 7
		int cx = x, cy = y;
		// 남서쪽 대각선 방향으로 검사
		while (cx >= 0 && cx < numberQeens && cy >= 0 && cy < numberQeens) { // 배열 d에 d[cx][cy]의 남서쪽 대각선에 배치 가능하냐 ? 1이면
																				// false 1이 없으면 true
			if (d[cx][cy] == 1) {
				return false;
			}

			cx++;
			cy--;

		}
		cx = x;
		cy = y;
		// 북동쪽 대각선 방향으로 검사
		while (cx >= 0 && cx < numberQeens && cy >= 0 && cy < numberQeens) {
			if (d[cx][cy] == 1) {
				return false;
			}
			cx--;
			cy++;
		}

		return true;
	}

	public static boolean checkDiagSE(int[][] d, int x, int y) {// x++, y++ or x--, y--

		int cx = x, cy = y;
		// 남서쪽 대각선 방향으로 검사
		while (cx >= 0 && cx < numberQeens && cy >= 0 && cy < numberQeens) {
			if (d[cx][cy] == 1) {
				return false;
			}
			cx++;
			cy++;
		}
		cx = x;
		cy = y;
		// 북동쪽 대각선 방향으로 검사
		while (cx >= 0 && cx < numberQeens && cy >= 0 && cy < numberQeens) {
			if (d[cx][cy] == 1) {
				return false;
			}
			cx--;
			cy--;
		}
		return true;
	}

	public static boolean CheckMove(int[][] d, int x, int y) {
		if (checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y)) {
			return true;
		}
		return false;
	}

	public static int NextMove(int[][] d, int row, int col) {
		for (int i = col + 1; i < numberQeens; i++) {
			if (CheckMove(d, row, i)) {
				System.out.println("row " + row + " col " + i);
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int row = numberQeens, col = numberQeens; // 체스판
		int[][] data = new int[numberQeens][numberQeens];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				data[i][j] = 0;

		SolveQueen(data);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(" " + data[i][j]);
			}
			System.out.println();
		}
	}
}

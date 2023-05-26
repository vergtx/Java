
package 자료구조5장_GPT;
//https://www.geeksforgeeks.org/n-queen-problem-backtracking-3/?ref=lbp

//N Queen problem / backtracking

//각 열에 1개의 퀸을 배치하는 조합을 재귀를 사용하여 나열한다.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import 자료구조5장_GPT.Stack3.EmptyIntStackException;
import 자료구조5장_GPT.Stack3.OverflowIntStackException;

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
//----------------------------------------------------------------------------

public class EightQueen {
	static final int numberQeens = 8;
	
	public static void SolveQueen(int[][] d, int row) {
	    if (row == numberQeens) {
	        // 모든 퀸을 배치한 경우, 결과를 출력하거나 다른 처리를 수행할 수 있습니다.
	        printBoard(d);
	        return;
	    }

	    for (int col = 0; col < numberQeens; col++) {
	        if (CheckMove(d, row, col)) {
	            d[row][col] = 1; // (row, col) 위치에 퀸 배치
	            SolveQueen(d, row + 1); // 다음 행으로 이동하여 퀸 배치를 진행
	            d[row][col] = 0; // 백트래킹을 위해 퀸 제거
	        }
	    }
	}

	public static void printBoard(int[][] board) {
		for (int i = 0; i < numberQeens; i++) {
			for (int j = 0; j < numberQeens; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static boolean checkRow(int[][] d, int crow) {
		// 배열명 d 에서 crow 에 queen 놓을 수 있느냐 ?
		for (int j = 0; j < numberQeens; j++) {
			if (d[crow][j] == 1)
				return false;
		}
		return true;
	}

	public static boolean checkCol(int[][] d, int ccol) {
		// 배열명 d 에서 ccol 열에 배치할 수 있느냐? 있다면 true로 리턴
		for (int i = 0; i < numberQeens; i++)
			if (d[i][ccol] == 1)
				return false;
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

	public static boolean CheckMove(int[][] d, int x, int y) {// (x,y)로 이동 가능한지를 check

		if (checkRow(d, x) && checkCol(d, y) && checkDiagSW(d, x, y) && checkDiagSE(d, x, y)) {
			return true;
		}
		return false;
	}

	public static int NextMove(int[][] d, int row, int col) {
		for (int i = col; i < numberQeens; i++) {
			if (CheckMove(d, row, i))
			{
				System.out.println("row   "+row + "col   " + i);
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
        int[][] board = new int[numberQeens][numberQeens];
        for (int i = 0; i < numberQeens; i++) {
            for (int j = 0; j < numberQeens; j++) {
                board[i][j] = 0;
            }
        }

        SolveQueen(board, 0);
    }
}

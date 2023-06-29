package a백준_심화;

import java.util.Scanner;

public class 채스 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] chessPieces = { 1, 1, 2, 2, 2, 8 }; // 주어진 체스말의 개수
		int[] actualPieces = new int[6]; // 실제 체스판에서의 체스말 개수

		for (int i = 0; i < actualPieces.length; i++) {
			int pieceInputed = sc.nextInt();

			actualPieces[i] = chessPieces[i] - pieceInputed;
				//pieceInputed 값은 사용자로부터 입력받은 값 중 하나를 각 인덱스에 대해 차례대로 처리하여 actualPieces에 반영
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(actualPieces[i] + " ");
		}
	}

}

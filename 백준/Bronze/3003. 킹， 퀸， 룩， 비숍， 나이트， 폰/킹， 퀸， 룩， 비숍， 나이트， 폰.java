

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] chessPieces = { 1, 1, 2, 2, 2, 8 }; // 주어진 체스말의 개수
		int[] actualPieces = new int[6]; // 실제 체스판에서의 체스말 개수

		for (int i = 0; i < actualPieces.length; i++) {
			int pieceInputed = sc.nextInt();

			actualPieces[i] = chessPieces[i] - pieceInputed;

		}
		for (int i = 0; i < 6; i++) {
			System.out.print(actualPieces[i] + " ");
		}
	}

}

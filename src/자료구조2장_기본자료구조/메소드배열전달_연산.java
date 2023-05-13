package 자료구조2장_기본자료구조;

import java.util.Random;

public class 메소드배열전달_연산 {
	
	static void getData(int[][] items) {
		Random r = new Random();
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items[0].length; j++) {
				items[i][j] = r.nextInt(56); // 난수 생성하며 배열에 반영
			}

		}
	}
	
	static void showData(int[][] items) {
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j < items[0].length; j++) {
				System.out.print(items[i][j]+ "\t"); // println을 print  로변경
			}
				System.out.println();
		}
	}

	static int[][] add(int[][]A ,int[][]A1) {
		int [][] A2 = new int[2][3];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A1[0].length; j++) { //A1의 모든 행의 열의 개수가 같다면 A1[0].length와 A1[1].length 모두 동일한 값을 가지기 때문에 [0] 대신에 [i]를 사용할 수 있습니다.
				A2[i][j] = A[i][j] + A1[i][j];
			}
				
		}
		return A2;
	}
    
	static int[][] multipl(int[][] A, int[][] B) {
		int[][] C = new int[2][4];
		for (int i = 0; i < A.length; i++) { // A의 각 행
			for (int j = 0; j < B[0].length; j++) { // B의 각 열
				for (int k = 0; k < B.length; k++) { // A의 각 열 // B의 각 행
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return C;
	}
   
	static swich(int[][] C) {
		int[][] D = new int[2][4];
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[0].length; j++) {
				D[i][j] = C[j][i];
			}
			
		}
	}
   
    
    
    public static void main(String[] args) {
        int[][] A = new int[2][3];
        int[][] A1 = new int[2][3];
        int[][] A2 = new int[2][3]; // 합
        int[][] B = new int[3][4]; 
        int[][] C = new int[2][4];
        int[][] D = new int[2][4];
        
        System.out.println("-----------A" + "-----------");
        getData(A);
        showData(A);
        
        System.out.println("-----------A1" + "-----------");
        getData(A1);
        showData(A1);
        
        System.out.println("------------A2"+ " 합"+ "-----------");
        A2 = add(A,A1); 
        showData(A2);
        
        System.out.println("-----------B" + "-----------");
        getData(B);
        showData(B);
        
        System.out.println("------------C"+ " 곱"+ "-----------");
        C = multipl(A,B);
        showData(C);
        
        System.out.println("------------ D -----------");
        D = swich C;
        showData(D);
        
  
    }
}
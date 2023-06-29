package a백준_심화;

import java.util.Scanner;


// 내일 학습 필요
public class 별찍기_재귀함수ver {
	
	public static void printStars(int n, int count) { // count 변수가 n과 같아졌을 때 (재귀 종료 조건), 함수를 종료
	        
		 	if (count == n) {
	            return; // 재귀 호출을 중단하고 이전 호출로 되돌아가는 것
	        }

	        for (int i = 0; i < n - count - 1; i++) {    
	            System.out.print(" ");
	        }

	        for (int i = 0; i < 2 * count + 1; i++) {
	            System.out.print("*");
	        }

	        System.out.println();

	        printStars(n, count + 1); //printStars() 함수를 재귀적으로 호출하면서 count 값을 1 증가// 이를 통해 다음줄 출력

	        for (int i = 0; i < n - count - 1; i++) {
	            System.out.print(" ");
	        }

	        for (int i = 0; i < 2 * count + 1; i++) {
	            System.out.print("*");
	        }

	        System.out.println();
	    }
	
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        printStars(n, 0);
    }

   
}

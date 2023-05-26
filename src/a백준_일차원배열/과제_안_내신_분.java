package a백준_일차원배열;

import java.util.Scanner;

public class 과제_안_내신_분 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean [] attend = new boolean[31]; // 크기가 31인 배열 선언
		
		//attend 배열은 attend[i]= false를 통하여 초기에는 모든 요소가 false로 초기화됩다  이후 후  attend[AttendedStudent] 반복문을 통해 일부 요소가 true로 업데이트됩니다.
		
		// 모든 요소를 false로 초기화
        for (int i = 1; i <= 30; i++) {
            attend[i] = false;
        }
		
		
		 // 출석한 학생들의 번호를 입력 받아 해당하는 배열 요소를 true로 변경
		for (int i = 1; i < 29; i++) {
			int AttendedStudent = sc.nextInt();
			attend[AttendedStudent] = true;
			
			
		}
		
		for (int i = 1; i <= 30 ; i++) {
			if(!attend[i]) {
				System.out.println(i);
			}
			
		}
		
	}

}

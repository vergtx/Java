import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean [] attend = new boolean[31]; // 크기가 31인 배열 선언
		

		
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

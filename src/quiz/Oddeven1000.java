package quiz;

public class Oddeven1000 {
	
	private int total;
	private int oddsum;
	private int evensum;

	// 필드선언 :  총합, 홀수합, 짝수합 만들기

	public Oddeven1000(int num) {
		for (int i = 1 ; i <= num ; i++) {
			if (i%2 == 0) evensum += i;
			else oddsum += i;			
		}
		total = evensum + oddsum;
		
	}
	
	

	}

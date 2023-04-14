package quiz;

public class Oddeven1000 {
	
	//위 클래스 선언
	
	private int total;
	private int oddsum;
	private int evensum;

	//위 필드선언 : 총합, 홀수합, 짝수합 만들기

	public Oddeven1000(int num) {
	// 위 메서드 선언 후 (괄호안에는 매개변수타입 매개변수이름)
	//아래 메서드 실행문 설정
		
		for (int i = 1 ; i <= num ; i++) {
			if (i%2 == 0) evensum += i;
			else oddsum += i;			
		}
		// for 문 사용 >> for(제어변수선언 및 초기화 ;조건식; 증감식) { if 실행문 2로 나누었을때 나머지 0인것 evensum 이라하고 더 함 그렇지 않은값은 oddsum 이라칭하고 더함}
		// if 문 사용 >>  if(조건식) {실행문;} else {실핸문;}
		total = evensum + oddsum;
	}
	public int getTotal() {return total;}
	public int getOddsum() {return oddsum;}
	public int getEvensum() {return evensum;}
	
	
	public class Calsum {
		// 클래스 선언
		public static void main(String[] args) {
			
			int arg = Integer.parseInt(args[0]);
			
			Oddeven1000 cs = new Oddeven1000(arg);
			
			System.out.println("총계 : " + cs.getTotal());
			System.out.println("짝계 : " + cs.getTotal());
			System.out.println("홀계 : " + cs.getTotal());
		}
			
		}

	}
	


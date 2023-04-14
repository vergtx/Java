package quiz;

class CalcSumSub {

	private int total;
	private int oddsum;
	private int evnsum;
	
	public CalcSumSub(int num) {
		for (int i = 1 ; i <= num ; i++) {
			if (i%2 == 0)	evnsum += i;
			else			oddsum += i;
		}
		total = evnsum + oddsum;
	}
	public int getTotal()  { return total;	}
	public int getOddsum() { return oddsum; }
	public int getEvnsum() { return evnsum; }
}

public class CalcSum {

	public static void main(String[] args) {

		int arg = Integer.parseInt(args[0]);
		
		CalcSumSub cs = new CalcSumSub(arg);

		System.out.println("총계 : " + cs.getTotal());
		System.out.println("짝계 : " + cs.getEvnsum());
		System.out.println("홀계 : " + cs.getOddsum());
	}

}
// 우클릭 run as run confignation arggument 숫자입력 run

// 교수님 코드
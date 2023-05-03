package backjoon;

import java.util.Scanner;

public class z25 {
	
	public static void main(String[] args) {
	
		try (Scanner sc = new Scanner(System.in)) {
			int total = sc.nextInt(); // 아이템 금액
			int count = sc.nextInt(); // 아이템 수

			for (int i = 0 ; i < count ; i++) {
				int price = sc.nextInt();
				int qty = sc.nextInt();
			   
				total = total - (price*qty);
			}

			if(total == 0) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
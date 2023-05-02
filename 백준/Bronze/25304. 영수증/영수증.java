import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int total = sc.nextInt();
			int count = sc.nextInt();
			int buy = 0;

			for (int i = 0; i < count; i++) {
				int price = sc.nextInt();
				int qty = sc.nextInt();
				buy += price * qty;;

			}
			if (total == buy) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			
		}

	}
}

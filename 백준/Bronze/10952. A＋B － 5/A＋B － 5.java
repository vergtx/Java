import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 반복이 몇회 해야하는지 모르면 while을 사용한다.
		while (true) {

			int a = sc.nextInt();
			int b = sc.nextInt();

			if (a == 0 & b == 0)
				break;

			System.out.println(a + b);

		}
	}

}
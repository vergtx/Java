import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		int K = sc.nextInt();

		// System.out.println(str);

		// System.out.println(K);

		char alphabet = str.charAt(K - 1);

		System.out.println(alphabet);

	}
}

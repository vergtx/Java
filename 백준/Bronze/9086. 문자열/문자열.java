
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String[] arr = new String[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.next();

		}

		for (int i = 0; i < n; i++) {
			char first = arr[i].charAt(0);
			char last = arr[i].charAt(arr[i].length()-1);

			System.out.println(first + "" +  last);
	
		}
	}

}

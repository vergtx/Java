
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		double[] arr = new double[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextDouble();
		}

//        for (int i = 0; i < n; i++) {
//            System.out.println(arr[i]);
//        }

		Arrays.sort(arr);
		double m = arr[n - 1];

		// System.out.println(m);
		double sum = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = (arr[i] / m) * 100;
			sum += arr[i];
		}

		double average = sum / n;
		System.out.println(average);

	}
}

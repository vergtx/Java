import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int count = 0;

		int v = sc.nextInt();

		for (int j = 0; j < n; j++) {
			if (arr[j] == v)
				count++; //반복문을 사용하여 배열 arr을 처음부터 끝까지 검사하면서, 현재 원소가 v와 같은지 비교합니다. 만약 같다면, count 변수를 1 증가시켜줍니다.

		}
		System.out.println(count);

	}

}

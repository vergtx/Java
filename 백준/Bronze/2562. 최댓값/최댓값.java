import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int max = arr[0];
		int index = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();

		}

		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i]; // 배열 첫번째 부터 돌아가면서 큰값 가져옴
				index = i+1;
			}
		}
       
      
        System.out.println(max);
        System.out.println(index);
        
    }
}

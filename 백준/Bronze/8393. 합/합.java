import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			int A = sc.nextInt();
			int total = 0;
			
			for (int i=1; i <= A ; i++ ) {
				total += i;
			} 
			 System.out.println(total);
		}
	}
	

}



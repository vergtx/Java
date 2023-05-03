import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			int a = sc.nextInt();
			
			int repeat = a/4;
			
			String b = "";
			
			
			for (int i = 0 ; i < repeat ; i++) {
				b += "long ";
				
			}
			System.out.println(b +"int");
		}
	}
	
}

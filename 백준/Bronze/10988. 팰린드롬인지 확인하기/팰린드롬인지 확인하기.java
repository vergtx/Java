import java.util.Scanner;

public class Main {
	
	private static String reverseString(String s) {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder(s);

		return sb.reverse().toString();
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		String reversed_str = reverseString(str);
		
		if (str.equals(reversed_str)) {
			System.out.println(1);
		} else System.out.println(0);
	
	}

}


import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
		 
		 Scanner sc = new Scanner(System.in);
		 
		 int a = sc.nextInt();
		 int b = sc.nextInt();
		 int c = 0;
		 
		 if (a>=0 && b>=0) {
			 c = 1 ;
			 }  else if (a<=0 && b>=0) {
				c = 2 ; 
			 }	else if (a<=0 && b<=0) {
				 c = 3;
			 }	else if (a>=0 && b<=0) {
				 c = 4;
			 }
	System.out.println(c);	 
	}
	 
	
}

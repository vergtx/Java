import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		int n = Integer.parseInt(br.readLine());
		
		br.close();
		
		for (int i =0 ; i<n ; i++) {
			for(int j = n-i-1 ; j > 0 ; j--) {
				System.out.print(" ");
			}
			for(int z= 0 ; z < i+1 ; z++) {
				System.out.print("*");
			} System.out.print("\n");
		} 
		
		bw.flush();
		bw.close();
	}
	
}
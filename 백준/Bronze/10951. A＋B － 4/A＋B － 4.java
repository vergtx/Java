
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		
		
		while (s != null) {
			
			StringTokenizer st = new StringTokenizer(s, " ");
			
			int a = Integer.parseInt(st.nextToken()); //nextToken() 은 " "기준으로 분리한 문자열 땡겨옴 
			int b = Integer.parseInt(st.nextToken());
			
			bw.write(a+b + "\n");
			s = br.readLine();
		}
		br.close();
		bw.flush();
		bw.close();
		
	}
	
	
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{ 
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int n = Integer.parseInt(br.readLine());
			for (int i = 1; i <= n; i++) {
				String s = br.readLine();
				int a = Integer.parseInt(s.split(" ")[0]);
				int b = Integer.parseInt(s.split(" ")[1]);
				bw.write("Case #" + i + ": " + (a + b) + "\n"); // modified this line to add "Case #" and fix the output format

			}
			bw.flush();
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

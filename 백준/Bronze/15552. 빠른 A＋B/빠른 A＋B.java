import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException{
		

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 사용자 문자열 읽어오는 함수
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int n = Integer.parseInt(br.readLine()); // 문자열을 정수형으로 변환
			for (int i = 0; i < n; i++) {		 // 이어서 for문을 사용해 n번 반복하며, br.readLine()을 사용해 문자열을 읽어들입니다.
												// 이 부분은 n개의 문자열을 입력받는 코드입니다.
				String s = br.readLine(); 		// 사용자로 부터 입력받은 문자열을 읽어들이는 함수
				int a = Integer.parseInt(s.split(" ")[0]);
				int b = Integer.parseInt(s.split(" ")[1]);
				bw.write(a + b + "\n"); 		//문자열로 만들어서 BufferedWriter에 쓰는 코드
			}
			bw.flush(); //임시 메모리에 저장되어 있는 데이터가 모두 출력
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

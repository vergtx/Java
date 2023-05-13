package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class z27 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedReader는 InputStreamReader를 통해 변환된 문자 스트림을 읽어들여 사용자 입력을 받을 수 있게 해줍니다.
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); //BufferedWriter는 데이터를 버퍼에 쌓아놓았다가 한꺼번에 출력할 수 있는 클래스입니다. OutputStreamWriter는 출력스트림을 문자 출력 스트림으로 변환해주는 클래스입니다. System.out은 콘솔에 출력할 수 있는 출력 스트림입니다
		
		int n = Integer.parseInt(br.readLine()); //이 코드는 사용자로부터 입력받은 문자열을 정수형으로 변환하는 코드입니다. br.readLine()은 BufferedReader 객체 br을 통해 사용자로부터 입력받은 문자열을 읽어오는 역할을 합니다. Integer.parseInt()는 읽어온 문자열을 정수형으로 변환하는 역할을 합니다. 따라서 int n에는 사용자가 입력한 문자열을 정수형으로 변환한 값이 저장됩니다.
		
		for(int i = 1 ; i<=n ; i++) {
			String s = br.readLine(); //BufferedReader에서 한 줄을 읽어와서 String 형태로 저장하는 역할을 합니다
			                          // 즉, 사용자로부터 입력받은 문자열을 s에 저장합니다
			int a = Integer.parseInt(s.split(" ")[0]);//이 코드는 입력받은 문자열 s를 공백(" ")을 기준으로 나누어 배열에 저장한 후, 그 배열의 첫 번째 원소와 두 번째 원소를 정수형으로 변환하여 변수 a와 b에 각각 저장합니다.
			int b = Integer.parseInt(s.split(" ")[1]); //Integer.parseInt()는 문자열을 정수형으로 변환하는 메소드입니다. 
			
			bw.write("Case #" + i + ": " + a + " + " + b +" = " + (a+b) + "\n");
			
		}
		bw.flush();
		bw.close();
		br.close();
		
		
	}
		
}
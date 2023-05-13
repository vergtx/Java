package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class z36 {
	
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

//StringTokenizer의 생성자로 입력 문자열 input을 전달하는 부분은 다음과 같은 코드입니다.
//StringTokenizer은 생성자로 전달된 문자열을 delimiter(구분자)로 분리하여 토큰(token)
//으로 만드는 역할을 합니다. delimiter를 지정하지 않으면 기본적으로 공백(space, tab, new 
//line)을 delimiter로 사용합니다. 따라서 위의 코드는 입력 문자열을 공백을 기준으로 분리하여 
//토큰으로 만듭니다.
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.StringTokenizer;
//
//public class z35 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        String input;
//        while ((input = br.readLine()) != null) {
//            StringTokenizer st = new StringTokenizer(input);
//
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//
//            bw.write(a + b + "\n");
//        }
//
//        br.close();
//        bw.flush();
//        bw.close();
//    }
//}
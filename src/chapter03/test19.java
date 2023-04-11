package chapter03;

public class test19 {

	public static void main(String[] args) {
		int score = 90;
		String result = "";
		
		if(score >= 60) {
			result = "합격";
		} else {
			result = "불합격";
		}

		System.out.println(result);
		
		System.out.println(score >= 60 ? "합격" : "불합격");
		// 삼항 연산자로 표현함. 삼항연산자는 괄호를 사용하여 우선순위 높일 수 있음
	}
}

package quiz;

public class a {
	
	public static void main(String[] args) { /// 메인 함수 args 아규먼트 받아오는 요소값
		int a = 10;
		int b = 20;
		
		int z = a+b ;    // 함수만들었으면 아래 함수 정의 해주어야함
		
		System.out.println(z); // 최종값 표시
		// a b 는 여기 중괄호 {} 안에서만 살아 있어서
		// 아래 public static int sum(int x, int y) << x y 대신 a b 사용해도됨
	}
	
	public static int sum(int x, int y) {  // 1. 함수 먼저 만들고
		return x + y; // 리터값 보여줌 리턴값이 없으면 void사용 (public static void)
	}
	
// 값을 받아오는 함수 만들려면 위와 같이 사용 해도 되고 
	// 변수 값에서 바로 계산 시켜도 된다.
	
}

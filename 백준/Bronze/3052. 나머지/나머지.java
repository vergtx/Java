import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int [] arr = new int[10];
		
		for (int i = 0 ; i<10 ; i ++) {
			arr[i] = (sc.nextInt() % 42);
		
			
		}
		
	/* for (int i = 0 ; i<10 ; i ++) {
			System.out.println(arr[i]);
		}*/
		
	///////////////////////////////////////////////////	
	/*	 HashSet 은 Collection중의 Set의 파생 클라스
		중복되는 원소를 넣을 경우 하나만 저장한다. 즉, 중복원소를 허용하지 않는다.
		순서 개념이 없기떄문에 sort사용 못한다.
		, HashSet 에 저장하면서 들어간 원소의 개수가 HashSet 의 사이즈가 되는 것이고, "서로 다른 나머지"가 됨.*/
		
		HashSet<Integer> temp = new HashSet<>();
		
		for (int i =0; i <10; i++) {
			temp.add(arr[i]);
		}
		
		int count = temp.size(); 
		System.out.println(count);
	}

}
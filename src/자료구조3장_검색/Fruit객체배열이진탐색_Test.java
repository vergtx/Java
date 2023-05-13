package 자료구조3장_검색;

//3장 객체 배열 정렬 - binary search
/*
* Comparator를 사용하는 방법
* MyComparator implements Comparator<>
* MyComparator myComparator = new MyComparator();
* Arrays.sort(array, myComparator);
* Collections.sort(list, myComparator);
*/

//Comparator와 Comparable의 차이
//Comparator와 Comparable의 가장 큰 차이점은 클래스에 대한 구현 위치입니다.
//Comparable 은 interface 로되어 있고 제애릭 타입<T>로 되어있다.
//Comparable 은 compareTo를 인터페이스 해서 무조건 compareTo사용, <> 안의 이름은 내가 입력.
//	Comparable은 클래스 내부에서 구현되며, 객체를 자체적으로 정렬 가능하게 만듭니다.(Boolean을 제외한 래퍼 클래스나 String, Time, Date와 같은 클래스의 인스턴스는 모두 정렬 가능)
//즉, 해당 클래스의 인스턴스들은 자연스러운 순서로 정렬됩니다.
//반면에 Comparator는 별도의 클래스로 구현되며, 객체의 속성을 기반으로 정렬합니다.
// 
//즉, 정렬할 대상 클래스의 소스 코드를 수정하지 않고도 정렬 방법을 바꿀 수 있습니다.

/*따라서, 
Comparable은 객체를 정렬하는 데에 있어서 자연스러운 순서가 이미 존재하고 이를 그대로 사용하고 싶을 때 사용하며,
Comparator는 객체를 정렬하는 방법을 정확하게 지정하고 싶을 때 사용합니다.*/

import java.util.Arrays;
import java.util.Comparator;

class Fruit { // 객채배열 이진 탐색에서 implements Comparable<Fruit> 이거 쓰는 이유 책 찾기
	String name;
	int price;
	String expire;

	public Fruit(String name, int price, String expire) {
		this.name = name;
		this.price = price;
		this.expire = expire;
	}

	public String toString() {
		return name + ", " + price + ", " + expire;
	}

	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	public String getName() {
		return name;
	}

}

public class Fruit객체배열이진탐색_Test {

	static void showData(Fruit[] arr) {
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " / ");
		} System.out.println();
	}

	private static int binarySearch(Fruit[] arr, Fruit newFruit, Comparator<? super Fruit> cc) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int pl = 0;
		int pr = n - 1;

		do {
			int pc = (pl + pr) / 2;
			if (cc.compare(arr[pc], newFruit) == 0)
				return pc;
			else if (cc.compare(arr[pc], newFruit) < 0)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);

		return -1;
	}

	static void sortData(Fruit[] arr, Comparator<Fruit> cc) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (cc.compare(arr[i], arr[j]) > 0) {
					swapData(arr, i, j);
				}
			}
		}
	}

	static void swapData(Fruit[] arr, int i, int j) {
		Fruit Temp = arr[i];
		arr[i] = arr[j];
		arr[j] = Temp;

	}

	public static void main(String[] args) {
		Fruit[] arr = {
		        new Fruit("사과", 200, "2023-5-8"),
		        new Fruit("키위", 500, "2023-6-8"),
		        new Fruit("오렌지", 200, "2023-7-8"),
		        new Fruit("바나나", 50, "2023-5-18"),
		        new Fruit("수박", 880, "2023-5-28"),
		        new Fruit("체리", 10, "2023-9-8")
		};
		System.out.print("정렬전 객체 배열: ");
		showData(arr);
		
		Arrays.sort(arr, (a,b) -> a.getPrice() - b.getPrice());//(a,b)<<-이부분이 compare(a1, a2)의미*//*a.getPrice() - b.getPrice() <이부분 익명클래스로 사용 해서 컴페어 메소드 사용*/ //1.배열 2.키값 3. 비교 연산자(메소드받아서사용) //Fruit에 compareTo()가 있어도 람다식 우선 적용
		System.out.print("\n람다식 정렬(가격)후 객체 배열: " + "(Fruit에 compareTo()가 있어도 람다식 우선 적용)");
		showData(arr);
		
		// Arrays.sort(Fruit[] a, Comparator<? super Fruit> c) 사용 하여 Array 내에서 이름 순으로 소트 하는 방법
		Arrays.sort(arr, new Comparator<Fruit>() {
			@Override
	      	public int compare(Fruit a1, Fruit a2) {
	    	  return a1.getName().compareTo(a2.getName());
			}
		});
		System.out.print("\n이름으로 comparator 정렬(이름)후 객체 배열: ");
		showData(arr);
		// Comparator 구문 main위 class 필드 내 위치 해서 사용 할 수 있다but Static 으로 이름 붙여서 사용<< 책126p 에 이방법 씀 (Static은 객체가 여러개 만들어 져도 하나의 값만 사용(class 당 하나의 값), 객체가 여러게 있어도 한가지 값만)
			
		Comparator<Fruit> cc_name = new Comparator<Fruit>() {//익명클래스 사용/  이름으로 구분하고 싶을때
			public int compare(Fruit f1, Fruit f2) {
				return (f1.name.compareTo(f2.name));
				}
		};  
	    Comparator<Fruit> cc_price = new Comparator<Fruit>() {//익명클래스 사용 했음으로 메소드 필요.(익명클래스 공부) //  가격으로 구분하고 싶을때
	    	public int compare(Fruit f1, Fruit f2) {
	    		return (f1.price - f2.price);
	    		}
	      };
	      Comparator<Fruit> cc_exDate = new Comparator<Fruit>() {//익명클래스 사용 //  가격으로 구분하고 싶을때
	      	public int compare(Fruit f1, Fruit f2) {
	      		return (f1.expire.compareTo(f2.expire));  
	      		}
        };
			//수업 내용 : "binarySearch(T[]a, T key, comparator<? Super T> c"
		    //>>>>> Arrays.binarySearch(null, null, null) 괄호안 왼쪽 부터 "배열", "키", "비교연산자".
		    //>>> 배열에서 키를 주면 비교연산자를 c로 쓰겠다.
        
			Fruit newFruit = new Fruit("체리", 500, "2023-5-18");

			int result3 = Arrays.binarySearch(arr, newFruit, cc_name); // binarySearch(Fruit[] a, Fruit key, Comparator<? super Fruit> c)(배열 /키값 / 비교연산자(비교법)) 이거 합수를 수면 이거를 받는거 맨 밑에
																		// 정의
			System.out.println("\nArrays.binarySearch(이름으로 찾기: \"체리\", 500, \"2023-5-18\") 조회결과::" + result3);

			result3 = binarySearch(arr, newFruit, cc_name);
			System.out.println("\nbinarySearch(이름으로 찾기:\"체리\", 500, \"2023-5-18\" ) 조회결과::" + result3);
			
			
			result3 = binarySearch(arr, newFruit, cc_exDate);
			System.out.println("\nbinarySearch(날짜으로 찾기:\"체리\", 500, \"2023-5-18\" ) 조회결과::" + result3);
			System.out.println();

			sortData(arr, cc_price);
			System.out.print("가격으로 comparator 정렬( 가격 )후 객체 배열: ");
			showData(arr);

			result3 = Arrays.binarySearch(arr, newFruit, cc_price);
			System.out.println("\nArrays.binarySearch(가격으로 찾기:\"체리\", 500, \"2023-5-18\") 조회결과::" + result3);

			result3 = binarySearch(arr, newFruit, cc_price);
			System.out.println("\nbinarySearch(가격으로 찾기:\"체리\", 500, \"2023-5-18\") 조회결과::" + result3);

		}
	
	 
 }

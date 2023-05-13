package 자료구조3장_검색;

import java.util.Arrays;
import java.util.Comparator;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData> { // 여기서 Comparable 은 compareTo를 인터페이스 해서 무조건 compareTo사용, <> 안의 이름은 내가
													// 입력.
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) { // 생성자 객채 초기화

		this.name = name;
		this.height = height;
		this.vision = vision;

	}

	@Override
	public int compareTo(PhyscData o) { // Comparable 인터페이스를 구현하려면, 해당 클래스에 compareTo 메서드를 구현.
		// TODO Auto-generated method stub
		// return this.name.compareTo(o.name); // 이거는 한가지 조건일때 2가지 이상의경우 if문 사용
		// //PhyscData 클래스에서 이름을 기준으로 정렬하고자 한다면, compareTo 메서드에서 이름을 비교하도록 구현

		/*if (this.name.compareTo(o.name) == 0) {
			if (this.height == o.height) {
				if (this.vision == o.vision) {
					return 0;
				} else if (this.vision < o.vision) {
					return -1;
				} else {
					return 1;
				}
			} else if (this.height < o.height) {
				return -1;
			} else {
				return 1;
			}

		} else if (this.name.compareTo(o.name) < 0) {
			return -1;
		} else {
			return 1;
		}
	}*/

		int result = this.name.compareTo(o.name);
		if (result == 0) {
			int hresult = this.height - o.height;
			if (hresult == 0) {
				return (int) (this.vision - o.vision); // (int)는 모두 int 값으로 변경해서 비교함.
			} else
				return hresult;
		} else
			return result;
	}

	public String toString() { // toString()은 자바 객체의 문자열 표현을 반환하는 메서드
								// 일반적으로 개발자가 클래스를 작성할 때, toString() 메서드를 오버라이딩하여 해당 객체를 문자열로 나타내는 방법을 정의합니다.
		return name + " " + height + " " + vision;
	}

	// public static final Comparator<PhyscData> re_order = new
	// re_ordercomparator();

}

public class 객체배열이진탐색_Test {
	static void showData(PhyscData[] data) {
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	static void sortData(PhyscData[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) { // 이중 배열의 특정 요소 비교
				if (data[i].compareTo(data[j]) > 0) { // *compareTo() 메서드는 문자열을 사전 순으로 비교하여, 첫 번째 문자열이 더 작으면 음수를, 같으면
														// 0을, 더 크면 양수를 반환함.
														// 위 코드에서 compareTo() 메서드를 사용하여 items[i]와 items[j]를 비교합니다. 만약
														// items[i]가 items[j]보다 크면(사전적으로 뒤에 위치하면), 두 요소의 위치를 바꿔줍
					swapData(data, i, j); // swapData 함수 호출
				}
			}
		}
	}

	static void swapData(PhyscData[] data, int i, int j) {
		PhyscData Temp = data[i];
		data[i] = data[j];
		data[j] = Temp;

	}

	static int linearSearch(PhyscData[] data, PhyscData key) {

		for (int i = 0; i < data.length; i++) {
			if (data[i].compareTo(key) == 0) {
				return i;
			}
		}
		return -1;
	}

	static int binarySearch(PhyscData[] data, PhyscData key) {
		int n = data.length;
		int pl = 0;
		int pr = n - 1;

		do {
			int pc = (pl + pr) / 2;
			if (data[pc].compareTo(key) == 0)
				return pc;
			else if (data[pc].compareTo(key) < 0)
				pl = pc + 1;
			else
				pr = pc - 1;
		} while (pl <= pr);

		return -1;
	}

	public static void main(String[] args) {
		PhyscData[] data = { new PhyscData("홍길동", 162, 0.3), new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7), new PhyscData("김홍길동", 172, 0.3), new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2), new PhyscData("길동", 167, 0.5), };
		showData(data);
		System.out.println("\n---------------데이터 정렬---------------");
		sortData(data);
		showData(data);
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		key = new PhyscData("길동", 167, 0.5);

		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		// Arrays.binarySearch(data, key, cc)
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);
	}

}

package 자료구조;  

class PhyscData implements Comparable<PhyscData> {
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) { // 생성자 객채 초기화

		this.name = name;
		this.height = height;
		this.vision = vision;

	}

	@Override
	public int compareTo(PhyscData o) {  // 이거를 다른 방법으로 바꿔봐야 겠다.
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() { 				// toString()은 자바 객체의 문자열 표현을 반환하는 메서드
											// 일반적으로 개발자가 클래스를 작성할 때, toString() 메서드를 오버라이딩하여 해당 객체를 문자열로 나타내는 방법을 정의합니다.

		return name + " " + height + " " + vision;
	}
}

public class 과제1_2장기본자료구조2 {

	static void showData(PhyscData[] items) {
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i] + ""); // 배열의 모든 요소 출력
		}
		
	}

	static void sortData(PhyscData[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) { // 이중 배열의 특정 요소 비교
				if (data[i].compareTo(data[j]) > 0) { // *compareTo() 메서드는 문자열을 사전 순으로 비교하여, 첫 번째 문자열이 더 작으면 음수를, 같으면 0을, 더 크면 양수를 반환함.
														//위 코드에서 compareTo() 메서드를 사용하여 items[i]와 items[j]를 비교합니다. 만약 items[i]가 items[j]보다 크면(사전적으로 뒤에 위치하면), 두 요소의 위치를 바꿔줍
					swapData(data, i, j); // swapData 함수 호출
				}
			}
		}
	}

	static void swapData(PhyscData[] data, int i, int j) {
		PhyscData temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3), 
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2),
				new PhyscData("최길동", 169, 0.5), };
		
		showData(data);
		sortData(data);
		System.out.println("이름순으로 정렬 ----------------------");
		showData(data);

	}

}

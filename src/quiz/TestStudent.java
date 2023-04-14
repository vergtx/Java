package quiz;
//하나의 java file에 Student class를 분리하여 정의 구현하는 실습
/*
 * 생성자 함수 구현 - this(); 호출 사용
 * static 데이터 멤버 사용
 * static 멤버 함수 구현
 * toString() 함수 구현과 사용
 * 객체 배열 사용
 */
//하나의 java file에 Student class를 분리하여 정의 구현하는 실습
/*
* 생성자 함수 구현 - this(); 호출 사용
* static 데이터 멤버 사용
* static 멤버 함수 구현
* toString() 함수 구현과 사용
* 객체 배열 사용
*/
class StudentTest {
	static int countStudents;// 객체수
	int sid;// 학번
	String sname; // 학생 이름
	String city; // 주소 도시

	public StudentTest() {
		this(0);
	}

	public StudentTest(int sid) {
		this(sid, "값없음"); 

	}

	public StudentTest(int sid, String sname) {
		this(sid, sname, "값없음");
	}

	public StudentTest(int sid, String sname, String city) {
		this.sid = sid;
		this.sname = sname;
		this.city = city;
		countStudents++;// 생성자 안에 객체 수 증감식 넣기
	}

	 void showStudent() {
		System.out.print("객체- ");
		this.toString();
		System.out.print(toString());
	}

	public static void showNumberObjects() {// 생성된 객체수를 출력한다.
		System.out.println(countStudents);

	}

	public String toString() {
	    return ("학번:" + sid +" , 이름: "+ sname +" , 도시: "+ city);
	}

}

public class TestStudent {
	public static void main(String[] args) {
		{
			int[] a = new int[5];
			StudentTest arry[] = new StudentTest[5];
			StudentTest.showNumberObjects();
			arry[0] = new StudentTest();
			arry[1] = new StudentTest(202301);
			arry[2] = new StudentTest(202302, "Hong");
			arry[3] = new StudentTest(202303, "Lee", "Busan");
			arry[4] = new StudentTest(202304, "Na", "jeju");
			StudentTest.showNumberObjects();
			for (int i = 0; i < 5; i++) {

				arry[i].showStudent();// 생성된 객체 모두를 출력한다.

			}

		}
	}
}
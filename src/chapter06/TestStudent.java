package chapter06;
//하나의 java file에 Student class를 분리하여 정의 구현하는 실습
/*
 * 생성자 함수 구현 - this(); 호출 사용
 * static 데이터 멤버 사용
 * static 멤버 함수 구현
 * toString() 함수 구현과 사용
 * 객체 배열 사용
 */
class TestStudent {
	 static int countStudents;//객체수
	 int sid;//학번
	 String sname; //학생 이름
	 String city; //주소 도시
	 void showStudent() {
		 System.out.print("객체: ");
		 this.toString();
		 System.out.println();
	 }
	 static void showNumberObjects() {//생성된 객체수를 출력한다.
	  
		public student() {
			this.sid = 0 ;
			this.sname = "guest";
			this.city = "null"; 
			}
		  
		public student(int sid) {
			this.sid = sid;
			this.sname = "guest";
			this.city = "null"; 
			} 
		public student(int sid, String sname) {
			this.sid = sid;
			this.sname = sname ;
			this.city = "null"; 
			}
		public student(int sid, String sname, String city) {
			this.sid = sid;
			this.sname = sname ;
			this.city = city; 
			}
		
		}
 
	 }

public class TestStudent {
	public static void main(String[] args) {
		int [] a = new int [5];
		 Student arry[] = new Student[5];
		 showNumberObjects();
	 
		 arry[0] = new Student(); {
		 arry[1] = new Student(202301);
		 arry[2] = new Studnet(202302, 'Hong');
		 arry[3] = new Student(202303, 'Lee', 'Busan');
		 arry[4] = new Student{202304, 'Na', 'jeju');
		 showNumberObjects();
		 }
		 for () {
			 arry[i].showStudent();//생성된 객체 모두를 출력한다.
		 }
	}
	

}

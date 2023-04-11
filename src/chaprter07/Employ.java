package chaprter07;

public class Employ extends Person {
	
	private String dept ;
	
	public Employ() {
		super();
		System.out.println("Employ 생성자가 호출되었습니다.");
		
	}
	
	public Employ(String name, int age, String dept) {
		super(name,age);
		this.dept = dept;
		System.out.println("Empoly(name, age, dept) 생성자 실행!");
		
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString() + ":" + dept ;
	}
// privte 속성 접급목해섬 돌리면 오류난다. private 땅겨올라면 케터와 쎄터 사용 해야 한다.
// 따라서 부모 클라스의 get name ...getName()... 땅겨 오몀된다.	
	
	
	

	

}

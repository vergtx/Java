package chaprter07.abstraction;

abstract class Empolyee {
	String name;
	int salary;
	
	public abstract void calcSalary ();
	
}

class Salesman extends Empolyee {
	public void calcSalary ( ) {
		System.out.println("Saleman 급여 = 기본급 + 판매 수당");
	}
	
}

class Consultant extends Empolyee {
	public void calcSalary ( ) {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
	}
}

class Manager extends Empolyee {
	public void calcSalary ( ) {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}
}

class Director extends Manager {
}
public class HRSTest {
	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Manager m = new Manager();
		
		s.calcSalary();
		c.calcSalary();
		m.calcSalary();
	}
}
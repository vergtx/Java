package chaprter07.abstraction1;

abstract class Empolyee {
	String name;
	int salary;
	
	public abstract void calcSalary ();
	public abstract void calcBonus ();
	
}

class Salesman extends Empolyee {
	public void calcSalary () {
		System.out.println("Saleman 급여 = 기본급 + 판매 수당");
	}
	
	public void calcBonus ( ) {
		System.out.println("Saleman 보너스 = 기본급 * 12 * 4 ");
	}
	
}

class Consultant extends Empolyee {
	public void calcSalary ( ) {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
	}
	
	public void calcBonus ( ) {
		System.out.println("Consultant 보너스 = 기본급 * 12 * 2 ");
	}
}

abstract class Manager extends Empolyee {
	public void calcSalary ( ) {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}
	
}

class Director extends Manager {
	public void calcBonus ( ) {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
	}
}

public class HRSTest {
	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Director d = new Director();
		
		s.calcBonus();
		c.calcBonus();
		d.calcBonus();
	}
}
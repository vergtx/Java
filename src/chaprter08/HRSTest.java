package chaprter08;

public class HRSTest {

    public static void calcTax(Employee e) {
        System.out.println("소득세를 계산합니다.");
    }

    public static void main(String[] args) {
        Salesman s = new Salesman();
        Consultant c = new Consultant();
        Director d = new Director();

        calcTax(s);
        calcTax(c);
        calcTax(d);

        System.out.println(s.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());

        if(s.equals(c)) {
            System.err.println("동일한 객체입니다.");
        } else {
            System.err.println("서로 다른 객체입니다.");
        }

        //
        Salesman s0 = s;
        System.out.println(s0.toString());


        if(s.equals(s0)) {
            System.err.println("동일한 객체입니다.");
        } else {
            System.err.println("서로 다른 객체입니다.");
        }

        //
        Salesman s1 = new Salesman();
        Employee s2 = new Salesman();
        Object s3 = new Salesman();

        Object m1 = new Manager();
        Employee m2 = new Manager();
        Manager m3 = new Manager();
        //Director m4 = new Manager();

    }
}
package study;

public class Test2 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        int z = sum(a, b);


        int p = What();


        System.out.println(z);
    }

    public static int sum(int x, int y) {
        return x + y;
    }

    public static void SayAnything() {
        System.err.println("아무말");
    }

    public static int What() {

        int k = 11 + 2 / 3;

        return k;
    }
}
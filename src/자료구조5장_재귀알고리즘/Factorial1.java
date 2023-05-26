package 자료구조5장_재귀알고리즘;

import java.util.Scanner;

public class Factorial1 {
    static int factorial(int n) {
        if (n > 0) {
            System.out.println("return " + n + " * factorial(" + (n - 1) + ");");
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int x = sc.nextInt();
        int result = factorial(x);
        System.out.println(x + "의 팩토리얼은 " + result + "입니다.");
    }
}

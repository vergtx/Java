
package study;

public class Test3 {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            if (i % 2 == 1) {
                for (int k = 0; k < i; k++) {
                    System.out.print(" ");
                }

                System.out.print("*");
                System.out.print("\n");
            }

        }
    }
}
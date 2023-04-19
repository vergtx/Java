package study;

public class Test4 {

    public static void main(String[] args) {

        for (int k = 2; k <= 9; k++) {

            for (int i = 1; i <= 9; i++) {

                if (i == 4) {
                    break;
                }

                System.out.println(k + " x " + i + " = " + (i * k));

            }

        }
        
    }

}
package study;

public class test6 {
    public static void main(String[] args) {

        int value = 0;
        int square = 1;
        int sum = 0;

        while(value <= 1000) {

            //value = 2 ** square;
            value = (int)Math.pow(2, square);

            if (value >= 1000) {
                break;
            }

            System.out.println("value = " + value);

            sum += value;

            square++;
        }

        System.out.println(sum);

    }
}
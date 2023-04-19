package study;

public class test8 {
    public static void main(String[] args) {

        int[] arr = new int[] { 15, 11, 1, 3, 8 };

        for (int cursor = 0; cursor < arr.length - 1; cursor++) {
            System.out.println("cursor = " + cursor);

            // int min = 99999999;
            // int minIndex = 0;
            for (int compare = cursor + 1; compare < arr.length; compare++) {
                System.out.println("  compare = " + compare);

                // if (min > arr[compare]) {
                //     min = arr[compare];
                //     minIndex = compare;
                // }''
            }
            // System.out.println("  - min = " + min);

            // if (arr[cursor] > min) {
            //     int temp = arr[cursor];
            //     arr[cursor] = min;
            //     arr[minIndex] = temp;
            // }
        }

        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(arr[i]);
        // }
    }
}
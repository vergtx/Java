package study;

public class test7 {
    public static void main(String[] args) {

        int[] arr = new int[] {11, 12, 13, 14, 11};

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[arr.length - i - 1]);

        }

        System.out.println("=".repeat(50));
        for(int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }

        boolean result = true;

        System.out.println("=".repeat(50));
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[arr.length - i - 1]) {
                result = true;
            } else {
                result = false;
                break;
            }
        }

        if(result == true) {
            System.out.println("회문입니다.");
        } else {
            System.out.println("회문이 아닙니다.");
        }


    }
}
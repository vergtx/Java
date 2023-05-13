package 자료구조2장_기본자료구조;

import java.util.Random;

public class 메소드배열전달 {
	
    static void getData(int[] items) {
        Random r = new Random();
        for (int i = 0 ; i < items.length; i++) {
            items[i] = r.nextInt(56); // 난수 생성하며 배열에 반영
        }
    }
	
    static void showData(int[] items) {
        for (int i = 0 ; i < items.length; i++) {
            System.out.print(items[i] + " "); // 배열의 모든 요소 출력
        }
    }
    
    static int findmax(int[] items) {
        int max = items[0];
        for (int i = 1 ; i < items.length; i++) {
            if (items[i] > max) {
                max = items[i];
            }
        }
        return max;
    }
    
    static void sortData(int[] items) {
        for (int i = 0; i < items.length ; i++) {
            for (int j = i + 1 ; j < items.length ; j++) { // 이중 배열의 특정 요소 비교
                if (items[i] < items[j]) {
                	swapData(items, i, j); // swapData 함수 호출
                }
            }
        }       
    }

    static void swapData(int[] a, int i, int j) {   
            int t = a[i];
            a[i] = a[j];
            a[j] = t;               
        }       
    
    
    public static void main(String[] args) {
        int[] data = new int[10];
        getData(data);
        showData(data);
        
        int mvalue = findmax(data);
        System.out.println("\n\nmax = " + mvalue);
        
        System.out.println("\n정렬 후 결과");
        sortData(data);
        showData(data);
    }
}
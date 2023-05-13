package 자료구조3장_검색;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
import java.util.Arrays;
import java.util.Random;


public class 정수배열이진탐색_Test {
	
	static void inputData(int[] data) {
		Random r = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = r.nextInt(100);
			  
		}
	}
	
	static void showData(int[] data) {
		for (int i=0; i<data.length; i++) {
			System.out.print(data[i] + " ");
		}
	}
	
	static void sortData(int[] data) {
        for (int i = 0; i < data.length ; i++) {
            for (int j = i + 1 ; j < data.length ; j++) { // 이중 배열의 특정 요소 비교
                if (data[i] > data[j]) {
                	swapData(data, i, j); // swapData 함수 호출
                }
            }
        }       
    }
	
	static void swapData(int[] data, int i, int j) {
	      int t = data[i];
	      data[i] = data[j];
	      data[j] = t;               
            
  
	}
	
	static int linearSearch(int[] data, int key) {
	    for (int i = 0; i < data.length; i++) {
	        if (data[i] == key) {
	            return i;
	        }
	    }
	    return -1;
	}
	
	static int binarySearch(int[] data, int key) {
		int n = data.length;
		int pl = 0;
		int pr = n-1;
		
		do {
			int pc = (pl + pr) / 2;
			if (data[pc] == key)
				return pc;
			else if (data[pc] < key)
				pl = pc + 1;
			else
				pr = pc - 1;
		}	while (pl <= pr);
		
		return -1;
			
		
	}
	

		

	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData(data);
		sortData(data);
		System.out.println();
		for (int num: data) {
			System.out.print(num+" ");
		}
		int key = 33;
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		
		key = 39;
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);
		
	}
	
}



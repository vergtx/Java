package 자료구조3장_검색;


//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
import java.util.Arrays;
import java.util.Random;


public class 스트링배열이진탐색_Test {
	
	
	
	static void showData(String[] data) {
		for (int i = 0 ;  i < data.length ; i++) {
			System.out.print(data[i] + " ");
		}
	}
	
	static void sortData(String[] data) {
		for (int i = 0; i < data.length; i++) {
			for (int j = i + 1; j < data.length; j++) { 
				if (data[i].compareTo(data[j]) > 0) { 
					swapData(data, i, j); 
				}
			}
		}
	}

	static void swapData(String[] data, int i, int j) {
		String temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	
	static int linearSearch(String[] data, String key) {
	    for (int i = 0; i < data.length; i++) {
	        if (data[i].equals(key)) {
	            return i;
	        }
	    }
	    return -1;
	}
	
	static int binarySearch(String[] data, String key) {
		int n = data.length;
		int pl = 0;
		int pr = n - 1;
		
		do {
			int pc = (pl + pr) / 2;
			if (data[pc].equals(key))
				return pc;
			else if (data[pc].compareTo(key) < 0) 
				pl = pc + 1;
			else
				pr = pc - 1;				
		} while (pl <= pr);
		
		return -1;
	}
	
	

	

	public static void main(String[] args) {
		String []data = {"apple","grape","persimmon", "감", "배", "사과", "포도", "pear","blueberry", "strawberry", "melon", "orientalmelon"};

		showData(data);
		System.out.println("\n ----------------------------------배열정렬 --------------------------------" );
				
		sortData(data);
		showData(data);
		System.out.println("\n");
						
		String key = "감";
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		
		key = "배";
		result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + result);
		
	}
	
	
}

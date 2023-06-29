package a백준_심화;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 단어공부_연습2 {

	public static String findMostFrequentAlphabet(String word) {
		
		Map<Character, Integer> counter = new HashMap<>();
		
		for(int i = 0 ; i < word.length(); i++) {
			char c =  Character.toLowerCase(word.charAt(i));
			int count = counter.getOrDefault(c, 0);
			counter.put(c, count + 1);
		}
		
		int maxcount = 0;
		char mostFrequent = '?';
		boolean multipleFrequent = false;
		
		for(Map.Entry<Character, Integer> entry : counter.entrySet()) {
			char c = entry.getKey();
			int count = entry.getValue();
			
			if(count > maxcount) {
				maxcount = count;
				mostFrequent = c ;
				multipleFrequent = false;
			}
			else if(count == maxcount) {
				multipleFrequent = true;
			}
		} if(multipleFrequent) {
			return "?";
		} else {
			return Character.toUpperCase(mostFrequent) + "";
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		
		String word = sc.nextLine();
		
		sc.close();
		
		String mostFrequent = findMostFrequentAlphabet(word) ;
		
		System.out.println(mostFrequent);
		
	}

}

package a백준_심화;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 단어공부_연습 {

	public static String findMostFrequentAlphabet(String word) {

		Map<Character, Integer> counter = new HashMap<>();

		for (int i = 0; i < word.length(); i++) {
			char c = Character.toLowerCase(word.charAt(i));
			int count = counter.getOrDefault(c, 0);
			counter.put(c, count + 1);
		}

		int maxCount = 0;
		char mostFrequent = '?';
		//큰 따옴표(")로 둘러싸여 있는 "문자열" 리터럴
		//작은 따옴표(')로 둘러싸여 있는 "문자" 리터럴
		boolean multipleFrequent = false;
		// Map 객체에 저장된 키-값 쌍을 바로 출력하는 것은 불가능합니다. 따라서 밑에 entry 사용
		for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
			char c = entry.getKey(); // 키값
			int count = entry.getValue();// value값
			if (count > maxCount) {
				maxCount = count;
				mostFrequent = c;
				multipleFrequent = false;
				// count가 maxCount보다 큰 경우 maxCount를 count로 업데이트
				// mostFrequent를 maxCount 문자인 c로 설정합니다.
				// 단일 최대 값이기 때문에 multipleFrequent를 false로 설정합니다.
				// for문이 종료될 때 까지 업데이트 된다.
			} else if (count == maxCount) {
				multipleFrequent = true;
			}

		}
		if (multipleFrequent) {
			return "?";
		} else {
			return Character.toUpperCase(mostFrequent) + "";
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String word = sc.nextLine();

		sc.close();

		String mostFrequent = findMostFrequentAlphabet(word);

		System.out.println(mostFrequent);

	}

}

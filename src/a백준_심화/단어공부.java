package a백준_심화;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 단어공부 {


	public static String findMostFrequentAlphabet(String word) {
		
		//Map 객체에 저장된 키-값 쌍을 바로 출력하는 것은 불가능합니다. 따라서 밑에 entry쓴 반복문 한번 더나옴
		Map<Character, Integer> counter = new HashMap<>();

		// 문자열 순회하며 알파벳 등장 횟수 세기
		for (int i = 0; i < word.length(); i++) {
			char c = Character.toLowerCase(word.charAt(i));
			//Character.toLowerCase() 메소드는 주어진 문자를 소문자로 변환해주는 역할
			//word.charAt(i)는 입력된 문자열 word에서 인덱스 i에 해당하는 문자를 가져옴
			
			int count = counter.getOrDefault(c, 0);
			//counter 맵에서 키 c에 해당하는 값을 가져오는데, 만약 해당 키가 존재하지 않으면 기본값으로 0을 반환
			//count는 counter 맵에서 특정 문자의 등장 횟수를 나타내는 값
			// 알파벳이 이미 등장한 경우 count 값을 가져와 1 증가시킴
			counter.put(c, count + 1); //c 는 알파벳, count + 1 은 동일 알파벳 나올때 나다 +1
			//"put역할은 update임."
			//put(key, value)은 맵(Map)에 키-값 쌍을 추가하거나 갱신하는 메서드
			//주어진 key가 이미 맵에 존재하는 경우, 해당 key의 값이 주어진 value로 갱신됩니다.
			//주어진 key가 맵에 존재하지 않는 경우, 새로운 키-값 쌍이 맵에 추가됩니다.
			//맵에 이미 등록된 알파벳의 경우 이전 카운트 값을 가져와 1을 더한 후 다시 맵에 저장합니다.
			//즉, 같은 알파벳이 나오는 경우에도 맵에 저장된 카운트 값이 증가하게 되므로 
			//별도의 같은 알파벳일 경우 같은 if 조건문을 사용하지 않아도 됨
		}

		int maxCount = 0;
		char mostFrequent = '?';
		//초기값으로 '?'를 선택한 이유는 문자열 내에 어떤 알파벳도 등장하지 않았을 때와 구분하기 위함.
		//초기값이기 때문에 나중에 실제 값이 나오면 실제값이 출력될 예정 .
		boolean multipleFrequent = false;
		//위의 코드는 문자열 내에서 가장 빈도가 높은 알파벳을 찾기 위해 사용됩니다.
		//문자열을 순회하면서 각 알파벳의 등장 횟수를 확인하고, maxCount 변수를 업데이트하며 가장 빈도가 높은 알파벳을 추적합니다.
		//동일한 최고 빈도를 갖는 알파벳이 여러 개인 경우, multipleFrequent 변수를 true로 설정하여 이를 표시합니다.

		// 가장 많이 등장한 알파벳 찾기
		
		//여기는 foreach 사용 for( A : B)
		//Entry"는 맵(Map)에서 키(key)와 값(value)으로 구성된 하나의 요소를 나타내는 용어
		
		for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
			
		//counter.entrySet()는 counter 맵의 키-값 쌍을 하나씩 가져오는 엔트리들의 집합을 반환
		//집합은 Set이라는 자료구조로, 각각의 엔트리는 키와 값으로 구성
		//Map.Entry<Character, Integer>는 맵의 키와 값의 쌍을 나타내는 인터페이스
		//for-each 문법을 사용하여 counter.entrySet()의 각각의 엔트리에 대해 반복문을 실행
		//각 반복마다 entry라는 변수에 현재 엔트리가 할당.
		//entry.getKey()를 사용하면 현재 엔트리의 키를 얻을 수 있고,
		//entry.getValue()를 사용하면 현재 엔트리의 값에 접근할 수 있음
	
			
			char c = entry.getKey();
			int count = entry.getValue();
			if (count > maxCount) {
				maxCount = count;
				mostFrequent = c;
				multipleFrequent = false;
			} else if (count == maxCount) {
				multipleFrequent = true;
			}
		}

		if (multipleFrequent) {
			return "?";
			// if(multipleFrequent == true)는 if(multipleFrequent) 동일한 의미임
		} else {
			return Character.toUpperCase(mostFrequent) + "";
			//Character.toUpperCase(mostFrequent)는 char 타입을 반환해야함
			//그러나 return 문에서는 문자열을 반환해야 합니다.
			//이렇게 하면 char 타입에 +"" 이 붙어 -> 문자열로 변환됨.
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

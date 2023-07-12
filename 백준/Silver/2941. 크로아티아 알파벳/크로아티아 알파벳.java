import java.util.Scanner;

public class Main {
	private static boolean isCroatianAlphabet(String chars) {
        String[] croatianAlphabets = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
    	//위 목록에 없는 알파벳은 한 글자씩 센다.
        for (String alphabet : croatianAlphabets) {
            if (chars.equals(alphabet)) {
                return true;
            }
        }
        return false;
    }
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int count = 0;
        int index = 0;
        while (index < input.length()) { //index가 문자열의 범위 내에 있는지 확인
            if (index + 1 < input.length()) { // 실제로 문자열을 자를 범위가 있는지 확인 문자 2개씩 자를 거라서 마지막 문자열일경우 +2 해서 자르면 자를 문자가 없는 것을 방지
                String twoChars = input.substring(index, index + 2); //(시작인덱스, 종료인덱스)
                //substring() 메서드는 첫 번째 매개변수로 시작 인덱스를 받고,
                //두 번째 매개변수로 종료 인덱스를 받는데, 종료 인덱스는 실제로 추출되는 부분 문자열에 포함되지 않음. 
                if (isCroatianAlphabet(twoChars)) {
                    count++;
                    index += 2;
                    continue;
                }
            }

            if (index + 2 < input.length()) {
                String threeChars = input.substring(index, index + 3);
                if (isCroatianAlphabet(threeChars)) {
                    count++;
                    index += 3;
                    continue;
                }
            }

            count++;
            index++;
        }

        System.out.println(count);
    }

    
}
package 자료구조;

public class 스트링배열 {
	

    static void showData(String[] items) {
        for (int i = 0 ; i < items.length; i++) {
            System.out.print(items[i] + " / "); // 배열의 모든 요소 출력
        }
    }
    
        
    static String findmax(String[] items) {   //String도 compareTo 메소드를 사용하여 사전식으로 비교할 수 있습니다. compareTo는 두 String 객체를 사전식으로 비교하며, 비교 결과가 음수, 0, 양수 중 하나의 값을 반환합니다. 이때, 반환 값이 양수라면 첫 번째 문자열이 두 번째 문자열보다 사전식으로 뒤에 위치하는 것입니다. 따라서 compareTo를 이용해 String 배열에서 max값을 찾을 수 있습니다.
    	
    	String max = items[0]; //items의 첫 번째 요소를 의미
        for (int i = 1 ; i < items.length; i++) {
            if (items[i].compareTo(max) > 0) {
                max = items[i];
            }
        }
        return max;
    }
    
    static void sortData(String[] items) {
        for (int i = 0; i < items.length ; i++) {
            for (int j = i + 1 ; j < items.length ; j++) { // 이중 배열의 특정 요소 비교
                if (items[i].compareTo(items[j]) < 0 ) { //  *compareTo를 사용하여 items[i]와 items[j]를 비교 비교하여 크면 음수 같으면 0 작으면 양수
                	swapData(items, i, j); // swapData 함수 호출
                }
            }
        }       
    }

    static void swapData(String[] a, int i, int j) {   
    	String temp  = a[i];
            a[i] = a[j];
            a[j] = temp ;               
        }       
    
    
    public static void main(String[] args) {
        String[] data = {"aaa", "apple", "grape", "melon", "manggo", "zz"};
       
        showData(data);
        
        String max_value = findmax(data);
        System.out.println("\n\nmax = " + max_value);
        
        System.out.println("\n정렬 후 결과");
        sortData(data);
        showData(data);
    }
}
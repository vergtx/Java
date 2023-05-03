package 자료구조;

class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;

}

public  PhyscData(String name, int height, double vision) { // 여기서 생성자 왜 호출한거지?
	
	this.name = name;
    this.height = height;
    this.vision = vision;
	
}

@Override
public int compareTo(PhyscData o) {
	// TODO Auto-generated method stub
	return 0;
}
public class 과제1_2장기본자료구조 {
	

	
    static void showData(PhyscData[] items) {
        for (int i = 0 ; i < items.length; i++) {
            System.out.print(items[i] + " / "); // 배열의 모든 요소 출력
        }
    }
    
	
	
	 static void sortData(String[] items) {
	        for (int i = 0; i < items.length ; i++) {
	            for (int j = i + 1 ; j < items.length ; j++) { // 이중 배열의 특정 요소 비교
	                if (items[i].compareTo(items[j]) != 0 ) { //  *compareTo를 사용하여 items[i]와 items[j]를 비교 비교하여 음수 같으면 0 작으면 양수
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
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("이길동", 182, 0.6),
				new PhyscData("박길동", 167, 0.2),
				new PhyscData("최길동", 169, 0.5),
		};
		showData(data);
		sortData(data);
		showData(data);
	}

	
}



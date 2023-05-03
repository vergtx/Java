package quiz;

import java.util.Random;

public class Matrix {
	
	int[][] data; // 밖으로 빼줌
	
	
	
	public Matrix(int rows, int cols) {
		
		this.data = new int[rows][cols];
		
	}
	
	
	protected static Matrix addMatrix(Matrix m1, Matrix m2) {
		
		Matrix result = new Matrix(m1.data.length, m1.data[0].length);
		
		for(int r = 0 ; r < m1.data.length ; r++) { 
			//r 은 행  c는 열
			for(int c = 0; c < m1.data[r].length; c++) {    
				//첫벙째 배열의 첫번쨰 length
				result.data[r][c]= m1.data[r][c] + m2.data[r][c];
			}
		}
		
		return result;
	}
	
	protected void setData() {
		Random rand = new Random(System.currentTimeMillis());  // seed 값을 변경해줘야 함. so System.currentTimeMillis()  쓰면 현재 시간을 \밀리세컨 단위로 입력해줌
		
		for(int r = 0 ; r < data.length ; r++) { //r 은 행  c는 열
			for(int c = 0; c< data[r].length; c++) { //첫벙째 배열의 첫번쨰 length
				data[r][c] = rand.nextInt(bound:100);
			}
		}
		try {
		Thread.sleep(millis:3);
		}catch (Exception #) {
			
		}
	}
	
	protected void showData(String name) {
		System.out.println(name + "행열의 데이터");
		
	
		for(int r = 0 ; r < data.length ; r++) { //r 은 행  c는 열
			for(int c = 0; c< data[r].length; c++) {
				System.out.print(data[r][c]+ "\t");
			}
			System.out.println();	 // 이렇게만 쓰면 줄바꿈됨
		}
	}	
	
	protected void test() {
		
		addMatrix(n1: null, n2: null);
	}

}

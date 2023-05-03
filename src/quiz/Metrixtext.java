package quiz;

public class Metrixtext {
	
	
		public static void main(String[] args) {
			
			Matrix A = new Matrix(rows:2, cols:3);
			
			Matrix A1 = new Matrix(rows:2, cols:3);
			
			A.setData();
			A1.setData();
			
			A.showData(name:"A");
			A1.showData(name:"A1");

			Matrix A2 = Matrix.addMatrix(A, A1);
			A2.showData(name: "A2");

		}

}

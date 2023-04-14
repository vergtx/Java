package chaprter08.innerClass;

public class 객체배열외부 {
	class Student{
		
		int sid;
		String sname ;
		Student (int sid, String sname) {
			this.sid = sid ;
			this.sname = sname ;
			
		}
		
		public String toString() {
			return "sid =" + sid + "sname =" + sname;
		}
		
		void show ( ) {
			System.out.println(this.toString());
		}
		
	}
	
	public static void main(String[] args) {
	
		int []data= new int[10];
		Student []sdata = new Student[10] ;
		data [0] = 10;
		객체배열외부 my = new 객체배열외부 (); 
		sdata[1] = new Student (2023, "hong");
		sdata[2] = my.new Student (2022, "kimg");
		sdata[3] = my.new Student (2021, "slee");
		sdata[4] = my.new Student (2020, "se");
		sdata[5] = my.new Student (2019, "edsx");
		for (int i = 0 ; i <5 ; i++)
			sdata[i].show();
	}	
	}


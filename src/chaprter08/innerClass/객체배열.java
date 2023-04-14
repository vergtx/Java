package chaprter08.innerClass;

class Student{
	
	int sid;
	String sname ;
	Student (int sid, String sname) {
		this.sid = sid ;
		this.sname = sname ;
		
	}
	
	void show ( ) {
		System.out.println("sid =" + sid + "sname =" + sname);
	}
	
}


public class 객체배열 {
	public static void main(String[] args) {
		int []data= new int[10];
		Student []sdata = new Student[10] ;
		data [0] = 10;
		sdata[1] = new Student (2023, "hong");
		sdata[2] = new Student (2022, "kimg");
		sdata[3] = new Student (2021, "slee");
		sdata[4] = new Student (2020, "se");
		sdata[5] = new Student (2019, "edsx");
		for (int i = 0 ; i <5 ; i++)
			sdata[i].show();
		
	}

}

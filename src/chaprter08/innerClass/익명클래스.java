package chaprter08.innerClass;

interface Messenger{  // 함수바디가 없다.
	String getMessage();
	void setMessge(String msg);
}

//class GMessenger implements Messenger {
//	public String getMessenger() {
//		return "good" ;
//	}
//	public void setMessage(String msg) {
//		System.out.println("my data -" + msg);
//	}
//	public void changeMod() {
//		System.out.println("change");
//	}
//}

public class 익명클래스 {
	public static void main(String[] args) {
//		GMessenger gm = new GMessenger();
		Messenger gm = new GMessenger();
		gm.getMessage();
		gm.setMessage("gong");	
	}

}




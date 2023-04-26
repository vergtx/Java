package zzzz;

class StringUtil {
	private String value;

	<T extends CharSequence> StringUtil(T value) {
		this.value = value.toString();
	}

	void printVal() {
		System.out.println("value: " + value);
	}
}

public class GenConsTest {

	public static void main(String[] args) {
		String s = new String("����");
		StringBuffer sbuf = new StringBuffer("����");
		StringBuilder sbui = new StringBuilder("�뱸");

		StringUtil su1 = new StringUtil(s);
		StringUtil su2 = new StringUtil(sbuf);
		StringUtil su3 = new StringUtil(sbui);

		su1.printVal();
		su2.printVal();
		su3.printVal();
	}
}
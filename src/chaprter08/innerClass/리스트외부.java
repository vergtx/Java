package chaprter08.innerClass;

class LinkedList {
	Node head ;
	Node temp ;
	void show() {
		Node p = head;
		while (p!=null) {
			System.out.println(p.toString());
			p = p.link;
		}
	}
	void add(String name) {
		Node temp = new Node(name);
		if(head == null) {
			head = temp;
				}

		else {
			temp.link = head;
			head = temp;
		}
	}
}

public class 리스트외부 {

	public static void main(String[] args) {
	LinkedList my = new LinkedList();
	my.add("hong");
	my.add("kim");
	my.add("im");
	
	my.show();
	
	
}
}

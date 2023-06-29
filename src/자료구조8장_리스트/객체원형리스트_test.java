
package 자료구조8장_리스트;

/*
 * 정수 리스트 > 객체 리스트> 객체 원형 리스트
 */
import java.util.Comparator;
import java.util.Scanner;

class SimpleObject3 {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}

	public SimpleObject3(String no, String name) {
		this.no = no;
		this.name = name;
	}
	public SimpleObject3() {
		this.no = null;
		this.name = null;
	}
	// --- 데이터를 읽어 들임 ---//
	void scanData(String guide, int sw) {
		Scanner sc = new Scanner(System.in);
		System.out.println(guide + "할 데이터를 입력하세요." + sw);

		if ((sw & NO) == NO) { // & 는 bit 연산자임
			System.out.print("번호: ");
			no = sc.next();
		}
		if ((sw & NAME) == NAME) {
			System.out.print("이름: ");
			name = sc.next();
		}
	}

	// --- 회원번호로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject3> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject3> {
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no) < 0) ? -1 : 0;
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject3> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject3> {
		public int compare(SimpleObject3 d1, SimpleObject3 d2) {
			return d1.name.compareTo(d2.name);
		}
	}
}

class Node3 {
	SimpleObject3 data;
	Node3 link;

	public Node3(SimpleObject3 element) {
		data = element;
		link = null;
	}
}

class CircularList { //
	Node3 first;

	public CircularList() { //head node
		Node3 newNode =  new Node3(null); //CircularList 생성자 // first 값은 null
		newNode.link = newNode;
		first = newNode;

	}

	public int Delete(SimpleObject3 element, Comparator<SimpleObject3> cc) {// delete the element
		return 0;

	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.

	}

	public void Add(SimpleObject3 element, Comparator<SimpleObject3> cc) { // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
		// 객체 list 가지고 와서 고치는 작업
		Node3 nd = new Node3(element); // 
		Node3 p = first; // 
		Node3 q = p;

		if (p.link == first) { // //3.만약 연결 리스트가 비어있다면, 새로운 노드를 첫 번째 노드로 설정
			first.link = nd;
			nd.link = p;
			return;
		}

		while (p != first) { // 2.연결 리스트의 첫 번째 노드부터 시작하여 삽입할 값이 들어갈 위치를 찾습니다. p를 한 칸씩 이동 하며 값을 삽입할 위치를 찾을 때까지
							// 노드를 한 칸씩 이동하며 탐색
			/* 수정된 부분cc.compare */
			if (cc.compare(element, p.data) < 0) { // 2-1 element 값과 현재 노드의 data 값을 비교하여 적절한 위치를 찾을 때까지 계속해서 노드를 이동합니다.
				if (q == first) { // 2-1-1 만약 q가 첫 번째 노드인 경우(q == first) nd를 첫 번째 노드로 설정하고
					nd.link = p; // 2-1-2 nd의 링크를 현재 노드인 p로 설정
					first = nd; // 2-1-3 first를 nd로 업데이트
					return;
				} else { // 2-1-4 q가 첫 번째 노드가 아닌 경우(q != first),
					nd.link = p; // nd를 현재 노드인 p의 앞에 삽입 이를 위해 1) nd의 링크를 p로 설정하고
					q.link = nd; // 2)q의 링크를 nd로 설정 ==> 1)2)를 하면 nd가 p 앞에 삽입되게 됨
					return;
				}

			} /* 수정된 부분cc.compare */
			else if (cc.compare(element, p.data) > 0) { // 2-2 element 값이 현재 노드의 값보다 크다면 q를 p로 이동시키고 p를 다음 노드로 이동시킵니다
				q = p; // 2-2-1 q를 p로 이동시키고
				p = p.link; // 2-2-2 p를 다음 노드로 이동시킵니다 이 과정은 연결 리스트를 끝까지 탐색하거나 element가 삽입할 위치를 찾을 때까지 반복됩니다.
				if (p == null) {
					q.link = nd; // 2-2-3 삽입할 element가 가장 큰 경우 마지막에 추가
					return;
				}
			} else {
				return; // element가 이미 존재하는 경우 중복 삽입 방지
			}
		}
	}

	public boolean Search(SimpleObject3 element, Comparator<SimpleObject3> cc) { // 전체 리스트를 순서대로 출력한다.
		return true;
	}
}

public class 객체원형리스트_test {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		System.out.println("Linked List");
		CircularList l = new CircularList(); //CircularList 생성자 정보 가지고 온다 /CircularList 생성자 만들어야 한다.
		Scanner sc = new Scanner(System.in);
		SimpleObject3 data;
		System.out.println("inserted");
		l.Show();
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				data = new SimpleObject3();
				data.scanData("입력", 3);
				l.Add(data, SimpleObject3.NO_ORDER);
				break;
			case Delete: // 머리 노드 삭제
				data = new SimpleObject3();
				data.scanData("삭제", SimpleObject3.NO);
				int num = l.Delete(data, SimpleObject3.NO_ORDER);
				System.out.println("삭제된 데이터 성공은 " + num);
				break;
			case Show: // 꼬리 노드 삭제
				l.Show();
				break;
			case Search: // 회원 번호 검색
				data = new SimpleObject3();
				data.scanData("탐색", SimpleObject3.NO);
				boolean result = l.Search(data, SimpleObject3.NO_ORDER);
				if (result == true)
					System.out.println("검색 성공 = " + result);
				else
					System.out.println("검색 실패 = " + result);
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}

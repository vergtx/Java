
package 자료구조8장_리스트;

/*
 * 정수 리스트 > 객체 리스트: 2번째 실습 대상 
 */
import java.util.Comparator; //Comparator 사용
import java.util.Scanner;

class SimpleObject {
	static final int NO = 1; // 번호를 읽어 들일까요?
	static final int NAME = 2; // 이름을 읽어 들일까요?

	private String no; // 회원번호
	private String name; // 이름

	// --- 문자열 표현을 반환 ---//
	public String toString() {
		return "(" + no + ") " + name;
	}

	public SimpleObject() {
		no = null;
		name = null;
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
	public static final Comparator<SimpleObject> NO_ORDER = new NoOrderComparator();

	private static class NoOrderComparator implements Comparator<SimpleObject> {
		public int compare(SimpleObject d1, SimpleObject d2) {
			return (d1.no.compareTo(d2.no) > 0) ? 1 : (d1.no.compareTo(d2.no) < 0) ? -1 : 0; // 3항 연산자 comparator 비교
		}
	}

	// --- 이름으로 순서를 매기는 comparator ---//
	public static final Comparator<SimpleObject> NAME_ORDER = new NameOrderComparator();

	private static class NameOrderComparator implements Comparator<SimpleObject> {
		public int compare(SimpleObject d1, SimpleObject d2) {
			return d1.name.compareTo(d2.name); // 문자열은 알아서 사전 순으로 비교 해줌
		}
	}
}

class Node2 {
	SimpleObject data;
	Node2 link;

	public Node2(SimpleObject element) {
		data = element;
		link = null;
	}
}

class LinkedList2 {
	Node2 first;

	public LinkedList2() {
		first = null;
	}

	public int Delete(SimpleObject element, Comparator<SimpleObject> cc) {
		Node2 p = first;
		Node2 q = null;
		while (p != null) {
			if (cc.compare(element, p.data) < 0) {
				if (q == null) {
					// 삭제할 노드가 첫 번째 노드인 경우
					first = p.link;
				} else {
					// 이전 노드와 다음 노드를 연결하여 삭제
					q.link = p.link;
				}
				 System.out.println("삭제된 데이터는 " + p.data + "입니다.");
				return 1; // 삭제된 노드의 데이터를 반환
			}
		
			q = p;
			p = p.link;
		}
		System.out.println("삭제할 데이터가 없습니다.");
		return -1; // delete the element

	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node2 p = first;
		if (p == null) {
			System.out.println("값이 없습니다.");
			System.out.println("\n");
		} else {
			while (p != null) {
				System.out.println(p.data); // 노드의 값을 출력

				p = p.link;
			}
		}

	}

	public void Add(SimpleObject element, Comparator<SimpleObject> cc) { // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다

		Node2 nd = new Node2(element); // 1. 값을 담는 새로운 노드를 생성합니다.
		Node2 p = first; // p 는 현재 집어 넣어야 할 값을 임의로 정의 한것. q는 이전의 노드 데이터
		Node2 q = p;/* 현재 노드(p)를 이전 노드(q)로 설정 
		Node2 q = p;는 p가 현재 노드를 가리키고 있을 때, q를 p로 설정함으로써 q가 이전 노드를 가리키도록 합니다
		 이후에 p를 다음 노드로 이동하면 q는 그 이전 노드를 가리키게 됩니다.*/

		if (p == null) { // //3.만약 연결 리스트가 비어있다면, 새로운 노드를 첫 번째 노드로 설정
			first = nd;
			return;
		}

		while (p != null) { // 2.연결 리스트의 첫 번째 노드부터 시작하여 삽입할 값이 들어갈 위치를 찾습니다. p를 한 칸씩 이동 하며 값을 삽입할 위치를 찾을 때까지
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

	public boolean Search(SimpleObject element, Comparator<SimpleObject> cc) {
		Node2 p = first;
		
		while (p != null) {
			if (cc.compare(element, p.data) == 0) {
				System.out.println("검색된 데이터는 " +p.data +" 입니다" );
				return true;
			} 
			p = p.link;
		}
		System.out.println("검색된 데이터가 없습니다.");
		return false;
	}

}

public class 객체연결리스트_test {

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
		LinkedList2 l = new LinkedList2();
		Scanner sc = new Scanner(System.in);
		SimpleObject data;
		System.out.println("inserted");
		l.Show();
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				data = new SimpleObject();
				data.scanData("입력", 3);
				l.Add(data, SimpleObject.NO_ORDER);
				break;
			case Delete: // 머리 노드 삭제
				data = new SimpleObject();
				data.scanData("삭제", SimpleObject.NO);
				int num = l.Delete(data, SimpleObject.NO_ORDER);
				System.out.println("삭제된 데이터 성공은 " + num);
				break;
			case Show: // 꼬리 노드 삭제
				l.Show();
				System.out.println("\n");
				break;
			case Search: // 회원 번호 검색
				data = new SimpleObject();
				data.scanData("탐색", SimpleObject.NO);
				boolean result = l.Search(data, SimpleObject.NO_ORDER);
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

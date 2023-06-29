
package 자료구조8장_리스트;
//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계

import java.util.Random;
import java.util.Scanner;

class Node1 { // 노드 
	int data;
	Node1 link;

	public Node1(int element) { // 생성자
		data = element;
		link = null;
	}

	@Override
	public String toString() {
		return "Node1: [data= " + data + ", link= " + link + "]";
	}
}

class LinkedList1 { 
	
	Node1 first; //1번정의

	public LinkedList1() { // 생성자
		
		first = null;
	
	}

	public int Delete(int element) { //
	    Node1 p = first;
	    Node1 q = null;
	    while (p != null) {
	        if (element == p.data) {
	            if (q == null) {
	                // 삭제할 노드가 첫 번째 노드인 경우
	                first = p.link;
	            } else {
	                // 이전 노드와 다음 노드를 연결하여 삭제
	                q.link = p.link;
	            }
	            return 1; // 삭제된 노드의 데이터를 반환
	        }
	        q = p;
	        p = p.link;
	    }
	    return -1; // 삭제할 노드가 없는 경우 -1 반환
	}
	/*Delete 메소드를 수정하여 노드를 삭제하고 삭제된 노드의 데이터를 반환하도록 수정되었습니다. 
	만약 삭제할 노드가 첫 번째 노드인 경우 first를 업데이트하고, 
	그렇지 않은 경우 이전 노드(q)와 다음 노드(p.link)를 연결하여 삭제합니다.
	삭제된 노드의 데이터를 반환하며, 삭제할 노드가 없는 경우 -1을 반환합니다.*/

	public void Show() { // 전체 리스트를 순서대로 출력한다. p!=null  출력 출력
		Node1 p = first; // p 는 현재 집어 넣어야 할 값을 임의로 정의 한것.
		while (p!=null) {
			
			
			//p값 출력
			p = p.link;
			System.out.println(p);
		}
	
	}

	public void Add(int element) { // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
		Node1 nd = new Node1(element); // 1. 삽입할 값을 담는 새로운 노드를 생성합니다.
		Node1 p = first; // p 는 현재 집어 넣어야 할 값을 임의로 정의 한것.
		Node1 q = p;

		if (p == null) { // //3.만약 연결 리스트가 비어있다면, 새로운 노드를 첫 번째 노드로 설정
			first = nd;
			return;
		}

		while (p != null) { // 2.연결 리스트의 첫 번째 노드부터 시작하여 삽입할 값이 들어갈 위치를 찾습니다. p를 한 칸씩 이동 하며 값을 삽입할 위치를 찾을 때까지
							// 노드를 한 칸씩 이동하며 탐색
			if (element < p.data) { // 2-1 element 값과 현재 노드의 data 값을 비교하여 적절한 위치를 찾을 때까지 계속해서 노드를 이동합니다.
				if (q == first) { // 2-1-1 만약 q가 첫 번째 노드인 경우(q == first) nd를 첫 번째 노드로 설정하고
					nd.link = p; // 2-1-2 nd의 링크를 현재 노드인 p로 설정
					first = nd; // 2-1-3 first를 nd로 업데이트
					return;
				} else { // 2-1-4 q가 첫 번째 노드가 아닌 경우(q != first),
					nd.link = p; // nd를 현재 노드인 p의 앞에 삽입 이를 위해 1) nd의 링크를 p로 설정하고
					q.link = nd; // 2)q의 링크를 nd로 설정 ==> 1)2)를 하면 nd가 p 앞에 삽입되게 됨
					return;
				}
			} else if (element > p.data) { // 2-2 element 값이 현재 노드의 값보다 크다면 q를 p로 이동시키고 p를 다음 노드로 이동시킵니다
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

	public boolean Search(int data) { // 전체 리스트를 순서대로 출력한다.
		return true;
	}
}

public class 정수연결리스트_test {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("출력"), Search("검색"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values()) //values는 m의 enum 0,1,2,3
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
	static Menu SelectMenu() { //p314
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) { //values는 m의 enum 0,1,2,3
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage()); //조건 맞으면 출력하는 함수
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt(); // 정수입력하면
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal()); //Menu.Add.ordinal()
		return Menu.MenuAt(key); // 정수입력하면 해당되는 메뉴 선책 됨
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		Random rand = new Random();
		System.out.println("Linked List");
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		int data = 0;
		System.out.println("inserted");
		l.Show();
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				data = rand.nextInt(20);
				//double d = Math.random();
				//data = (int) (d * 50);
				l.Add(data);
				break;
			case Delete: // 머리 노드 삭제
				data = sc.nextInt();
				int num = l.Delete(data);
				System.out.println("삭제된 데이터는 " + num);
				break;
			case Show: // 꼬리 노드 삭제
				l.Show();
				break;
			case Search: // 회원 번호 검색
				int n = sc.nextInt();
				boolean result = l.Search(n);
				if (result == false)
					System.out.println("검색 값 = " + n + "데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + n + "데이터가 존재합니다.");
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}

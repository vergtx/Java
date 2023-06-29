package 자료구조9장_트리;
/*
 * 23.6.7 3회차 실습 코드
 */
import java.util.Random;
import java.util.Scanner;


//정수를 저정하는 이진트리 만들기 실습
class TreeNode {
	TreeNode LeftChild;
	int data;
	TreeNode RightChild;

	public TreeNode(int x) {
		LeftChild = RightChild = null;
		data = x;//   현재 데이터에 x를 넣어주는 부분을 추가 안해서 오류가 났음 
	}
}

class Tree {
	TreeNode root;

	Tree() {
		root = null;
	}

	TreeNode inorderSucc(TreeNode current) { //중위 순회 방식으로 이진 트리를 탐색할 때 현재 노드의 다음에 방문해야 할 노드를 의미
		// 힌트inorderSucc 이용해서 delet 만들어야함	// 노드의 오른쪽 자식 노드를 찾고, 그 오른쪽 자식 노드의 가장 왼쪽 자식 노드를 찾아서 반환합니다. 이를 통해 중위 후속자를 구할
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}

	boolean isLeafNode(TreeNode current) {
		if (current.LeftChild == null && current.RightChild == null)
			return true;
		else
			return false;
	}

	void inorder() {
		inorder(root);
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}

	void inorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);// 왼쪽 타고 내려감 쭉 타고감
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild); // 왼 쪽 다보고 오른쪽
		}
	}

	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean insert(int x) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을

		TreeNode temp = new TreeNode(x); // 삽입할 값을 가지는 새로운 노드 temp를 생성
		TreeNode p = root; // 현재 노드를 나타내는 포인터 p를 루트 노드로 초기화
		TreeNode q = null; // p의 부모 노드를 기록하는 변수 q를 선언하고 null로 초기화

		if (p == null) { // 트리가 비어있을 경우, 새로운 노드 x를 루트 노드로 설정하고 true를 반환
			//root = new TreeNode(x);
			root = temp;
			return true;
		}
		while (p != null) { // 트리를 탐색하면서 삽입할 위치를 찾는 루프
			q = p; // p를 q에 저장하여 부모 노드를 기록
			if (x < p.data) { // x를 현재 노드 p의 값과 비교하여 ,
				p = p.LeftChild;// x가 작으면 왼쪽 자식 노드로 이동하고
			} else {
				p = p.RightChild; // 크면 오른쪽 자식 노드로 이동
			}
		} // while 루프 내 p가 null이 될 때까지 탐색 // q는 마지막으로 탐색한 노드의 부모 노드를 가리킴
			// q를 이용하여 temp 노드를 q의 자식 노드로 연결
			// 아래는 x 값을 q의 자식 노드로 루프돌며 찾아서 입력하는 if문
		if (x < q.data) { // q 가 부모니까 q의 LeftChild 나 RightChild 에 temp값으로 넣어줄 x를 입력 해줌
			q.LeftChild = temp;
		} else {
			q.RightChild = temp;
		}

		return true;
	}

	boolean delete(int num) {
		return true;

	}

	boolean search(int num) {
		return true;
	}
}

public class Chap9_Test_BinaryTreeInt {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("순차출력"), Exit("종료");

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
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		Tree t = new Tree();
		Menu menu; // 메뉴
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 노드 삽입
				System.out.println("The number of items = ");
				count = stdIn.nextInt();
				int[] input = new int[10];
				for (int ix = 0; ix < count; ix++) {
					input[ix] = rand.nextInt(20);
				}
				for (int i = 0; i < count; i++) {
					if (t.insert(input[i]) == false)
						System.out.println("Insert Duplicated data");
				}
				break;

			case Delete: // 노드 삭제
				System.out.println("삭제할 데이터:: ");
				num = stdIn.nextInt();
				if (t.delete(num) == true)
					System.out.println("삭제 데이터 = " + num + " 성공");
				else
					System.out.println("삭제 실패");
				;
				break;

			case Search: // 노드 검색
				System.out.println("검색할 데이터:: ");

				num = stdIn.nextInt();
				result = t.search(num);
				if (result == true)
					System.out.println(" 데이터 = " + num + "존재합니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				break;
			}
		} while (menu != Menu.Exit);
	}
}

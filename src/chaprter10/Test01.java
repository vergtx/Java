package chaprter10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("서울");
		list.add("부산");
		list.add("창원");
		list.add("서울");
		list.add("울산");
		list.add("밀양");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		list.add("����");
		list.add("�θ�");
		list.add("����");
		list.add("�ϰ�");
		list.add("����");
		list.add("����");
		System.out.println("1 : " + list.toString());

		list.add(1, "LA");
		print(2, list);

		// int indexOf(Object o) / int lastIndexOf(Object o)
		System.out.println("3 : " + list.indexOf("����"));
		System.out.println("4 : " + list.lastIndexOf("����"));

		// boolean remove(Object o)
		list.remove("LA");
		print(5, list);

		// E remove(int index)
		list.remove(2);
		print(6, list);

		// boolean contains(Object o)
		System.out.println("7 : " + list.contains("LA"));

		// Object[] toArray()
		Object obj[] = list.toArray();
		System.out.println("8 : " + Arrays.toString(obj));

		// <T> T[] toArray(T[] a)
		String cities[] = new String[0];
		cities = list.toArray(cities);
		System.out.println("9 : " + Arrays.toString(cities));

		// void clear()
		list.clear();
		print(10, list);

		// boolean isEmpty()
		System.out.println("11: " + list.isEmpty());

		list.add("�ĸ�");
		list.add("����");
		list.add("LA");

		// Arrays Ŭ������ static <T> List<T> asList(T... a)
		List<String> list2 = Arrays.asList("����", "����", "����");
		print(12, list2);

		// boolean addAll(Collection<? extends E> c)
		list.addAll(list2);
		print(13, list);

		// boolean containsAll(Collection<?> c)
		System.out.println("14: " + list.containsAll(list2));

		// boolean retainAll(Collection<?> c)
		list.retainAll(list2);
		print(15, list);

		// boolean removeAll(Collection<?> c)
		list.removeAll(list2);
		print(16, list);
	}

	public static void print(int n, List<String> list) {
		System.out.println(n + " : " + list);
	}
}
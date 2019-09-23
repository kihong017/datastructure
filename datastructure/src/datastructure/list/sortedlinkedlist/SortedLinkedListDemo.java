package datastructure.list.sortedlinkedlist;

public class SortedLinkedListDemo {

	public static void main(String[] args) {
		SortedLinkedList sortedLinkedList = new SortedLinkedList();
		sortedLinkedList.add(0);
		sortedLinkedList.add(30);
		sortedLinkedList.add(10);
		sortedLinkedList.add(20);
		
		System.out.println(sortedLinkedList.toString());
		System.out.println(sortedLinkedList.size());
		System.out.println(sortedLinkedList.get(0));
		System.out.println(sortedLinkedList.get(1));
		System.out.println(sortedLinkedList.get(2));
		System.out.println(sortedLinkedList.get(3));

	}

}

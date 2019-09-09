package datastructure.list.doublylinkedlist;

public class MainMethod {
//	int test1;
//	int test2 = 0;
//	Integer test3;
//	Integer test4 = 0;
//	Integer test5 = Integer.valueOf(0);
//	
//	public void testMethod() {
//		System.out.println(test1);
//		test1++;
//		System.out.println(test2);
//		System.out.println(test3);
//		System.out.println(test4);
//		System.out.println(test5);
//		System.out.println("After = " + test1);
//		System.out.println("After = " + test3);
//	}

	public static void main(String[] args) {
		
//		new MainMethod().testMethod();
		
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		doublyLinkedList.addLast(10);
		doublyLinkedList.addLast(20);
		doublyLinkedList.addLast(30);
		
		DoublyLinkedList.ListIterator i = doublyLinkedList.listIterator();
		i.add(40);
		System.out.println(i.next());
		i.add(50);
		System.out.println(i.next());
		System.out.println(i.next());
		System.out.println(doublyLinkedList);

	}

}

package datastructure.list.linkedlist;

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
		
		LinkedList linkedList = new LinkedList();
		linkedList.addLast(10);
		linkedList.addLast(20);
		linkedList.addLast(30);
		
		LinkedList.ListIterator i = linkedList.listIterator();
		i.add(40);
		System.out.println(i.next());
		i.add(50);
		System.out.println(i.next());
		System.out.println(i.next());
		System.out.println(linkedList);
		

	}

}

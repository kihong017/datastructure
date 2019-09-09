package datastructure.list.arraylist;

public class MainMethod {

	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList();
		
		arrayList.addFirst(10);
		arrayList.addLast(20);
		arrayList.addLast(30);
		arrayList.addLast(40);
		arrayList.addLast(50);
		arrayList.addLast(60);
		arrayList.addFirst(0);
		
		System.out.println(arrayList.toString());
		System.out.println(arrayList.getSize());
		
		arrayList.remove(5);
		
		System.out.println(arrayList.toString());
		System.out.println(arrayList.getSize());
		

	}

}

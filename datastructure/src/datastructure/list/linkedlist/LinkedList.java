package datastructure.list.linkedlist;

public class LinkedList {
	
	private Node head;
	private Node tail;
	private int size = 0;
	private class Node {
		private Object data;
		private Node next;
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		head = newNode;
		size++;
		
		if (null == newNode.next) {
			tail = head;
		}
	}
	
	public void addLast(Object input) {
		Node newNode = new Node(input);
		
		if (size == 0) {
			addFirst(input);
		} else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	Node node(int index) {
		Node x = head;

		for (int i = 0; i < index; i++) {
			x = x.next;
		}
		
		return x;
	}
	
	public void add(int index, Object input) {
		if (index == 0) {
			addFirst(input);
		} else {
			Node oldNode1 = node(index-1);
			Node oldNode2 = oldNode1.next;
			Node newNode = new Node(input);
			
			oldNode1.next = newNode;
			newNode.next = oldNode2;
			size++;
			
			if (null == newNode.next) {
				tail = newNode;
			}
		}
	}
	
	public String toString() {
		String ret = "[";
		Node temp = head;
		
//		for (int i = 0; i < size; i++) {
//			ret += node(i);
//			if (i < size-1) {
//				ret += ", ";
//			}
//		}
		
		while (null != temp.next) {
			ret += temp.data + ", ";
			temp = temp.next;
		}
		
		ret += temp.data;
		return ret + "]";
	}
	
	public Object removeFirst() {
		Node temp = head;
		Node newHead = temp.next;

		Object ret = temp.data;
		
		head.next = null;
		head = newHead;
		
		temp = null;
		size--;
		
		return ret;
	}
	
	public Object removeLast() {
		return remove(size-1);
	}

	public Object remove(int index) {
		
		if (index == 0) {
			return removeFirst();
		} 
		
		Node temp = node(index-1);
		Node toBeRemoved = temp.next;
		
		Object returnData = toBeRemoved.data;
		
		temp.next = temp.next.next;
		toBeRemoved.next = null;
		
		if (tail == toBeRemoved) {
			tail = temp;
		}
		
		toBeRemoved = null;
		size--;
		
		return returnData;
	}
	
	public int size() {
		return size;
	}
	
	public Object get(int index) {
		return node(index).data;
	}
	
	public int indexOf(Object input) {
//		for (int i = 0; i < size; i++) {
//			if (get(i) == input) {
//				return i;
//			}
//		}
//		
//		return -1;
		
		Node temp = head;
		int index = 0;
		
		while (temp.data != input) {
			temp = temp.next;
			index++;
			
			if (temp == null) {
				return -1;
			}
		}
		
		return index;
	}
	
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	public class ListIterator {
		private Node next;		
		private Node lastReturned;
		private int nextIndex;
		
		ListIterator() {
			next = head;
		}
		
		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}
		
		public boolean hasNext() {
			return nextIndex < size();		
		}
		
		public void add(Object input) {
			Node newNode = new Node(input);
			
			if (null == lastReturned) {
				head = newNode;
				newNode.next = next;
			} else {
				lastReturned.next = newNode;
				newNode.next = next;
			}
			
			lastReturned = newNode;
			nextIndex++;
			size++;
		}
		
		public void remove() {
			
			if (0 == nextIndex) {
				throw new IllegalStateException();
			} 
			
			LinkedList.this.remove(nextIndex-1);
			nextIndex--;
			
		}
	}
}

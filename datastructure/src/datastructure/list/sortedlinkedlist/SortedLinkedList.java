package datastructure.list.sortedlinkedlist;

public class SortedLinkedList {
	
	private Node head;
	private Node tail;
	private int size = 0;
	private class Node {
		private Object data;
		private Node next;
		private Node prev
		;
		public Node(Object input) {
			this.data = input;
			this.next = null;
			this.prev = null;
		}
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	Node node(int index) {
		Node x;
		
		if ( index < size/2 ) {
			x = head;
			for (int i = 0; i < index; i++) {
				x = x.next;
			}			
		} else {
			x = tail;
			for (int i = size-1; i > index; i--) {
				x = x.prev;
			}			
		}
		
		return x;
	}
	
	public void add(Object input) {
		Node newNode = new Node(input);
		int index = 0;

		if (null == head) {
			newNode.next = head;
						head = newNode;
			size++;
			
			if (null == newNode.next) {
				tail = head;
			}
		} else {
			Node current = this.head;
			
			while (null != current && null != current.next
					&& (int) current.next.data < (int) newNode.data ) {
				current = current.next;
			}

			newNode.next = current.next;
			current.next = newNode;
			
			newNode.prev = current;
			size++;
			
			if (null != newNode.next) {
				newNode.next.prev  = newNode;
			} else {
				tail = newNode;
			}
		}
	}
	
	public String toString() {
		String ret = "[";
		Node temp = head;
		
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
		
		if (null != head) {
			head.prev = null;
		}
		
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
		
		if (null != temp.next) {
			temp.next.prev = temp;
		}
		
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

}

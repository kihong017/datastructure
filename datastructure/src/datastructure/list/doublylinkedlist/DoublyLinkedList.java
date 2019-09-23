package datastructure.list.doublylinkedlist;

public class DoublyLinkedList {
	
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
	
	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head;
		
		if (null != head) {
			head.prev = newNode;
		}
		
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
			newNode.prev = tail;
			tail = newNode;
			size++;
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
	
	public void add(int index, Object input) {
		if (index == 0) {
			addFirst(input);
		} else if (index == size-1) {
			addLast(input);
		} else {
			Node oldNode1 = node(index-1);
			Node oldNode2 = oldNode1.next;
			Node newNode = new Node(input);
			
			oldNode1.next = newNode;
			newNode.next = oldNode2;
			
			if (null != oldNode2) {
				oldNode2.prev = newNode;
			}
			newNode.prev = oldNode1;
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
		
		public Object previous() {
			if (null == next) {
				lastReturned = next = tail;
			} else {
				lastReturned = next = next.prev;
			}
			
			nextIndex--;
			return lastReturned.data;
		}
		
		public boolean hasPrevious() {
			return nextIndex > 0;	
		}
		
		public void add(Object input) {
			Node newNode = new Node(input);
			
			if (null == lastReturned) {
				head = newNode;
				newNode.next = next;
				next.prev = newNode;
			} else {
				lastReturned.next = newNode;
				newNode.prev = lastReturned;
				if (null != next) {
					newNode.next = next;
					next.prev = newNode;
				} else {
					tail = newNode;
				}
			}
			
			lastReturned = newNode;
			nextIndex++;
			size++;
		}
		
		public void remove() {
			
			if (0 == nextIndex) {
				throw new IllegalStateException();
			}
			
			Node n = lastReturned.next;
			Node p = lastReturned.prev;
			
			// head
			if (null == p) {
				head = n;
				head.prev = null;
				lastReturned = null;
			} else {
				p.next = next;
				lastReturned.prev = null;
			}
			
			// middle
			if (null == n) {
				tail = p;
				tail.next = null;
			} else {
				n.prev = p;
			}
			
			// tail
			if (null == next) {
				lastReturned = tail;
			} else {
				lastReturned = next.prev;
			}
			
			size--;
			nextIndex--;
		}
	}
}

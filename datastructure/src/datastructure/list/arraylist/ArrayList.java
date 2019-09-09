package datastructure.list.arraylist;

public class ArrayList {
	
	private int size = 0;
	private Object[] elementData = new Object[100];
	
	public boolean addLast(Object element) {
		elementData[size] = element;
		size++;
		return true;
	}
	
	public boolean add(int index, Object element) {
		
		for ( int i = size-1; i>=index; i--  ) {
			elementData[i+1] = elementData[i];			
		}
		
		elementData[index] = element;
		size++;
		return true;
	}
	
	public boolean addFirst(Object element) {
		return add(0, element);
	}
	
	public String toString() {
		String str = "[";
		
		for ( int i = 0; i < size; i++ ) {
			str += elementData[i];
			if ( i < size -1 ) {
				str += ", ";
			}
		}
		
		str += "]";
		
		return str;
	}
	
	public Object remove(int index) {
		
		Object removedElement = elementData[index];
		
		for ( int i = index + 1; i <= size - 1; i++ ) {
			elementData[i-1] = elementData[i];
		}		
		
		size--;
		elementData[size] = null;
		
		return removedElement;
	}
	
	public Object removeFirst() {
		return remove(0);
	}
	
	public Object removeLast() {
		return remove(size-1);
	}
	
	public Object get(int index) {
		return elementData[index];
	}
	
	public int getSize() {
		return size;
	}
	
	public int indexOf(Object obj) {
		
		for ( int i = 0; i < size; i++ ) {
			if ( obj.equals(elementData[i])) {
				return i;
			}
		}
		
		return -1;
	}
	
	public ListIterator listIterator() {
		return new ListIterator();
	}
	
	public class ListIterator {
		
		int nextIndex = 0;
		
		public Object next() {
			return elementData[nextIndex++];
		}
		
		public boolean hasNext() {
			return nextIndex < getSize();
		}
		
		public Object previous() {
			return elementData[--nextIndex];
		}
		
		public boolean hasPrevious() {
			return getSize() > 0;
		}
		
		public void add(int index, Object element) {
			ArrayList.this.add(index, element);
		}
		
		public void remove() {
			ArrayList.this.remove(nextIndex-1);
			nextIndex--;
		}
	}
}

package datastructure.stack;

public class Stack {
	
	private Object[] stack = new Object[9];
	private int topIndex = -1;

	public boolean isEmpty() {
		return topIndex < 0;
	}

	public void push(Object inputData) {
		if (topIndex == stack.length-1) {
			throw new RuntimeException("Stack is full");
		} else {
			stack[++topIndex] = inputData;
		}
	}
	
	public Object pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		} else {
			Object lastElement = stack[topIndex];
			stack[topIndex--] = null;
			
			return lastElement;
		}
	}
	
	public Object peek() {
		return stack[topIndex];
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("[");
		for (int i = 0; i <= topIndex; i++) {
			str.append(stack[i]);
			if (i != topIndex) {
				str.append(", ");
			}
		}
		str.append("]");
		
		return str.toString();
	}
	
}

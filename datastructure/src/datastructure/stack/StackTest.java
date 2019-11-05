package datastructure.stack;

public class StackTest {

	public static void main(String[] args) {
		Stack stack = new Stack();
		
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println(stack.toString());
		
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		System.out.println(stack.toString());
		
		stack.push(77);
		stack.push(31);
		System.out.println(stack.toString());
	}

}

package datastructure.list.queue;

public class Queue {
	
	private Object[] queue;
	private int numOfItems = 0;
	private int head = -1;
	private int tail = -1;
	
	public Queue() {
		queue = new Object[5];
	}
	
	public Queue(int size) {
		queue = new Object[size];
	}
	
	public void enqueue(Object input) {
		if (isFull()) {
			new RuntimeException("Queue is full");
		} else if (tail == queue.length-1) {
			tail = -1;
		}
		queue[++tail] = input;
		numOfItems++;
	}
	
	public Object dequeue() {
		if (isEmpty()) {
			new RuntimeException("Queue is empty");
		} else if (head == queue.length-1) {
			head = -1;
		}
		numOfItems--;
		return queue[++head];
	}
	
	public Object peek() {
		return queue[head+1];
	}

	public boolean isFull() {
		return numOfItems == queue.length-1;
	}
	
	public boolean isEmpty() {
		return numOfItems == 0;
	}
	
}

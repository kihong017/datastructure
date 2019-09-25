package datastructure.list.queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue q = new Queue();
		System.out.println(q.isEmpty());
		q.enqueue(5);
		q.enqueue(4);
		q.enqueue(6);
		q.enqueue(10);
		q.enqueue(46);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(2);
		q.enqueue(4);
		q.enqueue(6);
		q.enqueue(8);
		System.out.println(q.dequeue());
		q.enqueue(10);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		q.enqueue(11);
		q.enqueue(12);
		q.enqueue(13);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

	}

}

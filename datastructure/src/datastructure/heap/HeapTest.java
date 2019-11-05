package datastructure.heap;

public class HeapTest {

	public static void main(String[] args) {
		Heap heap = new Heap(10);
		heap.insert(10);
		heap.insert(15);
		heap.insert(27);
		heap.insert(5);
		heap.insert(2);
		heap.insert(21);
		heap.heapSort();
		System.out.println(heap);
		Heap another = Heap.heapify(new int[]{73,16,40,1,46,28,12,21,22,44,66,90,7});
		another.heapSort();
		System.out.println(another);
	}
	
}

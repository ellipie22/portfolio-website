// import static org.junit.*;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;

/**
 * HeapTest class implements tester that will test the methods from heap file
 */
public class HeapTest {

	@Test
	public void testAdd() {
		Comparator<Integer> maxHeapComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		Heap<Integer, String> heap = new Heap<Integer, String>(maxHeapComparator);
		heap.add(25, "0");
		heap.add(50, "0");
		heap.add(55, "0");
		System.out.println(heap.toArray());
		heap.poll();
		heap.poll();
		heap.add(40, "0");
		heap.add(88, "0");
		heap.add(7, "0");
		System.out.println(heap.peek().toString());
		System.out.print(heap.toString());
		System.out.println(heap.toArray());
		assertEquals(4, heap.entries.size());
	}

}
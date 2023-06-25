import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

public class ElementFinder {

	public static int Kth_finder(String filename, int K, String operation) {

		// Create a comparator depending upon the type of operation
		// Heap<Integer, Integer> heap = new Heap<Integer, Integer>(comparator);
		/** TODO **/
		Comparator<Integer> comparatorTrue = findComparator(operation);
		Heap<Integer, Integer> newHeap = new Heap<Integer, Integer>(comparatorTrue);
		File f = new File(filename);
		Scanner sc = null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (sc.hasNextLine()) {
			String[] data = sc.nextLine().split(", ");
			// Add your code here
			for (int i = 0; i < data.length; i++) {
				int Number = Integer.parseInt(data[i]);
				newHeap.add(Number, Number);
			}

		}
		sc.close();

		int result = K;
		while (K > 1) {
			newHeap.poll();
			result--;
		}
		return newHeap.peek().getKey();

	}

	private static Comparator findComparator(String operation) {
		Comparator<Integer> comparator = null;
		if (operation.equals("smallest")) {
			comparator = new Comparator<Integer>() {

				@Override
				public int compare(Integer firstEntry, Integer secondEntry) {
					int results = firstEntry - secondEntry;
					return results;
				}
			};
		} else {
			comparator = new Comparator<Integer>() {

				@Override
				public int compare(Integer firstEntry, Integer secondEntry) {
					int results = firstEntry - secondEntry;
					return results;
				}
			};
		}
		return comparator;
	}
	/* Add any helper methods you find useful */

}

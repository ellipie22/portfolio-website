import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Heap<K extends Comparable<? super K>, V> implements PriorityQueue<K, V> {

	public List<Entry<K, V>> entries;
	public Comparator<K> comparator;

	public Heap(Comparator<K> Comparator) {
		// TODO Auto-generated constructor stub
		entries = new ArrayList<Entry<K, V>>();
		this.comparator = Comparator;
	}

	@Override
	public void add(K k, V v) {
		// TODO Auto-generated method stub
		Entry<K, V> newEntry = new Entry<K, V>(k, v);
		entries.add(newEntry);
		bubbleUp(entries.size());

	}

	@Override
	public Entry<K, V> poll() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (entries.size() == 0) {
			throw new NoSuchElementException("Size is 0");
		}
		Entry<K, V> result = entries.get(0);
		entries.set(0, entries.get(entries.size() - 1));
		entries.remove(entries.size() - 1);
		bubbleDown(0);
		return result;
	}

	@Override
	public Entry<K, V> peek() {
		if (entries.size() == 0) {
			throw new NoSuchElementException("Size is 0");
		}
		return entries.get(0);
	}

	@Override
	public List<Entry<K, V>> toArray() {
		// TODO Auto-generated method stub
		return entries;
	}

	@Override
	public boolean isEmpty() {
		if (entries.size() == 0) {
			return true;
		} else {
			return false;
		}

	}

	public int parent(int index) {

		return (index - 1) / 2;
	}

	public int left(int index) {
		return index * 2 + 1;
	}

	public int right(int index) {
		return index * 2 + 2;
	}

	public void swap(int i1, int i2) {
		Entry<K, V> copy = entries.get(i1);
		entries.set(i1, entries.get(i2));
		entries.set(i2, copy);

	}

	public void bubbleUp(int index) {

	}

	public void bubbleDown(int index) {

	}

	}

	public boolean existsAndGreater(int index1, int index2) {

		if (index1 >= entries.size() || index2 >= entries.size() || index2 < 0 || index1 < 0) {
			return false;
		}
		if (this.comparator.compare(entries.get(index1).getKey(), entries.get(index1).getKey()) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return entries.size();
	}

	@Override
	public String toString() {
		String results = "";
		for (int i = 0; i < entries.size(); i++) {
			results += entries.get(i).toString() + "\n";
		}
		return results;
	}

}

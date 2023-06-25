import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyHashMap<K, V> implements DefaultMap<K, V> {
	public static final double DEFAULT_LOAD_FACTOR = 0.75;
	public static final int DEFAULT_INITIAL_CAPACITY = 16;
	public static final String ILLEGAL_ARG_CAPACITY = "Initial Capacity must be non-negative";
	public static final String ILLEGAL_ARG_LOAD_FACTOR = "Load Factor must be positive";
	public static final String ILLEGAL_ARG_NULL_KEY = "Keys must be non-null";

	private double loadFactor;
	private int capacity;
	private int size;

	// Use this instance variable for Separate Chaining conflict resolution
	private List<HashMapEntry<K, V>>[] buckets;

	// Use this instance variable for Linear Probing
	private HashMapEntry<K, V>[] entries;

	public MyHashMap() {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	/**
	 * 
	 * @param initialCapacity the initial capacity of this MyHashMap
	 * @param loadFactor      the load factor for rehashing this MyHashMap
	 * @throws IllegalArgumentException if initialCapacity is negative or loadFactor
	 *                                  not positive
	 */
	@SuppressWarnings("unchecked")
	public MyHashMap(int initialCapacity, double loadFactor) throws IllegalArgumentException {
		// TODO Finish initializing instance fields
		if (initialCapacity < 0 || loadFactor <= 0) {

			throw new IllegalArgumentException("invalid capacity or loadFactor");

		}
		// if you use Separate Chaining
		capacity = initialCapacity;
		this.loadFactor = loadFactor;

		buckets = (List<HashMapEntry<K, V>>[]) new List<?>[capacity];

		// if you use Linear Probing
		entries = (HashMapEntry<K, V>[]) new HashMapEntry<?, ?>[initialCapacity];
	}

	@Override
	public boolean put(K key, V value) throws IllegalArgumentException {
		// can also use key.hashCode() assuming key is not null

		if (key == null) {
			throw new IllegalArgumentException("null key");
		}
		int keyHash = Objects.hashCode(key);
		System.out.println(keyHash);

		int index = (keyHash % buckets.length);
		if (index < 0) {
			index = index * -1;
		}
		System.out.println(index);
		System.out.println(capacity);
		if ((size / capacity) > loadFactor) {
			ExpandCapacity();
		}
		HashMapEntry test = new HashMapEntry(key, value);
		if (buckets[index] == null) {
			System.out.println("creating list");
			List<MyHashMap.HashMapEntry<K, V>> myList = new ArrayList<HashMapEntry<K, V>>();
			myList.add(test);

			buckets[index] = myList;

			size++;
			return true;
		} else {
			List myList = buckets[index];
			myList.add(test);
			buckets[index] = myList;
			size++;
			return true;
		}

		// TODO Auto-generated method stub

	}

	private void ExpandCapacity() {
		// TODO Auto-generated method stub

		List<HashMapEntry<K, V>>[] oldBuckets;
		capacity = capacity * 2;
		oldBuckets = this.buckets;

		this.size = 0;
		for (int i = 0; i < oldBuckets.length; i++) {
			for (int j = 0; j < oldBuckets[i].size(); j++) {
				this.set(oldBuckets[i].get(j).key, oldBuckets[i].get(j).value);
			}
		}
	}

	@Override
	public boolean replace(K key, V newValue) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new IllegalArgumentException("null key");
		}
		int keyHash = Objects.hashCode(key);
		int index = (keyHash % buckets.length);
		if (index < 0) {
			index = index * -1;
		}
		if (!buckets[index].isEmpty()) {
			remove(key);
			put(key, newValue);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new IllegalArgumentException("null key");
		}
		int keyHash = Objects.hashCode(key);
		int index = (keyHash % buckets.length);
		if (index < 0) {
			index = index * -1;
		}
		boolean result;
		if (buckets[index] != null) {
			if (buckets[index].size() > 0) {
				result = true;
			} else {
				result = false;
			}
			size = size - buckets[index].size();

			List myList = null;
			buckets[index] = myList;
		} else {
			result = false;
		}

		return result;
	}

	@Override
	public void set(K key, V value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new IllegalArgumentException("null key");
		}
		int keyHash = Objects.hashCode(key);
		int index = (keyHash % buckets.length) * -1;
		if (buckets[index] != null) {
			for (int i = 0; i < buckets[index].size(); i++) {
				if (buckets[index].get(i).key == key) {
					buckets[index].get(i).value = value;
				}
			}
		} else {
			this.put(key, value);

		}
	}

	@Override
	public V get(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new IllegalArgumentException("null key");
		}
		int keyHash = Objects.hashCode(key);
		int index = (keyHash % buckets.length) * -1;
		if (buckets[index] != null) {
			for (int i = 0; i < buckets[index].size(); i++) {
				if (buckets[index].get(i).key == key) {
					return buckets[index].get(i).value;
				}
			}

		}

		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub

		if (size == 0) {

			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean containsKey(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new IllegalArgumentException("null key");
		}

		List<K> keyList = new ArrayList<K>();
		keyList = this.keys();
		if (keyList.contains(key)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public List<K> keys() {
		// TODO Auto-generated method stub
		List<K> keyList = new ArrayList<K>();
		for (int i = 0; i < capacity; i++) {
			if (buckets[i] != null) {
				keyList.add(buckets[i].get(0).key);
				System.out.println("key added");
			}

		}
		return keyList;
	}

	private static class HashMapEntry<K, V> implements DefaultMap.Entry<K, V> {

		K key;
		V value;

		private HashMapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public void setValue(V value) {
			this.value = value;
		}
	}
}

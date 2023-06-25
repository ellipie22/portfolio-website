import java.util.ArrayList;
import java.util.List;

/**
 * File header Author: Pierre Ellie This is the BST.java file, this file is the
 * implementation of a binary search tree it contains methods used for adding,
 * searching through, and removing nodes, which have values and keys in a tree
 * that can be accessed.
 * 
 * 
 * @param <K> The type of the keys of this BST. They need to be comparable by
 *            nature of the BST "K extends Comparable" means that BST will only
 *            compile with classes that implement Comparable interface. This is
 *            because our BST sorts entries by key. Therefore keys must be
 *            comparable.
 * @param <V> The type of the values of this BST.
 */
public class BST<K extends Comparable<? super K>, V> implements DefaultMap<K, V> {
	/*
	 * TODO: Add instance variables You may add any instance variables you need, but
	 * you may NOT use any class that implements java.util.SortedMap or any other
	 * implementation of a binary search tree
	 */
	private int size = 0;
	private Node<K, V> topRoot;

	@Override
	public boolean put(K key, V value) throws IllegalArgumentException {
		// TODO Auto-generated method stub

		if (key == null) {
			throw new IllegalArgumentException("null key value");
		}
		if (containsKey(key)) {

			return false;
		}
		boolean result = false;
		Node<K, V> addNode = new Node<K, V>(key, value);

		if (size == 0) {
			size++;
			topRoot = addNode;
			result = true;
			return result;
		}

		Node<K, V> pointNode = null;
		Node<K, V> curNode = topRoot;

		while (curNode != null) {
			if (curNode.getKey().compareTo(addNode.getKey()) > 0) {

				pointNode = curNode;
				curNode = curNode.left;
			} else if (curNode.getKey().compareTo(addNode.getKey()) < 0) {

				pointNode = curNode;
				curNode = curNode.right;

			}
		}
		if (addNode.getKey().compareTo(pointNode.getKey()) < 0) {
			pointNode.setLeft(addNode);

			size++;
			result = true;
		} else if (addNode.getKey().compareTo(pointNode.getKey()) >= 0) {

			pointNode.setRight(addNode);

			size++;
			result = true;
		}
		return result;
	}

	@Override
	public boolean replace(K key, V newValue) throws IllegalArgumentException {
		if (key == null) {
			throw new IllegalArgumentException("null key value");
		}
		boolean result = false;
		Node<K, V> addNode = new Node<K, V>(key, newValue);

		if (size == 0) {
			return result;
		}
		Node<K, V> pointNode = null;
		Node<K, V> curNode = topRoot;

		while (curNode != null) {
			if (curNode.getKey().compareTo(addNode.getKey()) < 0) {
				pointNode = curNode;
				curNode = curNode.left;
			} else if (curNode.getKey().compareTo(addNode.getKey()) > 0) {
				pointNode = curNode;
				curNode = curNode.right;
			} else if (curNode.getKey().compareTo(addNode.getKey()) == 0) {

				if (newValue == null) {
					curNode.value = null;
					result = true;
					return result;
				} else {
					curNode.value = newValue;
					result = true;
					return result;
				}
			}

		}

		return result;
	}

	@Override
	public boolean remove(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new IllegalArgumentException("null key value");
		}
		boolean result = false;

		if (size == 0) {
			return result;
		}
		Node<K, V> pointNode = null;
		Node<K, V> curNode = topRoot;
		if (containsKey(key) == false) {
			System.out.println("not found1");
			return false;
		}
		while (curNode != null && curNode.getKey() != key) {
			if (curNode.getKey().compareTo(key) > 0) {
				if (pointNode != topRoot && pointNode != null) {
					System.out.println("moving from " + pointNode.value + " to " + curNode.value);
				}

				pointNode = curNode;
				curNode = curNode.left;

			} else if (curNode.getKey().compareTo(key) < 0) {
				if (pointNode != topRoot && pointNode != null) {
					System.out.println("moving from " + pointNode.value + " to " + curNode.value);
				}
				pointNode = curNode;
				curNode = curNode.right;

			}
		}
		if (curNode == null) {
			System.out.println("not found2");
			result = false;
			return result;
		}
		if (curNode.key == key) {
			// System.out.println("removal found at " + curNode.value + " child of " +
			// pointNode.value + " right is "
			// + pointNode.right.value + " left is " + pointNode.left.value);
			if (curNode.left == null && curNode.right == null) {
				// System.out.println("no children");
				if (pointNode.right == curNode) {
					pointNode.right = null;
				} else if (pointNode.left == curNode) {
					pointNode.left = null;
				} else {
					topRoot = null;
				}
				size--;
				result = true;
			} else if (curNode.left == null) {
				// System.out.println("right child");
				if (curNode != topRoot) {
					curNode.value = curNode.right.value;
					curNode.key = curNode.right.key;
					curNode.right = null;
				} else if (curNode == topRoot) {
					topRoot = curNode.right;
				}
				// System.out.println(curNode.value);
				size--;

				result = true;
			} else if (curNode.right == null) {
				System.out.println("left child");
				if (curNode != topRoot) {
					curNode.value = curNode.left.value;
					curNode.key = curNode.left.key;
					curNode.left = null;
				} else if (curNode == topRoot) {
					topRoot = curNode.left;
				}
				size--;
				result = true;

			} else {
				System.out.println("double child");
				Node<K, V> newNode = minNode(curNode.right);
				remove(newNode.key);
				System.out.println(newNode.value);
				System.out.println(curNode.value);

				curNode.key = newNode.key;
				curNode.value = newNode.value;
				System.out.println(curNode.left.value);
				pointNode.left = curNode;
				System.out.println("changed");
			}
		}

		return result;

	}

	private Node<K, V> minNode(Node<K, V> start) {

		Node<K, V> pointNode = null;
		Node<K, V> curNode = start;
		Node<K, V> minNode = curNode;

		while (curNode.left != null) {
			minNode = curNode.left;
			pointNode = curNode;
			curNode = curNode.left;
		}
		return minNode;
	}

	@Override
	public void set(K key, V value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new IllegalArgumentException("null key value");
		}
		if (containsKey(key)) {
			replace(key, value);
		}
		put(key, value);
	}

	@Override
	public V get(K key) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (key == null) {
			throw new IllegalArgumentException("null key value");
		}

		if (containsKey(key)) {
			// System.out.println("contains key");
			Node<K, V> pointNode = null;
			Node<K, V> curNode = topRoot;
			while (curNode != null) {
				if (key.compareTo(curNode.getKey()) == 0) {
					return curNode.getValue();
				} else if (key.compareTo(curNode.getKey()) < 0) {
					curNode = curNode.left;
				} else {
					curNode = curNode.right;
				}
			}

		}
		return null;
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean isEmpty() {

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
			throw new IllegalArgumentException("null key value");
		}
		Node<K, V> pointNode = null;
		Node<K, V> curNode = topRoot;

		while (curNode != null) {
			if (curNode.getKey().compareTo(key) > 0) {
				pointNode = curNode;
				curNode = curNode.left;
			} else if (curNode.getKey().compareTo(key) < 0) {
				pointNode = curNode;
				curNode = curNode.right;
			} else if (curNode.getKey().compareTo(key) == 0) {
				return true;
			}
		}
		return false;
	}

	// Keys must be in ascending sorted order
	// You CANNOT use Collections.sort() or any other sorting implementations
	// You must do inorder traversal of the tree
	@Override
	public List<K> keys() {
		// TODO Auto-generated method stub
		List<K> results = new ArrayList<K>();
		Node<K, V> curNode = topRoot;
		results = addList(results, curNode);

		return results;
	}

	private List<K> addList(List<K> currentList, Node<K, V> currentNode) {
		// System.out.println("running addList");
		if (currentNode != null) {
			// System.out.println(currentNode.value + " is parent of left " +
			// currentNode.leftNode().value
			// + " is parent of right " + currentNode.rightNode().value);
			addList(currentList, currentNode.leftNode());
			currentList.add(currentNode.key);
			addList(currentList, currentNode.rightNode());
		}

		return currentList;
	}

	private static class Node<K extends Comparable<? super K>, V> implements DefaultMap.Entry<K, V> {

		V value;
		K key;
		Node<K, V> left;
		Node<K, V> right;

		public Node(K key, V value) {
			this.value = value;
			this.key = key;

		}
		/*
		 * TODO: Add instance variables
		 */

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return this.key;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return this.value;
		}

		@Override
		public void setValue(V value) {
			// TODO Auto-generated method stub
			this.value = value;
		}

		public Node<K, V> leftNode() {
			return this.left;
		}

		public void setLeft(Node<K, V> node) {
			this.left = node;
		}

		public Node<K, V> rightNode() {
			return this.right;
		}

		public void setRight(Node<K, V> node) {
			this.right = node;
		}

	}

}
public class LinkedGL<E> implements MyList<E> {

	class Node {
		E value;
		Node next;

		public Node(E value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	Node front;
	int size;

	public LinkedGL(E[] contents) {
		// Fill in this constructor
		this.front = new Node(null, null);
		int index = 0;

		for (int i = 0; i < contents.length; i++) {
			Node curNode = front;
			while (curNode.next != null) {
				curNode = curNode.next;
			}
			curNode.next = new Node(contents[index], null);
			curNode = curNode.next;

			index++;
			size += 1;

		}

	}

	@Override
	public E[] toArray() {

		E[] temp = (E[]) new Object[size];

		Node curNode = front.next;
		for (int i = 0; i < size; i++) {
			if (curNode.value != null) {
				temp[i] = curNode.value;
				curNode = curNode.next;
			} else {
				curNode = curNode.next;
			}

		}

		return temp;
	}

	@Override
	public void transformAll(MyTransformer mt) {

		Node curNode = front.next;
		for (int i = 0; i < size; i++) {
			if (curNode.value != null) {
				curNode.value = (E) mt.transformElement(curNode.value);
				curNode = curNode.next;
			} else {
				curNode = curNode.next;
			}
		}

	}

	@Override
	public void chooseAll(MyChooser mc) {
		if (size != 0) {
			Node curNode = front.next;

			for (int i = 0; i < size + 1; i++) {

				if (mc.chooseElement(curNode.value) == true) {

					curNode = curNode.next;
				} else if (mc.chooseElement(curNode.value) == false) {

					int index = i;

					curNode = front;
					for (int j = 0; j < index; j++) {
						curNode = curNode.next;
					}
					if (curNode.next != null) {
						curNode.next = curNode.next.next;
						size -= 1;
						curNode = curNode.next;

					} else {
						curNode.next = null;
						size -= 1;
					}

				} else {
					curNode = curNode.next;
				}

			}
		}
	}

	@Override
	public boolean isEmpty() {

		Node curNode = front;
		if (curNode.next == null) {
			return true;
		}
		return false;
	}

	// Fill in all methods

}
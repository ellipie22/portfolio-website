public class ArrayGL<E> implements MyList<E> {

	E[] elements;
	int size;

	public ArrayGL(E[] initialElements) {
		this.elements = initialElements;
		this.size = initialElements.length;
	}

	// Fill in all required methods here
	@Override
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public E[] toArray() {
		E[] temp = (E[]) new Object[size];

		for (int i = 0; i < this.size; i++) {
			if (elements[i] != null) {
				temp[i] = elements[i];
			}

		}

		return temp;
	}

	@Override
	public void transformAll(MyTransformer mt) {

		for (int i = 0; i < this.size; i++) {
			if (elements[i] != null) {
				elements[i] = (E) mt.transformElement(elements[i]);
			}

		}

	}

	@Override
	public void chooseAll(MyChooser mc) {
		if (size != 0) {

			E[] temp = (E[]) new Object[size];
			int tempSize = 0;

			for (int i = 0; i < this.size; i++) {

				if (elements[i] != null) {
					if (mc.chooseElement(elements[i]) == true) {
						temp[tempSize] = elements[i];
						tempSize++;

					}

				}
			}

			for (int j = 0; j < this.size; j++) {
				elements[j] = null;
			}
			this.size = 0;
			int index = 0;
			while (temp[index] != null) {
				elements[index] = temp[index];
				index++;
				size++;
			}

		}
	}
}
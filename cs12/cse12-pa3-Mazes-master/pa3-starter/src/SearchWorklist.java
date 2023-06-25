
/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */
import java.util.ArrayList;
import java.util.Stack;

class StackWorklist implements SearchWorklist {
	Stack<Square> stack = new Stack<Square>();

	@Override
	public void add(Square c) {

		stack.push(c);
	}

	@Override
	public Square remove() {
		// System.out.println("in remove command : " + stack.peek());
		Square removed = stack.pop();

		return removed;
	}

	@Override
	public boolean isEmpty() {
		if (stack.size() == 0) {
			return true;
		}
		return false;
	}
}

class QueueWorklist implements SearchWorklist {
	ArrayList<Square> queue = new ArrayList<Square>();

	@Override
	public void add(Square c) {
		queue.add(c);
		System.out.println("queue is now" + queue.toString());

	}

	@Override
	public Square remove() {
		Square removed = queue.get(0);
		// System.out.println("giving :" + queue.peek() + " with prev :" +
		// queue.peek().getPrevious());
		// System.out.println("current queue" + queue.toString());

		queue.remove(0);
		System.out.println("queue is now" + queue.toString());
		return removed;
	}

	@Override
	public boolean isEmpty() {
		if (queue.isEmpty() == true) {
			return true;
		}
		return false;
	}
}

public interface SearchWorklist {
	void add(Square c);

	Square remove();

	boolean isEmpty();
}

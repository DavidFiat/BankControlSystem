package datastructure;

public class Stack<P> implements IStack<P> {

	private int size;
	private NodeList<P> top;

	public Stack() {

	}

	@Override
	public P top() {
		return top.getInfo();
	}

	@Override
	public P pop() {
		P elem = null;
		if (!isEmpty()) {
			elem = top.getInfo();
			if (top.getNext() != null) {
				top.getNext().setPrev(null);

			} else {
				top = null;

			}
			if (top != null) {
				top = top.getNext();
			}
			size--;
		}

		return elem;
	}

	@Override
	public void push(P element) {
		NodeList<P> elem = new NodeList<>(element);
		if (isEmpty()) {
			top = elem;
		} else {
			elem.setNext(top);
			top.setPrev(elem);
			top = elem;
		}
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

}

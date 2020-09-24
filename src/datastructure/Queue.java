package datastructure;

public class Queue<E> implements IQueue<E> {

	private int size;
	private NodeList<E> front;
	private NodeList<E> rear;

	public Queue() {
	}

	@Override
	public void enqueue(E element) {
		NodeList<E> elem = new NodeList<>(element);
		if (isEmpty()) {
			rear = elem;
			front = elem;
		} else {
			elem.setNext(rear);
			rear.setPrev(elem);
			rear = elem;
		}
		size++;
	}

	@Override
	public E dequeue() {
		E elem = null;
		if (!isEmpty()) {
			elem = front.getInfo();
			if (front.getPrev() != null) {
				front.getPrev().setNext(null);

			} else {
				rear = null;

			}
			front = front.getPrev();
			size--;
		}

		return elem;
	}

	@Override
	public E front() {
		E elem = null;
		if (!isEmpty()) {
			elem = front.getInfo();
		}
		return elem;
	}

	@Override
	public boolean isEmpty() {
		return front == null;
	}

	@Override
	public int size() {
		return size;
	}

}

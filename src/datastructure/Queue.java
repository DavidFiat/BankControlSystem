package datastructure;

public class Queue<E> implements IQueue<E> {

	private int size;
	private NodeList<E> front;
	private NodeList<E> rear;

	public Queue() {
		this.size = 0;
	}

	@Override
	public void enqueue(E element) {
		NodeList<E> elem = new NodeList<>(element);
		if (rear == null) {
			rear = elem;
			front = elem;
		}

	}

	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E front() {
		return front.getInfo();
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

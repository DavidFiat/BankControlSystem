package datastructure;

public class Heap<H extends Comparable<H>> implements IHeap<H> {

	public final static int CAPACITY = 100;
	private H[] elements;
	private int heapSize;

	public Heap() {
		elements = (H[]) new Object[CAPACITY];
		heapSize = 0;
	}

	public void heapify(int i) {
		int l = Left(i);
		int r = Right(i);
		int largest = i;
		if (l <= heapSize && elements[l].compareTo(elements[i]) > 0) {
			largest = l;
		}
		if (r <= heapSize && elements[r].compareTo(elements[largest]) > 0) {
			largest = r;
		}
		if (largest != i) {
			H temp = elements[i];
			elements[i] = elements[largest];
			elements[largest] = temp;
			heapify(largest);

		}
	}

	public int length() {
		return elements.length;
	}

	public int getHeapSize() {
		return heapSize;
	}

	public int Left(int i) {
		return (i * 2);
	}

	public int Right(int i) {
		return (i * 2 + 1);
	}

	public H[] getelements() {
		return elements;
	}

	public void buildHeap() {
		for (int i = (int) Math.floor(heapSize / 2); i >= 1; i--) {
			heapify(i);
		}
	}

	public void heapSort() {
		buildHeap();
		for (int i = elements.length - 1; i >= 2; i--) {
			H temp = elements[1];
			elements[1] = elements[i];
			elements[i] = temp;
			heapSize = heapSize - 1;
			heapify(1);
		}
	}
}

package datastructure;

import java.util.List;

public class Heap<H extends Comparable<H>> implements IHeap<H> {

	public final static int CAPACITY = 100;
	private H[] elements;
	private static int heapSize;

	public Heap() {
		elements = (H[]) new Object[CAPACITY];
		heapSize = 0;
	}

	public void heapify(int i) {
		int l = left(i);
		int r = right(i);
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

	public static int left(int i) {
		return (i * 2);
	}

	public static int right(int i) {
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

	@SuppressWarnings("unchecked")
	public static void heapSort(List list) {
		buildHeapStatic(list);
		for (int i = list.size() - 1; i >= 2; i--) {
			Object temp = list.get(1);
			list.set(1, list.get(i));
			list.set(i, temp);

			heapSize = heapSize - 1;
			heapifyStatic(1, list);
		}
	}

	public static void buildHeapStatic(List list) {
		for (int i = (int) Math.floor(heapSize / 2); i >= 1; i--) {
			heapifyStatic(i, list);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void heapifyStatic(int i, List list) {
		int l = left(i);
		int r = right(i);
		int largest = i;
		if (l <= heapSize && ((Comparable) list.get(l)).compareTo(list.get(i)) > 0) {
			largest = l;
		}
		if (r <= heapSize && ((Comparable) list.get(r)).compareTo(list.get(largest)) > 0) {
			largest = r;
		}
		if (largest != i) {
			Object temp = list.get(i);
			list.set(i, list.get(largest));
			list.set(largest, temp);
			heapifyStatic(largest, list);

		}
	}

	@Override
	public void insert(H element) {

		int a = heapSize;
		int father = (heapSize - 1) / 2;
		H fathe = null;

		if (a == elements.length) {
			Object[] tmp = new Object[elements.length + 10];
			for (int i = 0; i < elements.length; i++) {
				tmp[i] = elements[i];
			}
			elements = (H[]) tmp;
		}

		elements[a] = element;
		if (father >= 0)
			fathe = elements[father];
		while ((a > 0) && element.compareTo(fathe) < 0) {
			elements[a] = (H) fathe;
			a = father;
			father = (a - 1) / 2;
			if (father >= 0)
				fathe = elements[father];
		}
		elements[a] = element;
		heapify(a);
		heapSize++;

	}

	public void attend() {
		int last = heapSize - 1;

		if (last != 0) {
			elements[0] = elements[last];
		}

		heapSize--;
		heapify(left(last));
	}

}

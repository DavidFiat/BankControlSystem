package datastructure;

public interface IHeap<H> {

	public void heapify(int i);

	public void buildHeap();

	public void heapSort();

	public void insert(H element);

	public void attend();
}

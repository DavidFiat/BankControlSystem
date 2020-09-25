package datastructure;

public interface IStack<S> {

	public S top();

	public S pop();

	public void push(S element);

	public int size();

	public boolean isEmpty();
}

package datastructure;

public class NodeList<A> {

	private A info;
	private NodeList<A> next;
	private NodeList<A> prev;

	NodeList(A info) {
		this.info = info;
	}

	public A getInfo() {
		return info;
	}

	public NodeList<A> getNext() {
		return next;
	}

	public void setNext(NodeList<A> next) {
		this.next = next;
	}

	public NodeList<A> getPrev() {
		return prev;
	}

	public void setPrev(NodeList<A> prev) {
		this.prev = prev;
	}

}

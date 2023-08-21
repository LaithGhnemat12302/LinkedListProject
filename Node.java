package application;

public class Node<E extends Comparable<E>> {
	private E data;
	Node<E> next;
	// ___________________________________________________________________________________________//
	public Tawjihi student;

	public Node(E data) {
		super();
		this.data = data;
	}
	// ___________________________________________________________________________________________//

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}
	// ___________________________________________________________________________________________//

	@Override
	public String toString() {
		return "-->[" + data + "] ";
	}
}
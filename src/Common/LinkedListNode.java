package Common;

public class LinkedListNode<T> {
	private T value;
	private LinkedListNode<T> next;
	public LinkedListNode() {
		// TODO Auto-generated constructor stub
		next = null;
	}
	public LinkedListNode(T value) {
		this.value = value;
		this.next = null;
	}
	public LinkedListNode(T value, LinkedListNode<T> node) {
		this.value = value;
		this.next = node;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public LinkedListNode<T> getNext() {
		return next;
	}
	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}
	
}

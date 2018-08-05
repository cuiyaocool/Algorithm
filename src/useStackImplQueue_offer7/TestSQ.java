package useStackImplQueue_offer7;

public class TestSQ {
	public static void main(String[] args) {
		_2stacksImplQueue queue = new _2stacksImplQueue();
		queue.put(9);
		queue.put(3);
		System.out.println(queue.get());
		queue.put(5);
		queue.put(2);
		System.out.println(queue.get());
	}

}

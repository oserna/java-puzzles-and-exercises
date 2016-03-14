package datatype.collections.linkedlists;

public class LinkedList<T> {

	public Element<T> head;
	public Element<T> tail;
	
	public void add(Element<T> newElement) {
		if (head == null) {
			head = newElement;
			tail = head;
		} else {
			tail.next = newElement;
			tail = newElement;
		}
	}
	
	public static class Element<T> {
		
		T value;
		Element<T> next;
		
		public Element(T value) {
			super();
			this.value = value;
		}
		
	}
}

package datatype.collections.linkedlists;

import org.junit.Test;

import datatype.collections.linkedlists.LinkedList.Element;

public class ReverseLinkedList {
	
	@Test
	public void testReverseLinkedList() {

		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(new LinkedList.Element<Integer>(1));
		linkedList.add(new LinkedList.Element<Integer>(3));
		linkedList.add(new LinkedList.Element<Integer>(5));
		linkedList.add(new LinkedList.Element<Integer>(7));
		linkedList.add(new LinkedList.Element<Integer>(9));
		linkedList.add(new LinkedList.Element<Integer>(11));
		linkedList.add(new LinkedList.Element<Integer>(13));
		linkedList.add(new LinkedList.Element<Integer>(15));
		linkedList.add(new LinkedList.Element<Integer>(17));
		linkedList.add(new LinkedList.Element<Integer>(19));
		linkedList.add(new LinkedList.Element<Integer>(21));
		
		LinkedList<Integer> reversed = reverse(linkedList);
		
	}

	private LinkedList<Integer> reverse(LinkedList<Integer> list) {
		
		Element<Integer> aux = new Element<Integer>(0);
		Element<Integer> previous = null;
		Element<Integer> current = list.head;
		
		aux.next = current.next;
		current.next = null;
		previous = current;
		list.tail = previous;
		
		while ((current = aux.next) != null) {
			
			aux.next = current.next;
			current.next = previous;
			previous = current;
			
		}
		
		list.head = previous;
		return list;
		
	}
	

}

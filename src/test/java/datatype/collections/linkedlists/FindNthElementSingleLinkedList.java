package datatype.collections.linkedlists;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import datatype.collections.linkedlists.LinkedList.Element;

public class FindNthElementSingleLinkedList {
	
	@Test
	public void testFindNthElementInSingleLinkedList() {

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

		Element<Integer> nthElementToEnd2 = getNthElementToEnd(linkedList, 4);		
		assertTrue(nthElementToEnd2.value == 15);

		nthElementToEnd2 = getNthElementToEnd(linkedList, 3);		
		assertTrue(nthElementToEnd2.value == 17);

		nthElementToEnd2 = getNthElementToEnd(linkedList, 1);		
		assertTrue(nthElementToEnd2.value == 21);

	}
	
	/**
	 * The idea is to use two pointers. The second one starts when the number n has been reached so
	 * it will be a difference of n elements between them for ever. When the first pointer reachs the
	 * end, the second one is n elements behind
	 * 
	 * @param linkedList
	 * @param n
	 * @return
	 */
	private Element<Integer> getNthElementToEnd(LinkedList<Integer> linkedList, int n) {

		LinkedList.Element<Integer> target = linkedList.head;
		LinkedList.Element<Integer> current =  linkedList.head;
		int counter = 1;
		while ((current = current.next) != null) {
		
			if (counter >= n) {
				target = target.next;
			}
			
			counter++;
		}
		
		return target;
		
	}
	
	

}

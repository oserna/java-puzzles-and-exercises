package collections;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

import collections.LinkedListTest.LinkedList.Node;

public class LinkedListTest {

	//--------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------------- SWAP EVERY TWO NODES ---------------------------------------------------------------------------------
	
	/*
	 * L1 1 2 3 4 5 6
	 * R  2 1 4 3 6 5
	 */
	@Test
	public void testSwapEveryNodes() {
		
		LinkedList linkedList = new LinkedList();
		linkedList.add(new LinkedList.Node("1"));
		linkedList.add(new LinkedList.Node("2"));
		linkedList.add(new LinkedList.Node("3"));
		linkedList.add(new LinkedList.Node("4"));
		linkedList.add(new LinkedList.Node("5"));
		linkedList.add(new LinkedList.Node("6"));

		Node current = linkedList.head.next;
		Node previous = linkedList.head;
		while(current.next != null){
				current = current.next;
				previous = current;
			
				
			
		}
		
	}
	
	
	
	//--------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------------- MOVE LAST NODE TO FIRST ---------------------------------------------------------------------------------
	
	@Test
	public void testMoveLastNodeToFirst() {
		
		LinkedList linkedList = new LinkedList();
		linkedList.add(new LinkedList.Node("1"));
		linkedList.add(new LinkedList.Node("2"));
		linkedList.add(new LinkedList.Node("3"));
		linkedList.add(new LinkedList.Node("4"));
		linkedList.add(new LinkedList.Node("5"));
		linkedList.add(new LinkedList.Node("6"));
		
		moveLastToFirstRecursive(linkedList.head, linkedList.head, linkedList.head.next);
		
		assertEquals("6", linkedList.head.next.data);
		
		linkedList = new LinkedList();
		linkedList.add(new LinkedList.Node("1"));
		linkedList.add(new LinkedList.Node("2"));
		linkedList.add(new LinkedList.Node("3"));
		linkedList.add(new LinkedList.Node("4"));
		linkedList.add(new LinkedList.Node("5"));
		linkedList.add(new LinkedList.Node("6"));
		
		moveLastToFirstIterative(linkedList);
		
		assertEquals("6", linkedList.head.next.data);
	}
	
	private void moveLastToFirstRecursive(Node first, Node previous, Node currentNode){
		if(currentNode.next() == null){
			previous.setNext(null);
			currentNode.next = first.next;
			first.setNext(currentNode);
			return;
		}
		moveLastToFirstRecursive(first, currentNode, currentNode.next);
	}
	
	private void moveLastToFirstIterative(LinkedList linkedList){
		
		Node previous = null;
		Node current = linkedList.head;
		while(current.next != null){
			previous = current;
			current = current.next;
		}
		
		previous.setNext(null);
		current.next = linkedList.head.next;
		linkedList.head.next = current;
		
	}
	
	
	
	//--------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------------- LOOP IN LINKED LIST ---------------------------------------------------------------------------------
	
	@Test
	public void testFindTheLoop() {
		LinkedList linkedList = new LinkedList();
		linkedList.add(new LinkedList.Node("1"));
		Node two = new LinkedList.Node("2");
		linkedList.add(two);
		linkedList.add(new LinkedList.Node("3"));
		linkedList.add(new LinkedList.Node("4"));
		linkedList.add(new LinkedList.Node("5"));
		linkedList.add(new LinkedList.Node("6"));
		linkedList.add(new LinkedList.Node("7"));
		linkedList.add(two);
		
		hasLoop(linkedList.head);
	}
	
	private boolean hasLoop(Node head){
		Node slow = head;
		Node fast = slow.next;
		while(true){
			if(fast == null || fast.next == null){
				return false;
			}
			if(slow.data.equals(fast.data) || fast.next().data.equals(slow.data)){
				return true;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
	}
	
	
	//--------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------------- REVERSE ---------------------------------------------------------------------------------
	
	@Test
	public void testReverseOrder() {
		LinkedList linkedList = new LinkedList();
		linkedList.add(new LinkedList.Node("1"));
		linkedList.add(new LinkedList.Node("2"));
		linkedList.add(new LinkedList.Node("3"));
		linkedList.add(new LinkedList.Node("4"));
		linkedList.add(new LinkedList.Node("5"));
		linkedList.add(new LinkedList.Node("6"));
		linkedList.add(new LinkedList.Node("7"));
		linkedList.add(new LinkedList.Node("8"));
		linkedList.add(new LinkedList.Node("9"));
		
		LinkedList reversed = new LinkedList();
		reverseRecursiveEasier(linkedList.head, reversed);
		
		linkedList = new LinkedList();
		linkedList.add(new LinkedList.Node("1"));
		linkedList.add(new LinkedList.Node("2"));
		linkedList.add(new LinkedList.Node("3"));
		linkedList.add(new LinkedList.Node("4"));
		linkedList.add(new LinkedList.Node("5"));
		linkedList.add(new LinkedList.Node("6"));
		linkedList.add(new LinkedList.Node("7"));
		linkedList.add(new LinkedList.Node("8"));
		linkedList.add(new LinkedList.Node("9"));
		reversed = new LinkedList();
		LinkedList reverse2 = reverseRecursive(linkedList.head, reversed);
		
		reverseIterative(linkedList);
		
	}
	
	private void reverseRecursiveEasier(Node node, LinkedList newList){
		if(node.next != null){			
			reverseRecursiveEasier(node.next, newList);
		}
		newList.add(node);
	}
	
	private LinkedList reverseRecursive(Node node, LinkedList newList){
		if(node == null){			
			return newList;
		}else{
			LinkedList reverse = reverseRecursive(node.next, newList);
			reverse.add(node);
		}
		return newList;
	}
	
	private LinkedList reverseIterative(LinkedList list){
		
		LinkedList newList = new LinkedList();
		
		Deque<Node> stack = new ArrayDeque<>();
		
		Node node = list.head;
		while(node != null){
			stack.push(node);
			node = node.next;
		}
		
		while(!stack.isEmpty()){
			newList.add(stack.pop());
		}
		
		return newList;
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------------- CONTAINED SUBLIST ---------------------------------------------------------------------------------
	
	@Test
	public void testContainsLinkedList() {
		
		java.util.LinkedList<Integer> list1 = new java.util.LinkedList<>();
		list1.add(3);
		list1.add(5);
		list1.add(7);
		list1.add(9);
		list1.add(11);
		list1.add(20);
		list1.add(23);
		
		java.util.LinkedList<Integer> list2 = new java.util.LinkedList<>();
		list2.add(5);
		list2.add(7);
		list2.add(9);
		list2.add(11);
		
		assertEquals(1, sublistContained(list1, list2));
		
		list2 = new java.util.LinkedList<>();
		list2.add(5);
		list2.add(6);
		list2.add(9);
		list2.add(11);
		
		assertEquals(-1, sublistContained(list1, list2));
		
		list2 = new java.util.LinkedList<>();
		list2.add(4);
		list2.add(1);
		list2.add(5);
		list2.add(7);
		
		assertEquals(-1, sublistContained(list1, list2));
		
	}
	
	/**
	 * list ->    3  5  7  9  11 20 23 
	 * sublist -> 5  7  9  11 
	 * sublist2-> 5  6  9  11
	 * sublist3-> 4  1  5  7
	 * 
	 * @param list1
	 * @param list2
	 */	
	private int  sublistContained(java.util.LinkedList<Integer> list, java.util.LinkedList<Integer> sublist) {
		for (int i = 0; i < list.size() - sublist.size(); i++) {
			Integer listElement = list.get(i);			
			for (int j = 0; j <= sublist.size(); j++) {
				listElement = list.get(i+j);
				if(sublist.get(j) != listElement){
					break;
				}
				if (j == sublist.size()-1) {
					return i;
				}
			}
		}
		
		return -1;
		
	}
	
	private int contains(java.util.LinkedList<Integer> list, java.util.LinkedList<Integer> sublist) {
		
		for (int i = 0; i <= (list.size() - sublist.size()); i++) {
			for (int j = 0; (j < sublist.size()) && (list.get(i + j) == sublist.get(j)); j++) {
				if (j == sublist.size())
					return i;
			}
		}
		return -1;
	}
	
	/**
	 * L1 -> 3 5 7 9 11 20 23 
	 * L2 -> 5 7 9 11 L
	 * 3 -> 5 6 9 11
	 * 
	 * @param list1
	 * @param list2
	 */
	private int checkLists(java.util.LinkedList<Integer> list1, java.util.LinkedList<Integer> list2) {
		
		for (int i = 0; i < list1.size(); i++) {
			int integer1 = list1.get(i);
			for (int j = 0; j < list2.size(); j++) {
				int integer2 = list2.get(j);
				if (integer1 == integer2) {
					if(match(list1, list2, i, j)){
						return i;
					};
				}
			}
		}
		return -1;
	}
	
	private boolean match(java.util.LinkedList<Integer> list1,
			java.util.LinkedList<Integer> list2, int i, int j) {
		int minLenght = list1.size() > list2.size() ? list2.size() : list1
				.size();
		int counterMatches = 0;
		while (i < list1.size() && j < list2.size()) {
			if (list1.get(i) != list2.get(j)) {
				return false;
			}
			counterMatches++;
			i++;
			j++;
		}
		return counterMatches == minLenght;
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------------- MIDDLE NODE SUBLIST ONE PASS ---------------------------------------------------------------------------------
	
	
	@Test
	public void testMiddleNode() {
		
		LinkedList linkedList = new LinkedList();
		linkedList.add(new LinkedList.Node("1"));
		linkedList.add(new LinkedList.Node("2"));
		linkedList.add(new LinkedList.Node("3"));
		linkedList.add(new LinkedList.Node("4"));
		
		Node middle = middle(1, linkedList.head, linkedList.head);
		System.out.println(middle.data());
		
	}
	
	@Test
	public void testRemoveMafterN() {
		LinkedList linkedList = new LinkedList();
		linkedList.add(new LinkedList.Node("1"));
		linkedList.add(new LinkedList.Node("2"));
		linkedList.add(new LinkedList.Node("3"));
		linkedList.add(new LinkedList.Node("4"));
		linkedList.add(new LinkedList.Node("5"));
		linkedList.add(new LinkedList.Node("6"));
		linkedList.add(new LinkedList.Node("7"));
		linkedList.add(new LinkedList.Node("8"));
		linkedList.add(new LinkedList.Node("9"));
		
		LinkedList removeMafterN = removeMafterN(linkedList, 2, 2);
		Node node = removeMafterN.head;
		while ((node = node.next) != null) {
			System.out.println(node);
		}
		
	}
	
	private Node middle(int counter, Node middle, Node node) {
		if (node == null) {
			return middle;
		}
		if (counter % 2 == 0)
			middle = middle.next();
		return middle(++counter, middle, node.next);
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------------- REMOVE N AFTER M ---------------------------------------------------------------------------------	
	
	private LinkedList removeMafterN(LinkedList linkedList, int n, int m) {
		
		Node currentNode = linkedList.head();
		Node target = null;
		while (currentNode != null) {
			
			for (int i = 0; i < n; i++) {
				currentNode = currentNode.next();
				if (currentNode == null) {
					return linkedList;
				}
			}
			
			target = currentNode;
			
			Node aux = currentNode;
			for (int i = 0; i < n; i++) {
				currentNode = currentNode.next();
				aux.setNext(null);
				if (currentNode == null) {
					return linkedList;
				}
				aux = currentNode;
			}
			
			if (currentNode.next != null)
				target.setNext(currentNode.next);
		}
		return linkedList;
	}
	
	//--------------------------------------------------------------------------------------------------------------------------------------
	//---------------------------------- REMOVE DUPLICATES ---------------------------------------------------------------------------------	
	
	/**
	 * L1 -> 3 5 7 5 11 20 23
	 */
	@Test
	public void testRemoveDuplicates(){
		LinkedList linkedList = new LinkedList();
		linkedList.add(new LinkedList.Node("3"));
		linkedList.add(new LinkedList.Node("5"));
		linkedList.add(new LinkedList.Node("7"));
		linkedList.add(new LinkedList.Node("5"));
		linkedList.add(new LinkedList.Node("11"));
		linkedList.add(new LinkedList.Node("20"));
		linkedList.add(new LinkedList.Node("20"));
		
		Node external = linkedList.head;
		while(external != null){
			
			Node previous = external;
			Node internal = external.next;
			while(internal != null){
				if (external.data.equals(internal.data)) {
					previous.next = internal.next;
				}
				previous = internal;
				internal = internal.next();
			}
			external = external.next;
		}
		
		Node node = linkedList.head;
		while ((node = node.next) != null) {
			System.out.println(node);
		}
		
	}
	
	
	
	
	static class LinkedList {
		private Node head;
		private Node tail;
		
		public LinkedList() {
			this.head = new Node("head");
			tail = head;
		}
		
		public Node head() {
			return head;
		}
		
		public void add(Node node) {
			tail.next = node;
			tail = node;
		}
		
		public static class Node {
			private Node next;
			private String data;
			
			public Node(String data) {
				this.data = data;
			}
			
			public String data() {
				return data;
			}
			
			public void setData(String data) {
				this.data = data;
			}
			
			public Node next() {
				return next;
			}
			
			public void setNext(Node next) {
				this.next = next;
			}
			
			public String toString() {
				return this.data;
			}
		}
	}
	
}

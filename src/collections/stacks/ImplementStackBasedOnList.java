package collections.stacks;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class ImplementStackBasedOnList {

	private LinkedList<Integer> linkedList = new LinkedList<>();
	
	public int pop(){
		return linkedList.pollFirst();
	}
	
	public void push(int i){
		linkedList.addFirst(i);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

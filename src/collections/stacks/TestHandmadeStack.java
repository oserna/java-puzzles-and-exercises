package collections.stacks;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestHandmadeStack {

	@Test
	public void testPushAndPop(){
		HandmadeStack stack = new HandmadeStack();
		stack.push(1);
		Integer pop = stack.pop();
		assertEquals(new Integer(1), pop);		
	}
	
	@Test
	public void testMultiplePushAndPop(){
		HandmadeStack stack = new HandmadeStack();
		stack.push(1);
		stack.push(2);
		Integer pop = stack.pop();
		assertEquals(new Integer(2), pop);		
		pop = stack.pop();
		assertEquals(new Integer(1), pop);		
	}
	
	@Test
	public void testResizing(){
		HandmadeStack stack = new HandmadeStack();
		for (int i = 0; i < 11; i++) {
			stack.push(i);
		}
		Integer pop = stack.pop();
		assertEquals(10, stack.size());		
		assertEquals(new Integer(10), pop);		
		
	}
	
	
}

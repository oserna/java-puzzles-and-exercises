package datatype.string;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class TestStringValidAccordingParenthesisOrder {
	
	public static final char OPEN = '(';
	public static final char CLOSE = ')';
	
	@Test
	public void testValid () {
		
		assertTrue(isValidUsingStack("123(13(44))"));
		assertTrue(isValidUsingStack("123(1344)"));
		assertTrue(isValidUsingStack("123(()1344)"));
		assertTrue(isValidUsingStack("123(())1344"));
		assertTrue(isValidUsingStack("(1231344)"));

		assertFalse(isValidUsingStack(")1231344"));
		assertFalse(isValidUsingStack("1231344("));

		assertFalse(isValidUsingStack("123(13(44)"));
		assertFalse(isValidUsingStack("123(1344"));
		
		assertFalse(isValidUsingStack("1231344("));
		assertFalse(isValidUsingStack("(1231344"));
		assertFalse(isValidUsingStack(")1231344("));
		
		
				
		assertTrue(isValidUsingOneCounter("123(13(44))"));
		assertTrue(isValidUsingOneCounter("123(1344)"));
		assertTrue(isValidUsingOneCounter("123(()1344)"));
		assertTrue(isValidUsingOneCounter("123(())1344"));
		assertTrue(isValidUsingOneCounter("(1231344)"));

		assertFalse(isValidUsingOneCounter(")1231344"));
		assertFalse(isValidUsingOneCounter("1231344("));

		assertFalse(isValidUsingOneCounter("123(13(44)"));
		assertFalse(isValidUsingOneCounter("123(1344"));
		
		assertFalse(isValidUsingOneCounter("1231344("));
		assertFalse(isValidUsingOneCounter("(1231344"));
		assertFalse(isValidUsingOneCounter(")1231344("));
				
	}
	
	/**
	 * The idea is to use an stack to put parethesis
	 * @param input
	 * @return
	 */
	public boolean isValidUsingStack(String input) {
		
		Stack<Character> stack = new Stack<>();
		
		char[] charArray = input.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			
			if (c == OPEN) {
				stack.push(c);
			}
			
			if (c == CLOSE) {
				
				if (stack.isEmpty()) {
					return false;
				}
				
				Character peek = stack.peek();
				if (peek != OPEN) {
					return false;
				}
				
				stack.pop();
			} 
		}
		
		return stack.isEmpty();
		
	}

	/**
	 * This approach is not valid, the number of parenthesis is ok, but ")(" is not valid
	 * @param input
	 * @return
	 */
	public boolean isValidUsingCounters(String input) {
		
		int rightCounter = 0;
		int leftCounter = 0;
		
		char[] charArray = input.toCharArray();
		for (char c : charArray) {
			if (c == '(') {
				rightCounter++;
			}
			if (c == ')') {
				leftCounter++;
			}
		}
		return leftCounter == rightCounter;
		
	}

	public boolean isValidUsingOneCounter(String input) {
		
		int parenthesisCounter = 0;
		
		char[] charArray = input.toCharArray();
		for (char c : charArray) {
			if (c == '(') {
				parenthesisCounter++;
			}
			if (c == ')') {
				if (parenthesisCounter < 1) {
					return false;
				}
				parenthesisCounter--;
			}
		}
		return parenthesisCounter == 0;
		
	}

}

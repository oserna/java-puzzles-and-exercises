package datatype.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringReverse {

	@Test
	public void testReverseIteration() {
		assertTrue("Wrong reverse", reverse("hello").equals("olleh"));
	}
	
	@Test
	public void testReverseRecursive() {
		assertTrue("Wrong reverse", reverseRecursive("hello").equals("olleh"));
	}
	
	private String reverse(String stringToReverse){
		char [] reversed = new char[stringToReverse.length()];
		for (int i = 0; i < reversed.length; i++) {
			reversed[i] = stringToReverse.charAt(stringToReverse.length()-1-i);
		}
		return new String(reversed);
	}
	
	private String reverseRecursive(String input) {
		if (input.length() == 1) {
			return input;
		}
		
		return reverseRecursive(input.substring(1)) + input.charAt(0);
	}

}

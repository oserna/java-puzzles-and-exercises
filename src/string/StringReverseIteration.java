package string;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringReverseIteration {

	@Test
	public void testReverseIteration() {
		assertTrue("Wrong reverse", reverse("hello").equals("olleh"));
	}
	
	private String reverse(String stringToReverse){
		char [] reversed = new char[stringToReverse.length()];
		for (int i = 0; i < reversed.length; i++) {
			reversed[i] = stringToReverse.charAt(stringToReverse.length()-1-i);
		}
		return new String(reversed);
	}

}

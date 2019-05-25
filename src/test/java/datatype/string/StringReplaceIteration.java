package datatype.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringReplaceIteration {

	@Test
	public void testReplaceIteration() {
		assertTrue("wrong replace", replace("hola", 'h', 'c').equals("cola"));
	}

	private String replace(String replace, char c, char n) {
		char [] replaced = new char[replace.length()];
		for (int i = 0; i < replace.length(); i++) {
			char current = replace.charAt(i);
			if (current == c) {
				replaced[i] = n;
				continue;
			}
			replaced[i] = current;
		}
		return new String(replaced);
	
	}

}

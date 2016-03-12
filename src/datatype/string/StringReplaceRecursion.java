package datatype.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringReplaceRecursion {

	@Test
	public void testReplaceRecursion() {
		assertTrue("wrong replace", replace("hola", 'h', 'j').equals("jola"));
	}

	private String replace(String replace, char c, char n) {
		if ((null == replace) || (replace.length() < 1)) {
			return replace;
		}
		return replace(replace.substring(0, replace.length() - 1), c, n)
				+ (replace.charAt(replace.length() - 1) == c ? n : replace
						.charAt(replace.length() - 1));

	}

}

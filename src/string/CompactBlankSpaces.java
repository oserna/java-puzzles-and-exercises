package string;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompactBlankSpaces {

	@Test
	public void compactWhiteSpaces() {
	    
		String s = "ab cdef ghi jkl    mnopq";
		String compactBlankSpaces = compactBlankSpaces(s);
		assertTrue("ab cdef ghi jkl mnopq".equals(compactBlankSpaces));
	}
	
	String compactBlankSpaces(String string){
		String previous = ""+string.charAt(0);
		for (int i = 1; i < string.length(); i++) {
			if(previous.charAt(previous.length()-1) == ' ' && string.charAt(i) == ' '){
				continue;
			}			
			previous = previous + string.charAt(i);
		}
		return previous;
	}

}

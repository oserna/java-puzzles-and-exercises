package string;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveBlankSpacesRecursively {

	@Test
	public void testRemoveWhiteSpacesRecursively() {
	    
		String s = "ab cdef ghi jkl    mnopq";
		String compactBlankSpaces = removeBlankSpacesRecursively(s);
		assertTrue("abcdefghijklmnopq".equals(compactBlankSpaces));
	}
	
	String removeBlankSpacesRecursively(String string){
		if(string.length() <= 1){
			return string;
		}
		if(string.length() >0 && string.charAt(0) != ' '){
			return string.charAt(0) + removeBlankSpacesRecursively(string.substring(1));
		}
		return removeBlankSpacesRecursively(string.substring(1));
	}

}

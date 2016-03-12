package datatype.string;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class StringRepeated {

	@Test
	public void test(){
		
		String test = "teeter";
		char firstNonRepeatedCharacter = firstNonRepeatedCharacter(test);
		assertTrue("the character should be r", firstNonRepeatedCharacter=='r');
		
		test = "stress";
		firstNonRepeatedCharacter = firstNonRepeatedCharacter(test);
		assertTrue("the character should be t", firstNonRepeatedCharacter=='t');

		test = "astress";
		firstNonRepeatedCharacter = firstNonRepeatedCharacter(test);
		assertTrue("the character should be a", firstNonRepeatedCharacter=='a');
		
		test = "teete";
		Character found = firstNonRepeatedCharacter(test);
		assertTrue("the character should be a", found==null);

	}
	
	
	private Character firstNonRepeatedCharacter(String stringToSearch){

		Map<Character, Integer> occurences = new LinkedHashMap<>();
		char[] charArray = stringToSearch.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (occurences.containsKey(c)) {
				occurences.put(c, occurences.get(c) + 1);
			}else{
				occurences.put(c, 1);
			}
		}
		
		for (char c : occurences.keySet()) {
			if(occurences.get(c) == 1) return c;
		}
		
		return null;
	}
}

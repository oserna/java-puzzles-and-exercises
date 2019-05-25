package datatype.string;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

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

	

	/**
	 * The idea is to use an ordered map, the key is the character and the value is the number of times
	 * that it is repeated in the string. Because we are using a LinkedHashMap the elements will follow 
	 * the insertion order when I traverse the map. The first element in the map whose value is 1 is the
	 * target
	 * 
	 * @param stringToSearch
	 * @return
	 */
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

package arrays;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ReverseArray {

	@Test
	public void test() {
		
		int [] array =  new int[]{0,1,2,3,4,5,6,7};
		int [] output = new int[]{7,6,5,4,3,2,1,0};
		
		int j = array.length;
		int [] reverse = new int [j];
		for (int i = 0; i < array.length; i++) {
			reverse[i] = array[j-1];
			j--;
		}
		
		assertTrue(Arrays.equals(output, reverse));
		
	}
		
	
}

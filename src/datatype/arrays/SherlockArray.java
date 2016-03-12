package datatype.arrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class SherlockArray {

	@Test
	public void test() {
		assertEquals(3, check(new int[]{1,2,3,6,3,3}));
		assertEquals(2, check(new int[]{1,2,3,3}));
	}
	
	
	private int check(int [] array){
		for (int i = 0; i < array.length; i++) {
			int left = 0;
			int right = 0;
			for (int j = 0; j < array.length; j++) {
				if(j<i){
					left = left + array[j];
					continue;
				}else if(j>i){					
					right = right + array[j];
				}
			}
			if(left == right){
				return i;
			}
		}
		return -1;
	}

}

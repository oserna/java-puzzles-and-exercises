package datatype.arrays;

import org.junit.Test;

public class IntersectionSortedArrays {

	@Test
	public void test() {
		
		int [] a = new int[]{ 1, 3, 4, 5, 7};
		int [] b = new int[]{ 2, 3, 5, 6};
		
		int i = 0;
		int j = 0;
		while( i < a.length && j < b.length){
			if(a[i] > b[j]) {
				j++; 
			} else if(a[i] < b[j]){
				i++;
			}else{
				System.out.println(a[i]);
				i++	;
				j++;
			}
			
			
		}
	}
	
	@Test
	public void test2() {
		
		int [] a = new int[]{ 1, 3, 4, 5, 7};
		int [] b = new int[]{ 2, 3, 5, 6};
		
		boolean [] e = new boolean[b[b.length-1]+1];
		for (int i = 0; i < b.length; i++) {
			int j = b[i];
			e[j] = true;
		}
		
		for (int i = 0; i < a.length; i++) {
			int num = a[i];
			if(num < e.length && e[num]){
				System.out.println(num);
			}
		}
		
		
	}

}

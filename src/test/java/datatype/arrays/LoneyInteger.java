package datatype.arrays;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

/**
 * https://www.hackerrank.com/challenges/lonely-integer
 * @author oserna
 *
 */
public class LoneyInteger {

	@Test
	public void test() {
//		assertEquals(1, lonely2(1, new int[]{1}));
//		assertEquals(2, lonely2(3, new int[]{1,1,2}));
//		assertEquals(2, lonely2(3, new int[]{0,0,1,2,1}));
		assertEquals(9, lonely2(3, new int[]{0, 0, 1, 2, 7, 9, 1, 7, 2}));
		
	}	
	
	//http://aruncyberspace.blogspot.com.es/2013/09/hacker-rank-problem-search-lonely.html
	
	private int loneley(int number, int [] array){
				
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			int j = array[i];
			if(!map.containsKey(j)){				
				map.put(j, 1);
				continue;
			}
			map.put(j, map.get(j)+1);
		}
		
		for (Entry<Integer,Integer> entry : map.entrySet()) {
			if (entry.getValue()==1) {
				return entry.getKey();
			}
		}

		return -1;
	}
	
	private int lonely2(int number, int [] arr){
		 int unique=0;
	        unique=arr[0];
	        for(int i=1;i<arr.length;i++)
	        {
	        	System.out.println(unique+"^"+arr[i]+": "+(unique^=arr[i]));
	        }
	        return unique;
	}
		
	private int lonely3(int [] arr){
		 	int unique=arr[0];
	        for(int i=1;i<arr.length;i++)
	        {
	        	unique^=arr[i];
	        }
	        return unique;
	}
		
}

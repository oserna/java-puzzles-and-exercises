package datatype.string;

import junit.framework.Assert;

import org.junit.Test;

public class StringRepeatedRecursion {

	@Test
	public void testCountRepeated(){
		Assert.assertEquals(4, countRepeated('x',"xxhixx"));
		Assert.assertEquals(3, countRepeated('x',"xhixhix"));
		Assert.assertEquals(0, countRepeated('x',"hi"));

	}
	
	@Test
	public void testCountRepeated2(){
		Assert.assertEquals(4, countX("xxhixx"));
		Assert.assertEquals(3, countX("xhixhix"));
		Assert.assertEquals(0, countX("hi"));

	}
	
	@Test
	public void testCountGroupChar(){
		Assert.assertEquals(1, countHi("xxhixx"));
		Assert.assertEquals(2, countHi("xhixhix"));
		Assert.assertEquals(1, countHi("hi"));

	}
	
	private int countHi(String str) {
		if (str.length() <= 2) {
			return str.equals("hi") ? 1 : 0;
		}
		return countHi(str.substring(1))+ (str.substring(0, 2).equals("hi") ? 1 : 0);
	}
	
	
	private int countRepeated(char toCount, String string){
		if(string.length() == 1) return string.charAt(0) == toCount ? 1 : 0;
		
		return countRepeated(toCount, string.substring(1)) + (string.charAt(0) == toCount ? 1 : 0); 
	}
	
	
	public int countX(String str) {
		  if(str.length() == 1) return str.equals("x") ? 1 : 0;
				
		  return countX(str.substring(1)) + (str.substring(0,1).equals("x") ? 1 : 0); 

		}

}

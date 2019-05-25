package datatype.numbers;

import org.junit.Assert;
import org.junit.Test;

public class TestNumbers {

	@Test
	public void testCount8Double() {
		
		int number = 81238;
		Assert.assertEquals(2, count8(number));
		number = 88788;
		Assert.assertEquals(6, count8(number));
		
	}

	@Test
	public void testPowerN() {
		
		Assert.assertEquals(27, powerN(3,3));
		
	}
	
	private int powerN(int base, int n){
		if(n==1) return base;
		return base * powerN(base,--n);
	}
	

	private int count8(int n) {

		if (n < 10)
			return n == 8 ? 1 : 0;
		
		if(n % 100 == 88)
			return count8(n / 10) + 2;
		
		return count8(n / 10) + (n % 10 == 8 ? 1 : 0);

	}
	

}

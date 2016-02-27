package numbers;

import org.junit.Assert;
import org.junit.Test;

public class FactorialIterative {

	@Test
	public void testFactorial() {
		
		long number = 5;
		long computeFactorial = factorial(number);
		Assert.assertEquals(120, computeFactorial);
		
	}
	
	private long factorial(long number){
		long sum = 1;
		for (int i = 1; i <= number; i++) {
			sum = sum * i;
		}
		return sum;
	}
	

}

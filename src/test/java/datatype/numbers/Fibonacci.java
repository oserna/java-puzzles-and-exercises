package datatype.numbers;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class Fibonacci {

	@Test
	public void test() {
		
		int [] original = new int []{1,1,2,3,5,8,13,21};
		int [] computed = computeFibonacciSeriesUptoControl(original.length, new int []{1});
		for (int i = 0; i < computed.length; i++) {
			int j = computed[i];			
			assertTrue(original[i]==j);
		}
	}
	
	/**
	 * 1,1,2,3,5,8,13,21
	 * @return 
	 */
	private int[] computeFibonacciSeriesUptoControl(int control, int [] series){
		
		if (series.length == control) {
			return series;
		}
		
		int [] newSeries = Arrays.copyOf(series, series.length + 1);
		if(series.length < 2){
			newSeries[newSeries.length - 1] = 1; 			
			return computeFibonacciSeriesUptoControl(control, newSeries);
		}
		
		newSeries[newSeries.length - 1] = series[series.length-1] + series[series.length-2]; 
		return computeFibonacciSeriesUptoControl(control, newSeries);
	}
	
	
	public static int fibonacci(int number){
        if(number == 1 || number == 2){
            return 1;
        }
      
        return fibonacci(number-1) + fibonacci(number -2); //tail recursion
    }
	
	public static void main(String[] args) {
		int fibonacci = fibonacci(8);
		System.out.println(fibonacci);
	}
	

}

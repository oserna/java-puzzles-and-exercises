package datatype.arrays;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Scanner;

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
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
            System.out.print(" ");
        }
    }
	
}

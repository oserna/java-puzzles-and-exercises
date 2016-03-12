package companies.capitalone;

import java.io.*;
import java.util.Scanner;


public class Solution {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		String nextLine = in.nextLine();

		fizzbuzz(nextLine);

	}
	
	public static void fizzbuzz(String number){
			
		 int n = Integer.parseInt(number);
		 for (int i = 1; i <= n; i++) {
	            if (i % 5 == 0) {
	                System.out.println("Buzz");
	            } else if (i % 3 == 0) {
	                System.out.println("Fizz");
	            } else if (i % 3 == 0 && i % 5 == 0) {
	                System.out.println("FizzBuzz");
	            } else {
                    System.out.println(String.valueOf(i));

	            }
	        }
	}

}
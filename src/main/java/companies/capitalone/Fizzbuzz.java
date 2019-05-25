package companies.capitalone;

import java.io.*;
import java.util.Scanner;


public class Fizzbuzz {
	
	
	public static void main(String[] args) throws IOException {

		String number = "15";
		
		int n = Integer.parseInt(number );
		
		for (int i = 1; i <= n; i++) {
			if ((i % 3 == 0) && (i % 5 == 0))  {
				System.out.println("FizzBuzz");
				continue;
			} if (i % 3 == 0) {
				System.out.println("Fizz");
				continue;
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
				continue;
			} else {
				System.out.println(String.valueOf(i));
				continue;
			}
		}
		
	}
	

}
package datatype.string;

import java.util.HashSet;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/two-strings
 * @author oserna
 *
 */
public class TwoStrings {

	  public static void main(String[] args) {
	        Scanner sc= new Scanner(System.in);
	        int number = sc.nextInt();
	        for(int j = 0; j<number; j++){
	          String one = sc.next();
	          String two = sc.next();
	          HashSet<Character> oneSet = new HashSet<Character>();
		 	  char[] charArray = one.toCharArray();
			  for (int i = 0; i < charArray.length; i++) {
				char c = charArray[i];
				oneSet.add(c);
			  }
			  HashSet<Character> twoSet = new HashSet<Character>();
			  charArray = two.toCharArray();
			  for (int i = 0; i < charArray.length; i++) {
				char c = charArray[i];
				twoSet.add(c);
			  }
			  oneSet.retainAll(twoSet);
			  System.out.println(oneSet.size() > 0 ? "YES" : "NO");      
	 
	        }
	    }
}

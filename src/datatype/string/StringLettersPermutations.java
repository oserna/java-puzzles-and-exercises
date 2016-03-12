package datatype.string;

import java.util.HashSet;
import java.util.Set;

public class StringLettersPermutations {
	
    private static void permutation(String prefix, String str){
        int n = str.length();
        if (n == 0) 
            System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++){
            	
            	String newPrefix = prefix + str.charAt(i);
            	
            	String s1 = str.substring(0, i);
            	String s2 = str.substring(i+1);
            	
            	String rest =  s1 + s2;
            	
            	permutation(newPrefix,rest);
            }
        }
    }
    
    public static void main(String[] args) {
        permutation("", "ABCD");
    }
	
	public static void main2(String[] args) {
		String s = "ABC";
		String s1 = "EBAY";
		String s2 = "Yahoo";
		System.out.println("\nString " + s + ":\nPermutations: " + crunchifyPermutation(s));
		System.out.println("\nString " + s1 + ":\nPermutations: " + crunchifyPermutation(s1));
		System.out.println("\nString " + s2 + ":\nPermutations: " + crunchifyPermutation(s2));
	}
 
	public static Set<String> crunchifyPermutation(String str) {
		Set<String> crunchifyResult = new HashSet<String>();
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			crunchifyResult.add("");
			return crunchifyResult;
		}
 
		char firstChar = str.charAt(0);
		String rem = str.substring(1);
		Set<String> words = crunchifyPermutation(rem);
		for (String newString : words) {
			for (int i = 0; i <= newString.length(); i++) {
				String crunchifyCharAdd = crunchifyCharAdd(newString, firstChar, i);
				crunchifyResult.add(crunchifyCharAdd);
			}
		}
		return crunchifyResult;
	}
 
	public static String crunchifyCharAdd(String str, char c, int j) {
		String first = str.substring(0, j);
		String last = str.substring(j);
		return first + c + last;
	}
}

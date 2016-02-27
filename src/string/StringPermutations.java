package string;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
	
	public static void main(String[] args) {
		
		String abc = "abc";
		List<String> perms = perms(abc);
		for (String string : perms) {
			System.out.print(" "+string);
		}
		
	}
	
	private static List<String> perms(String s){
		
		List<String> accum = new ArrayList<>();
		
		if(s == null) return null;
		if(s.length() == 0){
			accum.add("");
			return accum;
		}
		
		
		char firstChar = s.charAt(0);
		String rest = s.substring(1);
		List<String> perms = perms(rest);
		for (String perm : perms) {
			for (int i = 0; i <= perm.length(); i++) {
				String swap = swap(perm, firstChar, i);
				accum.add(swap);
			}
		}
		return accum;
		
	}
	
	
	/**
	 * Me añade un caracter con todos los de una palabra en order
	 * @param c
	 * @param a
	 * @param b
	 * @return
	 */
	private static String swap(String string, char c, int b){
		String prefix = string.substring(0, b);
		String sufix = string.substring(b);
		return prefix + c + sufix;
	}

}

package string;

public class Palindrome {

	
	public static void main(String[] args) {
		String palindrome = "anilina";
		char[] charArray = palindrome.toCharArray();
		int j = charArray.length;
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			char c2 = charArray[j-1];
			if (c != c2) {
				System.out.println("FALSE");
				return;
			}
			j--;
		}
		
		System.out.println("TRUE");
	}
	
	
}

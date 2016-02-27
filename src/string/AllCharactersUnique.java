package string;

public class AllCharactersUnique {
	
	public static void main(String[] args) {
		String test = "oocar";
		boolean [] array = new boolean[256];
		for (int i = 0; i < test.length(); i++) {
			int val = test.charAt(i);
			char charAt = test.charAt(i);
			System.out.println(val);
			System.out.println(charAt);
		}
	}

}

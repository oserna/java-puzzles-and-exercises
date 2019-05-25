package companies.capitalone;

import java.util.Scanner;

public class Sanitize {
	
	public static final String startScript = "<script>";
	public static final String endScript= "</script>";
 	public static final String startScriptComplete = "<script language=\"JavaScript\">";
	
	public static void main(String[] args) {
		
//		Scanner in = new Scanner(System.in);
//		
//		String nextLine = null;
//		while( in.hasNextLine()){
//			nextLine = in.nextLine();
//			System.out.println(check(nextLine));			
//		}
		

		check("99447398617");
	}

	
	
	private static String check(String card){
		
		card = new StringBuilder(card).reverse().toString();
		
		char[] charArray = card.toCharArray();
		int a =0;
		int b =0;
		for (int i = 1; i <= charArray.length; i++) {
			char c = charArray[i-1];
			int num = Integer.parseInt(c+"");
			if(i % 2 == 0){
				int v = num  * 2;
				if(v >= 10){
					Integer integer = new Integer(v);
					char[] charArray2 = integer.toString().toCharArray();
					int one = Integer.parseInt(charArray2[0]+"");
					int two = Integer.parseInt(charArray2[1]+"");
					b = b + one + two;
				}else{
					b = b + v;
				}
			}else{
				a = a + num;
			}
			
		}
		if((a+b)  %  10 == 0){
			return "Yes";
		}
		
		return "No";
	}


}

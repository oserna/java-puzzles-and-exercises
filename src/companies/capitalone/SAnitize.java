package companies.capitalone;

public class SAnitize {
	
	public static final String startScript = "<script>";
	public static final String endScript= "</script>";
 	public static final String startScriptComplete = "<script language=\"JavaScript\">";
	
	public static void main(String[] args) {
		check("2345");

	}

	private static String sanitize(String nextLine) {
		
		String result = nextLine;
		int start = nextLine.indexOf(startScript);
		if (start<0) {
			start = nextLine.indexOf(startScriptComplete);
		}
		if (start>0) {
			String init = nextLine.substring(0, start);
			String substring = nextLine.substring(start+startScript.length());
			int end = substring.indexOf(endScript);
			if (end>0) {
				result = init + substring.substring(end+endScript.length());
			}
		}
		
		return result;
		
		
	}
	
	
	private static void check(String card){
		
		char[] charArray = card.toCharArray();
		int a =0;
		int b =0;
		for (int i = charArray.length-1; i >= 0 ; i--) {
			char c = charArray[i];
			int num = Integer.parseInt(c+"");
			if(num % 2 == 0){
				a = a + num;
			}else{
				int v = num  * 2;
				if(v>10){
					Integer integer = new Integer(v);
					char[] charArray2 = integer.toString().toCharArray();
					int one = Integer.parseInt(charArray2[0]+"");
					int two = Integer.parseInt(charArray2[1]+"");
					b = b + one + two;
				}else{
					b = b + v;
				}
			}
			
		}
		if((a+b)  %  10 == 0){
			return "Yes";
		}
		
		return "No";
	}


}

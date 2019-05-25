package companies.amazon;

public class MaxKeystrokes {

	
	public static void main(String[] args) {
		int findoptimal = findoptimal(8);
		System.out.println(findoptimal);
	}
	
	static int findoptimal(int N)
	{
	    // The optimal datatype.string length is N when N is smaller than 7
	    if (N <= 6)
	        return N;
	 
	    // Initialize result
	    int max = 0;
	 
	    // TRY ALL POSSIBLE BREAK-POINTS
	    // For any keystroke N, we need to loop from N-3 keystrokes
	    // back to 1 keystroke to find a breakpoint 'b' after which we
	    // will have Ctrl-A, Ctrl-C and then only Ctrl-V all the way.
	    int b;
	    for (b=N-3; b>=1; b--)
	    {
	            // If the breakpoint is s at b'th keystroke then
	            // the optimal datatype.string would have length
	            // (n-b-1)*screen[b-1];
	            int curr = (N-b-1)*findoptimal(b);
	            if (curr > max)
	                max = curr;
	     }
	     return max;
	}}

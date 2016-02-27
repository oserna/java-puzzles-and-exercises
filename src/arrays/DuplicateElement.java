package arrays;

public class DuplicateElement {

	public static void main(String[] args) {

		int[] array = new int[] { 601, 602, 603, 604, 605, 605, 606, 607 };
		
		int k,i,j=601;
		
		for(i=602;i<=607;i++)
	    {
	        j=j^i;
	    }

		System.out.println(j);
		System.out.println("-------");
		
	    for(k=0; k<8; k++)
	    {
	        j = j^array[k];
	        System.out.println(j);
	    }
		System.out.println(j);

	}
	

}

package arrays;

public class MergeSortedArrays {

	/**
	 * 
	 * @param a
	 * @param b
	 * @param num_elements_a number of elements contained in the array a, it could not the same than the length
	 * @param num_elements_b, number of elements contained in the array b, it could not the same than the length
	 */
	public static void merge(int[] a, int[] b, int num_elements_a, int num_elements_b) {
		
		int k = num_elements_b + num_elements_a - 1; // Index of last location of array b
		int i = num_elements_a - 1;// Index of last element in array b
		int j = num_elements_b - 1;// Index of last element in array a 
		
		System.out.println();
		
		// Start comparing from the last element and merge a and b
		while (i >= 0 && j >= 0) {
			if (a[i] > b[j]) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}
		while (j >= 0) {
			a[k--] = b[j--];
		}
	}

	public static void main( String[] args )
    {
      int[] a = {1,3,5,7,0,0,0,0,0,0,0,0,0};
      int[] b = {2,4,6,8};
      
//      int[] a = {1,3,5,0,0,0,0};
//      int[] b = {1,3};
      
        new MergeSortedArrays().merge( a, b, 4, 4 );
        
        for( int i = 0; i < a.length; i++ )
        {
            System.out.print( a[i] );
        }
        System.out.println();
    }
}

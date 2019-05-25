package datatype.arrays;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		int [] array = new int [] {1, 5, 4, 8, 7, 9};
		
		boolean flag = true;
		while(flag){			
			int temp = -1;
			flag = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] < array[i+1]) {
					temp = array[i];
					array[i] = array [i+1];
					array[i+1] = temp;
					flag = true;
				}
			}
		}
		
		
		System.out.println(array);
		
	}

}

package arrays;

public class SortArrayWithZerosAndOnes {

	
	public static void main(String[] args) {
		
		int [] array = new int[]{1,0,1,1,0,0,0,1,1};
	
		int i = 0;
		int j = array.length;
		while(j > i){
			if(array[i] == 0){
				i++;
				continue;
			}
			while(array[--j] == 1);
			array[i] = 0;
			array[j] = 1;
		}
		
		printArray(array);
	}
	
	
	public static void printArray(int [] array){
		System.out.print("[ ");
		for (int i = 0; i < array.length; i++) {
			int j = array[i];
			System.out.print(j+" ");
		}
		System.out.println("]");
	}

}

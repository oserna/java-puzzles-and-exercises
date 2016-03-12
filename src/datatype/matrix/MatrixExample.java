package datatype.matrix;

public class MatrixExample {

	
	public static void main(String[] args) {
		
		int [ ] [ ] matrix = {
							  { 20, 18, 22, 20, 16 }, //first row
                			  { 18, 20, 18, 21, 20 }, //second row
                			  { 16, 18, 16, 20, 24 }, //third row
                			  { 25, 24, 22, 24, 25 }  //fourth row
            			 	 };
		
		System.out.println("first row:    datatype.matrix[1]");
		printArray(matrix[1]);
		
		System.out.println("");
		
		System.out.println("first column: datatype.matrix[0][0], datatype.matrix[1][0], datatype.matrix[2][0], datatype.matrix[3][0]");
		System.out.print("[ ");
		System.out.print(matrix[0][0]+ " ");
		System.out.print(matrix[1][0]+ " ");
		System.out.print(matrix[2][0]+ " ");
		System.out.print(matrix[3][0]+ " ");
		System.out.print("]");
		
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

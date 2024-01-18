//Q3_SquareArray.java
//Alexander Gordon
//300290267

public class Q3_SquareArray{

	public static int[] createArray(int size) {
		int[] numbers = new int[size+1];

		for(int i=0; i<(size+1); i++){	//For loop adding squared variabled to array
			numbers[i] = i*i;
		}
		return numbers;	//Return array
	}

	public static void main(String[] args) {
		int[] arr = createArray(12);	//Declare array of length 12

		for(int i=0; i< arr.length; i++) {	//For loop printing array
			System.out.println("The square of "+i+" is: " +arr[i]);
		}
	}
}

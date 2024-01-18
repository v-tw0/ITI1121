//Q3_ReverseSortDemo.java
//Alexander Gordon
//300290267

public class Q3_ReverseSortDemo {
	public static void main(String[] args){
		char[] unorderedLetters;
		unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
		reverseSort(unorderedLetters);
		for (int i = 0 ; i < unorderedLetters.length; i++ )
			System.out.print(unorderedLetters[i]);
	}

	//method that sorts a char array into its reverse alphabetical order
	public static void reverseSort(char[] values){
		int i1 = values.length-1;					//Reverse index variable declared
		char[] result = new char[values.length];	//Temporary array to reverse variables

		for(int i = 0; i<values.length; i++){		//For loop reversing the variables
			if(i < values.length) {
				result[i] = values[i1];
			}
			i1--;
		}
		for(int i = 0; i < values.length; i++){		//Insert reverse variables back into original array
			values[i] = result[i];
		}
	}
}
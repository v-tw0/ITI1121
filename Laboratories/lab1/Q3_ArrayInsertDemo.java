//Q3_ArrayInsertDemo.java
//Alexander Gordon
//300290267

public class Q3_ArrayInsertDemo {
	public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert) {
		int afterArray[] = new int[beforeArray.length+1];

		for(int i = 0; i<afterArray.length; i++) {	//For loop inserting values
			if(i < indexToInsert){					//If i is less than position, insert values to new array
				afterArray[i] = beforeArray[i];
			}
			else if(i == indexToInsert){			//If i is on position, insert value to array
				afterArray[i] = valueToInsert;
			}
			else {									//Add the rest of the values into array
				afterArray[i] = beforeArray[i - 1];
			}
		}
		return afterArray;							//Return final array

	}

	public static void main(String[] args) {		
		int[] myArray = new int[]{1,5,4,7,9,6};		//Array initialized

		System.out.println("Array before insertion: ");	
		for(int i = 0; i<myArray.length; i++) {		//For loop printing array before insertion of variable
			System.out.println(myArray[i]);
		}

		int insertPos = 3;	//Position
		int insertNum = 15;	//Value

		int[] result = insertIntoArray(myArray, insertPos, insertNum);	//New array

		System.out.println("Array after insertion of " + insertNum + " at position " + insertPos);
		for(int i = 0; i<result.length; i++) {		//Floop loop printing array after insertion of variable
			System.out.println(result[i]);
		}
	}
}
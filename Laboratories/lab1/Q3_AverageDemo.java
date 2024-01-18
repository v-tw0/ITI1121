//Q3_AverageDemo.java
//Alexander Gordon
//300290267

public class Q3_AverageDemo{
	public static void main(String[] args){
		double[] valuesArray;
		valuesArray = new double[]{100.0,34.0,72.0,56.0,82.0,67.0,94.0};
		System.out.println("The average is: " + calculateAverage(valuesArray));
	}

	//method that calculates the average of the numbers in an array
	public static double calculateAverage(double[] values){
		double result;
		double sum = 0;						//Temporary sum double variable declared 
		for(int i=0;i<values.length;i++){	//For loop adding the array contents together
			sum = sum + values[i];
		}
		result = sum / values.length;		//Calculate average
		return result;						//Returns result
	}
}

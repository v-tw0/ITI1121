//Q6.java
//Alexander Gordon
//300290267

import java.util.Scanner;

public class Q6{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double gradeBook[] = new double[10];

		for(int i = 0; i<gradeBook.length; i++) { //Prompt user for grades
			System.out.print("Enter Grade for Student " + (i+1) + ": ");
			gradeBook[i] = input.nextInt();
		}

		System.out.println("\nAverage Grade: "+ calculateAverage(gradeBook));	//Call methods
		System.out.println("\nMedian: "+ calculateMedian(gradeBook));
		System.out.println("\n# of failed students: "+ calculateNumberFailed(gradeBook));
		System.out.println("\n# of passed students: "+ calculateNumberPassed(gradeBook));
	}

	/* Sums the grades, then divides it by it's quantity */
	public static double calculateAverage(double[] notes){
		double sum = 0;
		for(int i = 0; i<notes.length; i++) { 
			sum = sum + notes[i];
		}
		double avg = sum / notes.length;
		return avg;
	}

	/* Returns the middlemost variable of array */
	public static double calculateMedian(double[] notes){
		double median = 0;
		median = notes[notes.length/2];
		return median;
	}

	/* Returns quantity of variables below 50 */
	public static int calculateNumberFailed(double[] notes){
		int num = 0;
		for(int i = 0; i<notes.length;i++) {
			if(notes[i]<50) {
				num++;
			}
		}
		return num;
	}

	/* Returns quantity of variables above 50 */
	public static int calculateNumberPassed(double[] notes){
		int num = 0;
		for(int i = 0; i<notes.length;i++) {
			if(notes[i]>50) {
				num++;
			}
		}
		return num;
	}

}
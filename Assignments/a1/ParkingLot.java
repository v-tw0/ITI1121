import java.io.File;
import java.util.Scanner;

/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 */
public class ParkingLot {
	/**
	 * The delimiter that separates values
	 */
	private static final String SEPARATOR = ",";

	/**
	 * The delimiter that separates the parking lot design section from the parked
	 * car data section
	 */
	private static final String SECTIONER = "###";

	/**
	 * Instance variable for storing the number of rows in a parking lot
	 */
	private int numRows;

	/**
	 * Instance variable for storing the number of spaces per row in a parking lot
	 */
	private int numSpotsPerRow;

	/**
	 * Instance variable (two-dimensional array) for storing the lot design
	 */
	private CarType[][] lotDesign;

	/**
	 * Instance variable (two-dimensional array) for storing occupancy information
	 * for the spots in the lot
	 */
	private Car[][] occupancy;

	/**
	 * Constructs a parking lot by loading a file
	 * 
	 * @param strFilename is the name of the file
	 */

	/* Instance variables for temporary assignments, and less obejct conversion
	*/

	private char[][] lotDesign1;		
	private String[][] occupancy1;
	private int lotWidth;
	private int lotLength;

	public ParkingLot(String strFilename) throws Exception {

		if (strFilename == null) {
			System.out.println("File name cannot be null.");
			return;
		}

		calculateLotDimensions(strFilename);

		/* Declare size of two dimensional arrays*/
		lotDesign = new CarType[lotLength][lotWidth];
		occupancy = new Car[lotLength][lotWidth];

		char[][] lotDesign1 = new char[lotLength][lotWidth];
		String[][] occupancy1 = new String[lotLength][lotWidth];

		Scanner scanner = new Scanner(new File(strFilename));

		int j = 0;

		/* Populate lotDesign1 with File */
		while(scanner.hasNext()) {
			if(j == lotLength) {break;}
			String str = scanner.nextLine();
			if(str.equals(SECTIONER)) {break;}
			if(str.isEmpty()) {continue;}

			//Remove any additional spaces and commas
			str = str.replace(",","");
			str = str.replace(" ","");

			lotDesign1[j] = str.toCharArray();
			j++;
		}


		/* Skip over empty lines */
		for(int i = 0; i<3; i++) {
			String str = scanner.nextLine();
		}

		/* Populate occupancy1 and occupancy with File*/
		while(scanner.hasNext()) {
			String str = scanner.nextLine();
			if(str.equals("")) {
				continue;
			}

			//Remove any additional spaces
			str = str.replace(" ", "");

			//Get characters (position, type) from file
			char chposx = str.charAt(0);
			char chposy = str.charAt(2);
			char chtype = str.charAt(4);

			//Convert char to int/string
			int posx = Character.getNumericValue(chposx);
			int posy = Character.getNumericValue(chposy);
			String type = Character.toString(chtype);

			//Create new car object
			Car c = new Car(Util.getCarTypeByLabel(type), str.substring(6,str.length()));

			//If parking position is out of bounds
			if(posy >= occupancy1.length || posx >= occupancy1[0].length) {
				System.out.println("Car " + chtype + "(" + str.substring(6,str.length()) + ") cannot be parked at (" + chposx + "," + chposy + ")");
				continue;
			}
			
			String park = Character.toString(lotDesign1[posx][posy]);
			
			//If the type of car doesn't correspond to parking lot type
			if(!park.equals(type)) {
				System.out.println("Car " + chtype + "(" + str.substring(6,str.length()) + ") cannot be parked at (" + chposx + "," + chposy + ")");
				continue;
			}

			//If withiin bounds and type of car is same as parking spot type, populate occupancy and occupancy1
			if(posy < occupancy1.length && posx < occupancy1[0].length && park.equals(type)) {
				occupancy1[posx][posy] = type;
				occupancy[posx][posy] = c;
			}
		}

		//For loop populating lotDesign with lotDesign1
		for(int i = 0; i < lotDesign1.length; i++) {
			for(j = 0; j < lotDesign1[0].length; j++) {
				String str = Character.toString(lotDesign1[i][j]);
				lotDesign[i][j] = Util.getCarTypeByLabel(str);
			}
		}

		//NOTE: PopulateFromFile method was not used
	}

	/**
	 * Parks a car (c) at a give location (i, j) within the parking lot.
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @param c is the car to be parked
	 */
	public void park(int i, int j, Car c) {
		/* Parks car at (i,j). Overwrites current car that occupies position. */
		occupancy[i][j] = c;
	}

	/**
	 * Removes the car parked at a given location (i, j) in the parking lot
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return the car removed; the method returns null when either i or j are out
	 *         of range, or when there is no car parked at (i, j)
	 */
	public Car remove(int i, int j) {
		/* If i or j is out of range */
		if(i >= occupancy.length || j >= occupancy[0].length) {
			return null;
		}
		
		/* If spot is already empty */
		if(occupancy[i][j] == null) {
			return null;
		}
		
		/* Remove car */
		occupancy[i][j] = null;
		return occupancy[i][j];
	}

	/**
	 * Checks whether a car (which has a certain type) is allowed to park at
	 * location (i, j)
	 * 
	 * @param i is the parking row index
	 * @param j is the index of the spot within row i
	 * @return true if car c can park at (i, j) and false otherwise
	 */
	public boolean canParkAt(int i, int j, Car c) {
		/* If i or j is out of range */
		if(i >= occupancy.length || j >= occupancy[0].length) {
			return false;
		}
		/* If spot is occupied */
		if(occupancy != null) {
			return false;
		}
		/* If spot isn't matching car type */
		if(!c.getType().equals(lotDesign[i][j])) {
				return false;
		}
		/* If spot is empty and equals corresponding type */
		if(occupancy == null) {
			if(c.getType().equals(lotDesign[i][j])) {
				return true;
			}
		}
		return false; 
	}

	/**
	 * @return the total capacity of the parking lot excluding spots that cannot be
	 *         used for parking (i.e., excluding spots that point to CarType.NA)
	 */
	public int getTotalCapacity() {
		/* Instantiate capacity variable */
		int capacity = lotWidth * lotLength;

		/* Whenever the space in the parking lot is type NA, reduce capacity by 1 */
		for(int i = 0; i < (lotLength); i++) {
			for(int j = 0; j < (lotWidth); j++) {
				String str = lotDesign[i][j].toString();
				if(str.equals("NA")) {
					capacity--;
				}
			}
		}
		return capacity;
	}

	/**
	 * @return the total occupancy of the parking lot (i.e., the total number of
	 *         cars parked in the lot)
	 */
	public int getTotalOccupancy() {
		int totalOccupancy = 0;

		/* Whenever occupancy isn't null add 1 to total occupancy */
		for (int i = 0; i < occupancy.length; i++) {
			for (int j = 0; j < occupancy[0].length; j++) {
				if(occupancy[i][j] != null) {
					totalOccupancy++;
				}
			}
		}
		return totalOccupancy; 	
	}

	private void calculateLotDimensions(String strFilename) throws Exception {

		Scanner scanner = new Scanner(new File(strFilename));

		String widthLine = scanner.nextLine();

		//Remove additional spaces and commas
		widthLine = widthLine.replace(",", "");
		widthLine = widthLine.replace(" ", "");

		//Length variable, 1 by default
		int length = 1;

		//Keep adding to length variable until sectioner is reached. Ignores empty lines
		while (scanner.hasNext()) {
			String str = scanner.nextLine();
			if(str.contains(SECTIONER)) {
				break;
			}
			if(str.isEmpty()) {
				continue;
			}
			length++;
		}

		//Assigns variables to private lot width and length variables
		lotWidth = widthLine.length();
		lotLength = length;
		numSpotsPerRow = lotWidth;

		//Prints output (FOR TESTING PURPOSES ONLY!!!)
		//System.out.println("The lot's dimensions are " + widthLine.length() + " units wide and " + length + " units long.");
		scanner.close();
	}

	private void populateFromFile(String strFilename) throws Exception {
		//Method not used; writted in constructor
	}

	/**
	 * Produce string representation of the parking lot
	 * 
	 * @return String containing the parking lot information
	 */
	public String toString() {
		// NOTE: The implementation of this method is complete. You do NOT need to
		// change it for the assignment.
		StringBuffer buffer = new StringBuffer();
		buffer.append("==== Lot Design ====").append(System.lineSeparator());

		for (int i = 0; i < lotDesign.length; i++) {
			for (int j = 0; j < lotDesign[0].length; j++) {
				buffer.append((lotDesign[i][j] != null) ? Util.getLabelByCarType(lotDesign[i][j])
						: Util.getLabelByCarType(CarType.NA));
				if (j < numSpotsPerRow - 1) {
					buffer.append(", ");
				}
			}
			buffer.append(System.lineSeparator());
		}

		buffer.append(System.lineSeparator()).append("==== Parking Occupancy ====").append(System.lineSeparator());

		for (int i = 0; i < occupancy.length; i++) {
			for (int j = 0; j < occupancy[0].length; j++) {
				buffer.append(
						"(" + i + ", " + j + "): " + ((occupancy[i][j] != null) ? occupancy[i][j] : "Unoccupied"));
				buffer.append(System.lineSeparator());
			}

		}
		return buffer.toString();
	}

	/**
	 * <b>main</b> of the application. The method first reads from the standard
	 * input the name of the file to process. Next, it creates an instance of
	 * ParkingLot. Finally, it prints to the standard output information about the
	 * instance of the ParkingLot just created.
	 * 
	 * @param args command lines parameters (not used in the body of the method)
	 * @throws Exception
	 */

	public static void main(String args[]) throws Exception {

		StudentInfo.display();

		System.out.print("Please enter the name of the file to process: ");

		Scanner scanner = new Scanner(System.in);

		String strFilename = scanner.nextLine();

		ParkingLot lot = new ParkingLot(strFilename);

		System.out.println("Total number of parkable spots (capacity): " + lot.getTotalCapacity());

		System.out.println("Number of cars currently parked in the lot: " + lot.getTotalOccupancy());

		System.out.print(lot);

	}
}
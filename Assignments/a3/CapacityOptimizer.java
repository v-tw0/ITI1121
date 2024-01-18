public class CapacityOptimizer {
	private static final int NUM_RUNS = 10;

	private static final double THRESHOLD = 5.0d;

	public static int getOptimalNumberOfSpots(int hourlyRate) {

		/* Variable Declaration */
		int n = 1;
		double average = 6.0;
		ParkingLot lot; 
		Simulator sim; 

		/* While average queue size is greater than 5 */
		while(average >= 5) {
			average = 0;
		
			System.out.println("==== Setting lot capacity to: " + n + " ====");

			/* Simulate 10 times while queue size to average */
			for(int i = 0; i < NUM_RUNS; i++) {
				lot = new ParkingLot(n);

				sim = new Simulator(lot, hourlyRate, (24 * 3600));

				long mainStart = System.currentTimeMillis();

				sim.simulate();
				average += sim.getIncomingQueueSize();

				long mainEnd = System.currentTimeMillis();

				System.out.println("Simulation run " + (i+1) + " (" + (mainEnd - mainStart) + 
					"ms); Queue length at the end of simulation run: " + sim.getIncomingQueueSize());
			}
			System.out.println();

			/* Calculate average */
			average = average / 10;

			/* If average is less than 5, break */
			if(average <= 5) {
				break;
			}

			/* Else add one to lot capacity and continue */
			else {
				n++;
			}
		}

		/* Return result */
		return n;
	}

	public static void main(String args[]) {
	
		StudentInfo.display();

		long mainStart = System.currentTimeMillis();

		if (args.length < 1) {
			System.out.println("Usage: java CapacityOptimizer <hourly rate of arrival>");
			System.out.println("Example: java CapacityOptimizer 11");
			return;
		}

		if (!args[0].matches("\\d+")) {
			System.out.println("The hourly rate of arrival should be a positive integer!");
			return;
		}

		int hourlyRate = Integer.parseInt(args[0]);

		int lotSize = getOptimalNumberOfSpots(hourlyRate);

		System.out.println();
		System.out.println("SIMULATION IS COMPLETE!");
		System.out.println("The smallest number of parking spots required: " + lotSize);

		long mainEnd = System.currentTimeMillis();

		System.out.println("Total execution time: " + ((mainEnd - mainStart) / 1000f) + " seconds");

	}
}
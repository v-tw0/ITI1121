/**
 * @author Mehrdad Sabetzadeh, University of Ottawa
 *
 */
public class Spot {
	private Car car;
	private int timestamp;

	/* Get car from this spot */
	public Car getCar() {
		return car;
	}

	/* Assign car to this spot */
	public void setCar(Car car) {
		this.car = car;
	}

	/* Get timestamp of arrival */
	public int getTimestamp() {
		return timestamp;
	}

	/* Assign timestemp of arrival */
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;	
	}

	/* Constructor */
	public Spot(Car car, int timestamp) {
		this.car = car;
		this.timestamp = timestamp;
	}

	/**
	 * Returns a string representation of the spot
	 * This method is complete; you do not need to change it.
	 */
	public String toString() {
		return car + ", timestamp: " + timestamp;
	}
}

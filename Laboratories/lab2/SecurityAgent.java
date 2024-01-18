import java.util.Random;

public class SecurityAgent {

private final Combination SECRET;
private final DoorLock LOCK;

	public void activateDoorLock() {
		LOCK.activate(SECRET);
	}

	public DoorLock getDoorLock() {
		return LOCK;
	}

	public SecurityAgent() { 
		int first, second, third;
		Combination secret;

		first = (int)(Math.random()*5) + 1;
		second = (int)(Math.random()*5) + 1;
		third =  (int)(Math.random()*5) + 1;

		secret = new Combination(first,second,third);
		
		SECRET = secret;
		LOCK = new DoorLock(secret);
	}
}
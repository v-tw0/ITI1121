public class Iterative {

	public static BitList complement( BitList in ) {

		Iterator it = in.iterator();
		BitList out = new BitList();

		Iterator it1 = out.iterator();

		int value;

		while(it.hasNext()) {
			value = it.next();

			if(value == 0) {
				it1.add(1);
			}
			else {
				it1.add(0);
			}
		}

		return out;
	}

	public static BitList or( BitList a, BitList b ) {

		Iterator it1 = a.iterator();
		Iterator it2 = b.iterator();
		BitList out = new BitList();
		Iterator it = out.iterator();
		int value1;
		int value2;

		while(it1.hasNext() && it2.hasNext()) {
			value1 = it1.next();
			value2 = it2.next();

			if(value1 == 0) {
				if(value2 == 0) {
					it.add(0);
				}
				else {
					it.add(1);
				}
			}
			else {
				it.add(1);
			}
		}
		return out;
	}

	public static BitList and( BitList a, BitList b ) {

		Iterator it1 = a.iterator();
		Iterator it2 = b.iterator();
		BitList out = new BitList();
		Iterator it = out.iterator();
		int value1;
		int value2;

		while(it1.hasNext() && it2.hasNext()) {
			value1 = it1.next();
			value2 = it2.next();

			if(value1 == 1) {
				if(value2 == 1) {
					it.add(1);
				}
				else {
					it.add(0);
				}
			}
			else {
				it.add(0);
			}
		}
		return out;
	}

	public static BitList xor( BitList a, BitList b ) {

		Iterator it1 = a.iterator();
		Iterator it2 = b.iterator();
		BitList out = new BitList();
		Iterator it = out.iterator();
		int value1;
		int value2;

		while(it1.hasNext() && it2.hasNext()) {
			value1 = it1.next();
			value2 = it2.next();

			if(value1 == 0) {
				if(value2 == 1) {
					it.add(1);
				}
				else {
					it.add(0);
				}
			}
			else {
				if(value2 == 1) {
					it.add(0);
				}
				else {
					it.add(1);
				}
			}
		}
		return out;
	}
}

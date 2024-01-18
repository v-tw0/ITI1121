import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)
    private static class Node {

      	private Comparable value;
      	private Node previous;
      	private Node next;

      	private Node ( Comparable value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    // Instance variables

    private Node head;

    // Representation of the empty list.

    public OrderedList() {
        head = new Node(null, null, null);
    }

    // Calculates the size of the list

    public int size() {
      	int count = 0;
        Node n = head.next;
        while(n!=null) {count++; n = n.next;}
        return count;
    }


    public Object get( int pos ) {
        Node n = head.next;
        while(n != null && pos != 0) {pos--; n = n.next;}
        if(n != null && pos == 0) {return n.value;}
        return null;

    }

    // Adding an element while preserving the order

    public boolean add( Comparable o ) {
        Node prev = head;
        Node n = head.next;
        while(prev.next != null && prev.next.value.compareTo(o) < 0) {prev = prev.next;}
        prev.next = new Node(o, prev, prev.next);
        if(prev.next.next != null) {prev.next.next.previous = prev.next.next;}
        return true;
    }

    //Removes one item from the position pos.

    public void remove( int pos ) {
        Node prev = head;
        Node n = head.next;
        while(n != null && pos != 0) {pos--; prev = n; n = n.next;}
        if(pos == 0 && n != null) {
            prev.next = n.next;
            if(n.next != null) {
                n.previous = prev;
            }
        }
    }

    private void addAfter(Node oldNode, Comparable value) {
        Node newNode = new Node(value, oldNode, oldNode.next);
        if(oldNode.next != null) {
                oldNode.next.previous = newNode;
        }
        oldNode.next = newNode;
    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge( OrderedList other ) {
        Node prev = head;
        Node n = head.next;

        Node n1 = other.head.next;

        while(n1 != null) {
            while(n != null && n.value.compareTo(n1.value) < 0) {
                prev  = n;
                n = n.next;
            }
            addAfter(prev, n1.value);
            n = prev.next;
            n1 = n1.next;
        }
    } 

     public void printList() {
        // head is always present.
        Node ptr = head.next;
        while(ptr != null) {
                System.out.print(ptr.value + " ");
                ptr = ptr.next;
        }
        System.out.println(); 
    } 

    public static void main(String args[]) {
                OrderedList list1 = new OrderedList();
                list1.add(8);
                list1.add(18);
                list1.add(16);
                list1.add(23);
                list1.add(3);
                list1.add(7);
                
                list1.printList();
                
                // remember remove taks position, not value
                list1.remove(0);
                list1.printList();
                list1.remove(2);
                list1.printList();
                System.out.print("List1: ");
                list1.printList();

                OrderedList list2 = new OrderedList();
                list2.add(8);
                list2.add(18);
                list2.add(13);
                list2.add(71);
                list2.add(9);
                list2.add(15);
                System.out.print("List2: ");
                list2.printList();
                
                list1.merge(list2);

                System.out.print("Merged List: ");
                list1.printList();
        }
}

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    private static class Node<T> {

        private T value;
        private Node<T> prev;
        private Node<T> next;

        private Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;
    private int index;

    public LinkedList() {
        head = new Node<E>(null, null, null); // dummy node!
        head.prev = head.next = head;
        size = 0;
    }

    private class LinkedListIterator implements Iterator<E> {
        /* nextIndex variable */
        int nextIndex = 0; 
        private Node<E> current = head;

        /* Empty Constructor */
        public LinkedListIterator() {} 

        /* Constructor with index */
        public LinkedListIterator(int index) { 

            /* If index out of bounds, throw exception */
            if(index < 0 || index >= size) {
                throw new IndexOutOfBoundsException(Integer.toString(index));
            }

            /* Temporary node variable */
            Node<E> temp = head;

            /* Loop setting node to index position */
            if (index < size) {
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
            }

            /* Set current to temp */
            current = temp;

            /* Set nextIndex */
            nextIndex = index;
        }

        public boolean hasNext() {
            return (current.next != head);
        }
        
        /* nextIndex method */
        public int nextIndex() { 
            return nextIndex;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            current = current.next;
            /* Increment nextIndex */
            nextIndex++; 
            return current.value;
        }
    }
    
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    public Iterator<E> iterator(int nextIndex) {
        return new LinkedListIterator(nextIndex);
    }

    public Iterator<E> iterator(Iterator<E> other) {
        return new LinkedListIterator(other.nextIndex());
    }

    public int size() {
        return size;
    }

    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        Node<E> p = head.next;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.value;
    }

    public void addFirst(E elem) {

        if (elem == null) {
            throw new NullPointerException();
        }

        Node<E> second = head.next;

        head.next = new Node<E>(elem, head, second);
        second.prev = head.next;

        size++;
    }

    public void add(E elem) {

        if (elem == null) {
            throw new NullPointerException();
        }

        Node<E> before = head.prev, after = head;

        before.next = new Node<E>(elem, before, after);
        after.prev = before.next;

        size++;
    }
    
}

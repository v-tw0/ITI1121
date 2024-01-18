import java.util.*;

public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        if (capacity < DEFAULT_INC) {capacity = DEFAULT_INC;} {
            elems = (E[]) new Object[ capacity ];
            top = 0;
        }    
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E saved = elems[ --top ];
        elems[ top ] = null; // scrub the memory!
        if (elems.length - top == DEFAULT_INC && elems.length - DEFAULT_INC >= DEFAULT_INC) {
            E[] temp = (E[]) new Object[ elems.length - DEFAULT_INC ];
            for ( int i=0; i<top; i++ ) {
                temp[ i ] = elems[i];
            }
            elems=temp;      
        }
        return saved;    
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        elems[ top++ ] = element;
        if (top == elems.length) {
            E[] temp = (E[]) new Object[ top + DEFAULT_INC ];
            for ( int i=0; i<top; i++ ) {
                temp[ i ] = elems[i];
            }
            elems=temp;      
        }
    }

    @SuppressWarnings( "unchecked" )

    public void clear() {
        elems = (E[]) new Object[DEFAULT_INC]; 
        top = 0;
    }

}
